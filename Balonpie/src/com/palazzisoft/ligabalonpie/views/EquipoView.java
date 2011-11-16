package com.palazzisoft.ligabalonpie.views;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.palazzisoft.ligabalonpie.controllers.api.EquipoController;
import com.palazzisoft.ligabalonpie.entities.Equipo;
import com.palazzisoft.ligabalonpie.entities.Participante;
import com.palazzisoft.ligabalonpie.util.PageViews;

public class EquipoView implements Controller {

	@Autowired
	private EquipoController equipoController;
	
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
				
			}
		}
		catch(Exception e) {
			mv.setViewName(PageViews.ERROR_PAGINA);
		}
		
		return mv;
	}

}
