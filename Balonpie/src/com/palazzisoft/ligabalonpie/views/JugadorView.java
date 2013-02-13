package com.palazzisoft.ligabalonpie.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.palazzisoft.ligabalonpie.controllers.api.EquipoController;
import com.palazzisoft.ligabalonpie.controllers.api.JugadorController;
import com.palazzisoft.ligabalonpie.controllers.api.TipoJugadorController;
import com.palazzisoft.ligabalonpie.entities.Equipo;

@Component
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

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Model model) {
		Equipo equipo = equipoController.getById(1);

		System.out.println(equipo.getDescripcion());

		return null;
	}

}
