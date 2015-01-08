package com.palazzisoft.ligabalonpie.controllers.api;

import java.util.List;

import com.palazzisoft.ligabalonpie.entities.Torneo;
/**
 * 
 * @author ppalazzi
 *
 */
public interface TorneoController {

	Torneo obtenerTorneoPorId(Integer id);

	List<Torneo> obtenerTodosLosTorneos();

	void guardarTorneo(Torneo torneo);
}
