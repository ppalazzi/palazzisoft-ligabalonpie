package com.palazzisoft.ligabalonpie.daos.impl;

import java.util.List;

import com.palazzisoft.ligabalonpie.daos.api.AdministradorDao;
import com.palazzisoft.ligabalonpie.entities.Administrador;
import com.palazzisoft.ligabalonpie.entities.Participante;

public class AdministradorDaoImpl extends GenericDaoImpl<Administrador,Integer> implements AdministradorDao {

	private static final Integer PRIMER_ELEMENTO = 0;

	@Override
	public Administrador login(String user, String password) {
		Administrador administrador = null;		
		String query = "FROM Administrador p WHERE p.nombre = ? AND p.password = ?";
		
		List<Administrador> resultado = this.getHibernateTemplate().find(query, new Object[]{user,password} );
		
		if (!resultado.isEmpty()) {
			administrador = resultado.get(PRIMER_ELEMENTO);
		}
		
		return administrador;
	}

	@Override
	protected Class<Administrador> getPersistenceClass() {
		return Administrador.class;
	}

}
