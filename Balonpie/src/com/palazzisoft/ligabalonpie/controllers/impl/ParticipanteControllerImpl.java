package com.palazzisoft.ligabalonpie.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.palazzisoft.ligabalonpie.controllers.api.ParticipanteController;
import com.palazzisoft.ligabalonpie.daos.api.ParticipanteDao;
import com.palazzisoft.ligabalonpie.entities.Participante;

public class ParticipanteControllerImpl implements ParticipanteController {

	@Autowired
	private ParticipanteDao participanteDao;
	
	public Participante login(String user, String password) {
		return participanteDao.login(user, password);
	}

	
}
