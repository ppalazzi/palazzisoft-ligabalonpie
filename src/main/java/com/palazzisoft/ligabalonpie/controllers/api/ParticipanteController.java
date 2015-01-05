package com.palazzisoft.ligabalonpie.controllers.api;

import java.text.ParseException;
import java.util.List;

import com.palazzisoft.ligabalonpie.command.ParticipanteCommand;
import com.palazzisoft.ligabalonpie.entities.Participante;

public interface ParticipanteController {

	ParticipanteCommand login(String user, String password) throws ParseException;
	
	Participante guardarParticipante(ParticipanteCommand participanteCommand) throws ParseException;

	Participante obtenerParticipantePorId(Integer id);

	List<Participante> obtenerParticipantes();

	void guardarParticipante(Participante participante);
}
