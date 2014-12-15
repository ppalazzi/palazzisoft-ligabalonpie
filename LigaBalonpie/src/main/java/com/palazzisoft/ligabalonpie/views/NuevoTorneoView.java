package com.palazzisoft.ligabalonpie.views;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.palazzisoft.ligabalonpie.command.TorneoCommand;
import com.palazzisoft.ligabalonpie.controllers.api.TorneoController;
import com.palazzisoft.ligabalonpie.util.PageViews;

@Controller
@RequestMapping("/nuevoTorneo.htm")
public class NuevoTorneoView {

	Logger log = Logger.getLogger(NuevoTorneoView.class);	
	
	@Autowired
	private TorneoController torneoController;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(@RequestParam("participanteId") String participanteId, Model model) {
		model.addAttribute("participanteId", participanteId);
		return PageViews.NUEVO_TORNEO;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("torneoCommand") TorneoCommand torneoCommand,@RequestParam("participanteId") String participanteId, ModelMap model) {		
		try {
			this.torneoController.nuevoTorneo(torneoCommand, participanteId);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al intentar guardar un nuevo Torneo", e);
			model.addAttribute("message", "No se pudo crear un nuevo Torneo");
		}
		
		return null;
	}
}
