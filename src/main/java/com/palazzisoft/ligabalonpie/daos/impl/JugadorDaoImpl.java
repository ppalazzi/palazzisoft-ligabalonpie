package com.palazzisoft.ligabalonpie.daos.impl;

import static com.palazzisoft.ligabalonpie.enums.EEstado.ACTIVO;

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
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Jugador> obtenerJugadoresDisponiblesPorEquipo(Integer equipoId) {		
		String sql = "FROM Jugador j INNER JOIN EquipoJugador e ON j.id = e.jugador.id AND e.equipo.id = " + equipoId;		
		return  this.getHibernateTemplate().find(sql);
	}	

    @Override
	@SuppressWarnings("unchecked")
	public List<Jugador> obtenerJugadoresDisponiblesPorTipoJugador(Integer tipoJugadorId) {
		String sql = "FROM Jugador j WHERE j.tipoJugador.id = " + tipoJugadorId;
		return this.getHibernateTemplate().find(sql);
	}
	
	@Override
	@SuppressWarnings("unchecked")
    public List<Jugador> obtenerJugadoresDisponiblesParaComprar(Integer equipoId) {
    	String sql = "From Jugador j LEFT JOIN com.palazzisoft.ligabalonpie.entities.EquipoJugador e WITH j = e.jugador WHERE e.jugador IS NULL and e.equipo.id = ? AND j.estado = ?";
    	Object[] values = new Integer[] {equipoId, ACTIVO.getEstado()};
    	return this.getHibernateTemplate().find(sql, values);
    }
}
