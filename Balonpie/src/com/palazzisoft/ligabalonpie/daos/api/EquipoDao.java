package com.palazzisoft.ligabalonpie.daos.api;

import java.util.List;

import com.palazzisoft.ligabalonpie.entities.Equipo;

public interface EquipoDao extends GenericDao<Equipo,Integer> {

	public List<Equipo> obtenerEquipoPorParticipante(Integer id);
}
