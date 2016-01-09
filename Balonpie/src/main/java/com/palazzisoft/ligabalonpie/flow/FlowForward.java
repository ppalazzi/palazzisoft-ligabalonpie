package com.palazzisoft.ligabalonpie.flow;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.palazzisoft.ligabalonpie.command.NuevoTorneoCommand;
import com.palazzisoft.ligabalonpie.controllers.api.TorneoController;
import com.palazzisoft.ligabalonpie.exception.BalonpieException;
import com.palazzisoft.ligabalonpie.validators.NuevoTorneoValidator;

@Controller("flowForward")
public class FlowForward {

	private final NuevoTorneoValidator nuevoTorneoValidator;
	private final TorneoController torneoController;

	@Autowired
	public FlowForward(final NuevoTorneoValidator nuevoTorneoValidator,
			final TorneoController torneoController) {
		this.nuevoTorneoValidator = nuevoTorneoValidator;
		this.torneoController = torneoController;
	}

	@RequestMapping(value = "nuevoTorneo.htm", method = GET)
	public String nuevoTorneo(@RequestParam Integer participanteId,
			@ModelAttribute NuevoTorneoCommand nuevoTorneo, Model model) {
		model.addAttribute("nuevoTorneo", nuevoTorneo);
		model.addAttribute("participanteId", participanteId);
		return "frontend/torneo/nuevoTorneo";
	}

	@RequestMapping(value = "nuevoTorneo.htm", method = POST)
	public String guardarTorneo(@RequestParam Integer participanteId,
			@ModelAttribute NuevoTorneoCommand nuevoTorneo,
			BindingResult bindingResult, Model model) {
		this.nuevoTorneoValidator.validate(nuevoTorneo, bindingResult);

		if (bindingResult.hasErrors()) {
			return this.nuevoTorneo(participanteId, nuevoTorneo, model);
		}

		this.guardarTorneoDeParticipante(nuevoTorneo, participanteId, model);
		model.addAttribute("mensaje", "Se ha creado con éxito el Torneo " + nuevoTorneo.getNombreTorneo());
		
		return "frontend/torneo/nuevoTorneo";
	}

	private void guardarTorneoDeParticipante(
			NuevoTorneoCommand nuevoTorneoCommand, Integer participanteId, Model model) {
		try {
			this.torneoController.crearTorneo(nuevoTorneoCommand, participanteId);
		} catch (BalonpieException e) {
			model.addAttribute("mensaje", e.getMessage());
		}
	}
}
