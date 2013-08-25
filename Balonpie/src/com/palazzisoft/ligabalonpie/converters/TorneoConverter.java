package com.palazzisoft.ligabalonpie.converters;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.palazzisoft.ligabalonpie.command.TorneoCommand;
import com.palazzisoft.ligabalonpie.entities.Torneo;
import com.palazzisoft.ligabalonpie.util.FechaMascara;

public class TorneoConverter {

	public static Torneo convertirCommandATorneo(TorneoCommand torneoCommand) throws ParseException {
		Torneo torneo = new Torneo();
		torneo.setDescripcion(torneoCommand.getDescripcion());
		torneo.setEstado(torneoCommand.getEstado());
		
		if (torneoCommand.getFechaCreacion() != null) {
			torneo.setFechaCreacion(FechaMascara.stringToDateFormat(torneoCommand.getFechaCreacion()));
		}
		
		if (torneoCommand.getFechaFin() != null) {
			torneo.setFechaFin(FechaMascara.stringToDateFormat(torneoCommand.getFechaFin()));	
		}
		
		if (torneoCommand.getFechaInicio() != null) {
			torneo.setFechaInicio(FechaMascara.stringToDateFormat(torneoCommand.getFechaInicio()));	
		}
		
		
		return torneo;
	}	
	
	public static TorneoCommand convertirTorneoACommand(Torneo torneo) throws ParseException {
		TorneoCommand command = new TorneoCommand();
		command.setId(torneo.getId());
		command.setDescripcion(torneo.getDescripcion());
		command.setEstado(torneo.getEstado());
		
		if (torneo.getFechaCreacion() != null) {
			command.setFechaCreacion(FechaMascara.dateAFechaMesAno(torneo.getFechaCreacion()));	
		}
		
		if (torneo.getFechaFin() != null) {
			command.setFechaFin(FechaMascara.dateAFechaMesAno(torneo.getFechaFin()));	
		}
		
		if (torneo.getFechaInicio() != null) {
			command.setFechaInicio(FechaMascara.dateAFechaMesAno(torneo.getFechaInicio()));	
		}
				
		return command;
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
