package com.palazzisoft.ligabalonpie.controllers.api;

import java.util.List;

import com.palazzisoft.ligabalonpie.entities.Equipo;

public interface EquipoController {

	public List<Equipo> obtenerEquiposPorParticipante(Integer id);
}
