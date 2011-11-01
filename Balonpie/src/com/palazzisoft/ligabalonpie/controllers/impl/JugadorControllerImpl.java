package com.palazzisoft.ligabalonpie.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.palazzisoft.ligabalonpie.controllers.api.JugadorController;
import com.palazzisoft.ligabalonpie.daos.api.JugadorDao;
import com.palazzisoft.ligabalonpie.entities.Jugador;

public class JugadorControllerImpl implements JugadorController {

	@Autowired
	private JugadorDao jugadorDao;
	
	@Override
	public void getAll() {
		
	}

	@Override
	public Jugador getJugadorById(Integer id) {
		return jugadorDao.getById(id);
	}

	@Override
	public void eliminarJugadorById(Integer id) {
		// TODO hacer el método generico en el DAO
	}

	@Override
	public void updateJugador(Jugador jugador) {
		this.jugadorDao.update(jugador);
	}
	
}
