package com.palazzisoft.ligabalonpie.daos.api;

import java.util.List;

import com.palazzisoft.ligabalonpie.entities.ParticipanteTorneo;
import com.palazzisoft.ligabalonpie.entities.ParticipanteTorneoPK;

public interface ParticipanteTorneoDao extends GenericDao<ParticipanteTorneo, ParticipanteTorneoPK> {

	List<ParticipanteTorneo> obtenerTorneosDisponiblesPorParticitante(Integer participanteId);

}
