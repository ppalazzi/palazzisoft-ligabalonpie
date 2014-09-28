package com.palazzisoft.ligabalonpie.views;

import java.text.ParseException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.palazzisoft.ligabalonpie.command.ParticipanteCommand;
import com.palazzisoft.ligabalonpie.controllers.api.ParticipanteController;
import com.palazzisoft.ligabalonpie.converters.ParticipanteConverter;
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
	public String showForm(@RequestParam(value = "participanteId", required = false)Integer participanteId, HttpServletRequest request, ModelMap model) {
		model.put("paises", mapaPaises);

		try {
			if (participanteId != null) {
				Participante participante = participanteController.obtenerParticipantePorId(participanteId);
				model.addAttribute("participanteCommand", ParticipanteConverter.convertirParticipanteACommand(participante));
			}			
		}
		catch (ParseException e) {
			System.out.println(e);
		}
				
		return PageViews.REGISTRO;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(
			@ModelAttribute("participanteCommand") ParticipanteCommand participanteCommand,
			BindingResult errors, ModelMap model, HttpServletRequest request) {

		Participante participante = null;
		this.participanteValidator.validate(participanteCommand, errors);

		String viewExit = PageViews.DASHBOARD;

		try {
			if (!errors.hasErrors()) {
				participante = this.guardarParticipante(model, participanteCommand, viewExit, request);
				this.setParticipanteEnSession(participante, request);
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
	private Participante guardarParticipante(ModelMap model, ParticipanteCommand participanteCommand, String viewExit, HttpServletRequest request) throws ParseException {
		Participante participante = participanteController
				.guardarParticipante(participanteCommand);

		if (participante == null) {
			model.put("mensajeError", "El Email ya se encuentra registrado");
			viewExit = PageViews.REGISTRO;
		}
		return participante;
	}
	
	private void setParticipanteEnSession(Participante participante, HttpServletRequest request) {
		request.getSession().setAttribute("participanteId", participante.getId());
	}
}
