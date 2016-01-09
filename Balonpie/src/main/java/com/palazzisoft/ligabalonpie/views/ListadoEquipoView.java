package com.palazzisoft.ligabalonpie.views;

import static com.palazzisoft.ligabalonpie.converters.EquipoConverter.convertirEquipoACommand;
import static com.palazzisoft.ligabalonpie.util.PageViews.LISTADO_EQUIPOS_POR_PARTICIPANTE;
import static com.palazzisoft.ligabalonpie.util.PageViews.LISTADO_EQUIPO_BACK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.palazzisoft.ligabalonpie.command.EquipoCommand;
import com.palazzisoft.ligabalonpie.controllers.api.EquipoController;
import com.palazzisoft.ligabalonpie.entities.Equipo;

@Controller
public class ListadoEquipoView {

	private EquipoController equipoController;
	
	@Autowired
	public ListadoEquipoView(EquipoController equipoController) {
		this.equipoController = equipoController;
	}
	
	@RequestMapping(method = GET, value = "/listadoEquipo.htm")	
	public String showForm(@RequestParam("participanteId") Integer partidipanteId,  ModelMap model) {
		List<EquipoCommand> equipos = this.equipoController.obtenerEquiposPorParticipante(partidipanteId);
		model.put("equipos", equipos);
		
		return LISTADO_EQUIPOS_POR_PARTICIPANTE;
	}
	
	@RequestMapping(method = GET, value = "/listadoEquipo.adm")
	public String showBack(ModelMap model) {
		List<Equipo> equipos = this.equipoController.obtenerTodosLosEquipos();				
		List<EquipoCommand> equiposVista = convertirEquipoACommand(equipos);
		
		model.put("equipos", equiposVista);
		
		return LISTADO_EQUIPO_BACK;
	}
}
