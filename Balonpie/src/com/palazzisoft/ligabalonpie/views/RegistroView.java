package com.palazzisoft.ligabalonpie.views;

import java.text.ParseException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.palazzisoft.ligabalonpie.command.ParticipanteCommand;
import com.palazzisoft.ligabalonpie.controllers.api.ParticipanteController;
import com.palazzisoft.ligabalonpie.entities.Participante;
import com.palazzisoft.ligabalonpie.util.PageViews;

@Controller
@RequestMapping("/registro.htm")
public class RegistroView {

	Logger log = Logger.getLogger(RegistroView.class);

	@Autowired
	private ParticipanteController participanteController;

	private Map<Integer, String> mapaPaises;

	public RegistroView(Map<Integer, String> mapaPaises) {
		this.mapaPaises = mapaPaises;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		model.put("paises", mapaPaises);

		return PageViews.REGISTRO;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(
			@ModelAttribute("participanteCommand") ParticipanteCommand participanteCommand,
			ModelMap model) {

		String viewExit = PageViews.DASHBOARD;
		
		try {
			Participante participante = participanteController
					.guardarParticipante(participanteCommand);

			if (participante == null) {
				model.put("mensajeError", "El Email ya se encuentra registrado");
				viewExit = PageViews.REGISTRO;
			}
		} catch (ParseException e) {
			log.debug(e.getMessage());
			viewExit = PageViews.ERROR_PAGINA;
		}

		return viewExit;
	}
}
