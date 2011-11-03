package com.palazzisoft.ligabalonpie.daos.impl;

import java.util.List;

import com.palazzisoft.ligabalonpie.daos.api.JugadorDao;
import com.palazzisoft.ligabalonpie.entities.Jugador;

public class JugadorDaoImpl extends GenericDaoImpl<Jugador,Integer> implements JugadorDao {

	public JugadorDaoImpl() {
		
	}
			
	@Override
	protected Class<Jugador> getPersistenceClass() {
		return Jugador.class;
	}

	@SuppressWarnings("unchecked")
	public List<Jugador> obtenerJugadoresDisponibles() {		
		String sql = "FROM Jugador j WHERE j.estado = 1";		
		return  this.getHibernateTemplate().find(sql);
	}
	
}
