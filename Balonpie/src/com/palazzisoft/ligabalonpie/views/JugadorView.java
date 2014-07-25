package com.palazzisoft.ligabalonpie.views;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.palazzisoft.ligabalonpie.command.JugadorCommand;
import com.palazzisoft.ligabalonpie.controllers.api.EquipoController;
import com.palazzisoft.ligabalonpie.controllers.api.JugadorController;
import com.palazzisoft.ligabalonpie.controllers.api.TipoJugadorController;
import com.palazzisoft.ligabalonpie.util.PageViews;

@Controller
public class JugadorView {

	private JugadorController jugadorController;
	private TipoJugadorController tipoJugadorController;
	private EquipoController equipoController;

	@Autowired	
	public JugadorView(JugadorController jugadorController,
			TipoJugadorController tipoJugadorController, EquipoController equipoController) {
		this.jugadorController = jugadorController;
		this.tipoJugadorController = tipoJugadorController;
		this.equipoController = equipoController;
	}

	@RequestMapping(value = "/listadoJugador.adm" , method = GET)
	public String showBack(Model model) {
		List<JugadorCommand> jugadores = this.jugadorController.obtenerJugadoresDisponibles();
	
		model.addAttribute("jugadores", jugadores);
		
		return PageViews.LISTADO_JUGADORES_BACK;
	}

}
