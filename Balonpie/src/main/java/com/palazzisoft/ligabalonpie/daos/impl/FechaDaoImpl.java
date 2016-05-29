package com.palazzisoft.ligabalonpie.daos.impl;

import com.palazzisoft.ligabalonpie.daos.api.FechaDao;
import com.palazzisoft.ligabalonpie.entities.Fecha;

public class FechaDaoImpl extends GenericDaoImpl<Fecha, Integer> implements FechaDao {

	@Override
	protected Class<Fecha> getPersistenceClass() {
		return Fecha.class;
	}

}
