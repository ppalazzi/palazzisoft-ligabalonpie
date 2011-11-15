package com.palazzisoft.ligabalonpie.views;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.palazzisoft.ligabalonpie.command.JugadorCommand;
import com.palazzisoft.ligabalonpie.controllers.api.JugadorController;
import com.palazzisoft.ligabalonpie.converters.JugadorConverter;
import com.palazzisoft.ligabalonpie.entities.Jugador;
import com.palazzisoft.ligabalonpie.util.PageViews;

public class JugadorView implements Controller {

	@Autowired
	private JugadorController jugadorController;
	
	@SuppressWarnings("unchecked")
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		String jugadorId = req.getParameter("jugadorId");

		ModelAndView mv = new ModelAndView();
		
			// Caso alta/edicion
		if (jugadorId != null) { 
			Jugador jugador = jugadorController.getJugadorById(Integer.parseInt(jugadorId));
								
			if (jugador == null)
				jugador = new Jugador();
				
			mv.getModelMap().put("jugadorCommand", JugadorConverter.convertToCommand(jugador));			
			mv.setViewName(PageViews.EDICION_ALTA_JUGADOR);			
		}
		else {   // Caso consulta
			List<Jugador> jugadores = jugadorController.obtenerJugadoresDisponibles();				
			mv.setViewName(PageViews.LISTADO_JUGADORES);							
			mv.addObject("jugadores", jugadores);
		}
						
		return mv;
	}

}
