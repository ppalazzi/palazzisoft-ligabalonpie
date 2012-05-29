package com.palazzisoft.ligabalonpie.controllers.api;

import java.text.ParseException;

import com.palazzisoft.ligabalonpie.command.ParticipanteCommand;
import com.palazzisoft.ligabalonpie.entities.Participante;

public interface ParticipanteController {

	Participante login(String user, String password);
	
	Participante guardarParticipante(ParticipanteCommand participanteCommand) throws ParseException;
}
