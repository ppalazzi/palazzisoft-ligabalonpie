package com.palazzisoft.ligabalonpie.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.palazzisoft.ligabalonpie.command.EquipoCommand;
import com.palazzisoft.ligabalonpie.controllers.api.EquipoController;
import com.palazzisoft.ligabalonpie.controllers.api.JugadorController;
import com.palazzisoft.ligabalonpie.util.PageViews;

@Controller
public class EquipoView  {
	
	private EquipoController equipoController;	
	private JugadorController jugadorController;
	
	@Autowired
	public EquipoView(EquipoController equipoController, JugadorController jugadorController) {
		this.equipoController = equipoController;
		this.jugadorController = jugadorController;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/nuevoEquipo.htm", method = RequestMethod.GET)
	public String nuevoEquipoShowForm(@RequestParam("participanteId") String participanteId, ModelMap model) {
		model.put("participanteId", participanteId);
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

		return PageViews.DASHBOARD;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/traerEquipoDelTorneo", method = RequestMethod.POST)
	public String traerEquipoPorTorneoYUsuario(@RequestParam("torneoId") Integer torneoId,
			@RequestParam("participanteId") Integer participanteId, ModelMap model) {
		EquipoCommand equipoCommand = this.equipoController.obtenerEquipoPorTorneoYParticipante(
				torneoId, participanteId);
		
		model.put("equipo", equipoCommand);
		
		return PageViews.EQUIPO_RESUMEN;
	}
}
