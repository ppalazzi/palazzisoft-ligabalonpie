package com.palazzisoft.ligabalonpie.controllers.api;

import com.palazzisoft.ligabalonpie.entities.Jugador;

public interface JugadorController {

	public void getAll();
	
	public Jugador getJugadorById(Integer id);
	
	public void eliminarJugadorById(Integer id);
	
	public void updateJugador(Jugador jugador);
}
