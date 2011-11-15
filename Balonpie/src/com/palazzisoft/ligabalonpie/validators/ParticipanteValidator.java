package com.palazzisoft.ligabalonpie.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.palazzisoft.ligabalonpie.command.JugadorCommand;

public class ParticipanteValidator implements Validator {

	public boolean supports(Class type) {
		return JugadorCommand.class.equals(type);
	}

	public void validate(Object obj, Errors errors) {
		JugadorCommand command = (JugadorCommand)obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "error.usuario.nombre", "Error en nombre");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellido", "error.usuario.apellido", "Error en Apellido");
	}

}
