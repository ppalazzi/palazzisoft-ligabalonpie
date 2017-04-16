package com.palazzisoft.ligabalonpie.controllers.impl;

import static com.palazzisoft.balonpie.service.model.enumeration.EEstado.ACTIVO;
import static com.palazzisoft.ligabalonpie.converters.EquipoConverter.convertirAEquipoCommand;
import static com.palazzisoft.ligabalonpie.converters.EquipoConverter.convertirEquipoACommand;
import static java.util.Calendar.getInstance;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.palazzisoft.balonpie.service.model.Equipo;
import com.palazzisoft.balonpie.service.model.EquipoJugador;
import com.palazzisoft.balonpie.service.model.Jugador;
import com.palazzisoft.ligabalonpie.command.EquipoCommand;
import com.palazzisoft.ligabalonpie.controllers.api.EquipoController;
import com.palazzisoft.ligabalonpie.controllers.api.EquipoJugadorController;
import com.palazzisoft.ligabalonpie.controllers.api.JugadorController;
import com.palazzisoft.ligabalonpie.daos.api.EquipoDao;

@Controller
public class EquipoControllerImpl implements EquipoController {

	private final EquipoDao equipoDao;
	private final EquipoJugadorController equipoJugadorController;
	private final JugadorController jugadorController;

	@Autowired
	public EquipoControllerImpl(final EquipoDao equipoDao,
			final EquipoJugadorController equipoJugadorController, final JugadorController jugadorController) {
		this.equipoDao = equipoDao;
		this.equipoJugadorController = equipoJugadorController;
		this.jugadorController = jugadorController;
	}

	@Override
	@Transactional
	public Equipo getById(Integer id) {
		return equipoDao.getById(id);
	}

	@Override
	public List<EquipoCommand> obtenerEquiposPorParticipante(Integer id) {
		List<Equipo> equipos = equipoDao.obtenerEquipoPorParticipante(id);
		List<EquipoCommand> equiposCommand = new ArrayList<EquipoCommand>();

		if (equipos != null) {
			equiposCommand = convertirEquipoACommand(equipos);
		}

		return equiposCommand;
	}

	@Override
	public List<Jugador> obtenerJugadoresDeEquipo(Integer id) {
		List<EquipoJugador> equiposJugadores = equipoDao
				.obtenerJugadoresPorEquipo(id);
		List<Jugador> respuesta = new ArrayList<Jugador>();

		for (EquipoJugador ej : equiposJugadores) {
			respuesta.add(ej.getJugador());
		}

		return respuesta;
	}

	@Override
	public void comprarJugador(Jugador jugador, Equipo equipo) {
		// TODO falta hacer esto
	}

	@Override
	public void nuevoEquipo(EquipoCommand equipoCommand, Integer participanteId) {
		// TODO deberia ser eliminado el c�digo
	}

	@Override
	public boolean verificarExistenciaDeEquipo(String nombreEquipo) {
		Equipo equipo = this.equipoDao.obtenerEquipoPorNombre(nombreEquipo);

		return (equipo != null);
	}

	@Override
	public EquipoCommand obtenerEquipoPorTorneoYParticipante(Integer torneoId,
			Integer participanteId) {
		Equipo equipo = this.equipoDao.obtenerEquipoPorTorneoYParticipante(
				torneoId, participanteId);

		return convertirAEquipoCommand(equipo);
	}

	@Override
	public List<Equipo> obtenerTodosLosEquipos() {
		return this.equipoDao.obtenerTodosLosEquipos();
	}

	@Override
	@Transactional
	public void guardarEquipo(Equipo equipo) {
		if (equipo.getId() == null) {
			equipo.setFechaCreacion(getInstance().getTime());
			equipo.setEstado(ACTIVO.getEstado());
		}

		this.equipoDao.save(equipo);
	}

	@Override
	@Transactional
	public Equipo venderJugador(Integer equipoId, Integer jugadorId) {
		Equipo equipo = this.equipoDao.getById(equipoId);
		EquipoJugador equipoJugador = equipo
				.buscarEquipoJugadorPorJugador(jugadorId);
		equipo.sumarPresupuesto(Long.valueOf(equipoJugador.getJugador().getValor()));
		equipo.getEquipoJugadores().remove(equipoJugador);
		this.equipoJugadorController.eliminarEquipoJugador(equipoJugador);	
		this.equipoDao.save(equipo);

		return equipo;
	}
	
	@Override
	@Transactional
	public boolean comprarJugador(Integer equipoId, Integer jugadorId) {
		Jugador jugador = this.jugadorController.getJugadorById(jugadorId);
		Equipo equipo = this.equipoDao.getById(equipoId);
		
		if (jugador != null && equipo != null && equipo.agregarNuevoJugador(jugador)) {
			equipo.restarPresupuesto(Long.valueOf(jugador.getValor()));
			this.guardarEquipo(equipo);
			return true;
		}
		
		return false;
	}
	
	@Override
	public Equipo obtenerEquipoCreadorDeTorneo(Integer torneoId, Integer participanteId) {
		return this.equipoDao.obtenerEquipoCreadorDeTorneo(torneoId, participanteId);
	}
}
