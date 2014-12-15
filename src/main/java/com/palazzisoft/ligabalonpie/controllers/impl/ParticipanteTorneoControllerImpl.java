package com.palazzisoft.ligabalonpie.controllers.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.palazzisoft.ligabalonpie.command.TorneoCommand;
import com.palazzisoft.ligabalonpie.controllers.api.ParticipanteTorneoController;
import com.palazzisoft.ligabalonpie.converters.TorneoConverter;
import com.palazzisoft.ligabalonpie.daos.api.ParticipanteTorneoDao;
import com.palazzisoft.ligabalonpie.entities.ParticipanteTorneo;

@Component
public class ParticipanteTorneoControllerImpl implements ParticipanteTorneoController {

	private ParticipanteTorneoDao participanteTorneoDao;

	@Autowired	
	public ParticipanteTorneoControllerImpl(ParticipanteTorneoDao participanteTorneoDao) {
		this.participanteTorneoDao = participanteTorneoDao;
	}
	
	public void guardarParticipanteTorneo(ParticipanteTorneo participanteTorneo) {
		this.participanteTorneoDao.save(participanteTorneo);
	}

	@Override
	public List<TorneoCommand> obtenerTorneosDisponiblesPorParticipante(Integer participanteId)
			throws ParseException {
		List<ParticipanteTorneo> participantesTorneos = this.participanteTorneoDao
				.obtenerTorneosDisponiblesPorParticitante(participanteId);
		return this.filtrarSoloTorneos(participantesTorneos);
	}

	private List<TorneoCommand> filtrarSoloTorneos(List<ParticipanteTorneo> participantesTorneos)
			throws ParseException {
		List<TorneoCommand> torneosCommand = new ArrayList<TorneoCommand>();

		for (ParticipanteTorneo participanteTorneo : participantesTorneos) {
			TorneoCommand torneoCommand = TorneoConverter
					.convertirTorneoACommand(participanteTorneo.getTorneo());
			torneosCommand.add(torneoCommand);
		}

		return torneosCommand;
	}
}
