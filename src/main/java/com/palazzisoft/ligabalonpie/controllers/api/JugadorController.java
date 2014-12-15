package com.palazzisoft.ligabalonpie.controllers.api;

import java.util.List;

import com.palazzisoft.ligabalonpie.command.JugadorCommand;
import com.palazzisoft.ligabalonpie.entities.Jugador;

public interface JugadorController {

	List<JugadorCommand> obtenerJugadoresDisponibles();
	
	Jugador getJugadorById(Integer id);
	
	boolean eliminarJugadorById(Integer id);
	
	void updateJugador(Jugador jugador);
	
	void saveJugador(Jugador jugador);

	List<Jugador> obtenerJugadoresDisponiblesPorEquipo(Integer equipoId);
}
