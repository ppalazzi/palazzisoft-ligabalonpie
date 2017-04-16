package com.palazzisoft.ligabalonpie.daos.impl;

import java.util.ArrayList;
import java.util.List;

import com.palazzisoft.balonpie.service.model.Equipo;
import com.palazzisoft.balonpie.service.model.EquipoJugador;
import com.palazzisoft.ligabalonpie.daos.api.EquipoDao;

public class EquipoDaoImpl extends GenericDaoImpl<Equipo, Integer> implements EquipoDao {

	@Override
	protected Class<Equipo> getPersistenceClass() {
		return Equipo.class;
	}

	@SuppressWarnings("unchecked")
	public List<Equipo> obtenerEquipoPorParticipante(Integer id) {
		String sql = "FROM Equipo e where e.id = " + id;
		return this.getHibernateTemplate().find(sql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EquipoJugador> obtenerJugadoresPorEquipo(Integer id) {
		String sql = "FROM EquipoJugador e where e.equipo.id = " + id;
		return this.getHibernateTemplate().find(sql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Equipo obtenerEquipoPorNombre(String nombre) {
		Equipo equipo = null;
		String sql = "FROM Equipo e where e.nombre = ? ";

		List<Equipo> equipos = this.getHibernateTemplate().find(sql, nombre);

		if (!equipos.isEmpty()) {
			equipo = equipos.get(PRIMER_ELEMENTO);
		}

		return equipo;
	}

	@Override
	public Equipo obtenerEquipoPorTorneoYParticipante(Integer torneoId, Integer participanteId) {
		String sql = "FROM Equipo e where e.participante.id = ? and e.torneo.id = ?";

		@SuppressWarnings("unchecked")
		List<Equipo> equipos = this.getHibernateTemplate().find(sql,
				new Object[] { participanteId, torneoId });

		return devolverPrimerElemento(equipos);
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Equipo> obtenerTodosLosEquipos() {
		List<Equipo> equipos = new ArrayList<Equipo>();
		equipos = this.getHibernateTemplate().find("FROM Equipo e");
		
		return equipos;
	}
	
	@SuppressWarnings("unchecked")
	public Equipo obtenerEquipoCreadorDeTorneo(Integer torneoId, Integer participanteId) {
		String sql = "SELECT et.id.equipo FROM EquipoTorneo et "
				+ "WHERE et.id.equipo.participante.id = ? AND et.id.torneo.id = ?";
		
		Object[] parameters = new Object[] {participanteId, torneoId};		
		List<Equipo> equipos = this.getHibernateTemplate().find(sql, parameters);
		
		return devolverPrimerElemento(equipos);
	}
	
	private Equipo devolverPrimerElemento(List<Equipo> equipos) {
		Equipo equipo = null;
		
		if (!equipos.isEmpty()) {
			equipo = equipos.get(PRIMER_ELEMENTO);
		}

		return equipo;		
	}	
}
