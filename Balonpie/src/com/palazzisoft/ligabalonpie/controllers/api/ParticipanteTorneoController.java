package com.palazzisoft.ligabalonpie.controllers.api;

import java.text.ParseException;
import java.util.List;

import com.palazzisoft.ligabalonpie.command.TorneoCommand;
import com.palazzisoft.ligabalonpie.entities.ParticipanteTorneo;

public interface ParticipanteTorneoController {

	void guardarParticipanteTorneo(ParticipanteTorneo participanteTorneo);

	List<TorneoCommand> obtenerTorneosDisponiblesPorParticipante(Integer participanteId)
			throws ParseException;
}
