package com.palazzisoft.ligabalonpie.views;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.palazzisoft.ligabalonpie.command.EquipoCommand;
import com.palazzisoft.ligabalonpie.controllers.api.EquipoController;
import com.palazzisoft.ligabalonpie.util.PageViews;

@Component
@RequestMapping("/listadoEquipo.htm")
public class ListadoEquipoView {

	private EquipoController equipoController;
	
	@Autowired
	public ListadoEquipoView(EquipoController equipoController) {
		this.equipoController = equipoController;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET)	
	public String showForm(@RequestParam("participanteId") Integer partidipanteId,  ModelMap model) {
		List<EquipoCommand> equipos = this.equipoController.obtenerEquiposPorParticipante(partidipanteId);
		model.put("equipos", equipos);
		
		return PageViews.LISTADO_EQUIPOS_POR_PARTICIPANTE;
	}
}
