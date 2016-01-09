package com.palazzisoft.ligabalonpie.daos.api;

import java.util.List;

import com.palazzisoft.ligabalonpie.entities.Jugador;
import com.palazzisoft.ligabalonpie.entities.TipoJugador;

public interface TipoJugadorDao extends GenericDao<TipoJugador,Integer> {

	public List<TipoJugador> obtenerTiposJugadores();
}
