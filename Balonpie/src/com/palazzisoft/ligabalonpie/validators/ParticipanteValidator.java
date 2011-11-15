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
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "error.jugador.nombre", "Error en nombre");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellido", "error.jugador.apellido", "Error en Apellido");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fisico", "error.jugador.fisico", "Error en Fisico");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "habilidad", "error.jugador.habilidad", "Error en Habilidad");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "remate", "error.jugador.remate", "Error en Remate");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "velocidad", "error.jugador.velocidad", "Error en Velocidad");		
		validarCaracteristicas(command, errors);
	}

	private void validarCaracteristicas(JugadorCommand command,Errors errors) {
		Integer fisico    = command.getFisico() == null ? -1 : command.getFisico();
		Integer habilidad = command.getHabilidad() == null ? -1 : command.getHabilidad();
		Integer remate    = command.getRemate() == null ? -1 : command.getRemate();
		Integer velocidad = command.getVelocidad() == null ? -1 : command.getVelocidad();
		
		if (fisico < 0 || fisico > 100)
			errors.rejectValue("fisico", "error.jugador.fisico.valores");
		
		if (habilidad < 0 || habilidad > 100)
			errors.rejectValue("habilidad", "error.jugador.habilidad.valores");
		
		if (remate < 0 || remate > 100)
			errors.rejectValue("remate", "error.jugador.remate.valores");

		if (velocidad < 0 || velocidad > 100)
			errors.rejectValue("velocidad", "error.jugador.velocidad.valores");		
	}
}
