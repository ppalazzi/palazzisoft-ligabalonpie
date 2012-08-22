package com.palazzisoft.ligabalonpie.controllers.api;

import java.util.List;

import com.palazzisoft.ligabalonpie.entities.Torneo;

public interface TorneoController {

	public List<Torneo> obtenerTorneosPorParticipanteId(Integer participanteId);

	boolean verificarExistenciaDeTorneo(String descripcion);
}
