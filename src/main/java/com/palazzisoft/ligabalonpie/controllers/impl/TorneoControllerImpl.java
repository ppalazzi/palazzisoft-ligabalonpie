package com.palazzisoft.ligabalonpie.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.palazzisoft.ligabalonpie.controllers.api.TorneoController;
import com.palazzisoft.ligabalonpie.daos.api.TorneoDao;
import com.palazzisoft.ligabalonpie.entities.Torneo;
/**
 * 
 * @author ppalazzi
 *
 */
@Controller
public class TorneoControllerImpl implements TorneoController {

	private final TorneoDao torneoDao;	
	
	@Autowired
	public TorneoControllerImpl(final TorneoDao torneoDao) {
		this.torneoDao = torneoDao;
	}
	
	@Override
	public List<Torneo> obtenerTodosLosTorneos() {
		return this.torneoDao.obtenerTodosLosTorneos();
	}
	
	@Override
	public Torneo obtenerTorneoPorId(Integer id) {
		return this.torneoDao.getById(id);
	}	
	
	@Override
	public void guardarTorneo(Torneo torneo) {
		this.torneoDao.save(torneo);
	}
}
