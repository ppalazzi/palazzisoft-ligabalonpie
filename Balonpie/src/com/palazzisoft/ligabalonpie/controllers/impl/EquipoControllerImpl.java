package com.palazzisoft.ligabalonpie.controllers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.palazzisoft.ligabalonpie.controllers.api.EquipoController;
import com.palazzisoft.ligabalonpie.controllers.api.JugadorController;
import com.palazzisoft.ligabalonpie.daos.api.EquipoDao;
import com.palazzisoft.ligabalonpie.entities.Equipo;
import com.palazzisoft.ligabalonpie.entities.EquipoJugador;
import com.palazzisoft.ligabalonpie.entities.Jugador;

public class EquipoControllerImpl implements EquipoController {

	@Autowired
	private EquipoDao equipoDao;
	
	@Autowired
	private JugadorController jugadorController;
	
	@Override
	public Equipo getById(Integer id) {
		return equipoDao.getById(id);
	}
	
	@Override
	public List<Equipo> obtenerEquiposPorParticipante(Integer id) {
		List<Equipo> equipos = equipoDao.obtenerEquipoPorParticipante(id); 
		
		if (equipos == null)
			equipos = new ArrayList<Equipo>();
		
		return equipos;
	}

	@Override
	public List<Jugador> obtenerJugadoresDeEquipo(Integer id) {
		List<EquipoJugador> equiposJugadores = equipoDao.obtenerJugadoresPorEquipo(id);
		List<Jugador> respuesta = new ArrayList<Jugador>();
		
		for (EquipoJugador ej : equiposJugadores) {
			respuesta.add(ej.getJugador());
		}
		
		return respuesta;
	}

	@Override
	public void comprarJugador(Jugador jugador, Equipo equipo) {
		
	}

	
}
