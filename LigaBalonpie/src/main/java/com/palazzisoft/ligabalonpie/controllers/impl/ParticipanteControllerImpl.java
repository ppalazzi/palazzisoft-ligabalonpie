package com.palazzisoft.ligabalonpie.controllers.impl;

import java.text.ParseException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.palazzisoft.ligabalonpie.command.ParticipanteCommand;
import com.palazzisoft.ligabalonpie.controllers.api.ParticipanteController;
import com.palazzisoft.ligabalonpie.converters.ParticipanteConverter;
import com.palazzisoft.ligabalonpie.converters.TorneoConverter;
import com.palazzisoft.ligabalonpie.daos.api.ParticipanteDao;
import com.palazzisoft.ligabalonpie.daos.api.ParticipanteTorneoDao;
import com.palazzisoft.ligabalonpie.entities.Participante;
import com.palazzisoft.ligabalonpie.entities.ParticipanteTorneo;
import com.palazzisoft.ligabalonpie.entities.Torneo;
import com.palazzisoft.ligabalonpie.enums.EEstadoParticipante;

@Controller
public class ParticipanteControllerImpl implements ParticipanteController {

	private Logger log = Logger.getLogger(ParticipanteControllerImpl.class);

	@Autowired
	private ParticipanteDao participanteDao;

	@Autowired
	private ParticipanteTorneoDao participanteTorneoDao;

	public ParticipanteControllerImpl() {

	}

	@Transactional
	public ParticipanteCommand login(String user, String password) throws ParseException {
		Participante participante = participanteDao.login(user, password);

		ParticipanteCommand participanteCommand = ParticipanteConverter
				.convertirParticipanteACommand(participante);

		this.agregarTorneosACommand(participante, participanteCommand);
		
		return participanteCommand;
	}

	private void agregarTorneosACommand(Participante participante,
			ParticipanteCommand participanteCommand) throws ParseException {
		for (ParticipanteTorneo participanteTorneo : participante.getParticipanteTorneos()) {
			Torneo torneo = participanteTorneo.getTorneo();
			participanteCommand.getTorneos().add(TorneoConverter.convertirTorneoACommand(torneo));
		}
	}
	
	@Override
	public Participante guardarParticipante(ParticipanteCommand participanteCommand)
			throws ParseException {
		Participante participante = null;

		if (participanteCommand.getId() != null) {
			participante = this.modificarParticipante(participanteCommand);
		} else if (!existeParticipante(participanteCommand.getEmail())) {
			participante = this.guardarNuevoParticipante(participanteCommand);
		}

		return participante;
	}

	@Override
	@Transactional
	public Participante obtenerParticipantePorId(Integer id) {
		return this.participanteDao.getById(id);
	}

	private Participante modificarParticipante(ParticipanteCommand participanteCommand)
			throws ParseException {
		Participante participante = ParticipanteConverter
				.convertirCommandAParticipante(participanteCommand);

		participante.setEstado(EEstadoParticipante.ACTIVO.getEstadoParticipante().byteValue());
		participanteDao.update(participante);

		log.info("Usuario modificado correctamente");

		return participante;
	}

	private Participante guardarNuevoParticipante(ParticipanteCommand participanteCommand)
			throws ParseException {
		Participante participante = ParticipanteConverter
				.convertirCommandAParticipante(participanteCommand);

		participante.setEstado(EEstadoParticipante.ACTIVO.getEstadoParticipante().byteValue());

		participanteDao.save(participante);

		log.info("Usuario Guardado correctamente");

		return participante;
	}

	private boolean existeParticipante(String email) {
		Participante participante = participanteDao.obtenerParticipantePorEmail(email);

		return (participante != null);
	}
}
