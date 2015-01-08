package com.palazzisoft.ligabalonpie.views;

import static com.palazzisoft.ligabalonpie.converters.TorneoConverter.convertirCommandATorneo;
import static com.palazzisoft.ligabalonpie.converters.TorneoConverter.convertirTorneoACommand;
import static com.palazzisoft.ligabalonpie.util.PageViews.ALTA_EDICION_TORNEO;
import static com.palazzisoft.ligabalonpie.util.PageViews.LISTADO_TORNEO;
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

import com.palazzisoft.ligabalonpie.command.TorneoCommand;
import com.palazzisoft.ligabalonpie.controllers.api.TorneoController;
import com.palazzisoft.ligabalonpie.converters.TorneoConverter;
import com.palazzisoft.ligabalonpie.entities.Torneo;

@Controller
public class TorneoView {

	private final Logger log = Logger.getLogger(TorneoView.class);

	private final TorneoController torneoController;

	@Autowired
	public TorneoView(final TorneoController torneoController) {
		this.torneoController = torneoController;
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
}
