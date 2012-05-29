package com.palazzisoft.ligabalonpie.daos.api;

import java.util.List;

import com.palazzisoft.ligabalonpie.entities.ParticipanteTorneo;
import com.palazzisoft.ligabalonpie.entities.Torneo;

public interface TorneoDao extends GenericDao<Torneo,Integer> {

	public List<ParticipanteTorneo> obtenerParticipantesEquiposPorParticipanteId(Integer participanteId);
}
