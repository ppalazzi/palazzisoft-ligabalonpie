package com.palazzisoft.ligabalonpie.daos.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.palazzisoft.balonpie.service.model.Participante;
import com.palazzisoft.ligabalonpie.daos.api.ParticipanteDao;

@Component
public class ParticipanteDaoImpl extends GenericDaoImpl<Participante, Integer> implements
		ParticipanteDao {

	
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

	@Override
	@SuppressWarnings("unchecked")		
	public List<Participante> obtenerParticipantes() {
		String query = "FROM Participante";
		
		List<Participante> participantes = 
				this.getHibernateTemplate().find(query);
		
		return participantes;
	}
}
