package com.palazzisoft.ligabalonpie.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.palazzisoft.ligabalonpie.controllers.api.EquipoJugadorController;
import com.palazzisoft.ligabalonpie.daos.api.EquipoJugadorDao;
import com.palazzisoft.ligabalonpie.entities.Equipo;
import com.palazzisoft.ligabalonpie.entities.EquipoJugador;
import com.palazzisoft.ligabalonpie.entities.Jugador;

public class EquipoJugadorControllerImpl implements EquipoJugadorController {

	@Autowired
	private EquipoJugadorDao equipoJugadorDao;
	
	@Override
	public Boolean perteneceJugadorAlEquipo(Integer jugadorId, Integer equipoId) {
		Boolean respuesta = Boolean.FALSE;
		
		EquipoJugador ej = equipoJugadorDao.obtenerJugadorPorEquipo(jugadorId, equipoId);
		
		if (ej != null)
			respuesta = Boolean.TRUE;
		
		return respuesta;
	}

	@Override
	public void agregarJugadorAlEquipo(Integer jugadorId, Integer equipoId) {
		EquipoJugador ej = new EquipoJugador();
		
		Jugador jugador = new Jugador();
		jugador.setId(jugadorId);
		
		Equipo equipo = new Equipo();
		equipo.setId(equipoId);
		
		ej.setEquipo(equipo);
		ej.setJugador(jugador);
		
		equipoJugadorDao.save(ej);
	}

	@Override
	public Integer obtenerValorEquipo(Integer equipoId) {
		Integer costoEquipo = 0;
		List<EquipoJugador> equipoJugador = equipoJugadorDao.obtenerEquipoJugadoresPorEquipo(equipoId);
		
		for (EquipoJugador ej : equipoJugador) {
			costoEquipo = costoEquipo + ej.getJugador().getValor();
		}
		
		return costoEquipo;
	}

}
