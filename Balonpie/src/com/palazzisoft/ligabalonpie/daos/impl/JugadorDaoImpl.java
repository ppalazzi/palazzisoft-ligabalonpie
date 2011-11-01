package com.palazzisoft.ligabalonpie.daos.impl;

import com.palazzisoft.ligabalonpie.daos.api.JugadorDao;
import com.palazzisoft.ligabalonpie.entities.Jugador;

public class JugadorDaoImpl extends GenericDaoImpl<Jugador,Integer> implements JugadorDao {

	public JugadorDaoImpl() {
		
	}
			
	@Override
	protected Class<Jugador> getPersistenceClass() {
		return Jugador.class;
	}

}
