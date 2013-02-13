package com.palazzisoft.ligabalonpie.daos.impl;

import org.springframework.stereotype.Component;

import com.palazzisoft.ligabalonpie.daos.api.ParticipanteTorneoDao;
import com.palazzisoft.ligabalonpie.entities.ParticipanteTorneo;
import com.palazzisoft.ligabalonpie.entities.ParticipanteTorneoPK;

@Component
public class ParticipanteTorneoDaoImpl extends GenericDaoImpl<ParticipanteTorneo, ParticipanteTorneoPK> implements ParticipanteTorneoDao {

	@Override
	protected Class<ParticipanteTorneo> getPersistenceClass() {
		return ParticipanteTorneo.class;
	}

}
