package com.palazzisoft.ligabalonpie.daos.api;

import java.util.List;

import com.palazzisoft.ligabalonpie.entities.Jugador;

public interface JugadorDao extends GenericDao<Jugador,Integer> {

	public List<Jugador> obtenerJugadoresDisponibles();
}
