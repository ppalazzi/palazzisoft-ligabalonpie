package com.palazzisoft.ligabalonpie.controllers.api;

import java.util.List;

import com.palazzisoft.balonpie.service.model.Torneo;
import com.palazzisoft.ligabalonpie.command.NuevoTorneoCommand;
import com.palazzisoft.ligabalonpie.exception.BalonpieException;
/**
 * 
 * @author ppalazzi
 *
 */
public interface TorneoController {

	Torneo obtenerTorneoPorId(Integer id);

	List<Torneo> obtenerTodosLosTorneos();

	void guardarTorneo(Torneo torneo);

	void crearTorneo(NuevoTorneoCommand nuevoTorneo, Integer participanteId) throws BalonpieException;
	
	List<Torneo> obtenerTorneosValidosPorParticipante(Integer participanteId);
}
