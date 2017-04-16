package com.palazzisoft.ligabalonpie.controllers.impl;

import java.text.ParseException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.palazzisoft.balonpie.service.model.Participante;
import com.palazzisoft.balonpie.service.model.Torneo;
import com.palazzisoft.balonpie.service.model.enumeration.EEstadoParticipante;
import com.palazzisoft.ligabalonpie.command.ParticipanteCommand;
import com.palazzisoft.ligabalonpie.controllers.api.ParticipanteController;
import com.palazzisoft.ligabalonpie.converters.ParticipanteConverter;
import com.palazzisoft.ligabalonpie.daos.api.ParticipanteDao;
import com.palazzisoft.ligabalonpie.daos.api.TorneoDao;

@Controller
public class ParticipanteControllerImpl implements ParticipanteController {

	private Logger log = Logger.getLogger(ParticipanteControllerImpl.class);

	private final ParticipanteDao participanteDao;
	private final TorneoDao torneoDao;

	@Autowired
	public ParticipanteControllerImpl(final ParticipanteDao participanteDao, final TorneoDao torneoDao) {
		this.participanteDao = participanteDao;
		this.torneoDao = torneoDao;
	}

	@Transactional
	public ParticipanteCommand login(String user, String password) throws ParseException {
		Participante participante = participanteDao.login(user, password);

		ParticipanteCommand participanteCommand = ParticipanteConverter
				.convertirParticipanteACommand(participante);
		
		return participanteCommand;
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
	public void guardarParticipante(Participante participante) {
		this.participanteDao.save(participante);
	}
	
	@Override
	@Transactional (readOnly = true)
	public Participante obtenerParticipantePorId(Integer id) {
		return this.participanteDao.getById(id);
	}

	@Override
	@Transactional (readOnly = true)
	public List<Participante> obtenerParticipantes() {
		return this.participanteDao.obtenerParticipantes();
	}
	
	@Override
	public List<Torneo> torneosDeParticipante(Integer participanteId) {
		return this.torneoDao.obtenerTorneosDeParticipante(participanteId);
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
