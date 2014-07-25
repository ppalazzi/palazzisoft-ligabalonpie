package com.palazzisoft.ligabalonpie.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.palazzisoft.ligabalonpie.command.JugadorCommand;

@Component
public class JugadorValidator implements Validator {

	public boolean supports(Class type) {
		return JugadorCommand.class.isAssignableFrom(type);
	}

	public void validate(Object obj, Errors errors) {
		JugadorCommand command = (JugadorCommand)obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "error.jugador.nombre", "Error en nombre");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellido", "error.jugador.apellido", "Error en Apellido");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fisico", "error.jugador.fisico", "Error en Fisico");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "habilidad", "error.jugador.habilidad", "Error en Habilidad");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "remate", "error.jugador.remate", "Error en Remate");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "velocidad", "error.jugador.velocidad", "Error en Velocidad");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "valor", "error.jugador.valor", "Error en Valor");	
		validarCaracteristicas(command, errors);
	}

	private void validarCaracteristicas(JugadorCommand command,Errors errors) {
		Integer fisico    = command.getFisico() == null ? -1 : command.getFisico();
		Integer habilidad = command.getHabilidad() == null ? -1 : command.getHabilidad();
		Integer remate    = command.getRemate() == null ? -1 : command.getRemate();
		Integer velocidad = command.getVelocidad() == null ? -1 : command.getVelocidad();
		Integer valor     = command.getValor() == null ? 1499 : command.getValor();
		
		if (fisico < 0 || fisico > 100)
			errors.rejectValue("fisico", "error.jugador.fisico.valores");
		
		if (habilidad < 0 || habilidad > 100)
			errors.rejectValue("habilidad", "error.jugador.habilidad.valores");
		
		if (remate < 0 || remate > 100)
			errors.rejectValue("remate", "error.jugador.remate.valores");

		if (velocidad < 0 || velocidad > 100)
			errors.rejectValue("velocidad", "error.jugador.velocidad.valores");
		
		if (valor < 1500 || valor > 999999999)
			errors.rejectValue("valor", "error.jugador.valor.valores");		

	}
}
