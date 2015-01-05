package com.palazzisoft.ligabalonpie.views;

import static com.palazzisoft.ligabalonpie.converters.ParticipanteConverter.convertirCommandAParticipante;
import static com.palazzisoft.ligabalonpie.converters.ParticipanteConverter.convertirParticipanteACommand;
import static com.palazzisoft.ligabalonpie.converters.ParticipanteConverter.convertirParticipantesACommand;
import static com.palazzisoft.ligabalonpie.util.PageViews.LISTADO_PARTICIPANTE;
import static com.palazzisoft.ligabalonpie.util.PageViews.NUEVO_PARTICIPANTE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@Resource(name = "mapaPaises")
	private Map<Integer, String> mapaPaises;
	
	@Autowired
	public ParticipanteView(final ParticipanteController participanteController) {
		this.participanteController = participanteController;
	}

	@RequestMapping(value = "/listadoParticipante.adm", method = GET)
	public String obtenerTodosParticipantes(Model model) {
		List<Participante> participantes = this.participanteController.obtenerParticipantes();

		try {
			List<ParticipanteCommand> participantesCommand = convertirParticipantesACommand(participantes);
			model.addAttribute("participantes", participantesCommand);
		} catch (ParseException e) {
			model.addAttribute("error", "Hubo un error al cargar los datos");
		}

		return LISTADO_PARTICIPANTE;
	}

	@RequestMapping(value = "/nuevoParticipante.adm", method = GET)
	public String traerParticipante(@RequestParam Integer participanteId, Model model) {
		Participante participante = this.participanteController.obtenerParticipantePorId(participanteId);
		
		try {
			ParticipanteCommand participanteCommand = convertirParticipanteACommand(participante);
			model.addAttribute("participante", participanteCommand);
			model.addAttribute("paises", mapaPaises);
		} catch (ParseException e) {
			model.addAttribute("error", "Hubo un error al cargar los datos");
		}
		
		return NUEVO_PARTICIPANTE;
	}	
	
	@RequestMapping(value = "/nuevoParticipante.adm", method = POST)
	public String guardarParticipante(@ModelAttribute ParticipanteCommand participanteCommand,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("participante", participanteCommand);
		}
		
		try {
			Participante participante = convertirCommandAParticipante(participanteCommand);
			this.participanteController.guardarParticipante(participante);
		} catch (ParseException e) {
			model.addAttribute("error", "Hubo un error al cargar los datos");
		}
		
		return NUEVO_PARTICIPANTE;
	}
}
