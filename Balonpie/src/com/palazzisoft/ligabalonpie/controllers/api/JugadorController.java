package com.palazzisoft.ligabalonpie.controllers.api;

import java.util.List;

import com.palazzisoft.ligabalonpie.command.JugadorCommand;
import com.palazzisoft.ligabalonpie.entities.Jugador;

public interface JugadorController {

	public List<JugadorCommand> obtenerJugadoresDisponibles();
	
	public Jugador getJugadorById(Integer id);
	
	boolean eliminarJugadorById(Integer id);
	
	public void updateJugador(Jugador jugador);
	
	public void saveJugador(Jugador jugador);
}
