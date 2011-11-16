package com.palazzisoft.ligabalonpie.daos.impl;

import java.util.List;

import com.palazzisoft.ligabalonpie.daos.api.EquipoDao;
import com.palazzisoft.ligabalonpie.entities.Equipo;

public class EquipoDaoImpl extends GenericDaoImpl<Equipo,Integer> implements EquipoDao {

	@Override
	protected Class<Equipo> getPersistenceClass() {
		return Equipo.class;
	}

	@SuppressWarnings("unchecked")
	public List<Equipo> obtenerEquipoPorParticipante(Integer id) {
		String sql = "FROM Equipo e where e.id = " + id;		
		return  this.getHibernateTemplate().find(sql);
	}

}
