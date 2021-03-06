package com.palazzisoft.ligabalonpie.daos.api;

import java.util.List;

import com.palazzisoft.balonpie.service.model.EquipoJugador;

public interface EquipoJugadorDao extends GenericDao<EquipoJugador,Integer> {

	public EquipoJugador obtenerJugadorPorEquipo(Integer jugadorId, Integer equipoId);
	
	public List<EquipoJugador> obtenerEquipoJugadoresPorEquipo(Integer equipoId);
}
