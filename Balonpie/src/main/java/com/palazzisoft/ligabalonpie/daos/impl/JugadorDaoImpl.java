package com.palazzisoft.ligabalonpie.daos.impl;

import static com.palazzisoft.ligabalonpie.enums.EEstado.ACTIVO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

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
    public List<Jugador> obtenerJugadoresDisponiblesParaComprarPorTipoJugador(Integer tipoJugadorId) {
    	String sql = "Select j From Jugador j LEFT JOIN "
    			+ "FETCH j.equipoJugadores  e WHERE e.jugador IS NULL "
    			+ "AND j.tipoJugador.id = ? and j.estado = ? ";
    	Object[] values = new Integer[] {tipoJugadorId, ACTIVO.getEstado()};
    	return this.getHibernateTemplate().find(sql, values);
    }
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Jugador> obtenerJugadoresRestantes(Integer ids[]) {
		Criteria criteria = this.getSession().createCriteria(Jugador.class);
		criteria.add(Restrictions.not(Restrictions.in("id", ids)));
		
		return criteria.list();
	}
}
