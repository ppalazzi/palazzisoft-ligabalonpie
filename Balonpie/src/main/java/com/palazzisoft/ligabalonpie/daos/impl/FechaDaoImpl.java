package com.palazzisoft.ligabalonpie.daos.impl;

import com.palazzisoft.balonpie.service.model.Fecha;
import com.palazzisoft.ligabalonpie.daos.api.FechaDao;

public class FechaDaoImpl extends GenericDaoImpl<Fecha, Integer> implements FechaDao {

	@Override
	protected Class<Fecha> getPersistenceClass() {
		return Fecha.class;
	}

}
