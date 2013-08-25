package com.palazzisoft.ligabalonpie.controllers.api;

import java.text.ParseException;

import com.palazzisoft.ligabalonpie.command.ParticipanteCommand;
import com.palazzisoft.ligabalonpie.entities.Participante;

public interface ParticipanteController {

	ParticipanteCommand login(String user, String password) throws ParseException;
	
	Participante guardarParticipante(ParticipanteCommand participanteCommand) throws ParseException;

	ParticipanteCommand obtenerParticipantePorId(Integer id) throws ParseException;
}
