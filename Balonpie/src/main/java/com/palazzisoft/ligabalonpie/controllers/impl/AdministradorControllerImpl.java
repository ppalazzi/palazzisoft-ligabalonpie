package com.palazzisoft.ligabalonpie.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.palazzisoft.balonpie.service.model.Administrador;
import com.palazzisoft.ligabalonpie.controllers.api.AdministradorController;
import com.palazzisoft.ligabalonpie.daos.api.AdministradorDao;
@Component
public class AdministradorControllerImpl implements AdministradorController {
	
	@Autowired
	private AdministradorDao administradorDao;
	
	public Administrador login(String user, String password) {
		return administradorDao.login(user, password);
	}

	
}
