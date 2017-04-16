package com.palazzisoft.ligabalonpie.controllers.api;

import java.util.List;

import com.palazzisoft.balonpie.service.model.Jugador;
import com.palazzisoft.ligabalonpie.command.JugadorCommand;

public interface JugadorController {

	List<JugadorCommand> obtenerJugadoresDisponibles();
	
	Jugador getJugadorById(Integer id);
	
	boolean eliminarJugadorById(Integer id);
	
	void updateJugador(Jugador jugador);
	
	void saveJugador(Jugador jugador);

	List<Jugador> obtenerJugadoresDisponiblesPorEquipo(Integer equipoId);

	List<Jugador> obtenerJugadoresDisponiblesPorTipoJugador(Integer tipoJugadorId);

	List<Jugador> obtenerJugadoresDisponiblesParaComprarPorTipoDeJugador(Integer equipoId);	

	List<Jugador> obtenerJugadoresRestantes(Integer ids[]);
}
