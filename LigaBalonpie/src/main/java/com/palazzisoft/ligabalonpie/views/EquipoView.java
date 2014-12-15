package com.palazzisoft.ligabalonpie.views;

import static com.palazzisoft.ligabalonpie.converters.EquipoConverter.convertirAEquipo;
import static com.palazzisoft.ligabalonpie.converters.EquipoConverter.convertirAEquipoCommand;
import static com.palazzisoft.ligabalonpie.util.PageViews.ALTA_EDICION_EQUIPO;
import static com.palazzisoft.ligabalonpie.util.PageViews.DASHBOARD;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.palazzisoft.ligabalonpie.command.EquipoCommand;
import com.palazzisoft.ligabalonpie.controllers.api.EquipoController;
import com.palazzisoft.ligabalonpie.entities.Equipo;
import com.palazzisoft.ligabalonpie.util.PageViews;
import com.palazzisoft.ligabalonpie.validators.EquipoValidator;

@Controller
public class EquipoView  {
	
	private EquipoController equipoController;	
	private EquipoValidator equipoValidator;
	
	@Autowired
	public EquipoView(EquipoController equipoController, EquipoValidator equipoValidator) {
		this.equipoController = equipoController;
		this.equipoValidator = equipoValidator;
	}
	
	@RequestMapping(value = "/nuevoEquipo.htm", method = RequestMethod.GET)
	public String nuevoEquipoShowForm(@RequestParam("participanteId") String participanteId, ModelMap model) {
		model.addAttribute("participanteId", participanteId);
		return PageViews.NUEVO_EQUIPO;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/nuevoEquipo.htm", method = RequestMethod.POST)
	public String onSubmit(
			@ModelAttribute("torneoCommand") EquipoCommand equipoCommand,
			@RequestParam("participanteId") Integer participanteId,
			ModelMap model) {

		if (!this.equipoController.verificarExistenciaDeEquipo(equipoCommand
				.getNombre())) {
			this.equipoController.nuevoEquipo(equipoCommand, participanteId);
		} else {
			model.put("mensajeError", "Ya tenés un equipo con ese nombre");
		}

		return DASHBOARD;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/traerEquipoDelTorneo", method = POST)
	public String traerEquipoPorTorneoYUsuario(@RequestParam("torneoId") Integer torneoId,
			@RequestParam("participanteId") Integer participanteId, ModelMap model) {
		EquipoCommand equipoCommand = this.equipoController.obtenerEquipoPorTorneoYParticipante(
				torneoId, participanteId);
		
		model.put("equipo", equipoCommand);
		
		return PageViews.EQUIPO_RESUMEN;
	}
	
	@RequestMapping(value = "/nuevoEquipo.adm", method = GET)
	public String showBack(@ModelAttribute EquipoCommand equipoCommand, Model model) {
		if (equipoCommand.getId() != null) {
			Equipo equipo = this.equipoController.getById(equipoCommand.getId());
			equipoCommand = convertirAEquipoCommand(equipo);
		}
		
		model.addAttribute("equipo", equipoCommand);
		
		return ALTA_EDICION_EQUIPO;		
	}
	
	@RequestMapping(value = "/nuevoEquipo.adm", method = POST)
	public String onSubmit(@ModelAttribute EquipoCommand equipoCommand, BindingResult bindingResult, Model model) {
		this.equipoValidator.validate(equipoCommand, bindingResult);
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("equipo", equipoCommand);
			return ALTA_EDICION_EQUIPO;
		}
		
		Equipo equipo = convertirAEquipo(equipoCommand);
		this.equipoController.guardarEquipo(equipo);
		
		return ALTA_EDICION_EQUIPO;
	}
	
}
