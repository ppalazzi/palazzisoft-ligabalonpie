package com.palazzisoft.ligabalonpie.controllers.api;

import com.palazzisoft.balonpie.service.model.EquipoJugador;

/**
 * 
 * @author ppalazzi
 *
 */
public interface EquipoJugadorController {

	public Boolean perteneceJugadorAlEquipo(Integer jugadorId, Integer equipoId);
	
	public void agregarJugadorAlEquipo(Integer jugadorId, Integer equipoId);
	
	public Integer obtenerValorEquipo(Integer equipoId);

	void eliminarEquipoJugador(EquipoJugador equipoJugador);	
	
}
