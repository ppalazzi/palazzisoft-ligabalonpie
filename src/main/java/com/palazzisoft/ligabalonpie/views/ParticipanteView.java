package com.palazzisoft.ligabalonpie.views;

import static com.palazzisoft.ligabalonpie.converters.ParticipanteConverter.convertirParticipantesACommand;
import static com.palazzisoft.ligabalonpie.util.PageViews.LISTADO_PARTICIPANTE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.palazzisoft.ligabalonpie.command.ParticipanteCommand;
import com.palazzisoft.ligabalonpie.controllers.api.ParticipanteController;
import com.palazzisoft.ligabalonpie.entities.Participante;

/**
 * 
 * @author ppalazzi
 *
 */
@Controller
public class ParticipanteView {

	private final ParticipanteController participanteController;
	
	@Autowired
	public ParticipanteView(final ParticipanteController participanteController) {
		this.participanteController = participanteController;
	}
	
	@RequestMapping (value = "/listadoParticipante.adm", method = GET)
	public String obtenerTodosParticipantes(Model model) {
		List<Participante> participantes = 
				this.participanteController.obtenerParticipantes();
		
		try {
			List<ParticipanteCommand> participantesCommand = convertirParticipantesACommand(participantes);
			model.addAttribute("participantes", participantesCommand);
		} catch (ParseException e) {
			model.addAttribute("error", "Hubo un error al cargar los datos");
		}
		
		return LISTADO_PARTICIPANTE;
	}
}
