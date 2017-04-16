package com.palazzisoft.ligabalonpie.daos.api;

import java.util.List;

import com.palazzisoft.balonpie.service.model.Participante;

public interface ParticipanteDao extends GenericDao<Participante,Integer> {

	Participante login(String usuario,String password);
	
	Participante obtenerParticipantePorEmail(String email);

	List<Participante> obtenerParticipantes();
}
