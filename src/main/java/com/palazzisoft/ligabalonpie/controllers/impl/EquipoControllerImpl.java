package com.palazzisoft.ligabalonpie.controllers.impl;

import static com.palazzisoft.ligabalonpie.converters.EquipoConverter.convertirAEquipoCommand;
import static com.palazzisoft.ligabalonpie.converters.EquipoConverter.convertirEquipoACommand;
import static com.palazzisoft.ligabalonpie.enums.EEstado.ACTIVO;
import static java.util.Calendar.getInstance;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.palazzisoft.ligabalonpie.command.EquipoCommand;
import com.palazzisoft.ligabalonpie.controllers.api.EquipoController;
import com.palazzisoft.ligabalonpie.converters.EquipoConverter;
import com.palazzisoft.ligabalonpie.daos.api.EquipoDao;
import com.palazzisoft.ligabalonpie.daos.api.ParticipanteDao;
import com.palazzisoft.ligabalonpie.entities.Equipo;
import com.palazzisoft.ligabalonpie.entities.EquipoJugador;
import com.palazzisoft.ligabalonpie.entities.Jugador;
import com.palazzisoft.ligabalonpie.entities.Participante;
import com.palazzisoft.ligabalonpie.enums.EEstado;
import com.palazzisoft.ligabalonpie.util.PropertiesValues;

@Controller
public class EquipoControllerImpl implements EquipoController {

	private EquipoDao equipoDao;
	private ParticipanteDao participanteDao;

	@Autowired
	public EquipoControllerImpl(EquipoDao equipoDao, ParticipanteDao participanteDao) {
		this.equipoDao = equipoDao;
		this.participanteDao = participanteDao;
	}

	@Override
	public Equipo getById(Integer id) {
		return equipoDao.getById(id);
	}

	@Override
	public List<EquipoCommand> obtenerEquiposPorParticipante(Integer id) {
		List<Equipo> equipos = equipoDao.obtenerEquipoPorParticipante(id);
		List<EquipoCommand> equiposCommand = new ArrayList<EquipoCommand>();

		if (equipos != null) {
			equiposCommand = convertirEquipoACommand(equipos);
		}

		return equiposCommand;
	}

	@Override
	public List<Jugador> obtenerJugadoresDeEquipo(Integer id) {
		List<EquipoJugador> equiposJugadores = equipoDao.obtenerJugadoresPorEquipo(id);
		List<Jugador> respuesta = new ArrayList<Jugador>();

		for (EquipoJugador ej : equiposJugadores) {
			respuesta.add(ej.getJugador());
		}

		return respuesta;
	}

	@Override
	public void comprarJugador(Jugador jugador, Equipo equipo) {
		// TODO falta hacer esto
	}

	@Override
	public void nuevoEquipo(EquipoCommand equipoCommand, Integer participanteId) {
		Participante participante = this.participanteDao.getById(participanteId);

		Equipo equipo = EquipoConverter.convertirAEquipo(equipoCommand);
		equipo.setFechaCreacion(new Date());
		equipo.setParticipante(participante);
		equipo.setEstado(ACTIVO.getEstado());
		equipo.setPresupuesto(Long.valueOf(PropertiesValues.PRESUPUESTO_INICIAL));
		equipo.setPuntos(Long.valueOf(PropertiesValues.PUNTOS_INICIAL));

		this.equipoDao.save(equipo);
	}

	@Override
	public boolean verificarExistenciaDeEquipo(String nombreEquipo) {
		Equipo equipo = this.equipoDao.obtenerEquipoPorNombre(nombreEquipo);

		return (equipo != null);
	}

	@Override
	public EquipoCommand obtenerEquipoPorTorneoYParticipante(Integer torneoId,
			Integer participanteId) {
		Equipo equipo = this.equipoDao.obtenerEquipoPorTorneoYParticipante(torneoId, participanteId);

		return convertirAEquipoCommand(equipo);
	}
	
	@Override
	public List<Equipo> obtenerTodosLosEquipos() {
		return this.equipoDao.obtenerTodosLosEquipos();
	}
	
	@Override
	public void guardarEquipo(Equipo equipo) {
		if (equipo.getId() == null) {
			equipo.setFechaCreacion(getInstance().getTime());
			equipo.setEstado(ACTIVO.getEstado());
		}
		
		this.equipoDao.save(equipo);
	}
}
