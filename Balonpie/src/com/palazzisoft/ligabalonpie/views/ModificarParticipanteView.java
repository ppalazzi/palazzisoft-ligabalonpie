package com.palazzisoft.ligabalonpie.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.palazzisoft.ligabalonpie.controllers.api.ParticipanteController;
import com.palazzisoft.ligabalonpie.converters.ParticipanteConverter;
import com.palazzisoft.ligabalonpie.entities.Participante;
import com.palazzisoft.ligabalonpie.util.PageViews;

@Controller
@RequestMapping("/modificarParticipante.htm")
public class ModificarParticipanteView {

	@Autowired
	private ParticipanteController participanteController;

	@Autowired
	public ModificarParticipanteView(ParticipanteController participanteController) {
		this.participanteController = participanteController;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(@RequestParam("participanteId") Integer participanteId,
			ModelAndView model) {
		Participante participante = participanteController.obtenerParticipantePorId(participanteId);

		model.addObject("participanteCommand",
				ParticipanteConverter.convertirParticipanteACommand(participante));
		return PageViews.REGISTRO;
	}
}
