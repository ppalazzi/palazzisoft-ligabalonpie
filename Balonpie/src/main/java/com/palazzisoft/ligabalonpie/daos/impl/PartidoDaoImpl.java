package com.palazzisoft.ligabalonpie.daos.impl;

import com.palazzisoft.ligabalonpie.daos.api.PartidoDao;
import com.palazzisoft.ligabalonpie.entities.Partido;


public class PartidoDaoImpl extends GenericDaoImpl<Partido, Integer> implements PartidoDao {

	@Override
	protected Class<Partido> getPersistenceClass() {
		return Partido.class;
	}

}
