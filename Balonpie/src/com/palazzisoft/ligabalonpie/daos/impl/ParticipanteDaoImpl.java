package com.palazzisoft.ligabalonpie.daos.impl;

import java.util.List;

import com.palazzisoft.ligabalonpie.daos.api.ParticipanteDao;
import com.palazzisoft.ligabalonpie.entities.Participante;

public class ParticipanteDaoImpl extends GenericDaoImpl<Participante, Integer> implements
		ParticipanteDao {

	private static final Integer PRIMER_ELEMENTO = 0;
	
	@Override
	public Class<Participante> getPersistenceClass() {
		return Participante.class;
	}

	@SuppressWarnings("unchecked")
	public Participante login(String usuario, String password) {
		Participante participante = null;		
		String query = "FROM Participante p WHERE p.email = ? AND p.password = ?";
		
		List<Participante> resultado = this.getHibernateTemplate().find(query, new Object[]{usuario,password} );
		
		if (!resultado.isEmpty()) {
			participante = resultado.get(PRIMER_ELEMENTO);
		}
		
		return participante;
	}

	@Override
	@SuppressWarnings("unchecked")	
	public Participante obtenerParticipantePorEmail(String email) {
		Participante participante = null;		
		String query = "FROM Participante p WHERE p.email = ?";
		
		List<Participante> resultado = this.getHibernateTemplate().find(query,email);
		
		if (!resultado.isEmpty()) {
			participante = resultado.get(PRIMER_ELEMENTO);
		}
		
		return participante;
	}


}
