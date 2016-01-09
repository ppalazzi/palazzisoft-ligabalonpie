package com.palazzisoft.ligabalonpie.daos.api;

import java.util.List;

import com.palazzisoft.ligabalonpie.entities.ParticipanteTorneo;
import com.palazzisoft.ligabalonpie.entities.Torneo;
/**
 * 
 * @author ppalazzi
 *
 */
public interface TorneoDao extends GenericDao<Torneo,Integer> {

	List<ParticipanteTorneo> obtenerParticipantesEquiposPorParticipanteId(Integer participanteId);

	Torneo obtenerTorneoPorDescripcion(String descripcion);

	List<Torneo> obtenerTodosLosTorneos();

	List<Torneo> obtenerTorneosDeParticipante(Integer participanteId);
	
	List<Torneo> obtenerTorneosValidosPorParticipante(Integer participanteId);
}
