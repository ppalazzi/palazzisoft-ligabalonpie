package com.palazzisoft.ligabalonpie.views;

import java.text.ParseException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.palazzisoft.ligabalonpie.command.ParticipanteCommand;
import com.palazzisoft.ligabalonpie.controllers.api.ParticipanteController;
import com.palazzisoft.ligabalonpie.entities.Participante;
import com.palazzisoft.ligabalonpie.util.PageViews;
import com.palazzisoft.ligabalonpie.validators.ParticipanteValidator;

@Controller
@RequestMapping("/registro.htm")
public class RegistroView {

	Logger log = Logger.getLogger(RegistroView.class);

	@Autowired
	private ParticipanteController participanteController;
	
	@Autowired
	private ParticipanteValidator participanteValidator;

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
			BindingResult errors, ModelMap model) {

		participanteValidator.validate(participanteCommand, errors);

		String viewExit = PageViews.DASHBOARD;

		try {
			if (!errors.hasErrors()) {
				this.guardarParticipante(model, participanteCommand, viewExit);				
			} 	
			else {
				model.put("paises", mapaPaises);
				viewExit = PageViews.REGISTRO;
			}
			
		} catch (ParseException e) {
			log.debug(e.getMessage());
			viewExit = PageViews.ERROR_PAGINA;
		}

		return viewExit;
	}
	
	@SuppressWarnings("unchecked")
	private void guardarParticipante(ModelMap model, ParticipanteCommand participanteCommand, String viewExit) throws ParseException {
		Participante participante = participanteController
				.guardarParticipante(participanteCommand);

		if (participante == null) {
			model.put("mensajeError", "El Email ya se encuentra registrado");
			viewExit = PageViews.REGISTRO;
		}		
	}
}
