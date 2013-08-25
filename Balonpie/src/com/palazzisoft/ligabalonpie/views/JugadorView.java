package com.palazzisoft.ligabalonpie.views;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.palazzisoft.ligabalonpie.controllers.api.EquipoController;
import com.palazzisoft.ligabalonpie.controllers.api.JugadorController;
import com.palazzisoft.ligabalonpie.controllers.api.TipoJugadorController;
import com.palazzisoft.ligabalonpie.entities.Jugador;
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

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/listadoJugador.adm" , method = RequestMethod.GET)
	public String showBack(ModelMap model) {
		List<Jugador> jugadores = this.jugadorController.obtenerJugadoresDisponibles();

		model.put("jugadores", jugadores);
		
		return PageViews.LISTADO_JUGADORES_BACK;
	}

}
