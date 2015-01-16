package com.palazzisoft.ligabalonpie.views;

import static com.palazzisoft.ligabalonpie.converters.EquipoConverter.convertirAEquipo;
import static com.palazzisoft.ligabalonpie.converters.EquipoConverter.convertirAEquipoCommand;
import static com.palazzisoft.ligabalonpie.converters.JugadorConverter.convertirJugadoresAJugadoresCommand;
import static com.palazzisoft.ligabalonpie.util.PageViews.ALTA_BAJA_EQUIPO;
import static com.palazzisoft.ligabalonpie.util.PageViews.DASHBOARD;
import static com.palazzisoft.ligabalonpie.util.PageViews.EQUIPO_RESUMEN;
import static com.palazzisoft.ligabalonpie.util.PageViews.LISTADO_COMPRAR_JUGADOR;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.palazzisoft.ligabalonpie.command.EquipoCommand;
import com.palazzisoft.ligabalonpie.controllers.api.EquipoController;
import com.palazzisoft.ligabalonpie.controllers.api.JugadorController;
import com.palazzisoft.ligabalonpie.controllers.api.TipoJugadorController;
import com.palazzisoft.ligabalonpie.entities.Equipo;
import com.palazzisoft.ligabalonpie.entities.Jugador;
import com.palazzisoft.ligabalonpie.validators.EquipoValidator;

@Controller
public class EquipoView {

	private final EquipoController equipoController;
	private final EquipoValidator equipoValidator;
	private final JugadorController jugadorController;
	private final TipoJugadorController tipoJugadorController;

	@Autowired
	public EquipoView(final EquipoController equipoController,
			final EquipoValidator equipoValidator, final JugadorController jugadorController,
			final TipoJugadorController tipoJugadorController) {
		this.equipoController = equipoController;
		this.equipoValidator = equipoValidator;
		this.jugadorController = jugadorController;
		this.tipoJugadorController = tipoJugadorController;
	}

	@RequestMapping(value = "/nuevoEquipo.htm", method = RequestMethod.GET)
	public String nuevoEquipoShowForm(@RequestParam("participanteId") String participanteId,
			ModelMap model) {
		model.addAttribute("participanteId", participanteId);
		return ALTA_BAJA_EQUIPO;
	}

	@RequestMapping(value = "/nuevoEquipo.htm", method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("torneoCommand") EquipoCommand equipoCommand,
			@RequestParam("participanteId") Integer participanteId, ModelMap model) {

		if (!this.equipoController.verificarExistenciaDeEquipo(equipoCommand.getNombre())) {
			this.equipoController.nuevoEquipo(equipoCommand, participanteId);
		} else {
			model.put("mensajeError", "Ya tenés un equipo con ese nombre");
		}

		return DASHBOARD;
	}

	@RequestMapping(value = "/traerEquipoDelTorneo", method = POST)
	public String traerEquipoPorTorneoYUsuario(@RequestParam("torneoId") Integer torneoId,
			@RequestParam("participanteId") Integer participanteId, ModelMap model) {
		EquipoCommand equipoCommand = this.equipoController.obtenerEquipoPorTorneoYParticipante(
				torneoId, participanteId);

		model.put("equipo", equipoCommand);

		return EQUIPO_RESUMEN;
	}

	@RequestMapping(value = "/nuevoEquipo.adm", method = GET)
	public String showBack(@ModelAttribute EquipoCommand equipoCommand, Model model) {
		if (equipoCommand.getId() != null) {
			Equipo equipo = this.equipoController.getById(equipoCommand.getId());
			equipoCommand = convertirAEquipoCommand(equipo);
		}

		model.addAttribute("equipo", equipoCommand);

		return ALTA_BAJA_EQUIPO;
	}

	@RequestMapping(value = "/nuevoEquipo.adm", method = POST)
	public String onSubmit(@ModelAttribute EquipoCommand equipoCommand,
			BindingResult bindingResult, Model model) {
		this.equipoValidator.validate(equipoCommand, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("equipo", equipoCommand);
			return ALTA_BAJA_EQUIPO;
		}

		try {
			Equipo equipo = convertirAEquipo(equipoCommand);
			this.equipoController.guardarEquipo(equipo);
			model.addAttribute("mensaje", "Se ha guardado exitosamente");			
			return this.showBack(equipoCommand, model);
		} catch (ParseException e) {
			model.addAttribute("error", "Hubo un error al cargar los datos");
		}

		return ALTA_BAJA_EQUIPO;
	}

	@RequestMapping(value = "/listadoJugadorDisponibles.adm", method = POST)
	public String obtenerJugadoresDisponiblesPor(@RequestParam Integer tipoJugadorId, Model model) {
		List<Jugador> jugadores = this.jugadorController
				.obtenerJugadoresDisponiblesParaComprarPorTipoDeJugador(tipoJugadorId);
		
		model.addAttribute("jugadores", convertirJugadoresAJugadoresCommand(jugadores));
		model.addAttribute("tipoJugador", this.tipoJugadorController.obtenerTodosTipoJugador());
		model.addAttribute("tipoJugadorId", tipoJugadorId);

		return LISTADO_COMPRAR_JUGADOR;
	}

	@RequestMapping (value = "/venderJugador.adm", method = GET)
	public String venderJugador(@RequestParam Integer equipoId, @RequestParam Integer jugadorId, Model model) {		
		Equipo equipo = this.equipoController.venderJugador(equipoId, jugadorId);
		model.addAttribute("equipo", convertirAEquipoCommand(equipo));
		
		return ALTA_BAJA_EQUIPO;
	}

}
