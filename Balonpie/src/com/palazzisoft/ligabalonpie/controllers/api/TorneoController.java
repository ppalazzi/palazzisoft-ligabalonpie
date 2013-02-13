package com.palazzisoft.ligabalonpie.controllers.api;

import java.text.ParseException;
import java.util.List;

import com.palazzisoft.ligabalonpie.command.TorneoCommand;
import com.palazzisoft.ligabalonpie.entities.Torneo;

public interface TorneoController {

	List<Torneo> obtenerTorneosPorParticipanteId(Integer participanteId);

	boolean verificarExistenciaDeTorneo(String descripcion);

	Torneo nuevoTorneo(TorneoCommand torneoCommand, String participanteId) throws ParseException;
}
