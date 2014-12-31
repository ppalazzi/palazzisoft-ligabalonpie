package com.palazzisoft.ligabalonpie.controllers.api;

import java.util.List;

import com.palazzisoft.ligabalonpie.command.EquipoCommand;
import com.palazzisoft.ligabalonpie.entities.Equipo;
import com.palazzisoft.ligabalonpie.entities.Jugador;

public interface EquipoController {

	List<EquipoCommand> obtenerEquiposPorParticipante(Integer id);
	
	List<Jugador> obtenerJugadoresDeEquipo(Integer id);
	
	void comprarJugador(Jugador jugador, Equipo equipo);

	Equipo getById(Integer id);

	void nuevoEquipo(EquipoCommand equipoCommand, Integer participanteId);

	boolean verificarExistenciaDeEquipo(String nombreEquipo);	

	EquipoCommand obtenerEquipoPorTorneoYParticipante(Integer torneoId, Integer participanteId);

	List<Equipo> obtenerTodosLosEquipos();

	void guardarEquipo(Equipo equipo);

	void obtenerJugadoresDisponiblesParaEquipo(Long equipoId);
}
