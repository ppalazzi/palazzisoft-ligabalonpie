package com.palazzisoft.ligabalonpie.validators;

import static org.springframework.validation.ValidationUtils.rejectIfEmptyOrWhitespace;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.palazzisoft.ligabalonpie.command.NuevoTorneoCommand;

/**
 * 
 * @author ppalazzi
 *
 */
@Component
public class NuevoTorneoValidator implements Validator {

	private static final Integer CANTIDAD_JUGADORES = 11;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return NuevoTorneoCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NuevoTorneoCommand nuevoTorneo = (NuevoTorneoCommand) target;
		
		if (!errors.hasErrors()) {
			rejectIfEmptyOrWhitespace(errors, "nombreTorneo", "error.nuevoTorneo.nombreTorneo");
			rejectIfEmptyOrWhitespace(errors, "nombreEquipo", "error.nuevoTorneo.nombreEquipo");
			rejectIfEmptyOrWhitespace(errors, "descripcionEquipo", "error.nuevoTorneo.descripcionEquipo");
			
			this.validarJugadores(nuevoTorneo, errors);
			this.validarJugadoresRepetidos(nuevoTorneo, errors);
		}
	}

	private void validarJugadores(NuevoTorneoCommand nuevoTorneo, Errors errors) {
		for (int i = 0;i < 11; i++) {
			rejectIfEmptyOrWhitespace(errors, "idPos" + i, "error.nuevoTorneo.posicion." + i);			
		}	
	}
	
	private void validarJugadoresRepetidos(NuevoTorneoCommand nuevoTorneo, Errors errors) {
		if (nuevoTorneo.getCantidadJugadores() != CANTIDAD_JUGADORES) {
			errors.rejectValue("cantidadJugadores", "error.nuevoTorneo.jugadoresRepetidos");
		}
	}
}
