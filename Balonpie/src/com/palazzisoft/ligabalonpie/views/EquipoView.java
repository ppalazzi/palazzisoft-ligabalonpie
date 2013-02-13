package com.palazzisoft.ligabalonpie.views;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.palazzisoft.ligabalonpie.command.EquipoCommand;
import com.palazzisoft.ligabalonpie.controllers.api.EquipoController;
import com.palazzisoft.ligabalonpie.controllers.api.JugadorController;
import com.palazzisoft.ligabalonpie.entities.Equipo;
import com.palazzisoft.ligabalonpie.entities.Jugador;
import com.palazzisoft.ligabalonpie.entities.Participante;
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

	// TODO sacar las lineas comentadas
	
//	public ModelAndView handleRequest(HttpServletRequest req,
//			HttpServletResponse res) throws Exception {
//
//		ModelAndView mv = new ModelAndView(PageViews.LISTADO_EQUIPOS_POR_PARTICIPANTE);
//		
//		try {
//			String equipoId = req.getParameter("equipoId");
//			
//			Participante participante = (Participante)req.getSession().getAttribute("participanteSession");			
//			List<Equipo> equipos = equipoController.obtenerEquiposPorParticipante(participante.getId());
//			mv.addObject("equipos", equipos);
//			
//				// Selección el Id de un equipo, por lo tanto cargamos los jugadores de ese equipo
//			if (equipoId != null) {
//				List<Jugador> jugadores   = jugadorController.obtenerJugadoresDisponibles();
//				List<Jugador> disponibles = equipoController.obtenerJugadoresDeEquipo(Integer.parseInt(equipoId));
//				
//				mv.addObject("jugadores", jugadores);
//				mv.addObject("disponibles", disponibles);
//				mv.addObject("equipoId", equipoId);
//				mv.addObject("presupuesto", this.obtenerPresupuesto(equipos, Integer.parseInt(equipoId)));
//				mv.setViewName(PageViews.COMPRAR_EQUIPOS);				
//			}
//		}
//		catch(Exception e) {
//			mv.setViewName(PageViews.ERROR_PAGINA);
//		}
//		
//		return mv;
//	}
//
//
//	private Long obtenerPresupuesto(List<Equipo> equipos, Integer equipoId) {
//		Equipo equipo = this.equipoSeleccionado(equipos, equipoId);
//		
//		return equipo.getPresupuesto();
//	}
	
	private Equipo equipoSeleccionado(List<Equipo> equipos, Integer equipoId) {
		Equipo equipo = new Equipo();
		
		int i = 0; boolean esta = false;
		while(i < equipos.size() && !esta) {
			if (equipos.get(i).getId().equals(equipoId)) {
				equipo = equipos.get(i);
				esta = true;
			}
		}
		
		return equipo;
	}
}
