package com.palazzisoft.ligabalonpie.converters;

import static com.palazzisoft.ligabalonpie.util.FechaMascara.dateAFechaMesAno;
import static com.palazzisoft.ligabalonpie.util.FechaMascara.stringToDateFormat;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.palazzisoft.balonpie.service.model.Equipo;
import com.palazzisoft.balonpie.service.model.Participante;
import com.palazzisoft.balonpie.service.model.Torneo;
import com.palazzisoft.ligabalonpie.command.EquipoCommand;
import com.palazzisoft.ligabalonpie.command.TorneoCommand;
/**
 * 
 * @author ppalazzi
 *
 */
public class TorneoConverter {

	public static Torneo convertirCommandATorneo(TorneoCommand torneoCommand) throws ParseException {
		Torneo torneo = new Torneo();
		torneo.setDescripcion(torneoCommand.getDescripcion());
		torneo.setEstado(torneoCommand.getEstado());
		torneo.setId(torneoCommand.getId());
		
		if (torneoCommand.getFechaCreacion() != null) {
			torneo.setFechaCreacion(stringToDateFormat(torneoCommand.getFechaCreacion()));
		}
		
		if (torneoCommand.getFechaFin() != null) {
			torneo.setFechaFin(stringToDateFormat(torneoCommand.getFechaFin()));	
		}
		
		if (torneoCommand.getFechaInicio() != null) {
			torneo.setFechaInicio(stringToDateFormat(torneoCommand.getFechaInicio()));	
		}
		
		if (torneoCommand.getParticipanteId() != null) {
			Participante participante = new Participante();
			participante.setId(torneoCommand.getParticipanteId());
			torneo.setParticipante(participante);
		}

		return torneo;
	}	
	
	public static TorneoCommand convertirTorneoACommand(Torneo torneo) throws ParseException {
		TorneoCommand command = new TorneoCommand();
		command.setId(torneo.getId());
		command.setDescripcion(torneo.getDescripcion());
		command.setEstado(torneo.getEstado());
		
		if (torneo.getFechaCreacion() != null) {
			command.setFechaCreacion(dateAFechaMesAno(torneo.getFechaCreacion()));	
		}
		
		if (torneo.getFechaFin() != null) {
			command.setFechaFin(dateAFechaMesAno(torneo.getFechaFin()));	
		}
		
		if (torneo.getFechaInicio() != null) {
			command.setFechaInicio(dateAFechaMesAno(torneo.getFechaInicio()));	
		}
		
		if (torneo.getParticipante() != null) {
			command.setParticipanteId(torneo.getParticipante().getId());
		}
		
		convertEquiposDeTorneo(command, torneo);
		
		return command;
	}
	
	private static void convertEquiposDeTorneo(TorneoCommand torneoCommand, Torneo torneo) {
		for (Equipo equipo : torneo.getEquipos()) {
			EquipoCommand equipoCommand = EquipoConverter.convertirAEquipoCommand(equipo);
			torneoCommand.getEquipos().add(equipoCommand);
		}
	}
	
	public static List<TorneoCommand> convertirListadoACommand(List<Torneo> torneos) throws ParseException {
		List<TorneoCommand> torneosCommand = new ArrayList<TorneoCommand>();
		
		for (Torneo torneo : torneos) {
			TorneoCommand torneoCommand = convertirTorneoACommand(torneo);
			torneosCommand.add(torneoCommand);
		}
		
		return torneosCommand;
	}
}
