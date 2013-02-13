package com.palazzisoft.ligabalonpie.converters;

import java.util.ArrayList;
import java.util.List;

import com.palazzisoft.ligabalonpie.command.EquipoCommand;
import com.palazzisoft.ligabalonpie.entities.Equipo;

public class EquipoConverter {

	public static Equipo convertirAEquipo(EquipoCommand equipoCommand) {
		Equipo equipo = new Equipo();
		equipo.setDescripcion(equipoCommand.getDescripcion());
		equipo.setNombre(equipoCommand.getNombre());
		
		return equipo;
	}
	
	public static EquipoCommand convertirAEquipoCommand(Equipo equipo) {
		EquipoCommand equipoCommand = new EquipoCommand();
		equipoCommand.setDescripcion(equipo.getDescripcion());
		equipoCommand.setNombre(equipo.getNombre());
		equipoCommand.setId(String.valueOf(equipo.getId()));
		
		return equipoCommand;
	}
	
	public static List<EquipoCommand> convertirEquipoACommand(List<Equipo> equipos) {
		List<EquipoCommand> equiposCommand = new ArrayList<EquipoCommand>();
		
		for (Equipo equipo : equipos) {
			EquipoCommand equipoCommand = convertirAEquipoCommand(equipo);
			equiposCommand.add(equipoCommand);
		}
		
		return equiposCommand;
	}
}
