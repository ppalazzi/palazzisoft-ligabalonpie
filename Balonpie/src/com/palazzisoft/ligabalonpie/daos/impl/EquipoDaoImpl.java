package com.palazzisoft.ligabalonpie.daos.impl;

import java.util.List;

import com.palazzisoft.ligabalonpie.daos.api.EquipoDao;
import com.palazzisoft.ligabalonpie.entities.Equipo;
import com.palazzisoft.ligabalonpie.entities.EquipoJugador;

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
		Equipo equipo = null;
		String sql = "FROM Equipo e where e.participante.id = ? and e.torneo.id = ?";

		@SuppressWarnings("unchecked")
		List<Equipo> equipos = this.getHibernateTemplate().find(sql,
				new Object[] { participanteId, torneoId });

		if (!equipos.isEmpty()) {
			equipo = equipos.get(PRIMER_ELEMENTO);
		}

		return equipo;
	}
}
