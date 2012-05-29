package com.palazzisoft.ligabalonpie.controllers.api;

import java.util.List;

import com.palazzisoft.ligabalonpie.entities.Equipo;
import com.palazzisoft.ligabalonpie.entities.Jugador;

public interface EquipoController {

	public List<Equipo> obtenerEquiposPorParticipante(Integer id);
	
	public List<Jugador> obtenerJugadoresDeEquipo(Integer id);
	
	public void comprarJugador(Jugador jugador, Equipo equipo);

	public Equipo getById(Integer id);	
}
