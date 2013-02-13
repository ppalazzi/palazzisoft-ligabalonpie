package com.palazzisoft.ligabalonpie.converters;

import java.text.ParseException;

import com.palazzisoft.ligabalonpie.command.ParticipanteCommand;
import com.palazzisoft.ligabalonpie.entities.Pais;
import com.palazzisoft.ligabalonpie.entities.Participante;
import com.palazzisoft.ligabalonpie.entities.ParticipanteTorneo;
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
		
		if (participante.getFechaNacimiento() != null) {
			command.setFechaNacimiento(FechaMascara.dateAFechaMesAno(participante.getFechaNacimiento()));
		}
	
		for (ParticipanteTorneo participanteTorneo : participante.getParticipanteTorneos()) {
			command.agregarTorneo(TorneoConverter.convertirTorneoACommand(participanteTorneo.getTorneo()));
		}
		
		return command;
	}
	
}
