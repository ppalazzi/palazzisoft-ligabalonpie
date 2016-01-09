package com.palazzisoft.ligabalonpie.daos.api;

import com.palazzisoft.ligabalonpie.entities.Administrador;

public interface AdministradorDao extends GenericDao<Administrador,Integer> {

	public Administrador login(String user, String password);
}
