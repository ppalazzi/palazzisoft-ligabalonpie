package com.palazzisoft.ligabalonpie.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.palazzisoft.ligabalonpie.controllers.api.TorneoController;
import com.palazzisoft.ligabalonpie.daos.api.TorneoDao;
import com.palazzisoft.ligabalonpie.entities.ParticipanteTorneo;
import com.palazzisoft.ligabalonpie.entities.Torneo;

public class TorneoControllerImpl implements TorneoController {

	@Autowired
	private TorneoDao torneoDao;
	
	@Override
	public List<Torneo> obtenerTorneosPorParticipanteId(Integer participanteId) {
		List<ParticipanteTorneo> participantesEquipos = 
				torneoDao.obtenerParticipantesEquiposPorParticipanteId(participanteId);
		
		// TODO terminar esto de una vez
		
		return null;
	}
	
	@Override
	public boolean verificarExistenciaDeTorneo(String descripcion) {
		Torneo torneo = torneoDao.obtenerTorneoPorDescripcion(descripcion);
		
		return (torneo != null);
	}

}
