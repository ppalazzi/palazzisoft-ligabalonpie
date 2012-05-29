package com.palazzisoft.ligabalonpie.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.palazzisoft.ligabalonpie.command.ParticipanteCommand;
import com.palazzisoft.ligabalonpie.entities.Participante;

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
		
		if (command.getFechaNacimiento() != null) {
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			format.parse(command.getFechaNacimiento());			
		}
				
		return participante;
	}
}
