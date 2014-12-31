package com.palazzisoft.ligabalonpie.views;

import static com.palazzisoft.ligabalonpie.converters.JugadorConverter.convertirACommand;
import static com.palazzisoft.ligabalonpie.util.PageViews.LISTADO_JUGADORES_BACK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.palazzisoft.ligabalonpie.command.JugadorCommand;
import com.palazzisoft.ligabalonpie.controllers.api.EquipoController;
import com.palazzisoft.ligabalonpie.controllers.api.JugadorController;
import com.palazzisoft.ligabalonpie.controllers.api.TipoJugadorController;
import com.palazzisoft.ligabalonpie.entities.Equipo;
import com.palazzisoft.ligabalonpie.entities.EquipoJugador;
import com.palazzisoft.ligabalonpie.entities.Jugador;
import com.palazzisoft.ligabalonpie.util.PageViews;

@Controller
public class JugadorView {

	private JugadorController jugadorController;
	private EquipoController equipoController;
	private TipoJugadorController tipoJugadorController;

	@Autowired
	public JugadorView(JugadorController jugadorController, EquipoController equipoController,
			TipoJugadorController tipoJugadorController) {
		this.jugadorController = jugadorController;
		this.equipoController = equipoController;
		this.tipoJugadorController = tipoJugadorController;
	}

	@RequestMapping(value = "/listadoJugador.adm", method = GET)
	public String showBack(@RequestParam(value = "tipoJugador", required = false) Integer tipoJugadorId, Model model) {
		List<Jugador> jugadores = this.jugadorController.obtenerJugadoresDisponiblesPorTipoJugador(tipoJugadorId);
		List<JugadorCommand> jugadoresCommand = new ArrayList<JugadorCommand>();
		
		for (Jugador jugador : jugadores) {
			JugadorCommand jugadorCommand = convertirACommand(jugador);
			jugadoresCommand.add(jugadorCommand);
		}
		
		model.addAttribute("tipoJugador", this.tipoJugadorController.obtenerTodosTipoJugador());
		model.addAttribute("jugadores", jugadoresCommand);
		model.addAttribute("tipoJugadorId", tipoJugadorId);

		return PageViews.LISTADO_JUGADORES_BACK;
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

}
