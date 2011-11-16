package com.palazzisoft.ligabalonpie.controllers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.palazzisoft.ligabalonpie.controllers.api.EquipoController;
import com.palazzisoft.ligabalonpie.daos.api.EquipoDao;
import com.palazzisoft.ligabalonpie.entities.Equipo;

public class EquipoControllerImpl implements EquipoController {

	@Autowired
	private EquipoDao equipoDao;
	
	public List<Equipo> obtenerEquiposPorParticipante(Integer id) {
		List<Equipo> equipos = equipoDao.obtenerEquipoPorParticipante(id); 
		
		if (equipos == null)
			equipos = new ArrayList<Equipo>();
		
		return equipos;
	}

}
