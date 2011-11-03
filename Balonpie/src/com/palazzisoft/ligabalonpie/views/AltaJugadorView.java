package com.palazzisoft.ligabalonpie.views;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.palazzisoft.ligabalonpie.controllers.api.JugadorController;
import com.palazzisoft.ligabalonpie.entities.Jugador;
import com.palazzisoft.ligabalonpie.util.PageViews;

public class AltaJugadorView implements Controller {

	@Autowired
	private JugadorController jugadorController;
	
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		String salida = PageViews.ERROR_PAGINA;
		ModelAndView mv = new ModelAndView(salida);
		
		Integer idJugador = Integer.parseInt(req.getParameter("idJugador"));
		
		if (idJugador != null) {
			Jugador jugador = jugadorController.getJugadorById(idJugador);
			mv.addObject("jugador", jugador);
			mv.setViewName(PageViews.EDICION_ALTA_JUGADOR);
		}
		
		return mv;
	}

	
}
