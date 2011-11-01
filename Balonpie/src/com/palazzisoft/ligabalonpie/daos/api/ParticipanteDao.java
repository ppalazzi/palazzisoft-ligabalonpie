package com.palazzisoft.ligabalonpie.daos.api;

import com.palazzisoft.ligabalonpie.entities.Participante;

public interface ParticipanteDao extends GenericDao<Participante,Integer> {

	public Participante login(String usuario,String password);
}
