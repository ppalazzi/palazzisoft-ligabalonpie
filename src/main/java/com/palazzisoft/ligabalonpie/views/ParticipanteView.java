package com.palazzisoft.ligabalonpie.views;

import static com.palazzisoft.ligabalonpie.converters.ParticipanteConverter.convertirCommandAParticipante;
import static com.palazzisoft.ligabalonpie.converters.ParticipanteConverter.convertirParticipanteACommand;
import static com.palazzisoft.ligabalonpie.converters.ParticipanteConverter.convertirParticipantesACommand;
import static com.palazzisoft.ligabalonpie.converters.TorneoConverter.convertirListadoACommand;
import static com.palazzisoft.ligabalonpie.util.PageViews.ALTA_BAJA_PARTICIPANTE;
import static com.palazzisoft.ligabalonpie.util.PageViews.LISTADO_PARTICIPANTE;
import static com.palazzisoft.ligabalonpie.util.PageViews.MIS_TORNEOS;
import static com.palazzisoft.ligabalonpie.util.PageViews.PERFIL;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.palazzisoft.ligabalonpie.command.ParticipanteCommand;
import com.palazzisoft.ligabalonpie.controllers.api.ParticipanteController;
import com.palazzisoft.ligabalonpie.converters.ParticipanteConverter;
import com.palazzisoft.ligabalonpie.entities.Participante;
import com.palazzisoft.ligabalonpie.entities.Torneo;
import com.palazzisoft.ligabalonpie.validators.ParticipanteValidator;

/**
 * 
 * @author ppalazzi
 * 
 */
@Controller
public class ParticipanteView {

	private final ParticipanteController participanteController;
	private final ParticipanteValidator participanteValidator;

	@Resource(name = "mapaPaises")
	private Map<Integer, String> mapaPaises;
	
	@Autowired
	public ParticipanteView(
			final ParticipanteController participanteController,
			final ParticipanteValidator participanteValidator) {
		this.participanteController = participanteController;
		this.participanteValidator = participanteValidator;
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
	public String traerParticipante(
			@ModelAttribute ParticipanteCommand participanteCommand, Model model) {
		try {
			participanteCommand = obtenerParticipantePorId(participanteCommand);
			model.addAttribute("participante", participanteCommand);
			model.addAttribute("paises", mapaPaises);
		} catch (ParseException e) {
			model.addAttribute("error", "Hubo un error al cargar los datos");
		}

		return ALTA_BAJA_PARTICIPANTE;
	}
	
	@RequestMapping(value = "/nuevoParticipante.adm", method = POST)
	public String guardarParticipante(@ModelAttribute @Valid ParticipanteCommand participanteCommand,
			BindingResult bindingResult, Model model) {
		return altaEdicionParticipante(participanteCommand, bindingResult, model, ALTA_BAJA_PARTICIPANTE);		
	}
	
	@RequestMapping( value = "/torneosDeParticipante.htm", method = GET)
	public String torneosDeParticipante(@RequestParam Integer participanteId, Model model) {
		try {
			List<Torneo> torneos = this.participanteController.torneosDeParticipante(participanteId);		
			model.addAttribute("torneos",convertirListadoACommand(torneos));
		} catch (ParseException e) {
			model.addAttribute("error", "Hubo un error al cargar los datos");			
		}
		
		return MIS_TORNEOS;
	}

	@RequestMapping(value = "/participantePorId.htm", method = GET)
	public String participantePorId(@RequestParam Integer participanteId, Model model) {
		try {
			Participante participante = this.participanteController.obtenerParticipantePorId(participanteId);
			ParticipanteCommand participanteCommand = ParticipanteConverter.convertirParticipanteACommand(participante);
			model.addAttribute("participante", participanteCommand);
			model.addAttribute("paises", mapaPaises);
		} catch (ParseException e) {
			model.addAttribute("error", "Hubo un error al cargar los datos");			
		}

		return PERFIL;
	}
	
	@RequestMapping(value = "/modificarPerfil.htm", method = POST)
	public String modificarParticipante(ParticipanteCommand participanteCommand,
			BindingResult bindingResult, Model model) {
		return altaEdicionParticipante(participanteCommand, bindingResult, model, PERFIL);
	}
	
	private ParticipanteCommand obtenerParticipantePorId(ParticipanteCommand participanteCommand)
			throws ParseException {
		if (participanteCommand.getId() != null) {
			Participante participante = this.participanteController
					.obtenerParticipantePorId(participanteCommand.getId());
			participanteCommand = convertirParticipanteACommand(participante);		

		}
		return participanteCommand;
	}	
	
	private String altaEdicionParticipante(ParticipanteCommand participanteCommand,
			BindingResult bindingResult, Model model, String output) {
		this.participanteValidator.validate(participanteCommand, bindingResult);
		model.addAttribute("paises", mapaPaises);
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("participante", participanteCommand);
			return output;
		}
		
		try {
			Participante participante = convertirCommandAParticipante(participanteCommand);
			this.participanteController.guardarParticipante(participante);
			model.addAttribute("participante", participanteCommand);
			model.addAttribute("mensaje", "Se ha guardado exitosamente");
		} catch (ParseException e) {
			model.addAttribute("error", "Hubo un error al cargar los datos");
		}
		
		return output;
	}	
}
