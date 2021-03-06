package com.palazzisoft.ligabalonpie.controllers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.palazzisoft.balonpie.service.model.Jugador;
import com.palazzisoft.balonpie.service.model.enumeration.EEstado;
import com.palazzisoft.ligabalonpie.command.JugadorCommand;
import com.palazzisoft.ligabalonpie.controllers.api.JugadorController;
import com.palazzisoft.ligabalonpie.converters.JugadorConverter;
import com.palazzisoft.ligabalonpie.daos.api.JugadorDao;
@Controller
public class JugadorControllerImpl implements JugadorController {

	@Autowired
	private JugadorDao jugadorDao;
	

	@Transactional (readOnly = true)
	public Jugador getJugadorById(Integer id) {
		return jugadorDao.getById(id);
	}

	/**
	 * Recibe el id del Jugador que se intenta eliminar. 
	 * Devuelve TRUE en caso de que lo haya eliminado con exito y
	 * FALSE en caso contrario.  La baja es lógica, no se elimina
	 * sinó que se le cambia de estado.
	 */
	public boolean eliminarJugadorById(Integer id) {
		Jugador jugador = this.jugadorDao.getById(id);
		
		if (jugador != null) {
			jugador.setEstado(EEstado.INACTIVO.getEstado());
			this.jugadorDao.update(jugador);
			return true;
		}
		
		return false;
	}

	@Transactional
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

	@Override
	public List<Jugador> obtenerJugadoresDisponiblesPorEquipo(Integer equipoId) {
		return this.jugadorDao.obtenerJugadoresDisponiblesPorEquipo(equipoId);
	}
	
	@Override
	public List<Jugador> obtenerJugadoresDisponiblesPorTipoJugador(Integer tipoJugadorId) {
		if (tipoJugadorId == null) {
			return this.jugadorDao.obtenerJugadoresDisponibles();
		}
		
		return this.jugadorDao.obtenerJugadoresDisponiblesPorTipoJugador(tipoJugadorId);
	}
	
	@Transactional
	public void saveJugador(Jugador jugador) {
		this.jugadorDao.save(jugador);	
	}

	@Override
	public List<Jugador> obtenerJugadoresDisponiblesParaComprarPorTipoDeJugador(Integer tipoJugadorId) {
		return this.jugadorDao.obtenerJugadoresDisponiblesParaComprarPorTipoJugador(tipoJugadorId);
	}

	@Override
	public List<Jugador> obtenerJugadoresRestantes(Integer[] ids) {
		return this.jugadorDao.obtenerJugadoresRestantes(ids);
	}
	
}
