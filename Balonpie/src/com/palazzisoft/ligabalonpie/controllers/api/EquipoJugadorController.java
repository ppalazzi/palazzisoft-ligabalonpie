package com.palazzisoft.ligabalonpie.controllers.api;

public interface EquipoJugadorController {

	public Boolean perteneceJugadorAlEquipo(Integer jugadorId, Integer equipoId);
	
	public void agregarJugadorAlEquipo(Integer jugadorId, Integer equipoId);
	
	public Integer obtenerValorEquipo(Integer equipoId);	
	
}
