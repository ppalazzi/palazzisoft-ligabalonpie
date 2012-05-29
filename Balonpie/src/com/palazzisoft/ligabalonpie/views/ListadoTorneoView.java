package com.palazzisoft.ligabalonpie.views;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.palazzisoft.ligabalonpie.controllers.api.TorneoController;
import com.palazzisoft.ligabalonpie.entities.Participante;
import com.palazzisoft.ligabalonpie.entities.Torneo;
import com.palazzisoft.ligabalonpie.util.PageViews;

@Controller
@RequestMapping("/listadoTorneoView.htm")
public class ListadoTorneoView {

	@Autowired
	private TorneoController torneoController;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(HttpServletRequest request,ModelMap model) {
		
		Participante participante = (Participante)request.getSession().getAttribute("participanteSession");
		List<Torneo> torneos = torneoController.obtenerTorneosPorParticipanteId(participante.getId());
		
		System.out.println("Cantidad de Torneos " + torneos.size());		
		
		return PageViews.DASHBOARD;
	}
}
