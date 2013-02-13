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
		String sql = "FROM ParticipanteTorneo pe where  pe.participante.id = ?";		
		
		return this.getHibernateTemplate().find(sql, participanteId);	
	}
	
	@Override
	public Torneo obtenerTorneoPorDescripcion(String descripcion) {
		Torneo torneo = null;
		String sql = "FROM Torneo t where t.descripcion = ?";
		
		@SuppressWarnings("unchecked")
		List<Torneo> resultado = this.getHibernateTemplate().find(sql, descripcion);
		
		if (!resultado.isEmpty()) {
			torneo = resultado.get(PRIMER_ELEMENTO);
		}
		
		return torneo;
	}

}
