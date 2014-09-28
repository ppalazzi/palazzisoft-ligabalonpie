package com.palazzisoft.ligabalonpie.views;

import static com.palazzisoft.ligabalonpie.converters.JugadorConverter.convertirACommand;
import static com.palazzisoft.ligabalonpie.util.PageViews.LISTADO_JUGADORES_BACK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

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
import com.palazzisoft.ligabalonpie.entities.Equipo;
import com.palazzisoft.ligabalonpie.entities.EquipoJugador;
import com.palazzisoft.ligabalonpie.util.PageViews;

@Controller
public class JugadorView {

	private JugadorController jugadorController;
	private EquipoController equipoController;

	@Autowired
	public JugadorView(JugadorController jugadorController, EquipoController equipoController) {
		this.jugadorController = jugadorController;
		this.equipoController = equipoController;
	}

	@RequestMapping(value = "/listadoJugador.adm", method = GET)
	public String showBack(Model model) {
		List<JugadorCommand> jugadores = this.jugadorController.obtenerJugadoresDisponibles();

		model.addAttribute("jugadores", jugadores);

		return PageViews.LISTADO_JUGADORES_BACK;
	}
	
	@RequestMapping(value = "/listadoJugadorPorEquipo.adm", method = GET) 
	public String mostrarListadoDeJugadorPorEquipo(@RequestParam("equipoId") Integer equipoId, Model model) {
		Equipo equipo = this.equipoController.getById(equipoId);
		List<JugadorCommand> jugadoresCommand = new ArrayList<>();
		
		for (EquipoJugador equipoJugador : equipo.getEquipoJugadores()) {
			JugadorCommand jugadorCommand = convertirACommand(equipoJugador.getJugador());
			jugadoresCommand.add(jugadorCommand);
		}
		
		model.addAttribute("jugadores", jugadoresCommand);
		
		return LISTADO_JUGADORES_BACK;
	}

	@RequestMapping(value = "/borrarJugador.adm", method = GET) 
	public String onDelete(@ModelAttribute JugadorCommand jugadorCommand, BindingResult bindingResult, Model model) {
				
		if (bindingResult.hasErrors()) {
			bindingResult.rejectValue("id", "error.jugador.id");
			return this.showBack(model);
		}
		
		this.jugadorController.eliminarJugadorById(jugadorCommand.getId());
		
		return this.showBack(model);
	}
	
}
