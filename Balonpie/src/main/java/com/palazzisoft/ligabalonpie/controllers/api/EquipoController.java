package com.palazzisoft.ligabalonpie.controllers.api;

import java.util.List;

import com.palazzisoft.balonpie.service.model.Equipo;
import com.palazzisoft.balonpie.service.model.Jugador;
import com.palazzisoft.ligabalonpie.command.EquipoCommand;
/**
 * 
 * @author ppalazzi
 *
 */
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

	Equipo venderJugador(Integer equipoId, Integer jugadorId);

	boolean comprarJugador(Integer equipoId, Integer jugadorId);

	Equipo obtenerEquipoCreadorDeTorneo(Integer torneoId, Integer participanteId);
}
