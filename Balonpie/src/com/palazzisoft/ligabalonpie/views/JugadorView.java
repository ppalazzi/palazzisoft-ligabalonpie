package com.palazzisoft.ligabalonpie.views;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.palazzisoft.ligabalonpie.controllers.api.JugadorController;
import com.palazzisoft.ligabalonpie.controllers.api.TipoJugadorController;
import com.palazzisoft.ligabalonpie.converters.JugadorConverter;
import com.palazzisoft.ligabalonpie.entities.Jugador;
import com.palazzisoft.ligabalonpie.entities.TipoJugador;
import com.palazzisoft.ligabalonpie.util.PageViews;

public class JugadorView implements Controller {

	@Autowired
	private JugadorController jugadorController;
	
	@Autowired
	private TipoJugadorController tipoJugadorController;
	
	@SuppressWarnings("unchecked")
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		String jugadorId = req.getParameter("jugadorId");

		ModelAndView mv = new ModelAndView();
		
			// Caso alta/edicion
		if (jugadorId != null) { 
			Jugador jugador = jugadorController.getJugadorById(Integer.parseInt(jugadorId));
			List<TipoJugador> tipoJugadores = tipoJugadorController.obtenerTodosTipoJugador();
			
			if (jugador == null)
				jugador = new Jugador();
				
			mv.getModelMap().put("jugadorCommand", JugadorConverter.convertToCommand(jugador));
			mv.addObject("tipoJugadores", tipoJugadores);			
			mv.setViewName(PageViews.EDICION_ALTA_JUGADOR);			
		}
		else {   // Caso consulta
			List<Jugador> jugadores         = jugadorController.obtenerJugadoresDisponibles();
			List<TipoJugador> tipoJugadores = tipoJugadorController.obtenerTodosTipoJugador();			
			mv.setViewName(PageViews.LISTADO_JUGADORES);							
			mv.addObject("jugadores", jugadores);
			mv.addObject("tipoJugadores", tipoJugadores);
		}
								
		return mv;
	}

}
