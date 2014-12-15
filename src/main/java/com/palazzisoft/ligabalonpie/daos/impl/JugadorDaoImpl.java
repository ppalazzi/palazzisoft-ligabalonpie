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
	@Override
	public List<Jugador> obtenerJugadoresDisponibles() {		
		String sql = "FROM Jugador j";		
		return  this.getHibernateTemplate().find(sql);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Jugador> obtenerJugadoresDisponiblesPorEquipo(Integer equipoId) {		
		String sql = "FROM Jugador j INNER JOIN EquipoJugador e ON j.id = e.jugador.id AND e.equipo.id = " + equipoId;		
		return  this.getHibernateTemplate().find(sql);
	}	
	
}
