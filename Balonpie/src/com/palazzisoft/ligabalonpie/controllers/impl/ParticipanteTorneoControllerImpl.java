package com.palazzisoft.ligabalonpie.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.palazzisoft.ligabalonpie.controllers.api.ParticipanteTorneoController;
import com.palazzisoft.ligabalonpie.daos.api.ParticipanteTorneoDao;
import com.palazzisoft.ligabalonpie.entities.ParticipanteTorneo;

public class ParticipanteTorneoControllerImpl implements ParticipanteTorneoController {

	@Autowired
	private ParticipanteTorneoDao participanteTorneoDao;
	
	public void guardarParticipanteTorneo(ParticipanteTorneo participanteTorneo) {
		this.participanteTorneoDao.save(participanteTorneo);
	}
}
