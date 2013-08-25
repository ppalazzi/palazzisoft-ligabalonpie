package com.palazzisoft.ligabalonpie.views;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.palazzisoft.ligabalonpie.command.ParticipanteCommand;
import com.palazzisoft.ligabalonpie.controllers.api.ParticipanteController;
import com.palazzisoft.ligabalonpie.controllers.api.ParticipanteTorneoController;
import com.palazzisoft.ligabalonpie.entities.Participante;
import com.palazzisoft.ligabalonpie.util.PageViews;

@Component
public class ListadoTorneoView {

	private ParticipanteController participanteController;
	private ParticipanteTorneoController participanteTorneoController;
	
	@Autowired
	public ListadoTorneoView(ParticipanteController participanteController) {
		this.participanteController = participanteController;
		//this.participanteTorneoController = participanteTorneoController;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/listadoTorneoView.htm", method = RequestMethod.GET)
	public String misTorneos(HttpServletRequest request, ModelMap model) {
		
		try {
			Participante participante = (Participante)request.getSession().getAttribute("participanteSession");
			ParticipanteCommand participanteCommand = participanteController.obtenerParticipantePorId(participante.getId());
			model.put("torneos", participanteCommand.getTorneos());
		}
		catch (ParseException e) {
			return PageViews.ERROR_PAGINA;
		}							
		
		return PageViews.LISTADO_TORNEO;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/torneosDisponibles.htm")
	public String torneosDisponibles(@RequestParam("participanteId") Integer participanteId, ModelMap model) {
		try {
			model.put("torneos", this.participanteTorneoController.obtenerTorneosDisponiblesPorParticipante(participanteId));
			return PageViews.LISTADO_TORNEO;
		} catch (ParseException e) {
			return PageViews.ERROR_PAGINA;
		}
	}
	
}
