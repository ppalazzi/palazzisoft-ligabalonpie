package com.palazzisoft.ligabalonpie.daos.api;

import java.util.List;

import com.palazzisoft.balonpie.service.model.Jugador;
import com.palazzisoft.balonpie.service.model.TipoJugador;

public interface TipoJugadorDao extends GenericDao<TipoJugador,Integer> {

	public List<TipoJugador> obtenerTiposJugadores();
}
