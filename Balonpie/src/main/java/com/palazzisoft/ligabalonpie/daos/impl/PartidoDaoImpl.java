package com.palazzisoft.ligabalonpie.daos.impl;

import com.palazzisoft.balonpie.service.model.Partido;
import com.palazzisoft.ligabalonpie.daos.api.PartidoDao;


public class PartidoDaoImpl extends GenericDaoImpl<Partido, Integer> implements PartidoDao {

	@Override
	protected Class<Partido> getPersistenceClass() {
		return Partido.class;
	}

}
