package com.palazzisoft.ligabalonpie.validators;

import static org.springframework.validation.ValidationUtils.rejectIfEmptyOrWhitespace;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.palazzisoft.ligabalonpie.command.ParticipanteCommand;

@Component
public class ParticipanteValidator implements Validator {

	@Override
	public boolean supports(@SuppressWarnings("rawtypes") Class type) {
		return ParticipanteCommand.class.equals(type);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		this.validateEmptyOrWhitespace(errors);
	}

	private void validateEmptyOrWhitespace(Errors errors) {
		rejectIfEmptyOrWhitespace(errors, "nombre", "error.participante.nombre",
				"Error en nombre");
		rejectIfEmptyOrWhitespace(errors, "apellido", "error.participante.apellido",
				"Error en apellido");
		rejectIfEmptyOrWhitespace(errors, "email", "error.participante.email",
				"Error en Email");
		rejectIfEmptyOrWhitespace(errors, "ciudad", "error.participante.ciudad",
				"Error en Ciudad");		
		rejectIfEmptyOrWhitespace(errors, "numero", "error.participante.numero",
				"Error en Número");
		rejectIfEmptyOrWhitespace(errors, "fechaNacimiento", "error.participante.fechaNacimiento",
				"Error en Fecha de nacimiento");				
		rejectIfEmptyOrWhitespace(errors, "calle", "error.participante.calle",
				"Error en Calle");				
		rejectIfEmptyOrWhitespace(errors, "password", "error.participante.password",
				"Error en Password");	
	}
}
