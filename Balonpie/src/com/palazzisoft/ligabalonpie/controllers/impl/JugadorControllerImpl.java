package com.palazzisoft.ligabalonpie.controllers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.palazzisoft.ligabalonpie.command.JugadorCommand;
import com.palazzisoft.ligabalonpie.controllers.api.JugadorController;
import com.palazzisoft.ligabalonpie.converters.JugadorConverter;
import com.palazzisoft.ligabalonpie.daos.api.JugadorDao;
import com.palazzisoft.ligabalonpie.entities.Jugador;

public class JugadorControllerImpl implements JugadorController {

	@Autowired
	private JugadorDao jugadorDao;
	

	public Jugador getJugadorById(Integer id) {
		return jugadorDao.getById(id);
	}

	public void eliminarJugadorById(Integer id) {
		// TODO hacer el m�todo generico en el DAO
	}

	public void updateJugador(Jugador jugador) {
		this.jugadorDao.update(jugador);
	}

	@Transactional
	public List<JugadorCommand> obtenerJugadoresDisponibles() {
		List<Jugador> jugadores = jugadorDao.obtenerJugadoresDisponibles();
		List<JugadorCommand> jugadoresCommand = new ArrayList<JugadorCommand>();
		
		for (Jugador jugador : jugadores) {
			JugadorCommand jugaadorCommand = JugadorConverter.convertirACommand(jugador);
			jugadoresCommand.add(jugaadorCommand);
		}
		
		return jugadoresCommand;
	}

	public void saveJugador(Jugador jugador) {
		this.jugadorDao.save(jugador);
	}
	
}
