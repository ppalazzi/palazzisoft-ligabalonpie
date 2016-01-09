package com.palazzisoft.ligabalonpie.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.palazzisoft.ligabalonpie.controllers.api.TipoJugadorController;
import com.palazzisoft.ligabalonpie.daos.api.TipoJugadorDao;
import com.palazzisoft.ligabalonpie.entities.TipoJugador;

public class TipoJugadorControllerImpl implements TipoJugadorController {

	@Autowired
	private TipoJugadorDao tipoJugadorDao;
	
	public TipoJugadorControllerImpl() {
		
	}

	public List<TipoJugador> obtenerTodosTipoJugador() {
		return tipoJugadorDao.obtenerTiposJugadores();
	}
}
