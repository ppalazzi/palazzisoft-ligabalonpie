package com.palazzisoft.ligabalonpie.daos.impl;

import java.util.List;

import com.palazzisoft.ligabalonpie.daos.api.TorneoDao;
import com.palazzisoft.ligabalonpie.entities.ParticipanteTorneo;
import com.palazzisoft.ligabalonpie.entities.Torneo;

public class TorneoDaoImpl extends GenericDaoImpl<Torneo, Integer> implements TorneoDao {
	
	@Override
	protected Class<Torneo> getPersistenceClass() {
		return Torneo.class;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ParticipanteTorneo> obtenerParticipantesEquiposPorParticipanteId(Integer participanteId) {
		String sql = "FROM ParticipanteEquipo pe where  pe.participante.id = :participanteId";		
		
		return this.getHibernateTemplate().find(sql, participanteId);	
	}

}
