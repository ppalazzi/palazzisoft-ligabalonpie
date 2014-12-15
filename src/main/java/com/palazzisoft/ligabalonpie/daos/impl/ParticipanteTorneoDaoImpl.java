package com.palazzisoft.ligabalonpie.daos.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.palazzisoft.ligabalonpie.daos.api.ParticipanteTorneoDao;
import com.palazzisoft.ligabalonpie.entities.ParticipanteTorneo;
import com.palazzisoft.ligabalonpie.entities.ParticipanteTorneoPK;

@Component
public class ParticipanteTorneoDaoImpl extends GenericDaoImpl<ParticipanteTorneo, ParticipanteTorneoPK> implements ParticipanteTorneoDao {

	@Override
	protected Class<ParticipanteTorneo> getPersistenceClass() {
		return ParticipanteTorneo.class;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ParticipanteTorneo> obtenerTorneosDisponiblesPorParticitante(Integer participanteId) {
		String sql = "FROM ParticipanteTorneo pt where pt.participante.id = ?";
		return this.getHibernateTemplate().find(sql, participanteId);
	}
}
