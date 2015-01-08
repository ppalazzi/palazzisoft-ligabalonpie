package com.palazzisoft.ligabalonpie.validators;

import static com.mysql.jdbc.StringUtils.isNullOrEmpty;
import static com.palazzisoft.ligabalonpie.util.PropertiesValues.PRESUPUESTO_MAXIMO;
import static com.palazzisoft.ligabalonpie.util.PropertiesValues.PUNTOS_MAXIMO;
import static org.springframework.validation.ValidationUtils.rejectIfEmptyOrWhitespace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.palazzisoft.ligabalonpie.command.EquipoCommand;
import com.palazzisoft.ligabalonpie.controllers.api.ParticipanteController;
import com.palazzisoft.ligabalonpie.controllers.api.TorneoController;
import com.palazzisoft.ligabalonpie.entities.Participante;
import com.palazzisoft.ligabalonpie.entities.Torneo;


/**
 * @author ppalazzi
 */
@Component
public class EquipoValidator implements Validator {

	private final ParticipanteController participanteController;
	private TorneoController torneoController;
	
	@Autowired
	public EquipoValidator(final ParticipanteController participanteController, final TorneoController torneoController) {
		this.participanteController = participanteController;
		this.torneoController = torneoController;
	}
	
	@Override
	public boolean supports(@SuppressWarnings("rawtypes") Class type) {
		return EquipoCommand.class.isAssignableFrom(type);
	}

	@Override
	public void validate(Object target, Errors errors) {
		EquipoCommand equipoCommand = (EquipoCommand)target;
		
		if (!errors.hasErrors()) {
			rejectIfEmptyOrWhitespace(errors, "presupuesto", "error.equipo.presupuesto.vacio");
			rejectIfEmptyOrWhitespace(errors, "puntos", "error.equipo.puntos.vacio");
			rejectIfEmptyOrWhitespace(errors, "torneoId", "error.equipo.torneo.vacio");
			
			this.validarValores(equipoCommand, errors);			
		}
	}
	
	private void validarValores(EquipoCommand equipoCommand, Errors errors) {
		if (isNullOrEmpty(equipoCommand.getNombre())) {
			errors.rejectValue("nombre", "error.equipo.nombre.vacio");
		}
		
		if (isNullOrEmpty(equipoCommand.getDescripcion())) {
			errors.rejectValue("descripcion", "error.equipo.descripcion.vacio");
		}
		
		if (equipoCommand.getPresupuesto() != null && equipoCommand.getPresupuesto() > PRESUPUESTO_MAXIMO) {
			errors.rejectValue("presupuesto", "error.equipo.presupuesto.valor.maximo");
		}
		
		if (equipoCommand.getPuntos() != null && equipoCommand.getPuntos() > PUNTOS_MAXIMO) {
			errors.rejectValue("puntos", "error.equipo.presupuesto.puntos.maximo");
		}
		
		if (equipoCommand.getParticipanteId() != null) {
			Participante participante = this.participanteController.obtenerParticipantePorId(equipoCommand.getParticipanteId());
			
			if (participante == null) {
				errors.rejectValue("participanteId", "error.equipo.participante.id");
			}
		}
		
		if (equipoCommand.getTorneoId() != null) {
			Torneo torneo  = this.torneoController.obtenerTorneoPorId(equipoCommand.getTorneoId());			
			if (torneo == null) {
				errors.rejectValue("torneoId", "error.equipo.torneo.id");
			}
			
		}
	}
}
