package com.palazzisoft.ligabalonpie.daos.api;

import java.util.List;

import com.palazzisoft.ligabalonpie.entities.Equipo;
import com.palazzisoft.ligabalonpie.entities.EquipoJugador;

public interface EquipoDao extends GenericDao<Equipo,Integer> {

	List<Equipo> obtenerEquipoPorParticipante(Integer id);
	
	List<EquipoJugador> obtenerJugadoresPorEquipo(Integer id);

	Equipo obtenerEquipoPorNombre(String nombre);
}
