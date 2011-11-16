package com.palazzisoft.ligabalonpie.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.palazzisoft.ligabalonpie.controllers.api.AdministradorController;
import com.palazzisoft.ligabalonpie.daos.api.AdministradorDao;
import com.palazzisoft.ligabalonpie.entities.Administrador;

public class AdministradorControllerImpl implements AdministradorController {
	
	@Autowired
	private AdministradorDao administradorDao;
	
	@Override
	public Administrador login(String user, String password) {
		return administradorDao.login(user, password);
	}

	
}
