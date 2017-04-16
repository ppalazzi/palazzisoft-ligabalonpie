package com.palazzisoft.ligabalonpie.daos.impl;

import java.util.List;

import com.palazzisoft.balonpie.service.model.EquipoJugador;
import com.palazzisoft.ligabalonpie.daos.api.EquipoJugadorDao;

public class EquipoJugadorDaoImpl extends GenericDaoImpl<EquipoJugador,Integer> implements EquipoJugadorDao {

	@Override
	protected Class<EquipoJugador> getPersistenceClass() {
		return EquipoJugador.class;
	}

	@Override
	@SuppressWarnings("unchecked")	
	public EquipoJugador obtenerJugadorPorEquipo(Integer jugadorId,
			Integer equipoId) {
		EquipoJugador equipoJugador = null;
		String query = "FROM EquipoJugador ej where ej.jugador.id = ? AND ej.equipo.id = ?";
		
		List<EquipoJugador> resultado = this.getHibernateTemplate().find(query, new Object[]{jugadorId,equipoId} );
		
		if (!resultado.isEmpty()) {
			equipoJugador = resultado.get(0);
		}
		
		
		return equipoJugador;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EquipoJugador> obtenerEquipoJugadoresPorEquipo(Integer equipoId) {
		String query = "FROM EquipoJugador ej WHERE ej.equipo.id = " + equipoId;		
		return this.getHibernateTemplate().find(query);
	}

}
