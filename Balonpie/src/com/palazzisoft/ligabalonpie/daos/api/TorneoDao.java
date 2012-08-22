package com.palazzisoft.ligabalonpie.daos.api;

import java.util.List;

import com.palazzisoft.ligabalonpie.entities.ParticipanteTorneo;
import com.palazzisoft.ligabalonpie.entities.Torneo;

public interface TorneoDao extends GenericDao<Torneo,Integer> {

	List<ParticipanteTorneo> obtenerParticipantesEquiposPorParticipanteId(Integer participanteId);

	Torneo obtenerTorneoPorDescripcion(String descripcion);
}
