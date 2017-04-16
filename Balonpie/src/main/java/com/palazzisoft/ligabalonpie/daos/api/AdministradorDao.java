package com.palazzisoft.ligabalonpie.daos.api;

import com.palazzisoft.balonpie.service.model.Administrador;

public interface AdministradorDao extends GenericDao<Administrador,Integer> {

	public Administrador login(String user, String password);
}
