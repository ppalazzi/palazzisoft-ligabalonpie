package com.palazzisoft.ligabalonpie.views;

import static com.palazzisoft.ligabalonpie.converters.EquipoConverter.convertirAEquipoCommand;
import static com.palazzisoft.ligabalonpie.converters.TorneoConverter.convertirCommandATorneo;
import static com.palazzisoft.ligabalonpie.converters.TorneoConverter.convertirListadoACommand;
import static com.palazzisoft.ligabalonpie.converters.TorneoConverter.convertirTorneoACommand;
import static com.palazzisoft.ligabalonpie.util.PageViews.ALTA_EDICION_TORNEO;
import static com.palazzisoft.ligabalonpie.util.PageViews.LISTADO_TORNEO;
import static com.palazzisoft.ligabalonpie.util.PageViews.MIS_TORNEOS;
import static com.palazzisoft.ligabalonpie.util.PageViews.TORNEO_DETALLES;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.palazzisoft.ligabalonpie.command.TorneoCommand;
import com.palazzisoft.ligabalonpie.controllers.api.EquipoController;
import com.palazzisoft.ligabalonpie.controllers.api.TorneoController;
import com.palazzisoft.ligabalonpie.converters.TorneoConverter;
import com.palazzisoft.ligabalonpie.entities.Equipo;
import com.palazzisoft.ligabalonpie.entities.Torneo;
import com.palazzisoft.ligabalonpie.exception.BalonpieException;

@Controller
public class TorneoView {

	private final Logger log = Logger.getLogger(TorneoView.class);

	private final TorneoController torneoController;
	private final EquipoController equipoController;

	@Autowired
	public TorneoView(final TorneoController torneoController, final EquipoController equipoController) {
		this.torneoController = torneoController;
		this.equipoController = equipoController;
	}
	
	@RequestMapping(value = "/torneoDeParticipante.htm", method = GET)
	public String obtenerTorneosPorParticipante(@RequestParam Integer participanteId, Model model) {
		log.info("Trayendo todos los torneos activos de un participante");
		
		try {
			List<Torneo> torneos = this.torneoController.obtenerTorneosValidosPorParticipante(participanteId);
			model.addAttribute("torneos", convertirListadoACommand(torneos));
		}
		catch (Exception e) {
			log.error("Error al traer los torneos activos de un participante", e);
			model.addAttribute("error","Error al traer Torneo del participante");
		}
		return MIS_TORNEOS;
	}

	@RequestMapping(value = "/torneosDetalles.htm", method = GET)
	public String obtenerDetallesDeTorneo(@RequestParam Integer torneoId, Model model) {
		log.info("Trayendo el torneo y su equipo seleccionado en Mis Torneos");
		
		try {
			Torneo torneo = this.torneoController.obtenerTorneoPorId(torneoId);
			Equipo equipo = this.equipoController.obtenerEquipoCreadorDeTorneo(torneoId, torneo.getParticipante().getId());
			
			model.addAttribute("torneo", convertirTorneoACommand(torneo));
			model.addAttribute("equipo", convertirAEquipoCommand(equipo));
			model.addAttribute("participanteId" , equipo.getParticipante().getId());
		}
		catch (Exception e) {
			log.error("Error al traer el torneo y su equipo de Mis Torneos", e);
		}
		
		return TORNEO_DETALLES;
	}
	
	@RequestMapping(value = "/listadoTorneo.adm", method = GET)
	public String obtenerTodosLosTorneos(Model model) {
		log.info("Trayendo todos los torneos");

		try {
			List<TorneoCommand> torneos = TorneoConverter
					.convertirListadoACommand(this.torneoController
							.obtenerTodosLosTorneos());
			model.addAttribute("torneos", torneos);
		} catch (ParseException e) {
			log.error("Error en el parseo de Fecha", e);
			model.addAttribute("error", "Hubo un error al cargar los datos");
		}

		return LISTADO_TORNEO;
	}

	@RequestMapping(value = "/nuevoTorneo.adm", method = GET)
	public String traerTorneo(TorneoCommand torneoCommand, Model model) {
		try {
			if (torneoCommand.getId() != null) {
				Torneo torneo = this.torneoController
						.obtenerTorneoPorId(torneoCommand.getId());
				torneoCommand = convertirTorneoACommand(torneo);
			}
			model.addAttribute("torneo", torneoCommand);
		} catch (ParseException e) {
			log.error("Error en el parseo de Fecha", e);
			model.addAttribute("error", "Hubo un error al cargar los datos");
		}

		return ALTA_EDICION_TORNEO;
	}

	@RequestMapping (value = "/nuevoTorneo.adm", method = POST)
	public String guardarTorneo(@Valid TorneoCommand torneoCommand,
			BindingResult bindingResults, Model model) {
		try {
			if (!bindingResults.hasErrors()) {
				Torneo torneo = convertirCommandATorneo(torneoCommand);
				this.torneoController.guardarTorneo(torneo);
				model.addAttribute("mensaje", "Se ha guardado exitosamente");
			}			
		} catch (ParseException e) {
			log.error("Error en el parseo de Fecha", e);
			model.addAttribute("error", "Hubo un error al cargar los datos");
		}

		model.addAttribute("torneo", torneoCommand);
		return ALTA_EDICION_TORNEO;
	}
	
	@RequestMapping (value = "/desligarEquipo.adm", method = GET)
	public String desligarEquipo(@RequestParam Integer torneoId,
			@RequestParam Integer equipoId, Model model) {
		TorneoCommand torneoCommand = new TorneoCommand();
		torneoCommand.setId(torneoId);

		try {
			Torneo torneo = this.torneoController.obtenerTorneoPorId(torneoId);
			torneo.desligarEquipo(equipoId);
			this.torneoController.guardarTorneo(torneo);
			model.addAttribute("torneo", convertirTorneoACommand(torneo));
		} catch (ParseException e) {
			log.info("Error en el parseo de Fecha", e);
			model.addAttribute("error", "Hubo un error al cargar los datos");
		} catch (BalonpieException e) {
			log.info("Error en los datos", e);
			model.addAttribute("error", "No se puede eliminar un Equipo de un Torneo Activo");			
			return this.traerTorneo(torneoCommand, model);
		}
		
		return ALTA_EDICION_TORNEO;
	}
}
