package com.palazzisoft.ligabalonpie.daos.api;

import java.util.List;

import com.palazzisoft.balonpie.service.model.Jugador;

public interface JugadorDao extends GenericDao<Jugador,Integer> {

	List<Jugador> obtenerJugadoresDisponibles();

	List<Jugador> obtenerJugadoresDisponiblesPorEquipo(Integer equipoId);

	List<Jugador> obtenerJugadoresDisponiblesPorTipoJugador(Integer tipoJugadorId);

	List<Jugador> obtenerJugadoresDisponiblesParaComprarPorTipoJugador(Integer equipoId);

	List<Jugador> obtenerJugadoresRestantes(Integer[] ids);
}
