package com.palazzisoft.ligabalonpie.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.palazzisoft.ligabalonpie.controllers.api.JugadorController;
import com.palazzisoft.ligabalonpie.daos.api.JugadorDao;
import com.palazzisoft.ligabalonpie.entities.Jugador;

public class JugadorControllerImpl implements JugadorController {

	@Autowired
	private JugadorDao jugadorDao;
	

	public Jugador getJugadorById(Integer id) {
		return jugadorDao.getById(id);
	}

	public void eliminarJugadorById(Integer id) {
		// TODO hacer el método generico en el DAO
	}

	public void updateJugador(Jugador jugador) {
		this.jugadorDao.update(jugador);
	}

	public List<Jugador> obtenerJugadoresDisponibles() {
		return jugadorDao.obtenerJugadoresDisponibles();
	}
	
}
