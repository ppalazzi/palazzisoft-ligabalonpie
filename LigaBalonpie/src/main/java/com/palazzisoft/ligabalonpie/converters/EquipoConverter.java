package com.palazzisoft.ligabalonpie.converters;

import static com.palazzisoft.ligabalonpie.converters.ConverterUtil.getFormat;

import java.util.ArrayList;
import java.util.List;

import com.palazzisoft.ligabalonpie.command.EquipoCommand;
import com.palazzisoft.ligabalonpie.entities.Equipo;
import com.palazzisoft.ligabalonpie.entities.Participante;
import com.palazzisoft.ligabalonpie.entities.Torneo;

public class EquipoConverter {

	public static Equipo convertirAEquipo(EquipoCommand equipoCommand) {
		Equipo equipo = new Equipo();
		equipo.setId(equipoCommand.getId());
		equipo.setDescripcion(equipoCommand.getDescripcion());
		equipo.setNombre(equipoCommand.getNombre());		
		equipo.setPresupuesto(equipoCommand.getPresupuesto());
		equipo.setPuntos(equipoCommand.getPuntos());
		
		Participante participante = new Participante();		
		if (equipoCommand.getParticipanteId() != null) {
			participante.setId(equipoCommand.getParticipanteId());
			equipo.setParticipante(participante);			
		}
		
		Torneo torneo = new Torneo();
		torneo.setId(equipoCommand.getTorneoId());
		equipo.setTorneo(torneo);
		
		return equipo;
	}
	
	public static EquipoCommand convertirAEquipoCommand(Equipo equipo) {
		EquipoCommand equipoCommand = new EquipoCommand();
		equipoCommand.setDescripcion(equipo.getDescripcion());
		equipoCommand.setNombre(equipo.getNombre());
		equipoCommand.setId(equipo.getId());
		equipoCommand.setEstado(equipo.getEstado());
		equipoCommand.setFechaCreacion(getFormat().format(equipo.getFechaCreacion()));
		equipoCommand.setParticipanteId(equipo.getParticipante().getId());
		equipoCommand.setPresupuesto(equipo.getPresupuesto());
		equipoCommand.setTorneoId(equipo.getTorneo().getId());
		equipoCommand.setPuntos(equipo.getPuntos());
		
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
	
	public static void llenarDatosParaGuardar(EquipoCommand equipoCommand, Equipo equipo) {
		equipo.setNombre(equipoCommand.getNombre());
		equipo.setDescripcion(equipoCommand.getDescripcion());
		equipo.setPresupuesto(equipoCommand.getPresupuesto());
		equipo.setPuntos(equipoCommand.getPuntos());
		equipo.setEstado(equipoCommand.getEstado());
		
		Participante participante = new Participante();
		participante.setId(equipoCommand.getParticipanteId());
		equipo.setParticipante(participante);
	}
}
