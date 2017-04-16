package com.palazzisoft.ligabalonpie.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.palazzisoft.balonpie.service.model.TipoJugador;
import com.palazzisoft.ligabalonpie.controllers.api.TipoJugadorController;
import com.palazzisoft.ligabalonpie.daos.api.TipoJugadorDao;

public class TipoJugadorControllerImpl implements TipoJugadorController {

	@Autowired
	private TipoJugadorDao tipoJugadorDao;
	
	public TipoJugadorControllerImpl() {
		
	}

	public List<TipoJugador> obtenerTodosTipoJugador() {
		return tipoJugadorDao.obtenerTiposJugadores();
	}
}
