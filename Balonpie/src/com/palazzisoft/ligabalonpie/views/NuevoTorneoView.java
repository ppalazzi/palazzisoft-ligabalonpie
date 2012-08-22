package com.palazzisoft.ligabalonpie.views;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.palazzisoft.ligabalonpie.controllers.api.TorneoController;
import com.palazzisoft.ligabalonpie.util.PageViews;

@Controller
@RequestMapping("/nuevoTorneo.htm")
public class NuevoTorneoView {

	@Autowired
	private TorneoController torneoController;
	
	Logger log = Logger.getLogger(NuevoTorneoView.class);

	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return PageViews.NUEVO_TORNEO;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(ModelMap model) {
		// TODO terminar esto ya es tarde y tengo nonito
		
		return null;
	}
}
