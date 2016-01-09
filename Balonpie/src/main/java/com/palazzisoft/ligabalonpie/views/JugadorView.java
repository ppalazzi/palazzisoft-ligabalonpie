package com.palazzisoft.ligabalonpie.views;

import static com.google.common.collect.Lists.newArrayList;
import static com.palazzisoft.ligabalonpie.converters.JugadorConverter.convertirACommand;
import static com.palazzisoft.ligabalonpie.converters.JugadorConverter.convertirAJugador;
import static com.palazzisoft.ligabalonpie.util.PageViews.ALTA_BAJA_JUGADOR;
import static com.palazzisoft.ligabalonpie.util.PageViews.COMPRAR_JUGADOR;
import static com.palazzisoft.ligabalonpie.util.PageViews.LISTADO_JUGADORES_BACK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.palazzisoft.ligabalonpie.command.JugadorCommand;
import com.palazzisoft.ligabalonpie.controllers.api.EquipoController;
import com.palazzisoft.ligabalonpie.controllers.api.JugadorController;
import com.palazzisoft.ligabalonpie.controllers.api.TipoJugadorController;
import com.palazzisoft.ligabalonpie.entities.Equipo;
import com.palazzisoft.ligabalonpie.entities.EquipoJugador;
import com.palazzisoft.ligabalonpie.entities.Jugador;
import com.palazzisoft.ligabalonpie.validators.JugadorValidator;
/**
 * 
 * @author ppalazzi
 *
 */
@Controller
public class JugadorView {

	private final JugadorController jugadorController;
	private final EquipoController equipoController;
	private final TipoJugadorController tipoJugadorController;
	private final JugadorValidator jugadorValidator;

	@Autowired
	public JugadorView(final JugadorController jugadorController, final EquipoController equipoController,
			final TipoJugadorController tipoJugadorController, final JugadorValidator jugadorValidator) {
		this.jugadorController = jugadorController;
		this.equipoController = equipoController;
		this.tipoJugadorController = tipoJugadorController;
		this.jugadorValidator = jugadorValidator;
	}

	@RequestMapping(value = "/listadoJugador.htm", method = GET)
	public String obtenerJugadoresPorTipo(@RequestParam(value = "tipoJugador") Integer tipoJugadorId,
			@RequestParam(value = "posicion", required = false) Integer posicion , Model model) {
		List<JugadorCommand> jugadoresCommand = buildJugadorCommand(tipoJugadorId);
		model.addAttribute("jugadores", jugadoresCommand);
		model.addAttribute("tipoJugadorId", tipoJugadorId);
		model.addAttribute("posicion", posicion);
		
		return COMPRAR_JUGADOR;
	}
	
	@RequestMapping(value = "/listadoJugador.adm", method = GET)
	public String showBack(@RequestParam(value = "tipoJugador", required = false) Integer tipoJugadorId, Model model) {
		List<JugadorCommand> jugadoresCommand = buildJugadorCommand(tipoJugadorId);
		
		model.addAttribute("tipoJugador", this.tipoJugadorController.obtenerTodosTipoJugador());
		model.addAttribute("jugadores", jugadoresCommand);
		model.addAttribute("tipoJugadorId", tipoJugadorId);

		return LISTADO_JUGADORES_BACK;
	}


	@RequestMapping(value = "/listadoJugadorPorEquipo.adm", method = GET)
	public String mostrarListadoDeJugadorPorEquipo(@RequestParam("equipoId") Integer equipoId,
			Model model) {
		Equipo equipo = this.equipoController.getById(equipoId);
		List<JugadorCommand> jugadoresCommand = new ArrayList<>();

		for (EquipoJugador equipoJugador : equipo.getEquipoJugadores()) {
			JugadorCommand jugadorCommand = convertirACommand(equipoJugador.getJugador());
			jugadoresCommand.add(jugadorCommand);
		}

		model.addAttribute("jugadores", jugadoresCommand);

		return LISTADO_JUGADORES_BACK;
	}

	@RequestMapping(value = "/nuevoJugador.adm", method = GET)
	public String showForm(@ModelAttribute("jugadorCommand") JugadorCommand jugadorCommand,
			Model model) {
		if (jugadorCommand.getId() != null) {
			Jugador jugador = this.jugadorController.getJugadorById(jugadorCommand.getId());
			jugadorCommand = convertirACommand(jugador);
		}

		model.addAttribute("jugador", jugadorCommand);
		model.addAttribute("tipoJugador", this.tipoJugadorController.obtenerTodosTipoJugador());

		return ALTA_BAJA_JUGADOR;
	}

	@RequestMapping(value = "/nuevoJugador.adm", method = POST)
	public String onSubmit(@ModelAttribute("jugadorCommand") JugadorCommand jugadorCommand,
			BindingResult bindingResult, Model model) throws ParseException {
		this.jugadorValidator.validate(jugadorCommand, bindingResult);

		if (bindingResult.hasErrors()) {
			return this.showForm(jugadorCommand, model);
		}
		
		Jugador jugador = convertirAJugador(jugadorCommand);
		this.jugadorController.saveJugador(jugador);
		model.addAttribute("mensaje", "Se ha guardado exitosamente");

		return this.showForm(jugadorCommand, model);
	}	

	private List<JugadorCommand> buildJugadorCommand(Integer tipoJugadorId) {
		List<Jugador> jugadores = this.jugadorController.obtenerJugadoresDisponiblesPorTipoJugador(tipoJugadorId);
		List<JugadorCommand> jugadoresCommand = newArrayList();
		
		for (Jugador jugador : jugadores) {
			JugadorCommand jugadorCommand = convertirACommand(jugador);
			jugadoresCommand.add(jugadorCommand);
		}
		return jugadoresCommand;
	}
}
