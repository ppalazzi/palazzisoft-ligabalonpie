package com.palazzisoft.ligabalonpie.controllers.impl;

import static com.palazzisoft.ligabalonpie.entities.Torneo.TORNEO_DURACION;
import static com.palazzisoft.ligabalonpie.enums.EEstado.ACTIVO;
import static com.palazzisoft.ligabalonpie.util.PropertiesValues.PRESUPUESTO_INICIAL;
import static java.util.Calendar.getInstance;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.palazzisoft.ligabalonpie.command.NuevoTorneoCommand;
import com.palazzisoft.ligabalonpie.controllers.api.EquipoController;
import com.palazzisoft.ligabalonpie.controllers.api.JugadorController;
import com.palazzisoft.ligabalonpie.controllers.api.ParticipanteController;
import com.palazzisoft.ligabalonpie.controllers.api.TorneoController;
import com.palazzisoft.ligabalonpie.daos.api.TorneoDao;
import com.palazzisoft.ligabalonpie.entities.Equipo;
import com.palazzisoft.ligabalonpie.entities.Jugador;
import com.palazzisoft.ligabalonpie.entities.Participante;
import com.palazzisoft.ligabalonpie.entities.Torneo;
import com.palazzisoft.ligabalonpie.enums.EEstado;
import com.palazzisoft.ligabalonpie.exception.BalonpieException;

/**
 * 
 * @author ppalazzi
 *
 */
@Controller
public class TorneoControllerImpl implements TorneoController {

	private final Logger log = Logger.getLogger(TorneoControllerImpl.class);
	
	private final TorneoDao torneoDao;
	private final EquipoController equipoController;
	private final ParticipanteController participanteController;

	@Autowired
	public TorneoControllerImpl(final TorneoDao torneoDao,
			final JugadorController jugadorController,
			final EquipoController equipoController,
			final ParticipanteController participanteController) {
		this.torneoDao = torneoDao;
		this.equipoController = equipoController;
		this.participanteController = participanteController;
	}

	@Override
	@Transactional
	public List<Torneo> obtenerTodosLosTorneos() {
		return this.torneoDao.obtenerTodosLosTorneos();
	}

	@Override
	@Transactional
	public void guardarTorneo(Torneo torneo) {
		if (torneo.getId() == null) {
			torneo.setFechaCreacion(getInstance().getTime());
			this.torneoDao.save(torneo);
		} else {
			this.torneoDao.update(torneo);
		}
	}

	@Override
	public Torneo obtenerTorneoPorId(Integer id) {
		return this.torneoDao.getById(id);
	}

	@Override
	@Transactional
	public void crearTorneo(NuevoTorneoCommand nuevoTorneo, Integer participanteId) throws BalonpieException {
		try {
			Participante participante = this.participanteController.obtenerParticipantePorId(participanteId);
			Torneo torneo = this.nuevoTorneo(nuevoTorneo, participante);
			Equipo equipo = this.nuevoEquipo(nuevoTorneo, participante);
			
			torneo.getEquipos().add(equipo);
			
			this.agregarJugadores(nuevoTorneo, equipo);	
			
			this.equipoController.guardarEquipo(equipo);
			this.torneoDao.save(torneo);
		} catch (Exception e) {
			log.error("error al crear nuevo Torneo", e);
			throw new BalonpieException("Error al crear nuevo Torneo", e);
		}
	}
	
	private Torneo nuevoTorneo(NuevoTorneoCommand nuevoTorneo, Participante participante) {
		Torneo torneo = new Torneo();
		torneo.setDescripcion(nuevoTorneo.getNombreTorneo());
		torneo.setEstado(ACTIVO.getEstado());
		torneo.setFechaCreacion(Calendar.getInstance().getTime());
		torneo.setFechaInicio(Calendar.getInstance().getTime());
		torneo.setFechaFin(DateUtils.addDays(torneo.getFechaInicio(), TORNEO_DURACION));
		torneo.setParticipante(participante);
		
		return torneo;
	}
	
	private Equipo nuevoEquipo(NuevoTorneoCommand nuevoTorneo, Participante participante) {
		Equipo equipo = new Equipo();
		equipo.setDescripcion(nuevoTorneo.getDescripcionEquipo());
		equipo.setEstado(EEstado.ACTIVO.getEstado());
		equipo.setFechaCreacion(Calendar.getInstance().getTime());
		equipo.setNombre(nuevoTorneo.getNombreEquipo());
		equipo.setPresupuesto(PRESUPUESTO_INICIAL);
		equipo.setParticipante(participante);
		
		return equipo;
	}
	
	private void agregarJugadores(NuevoTorneoCommand nuevoTorneo, Equipo equipo) {
		Jugador arquero = new Jugador();
		arquero.setId(nuevoTorneo.getIdPos0());
		equipo.agregarJugador(arquero);			
		
		Jugador defensor1 = new Jugador();
		defensor1.setId(nuevoTorneo.getIdPos1());
		equipo.agregarJugador(defensor1);
		
		Jugador defensor2 = new Jugador();
		defensor2.setId(nuevoTorneo.getIdPos2());
		equipo.agregarJugador(defensor2);
		
		Jugador defensor3 = new Jugador();
		defensor3.setId(nuevoTorneo.getIdPos3());
		equipo.agregarJugador(defensor3);
		
		Jugador defensor4 = new Jugador();
		defensor4.setId(nuevoTorneo.getIdPos4());
		equipo.agregarJugador(defensor4);
		
		Jugador defensor5 = new Jugador();
		defensor5.setId(nuevoTorneo.getIdPos5());
		equipo.agregarJugador(defensor5);

		Jugador defensor6 = new Jugador();
		defensor6.setId(nuevoTorneo.getIdPos6());
		equipo.agregarJugador(defensor6);

		Jugador defensor7 = new Jugador();
		defensor7.setId(nuevoTorneo.getIdPos7());
		equipo.agregarJugador(defensor7);

		Jugador defensor8 = new Jugador();
		defensor8.setId(nuevoTorneo.getIdPos8());
		equipo.agregarJugador(defensor8);

		Jugador defensor9 = new Jugador();
		defensor9.setId(nuevoTorneo.getIdPos9());
		equipo.agregarJugador(defensor9);

		Jugador defensor10 = new Jugador();
		defensor10.setId(nuevoTorneo.getIdPos10());
		equipo.agregarJugador(defensor10);
	}

	@Override
	public List<Torneo> obtenerTorneosValidosPorParticipante(
			Integer participanteId) {
		return this.torneoDao.obtenerTorneosValidosPorParticipante(participanteId);
	}
}
