package com.palazzisoft.ligabalonpie.validators;

import static org.springframework.validation.ValidationUtils.rejectIfEmptyOrWhitespace;

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
		
		rejectIfEmptyOrWhitespace(errors, "nombre", "error.jugador.nombre", "Debe completar el campo Nombre");
		rejectIfEmptyOrWhitespace(errors, "apellido", "error.jugador.apellido", "Debe completar el campo Apellido");
		rejectIfEmptyOrWhitespace(errors, "fisico", "error.jugador.fisico", "Debe completar el campo Físico");
		rejectIfEmptyOrWhitespace(errors, "habilidad", "error.jugador.habilidad", "Debe completar el campo Habilidad");
		rejectIfEmptyOrWhitespace(errors, "remate", "error.jugador.remate", "Debe completar el campo Remate");
		rejectIfEmptyOrWhitespace(errors, "velocidad", "error.jugador.velocidad", "Debe completar el campo Velocidad");
		rejectIfEmptyOrWhitespace(errors, "valor", "error.jugador.valor", "Debe completar el campo Valor");	
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
