package com.palazzisoft.ligabalonpie.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.palazzisoft.ligabalonpie.command.ParticipanteCommand;
import com.palazzisoft.ligabalonpie.entities.Participante;
import com.palazzisoft.ligabalonpie.util.FechaMascara;

public class ParticipanteConverter {

	public static Participante convertirCommandAParticipante(
			ParticipanteCommand command) throws ParseException {

		Participante participante = new Participante();
		participante.setApellido(command.getApellido());
		participante.setCalle(command.getCalle());
		participante.setEmail(command.getEmail());
		participante.setNombre(command.getNombre());
		participante.setNumero(command.getNumero());
		participante.setPassword(command.getPassword());	
		participante.setCiudad(command.getCiudad());
		
		// TODO usar el FechaMascara
		if (command.getFechaNacimiento() != null) {
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			format.parse(command.getFechaNacimiento());			
		}
				
		return participante;
	}
	
	public static ParticipanteCommand convertirParticipanteACommand(Participante participante) {
		ParticipanteCommand command = new ParticipanteCommand();
		command.setApellido(participante.getApellido());
		command.setCalle(participante.getCalle());
		command.setEmail(participante.getEmail());		
		command.setNombre(participante.getNombre());
		command.setNumero(participante.getNumero());
		command.setPais(participante.getPais().getId());
		command.setPassword(participante.getPassword());
		command.setCiudad(participante.getCiudad());
		
		if (participante.getFechaNacimiento() != null) {
			command.setFechaNacimiento(FechaMascara.dateAFechaMesAno(participante.getFechaNacimiento()));
		}
				
		return command;
	}
}
