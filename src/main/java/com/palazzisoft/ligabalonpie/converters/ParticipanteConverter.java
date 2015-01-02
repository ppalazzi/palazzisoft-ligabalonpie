package com.palazzisoft.ligabalonpie.converters;

import static com.google.common.collect.Lists.newArrayList;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.palazzisoft.ligabalonpie.command.ParticipanteCommand;
import com.palazzisoft.ligabalonpie.entities.Pais;
import com.palazzisoft.ligabalonpie.entities.Participante;
import com.palazzisoft.ligabalonpie.util.FechaMascara;

public class ParticipanteConverter {

	public static Participante convertirCommandAParticipante(
			ParticipanteCommand command) throws ParseException {

		Participante participante = new Participante();
		participante.setId(command.getId());
		participante.setApellido(command.getApellido());
		participante.setCalle(command.getCalle());
		participante.setEmail(command.getEmail());
		participante.setNombre(command.getNombre());
		participante.setNumero(command.getNumero());
		participante.setPassword(command.getPassword());	
		participante.setCiudad(command.getCiudad());
		
		Pais pais = new Pais(command.getPais());
		participante.setPais(pais);
				
		if (command.getFechaNacimiento() != null) {
			participante.setFechaNacimiento(FechaMascara.stringToDateFormat(command.getFechaNacimiento()));			
		}
				
		return participante;			
	}
	
	public static ParticipanteCommand convertirParticipanteACommand(Participante participante) throws ParseException {
		ParticipanteCommand command = new ParticipanteCommand();
		command.setId(participante.getId());
		command.setApellido(participante.getApellido());
		command.setCalle(participante.getCalle());
		command.setEmail(participante.getEmail());		
		command.setNombre(participante.getNombre());
		command.setNumero(participante.getNumero());
		command.setPais(participante.getPais().getId());
		command.setPassword(participante.getPassword());
		command.setCiudad(participante.getCiudad());
		command.setPais(participante.getPais().getId());
		command.setEstado(participante.getEstado().intValue());
		
		if (participante.getFechaNacimiento() != null) {
			command.setFechaNacimiento(FechaMascara.dateAFechaMesAno(participante.getFechaNacimiento()));
		}
			
		return command;
	}
	
	public static List<ParticipanteCommand> convertirParticipantesACommand(List<Participante> participantes) throws ParseException {
		ArrayList<ParticipanteCommand> participantesCommand = newArrayList();
		
		for (Participante participante : participantes) {
			participantesCommand.add(convertirParticipanteACommand(participante));
		}
		
		return participantesCommand;
	}
}
