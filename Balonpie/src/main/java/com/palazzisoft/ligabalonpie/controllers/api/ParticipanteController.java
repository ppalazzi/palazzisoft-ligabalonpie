package com.palazzisoft.ligabalonpie.controllers.api;

import java.text.ParseException;
import java.util.List;

import com.palazzisoft.balonpie.service.model.Participante;
import com.palazzisoft.balonpie.service.model.Torneo;
import com.palazzisoft.ligabalonpie.command.ParticipanteCommand;

public interface ParticipanteController {

	ParticipanteCommand login(String user, String password) throws ParseException;
	
	Participante guardarParticipante(ParticipanteCommand participanteCommand) throws ParseException;

	Participante obtenerParticipantePorId(Integer id);

	List<Participante> obtenerParticipantes();

	void guardarParticipante(Participante participante);

	List<Torneo> torneosDeParticipante(Integer participanteId);
}
