package com.palazzisoft.ligabalonpie.daos.impl;

import java.util.List;

import com.palazzisoft.ligabalonpie.daos.api.TipoJugadorDao;
import com.palazzisoft.ligabalonpie.entities.TipoJugador;


public class TipoJugadorDaoImpl extends GenericDaoImpl<TipoJugador,Integer> implements TipoJugadorDao {

	@Override
	protected Class<TipoJugador> getPersistenceClass() {
		return TipoJugador.class;
	}

	public void save(TipoJugadorDao object) {
		// TODO
	}

	public void update(TipoJugadorDao object) {
		// TODO
	}

	public List<TipoJugador> obtenerTiposJugadores() {
		String sql = "FROM TipoJugador";		
		return  this.getHibernateTemplate().find(sql);
	}
}
