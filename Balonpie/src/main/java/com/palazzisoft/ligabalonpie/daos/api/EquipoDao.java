package com.palazzisoft.ligabalonpie.daos.api;

import java.util.List;

import com.palazzisoft.balonpie.service.model.Equipo;
import com.palazzisoft.balonpie.service.model.EquipoJugador;

public interface EquipoDao extends GenericDao<Equipo,Integer> {

	List<Equipo> obtenerEquipoPorParticipante(Integer id);
	
	List<EquipoJugador> obtenerJugadoresPorEquipo(Integer id);

	Equipo obtenerEquipoPorNombre(String nombre);

	Equipo obtenerEquipoPorTorneoYParticipante(Integer torneoId, Integer participanteId);

	List<Equipo> obtenerTodosLosEquipos();
	
	Equipo obtenerEquipoCreadorDeTorneo(Integer torneoId, Integer participanteId);
}
