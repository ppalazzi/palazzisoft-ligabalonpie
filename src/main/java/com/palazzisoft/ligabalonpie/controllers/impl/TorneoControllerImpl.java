package com.palazzisoft.ligabalonpie.controllers.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.palazzisoft.ligabalonpie.command.TorneoCommand;
import com.palazzisoft.ligabalonpie.controllers.api.TorneoController;
import com.palazzisoft.ligabalonpie.converters.TorneoConverter;
import com.palazzisoft.ligabalonpie.daos.api.ParticipanteDao;
import com.palazzisoft.ligabalonpie.daos.api.ParticipanteTorneoDao;
import com.palazzisoft.ligabalonpie.daos.api.TorneoDao;
import com.palazzisoft.ligabalonpie.entities.Participante;
import com.palazzisoft.ligabalonpie.entities.ParticipanteTorneo;
import com.palazzisoft.ligabalonpie.entities.Torneo;
import com.palazzisoft.ligabalonpie.enums.EEstadoTorneo;

@Controller
public class TorneoControllerImpl implements TorneoController {

	private TorneoDao torneoDao;	
	private ParticipanteTorneoDao participanteTorneoDao;	
	private ParticipanteDao participanteDao;
	
	@Autowired
	public TorneoControllerImpl(TorneoDao torneoDao,
			ParticipanteTorneoDao participanteTorneoDao,
			ParticipanteDao participanteDao) {
		this.torneoDao = torneoDao;
		this.participanteDao = participanteDao;
		this.participanteTorneoDao = participanteTorneoDao;
	}
	
	@Override
	public List<Torneo> obtenerTorneosPorParticipanteId(Integer participanteId) {
		List<ParticipanteTorneo> participantesTorneos = 
				torneoDao.obtenerParticipantesEquiposPorParticipanteId(participanteId);
				
		return this.getTorneosDelListado(participantesTorneos);
	}
		
	@Override
	public boolean verificarExistenciaDeTorneo(String descripcion) {
		Torneo torneo = torneoDao.obtenerTorneoPorDescripcion(descripcion);
		
		return (torneo != null);
	}

	@Override
	public Torneo nuevoTorneo(TorneoCommand torneoCommand, String participanteId) throws ParseException {
		Torneo torneo = TorneoConverter.convertirCommandATorneo(torneoCommand);
		torneo.setFechaCreacion(new Date());
		torneo.setFechaInicio(new Date());
		torneo.setFechaFin(this.obtenerFechaDentroDeUnMes());
		torneo.setEstado(EEstadoTorneo.ACTIVO.getEstadoTorneo());
				
		Participante participante = this.participanteDao.getById(Integer.parseInt(participanteId));
		
		ParticipanteTorneo pt = new ParticipanteTorneo();
		pt.setTorneo(torneo);
		pt.setParticipante(participante);		
		pt.setEsCreador(Boolean.TRUE);
		
		this.torneoDao.save(torneo);
		this.participanteTorneoDao.save(pt);
		
		return torneo;
	}
	
	@Override
	public Torneo obtenerTorneoPorId(Integer id) {
		return this.torneoDao.getById(id);
	}
	
	private Date obtenerFechaDentroDeUnMes() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 30);
		
		return c.getTime();
	}
	
	private List<Torneo> getTorneosDelListado(List<ParticipanteTorneo> participantesTorneo) {
		List<Torneo> torneos = new ArrayList<Torneo>();
		
		for (ParticipanteTorneo participanteTorneo : participantesTorneo) {
			torneos.add(participanteTorneo.getTorneo());
		}
		
		return torneos;
	}	
}
