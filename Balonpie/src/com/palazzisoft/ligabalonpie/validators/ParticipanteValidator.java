package com.palazzisoft.ligabalonpie.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
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
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "error.participante.nombre",
				"Error en nombre");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellido", "error.participante.apellido",
				"Error en apellido");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.participante.email",
				"Error en Email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ciudad", "error.participante.ciudad",
				"Error en Ciudad");		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numero", "error.participante.numero",
				"Error en Número");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fechaNacimiento", "error.participante.fechaNacimiento",
				"Error en Fecha de nacimiento");				
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "calle", "error.participante.calle",
				"Error en Calle");				
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.participante.password",
				"Error en Password");						
	}
}
