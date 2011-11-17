package com.palazzisoft.ligabalonpie.views;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.palazzisoft.ligabalonpie.controllers.api.EquipoController;
import com.palazzisoft.ligabalonpie.controllers.api.JugadorController;
import com.palazzisoft.ligabalonpie.entities.Equipo;
import com.palazzisoft.ligabalonpie.entities.Jugador;
import com.palazzisoft.ligabalonpie.entities.Participante;
import com.palazzisoft.ligabalonpie.util.PageViews;

public class EquipoView implements Controller {

	@Autowired
	private EquipoController equipoController;
	
	@Autowired
	private JugadorController jugadorController;
	
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		ModelAndView mv = new ModelAndView(PageViews.LISTADO_EQUIPOS_POR_PARTICIPANTE);
		
		try {
			String equipoId = req.getParameter("equipoId");
			
			Participante participante = (Participante)req.getSession().getAttribute("participanteSession");			
			List<Equipo> equipos = equipoController.obtenerEquiposPorParticipante(participante.getId());
			mv.addObject("equipos", equipos);
			
				// Seleccionó el Id de un equipo, por lo tanto cargamos los jugadores de ese equipo
			if (equipoId != null) {
				List<Jugador> jugadores   = jugadorController.obtenerJugadoresDisponibles();
				List<Jugador> disponibles = equipoController.obtenerJugadoresDeEquipo(Integer.parseInt(equipoId));
				
				mv.addObject("jugadores", jugadores);
				mv.addObject("disponibles", disponibles);
				mv.addObject("equipoId", equipoId);
				mv.addObject("presupuesto", this.obtenerPresupuesto(equipos, Integer.parseInt(equipoId)));
				mv.setViewName(PageViews.COMPRAR_EQUIPOS);				
			}
		}
		catch(Exception e) {
			mv.setViewName(PageViews.ERROR_PAGINA);
		}
		
		return mv;
	}


	private Integer obtenerPresupuesto(List<Equipo> equipos, Integer equipoId) {
		Equipo equipo = this.equipoSeleccionado(equipos, equipoId);
		
		return equipo.getPresupuesto();
	}
	
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
