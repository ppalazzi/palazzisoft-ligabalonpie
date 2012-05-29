package com.palazzisoft.ligabalonpie.controllers.impl;

import java.text.ParseException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.palazzisoft.ligabalonpie.command.ParticipanteCommand;
import com.palazzisoft.ligabalonpie.controllers.api.ParticipanteController;
import com.palazzisoft.ligabalonpie.converters.ParticipanteConverter;
import com.palazzisoft.ligabalonpie.daos.api.ParticipanteDao;
import com.palazzisoft.ligabalonpie.entities.Pais;
import com.palazzisoft.ligabalonpie.entities.Participante;
import com.palazzisoft.ligabalonpie.enums.EEstadoParticipante;

public class ParticipanteControllerImpl implements ParticipanteController {

	private Logger log = Logger.getLogger(ParticipanteControllerImpl.class);
	
	@Autowired
	private ParticipanteDao participanteDao;

	public ParticipanteControllerImpl() {

	}

	public Participante login(String user, String password) {
		return participanteDao.login(user, password);
	}

	@Override
	public Participante guardarParticipante(ParticipanteCommand participanteCommand) throws ParseException {
		Participante participante = null;
		
		if (!existeParticipante(participanteCommand.getEmail())) {
			participante = this.guardarNuevoParticipante(participanteCommand);
		}	
		
		return participante;
	}
	
	private Participante guardarNuevoParticipante(ParticipanteCommand participanteCommand) throws ParseException {
		Participante participante = ParticipanteConverter
				.convertirCommandAParticipante(participanteCommand);

		participante.setEstado(EEstadoParticipante.ACTIVO.getEstadoParticipante().byteValue());
		Pais pais = new Pais(participanteCommand.getPais());
		participante.setPais(pais);

		participanteDao.save(participante);
		
		log.info("Usuario Guardado correctamente");	
		
		return participante;
	}
	
	private boolean existeParticipante(String email) {
		Participante participante = participanteDao.obtenerParticipantePorEmail(email);
						
		return (participante != null);
	}
}
