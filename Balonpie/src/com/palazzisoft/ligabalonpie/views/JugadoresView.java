package com.palazzisoft.ligabalonpie.views;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.palazzisoft.ligabalonpie.controllers.api.JugadorController;
import com.palazzisoft.ligabalonpie.entities.Jugador;

public class JugadoresView implements Controller {

	Logger log = Logger.getLogger(JugadoresView.class);
	
	@Autowired
	private JugadorController jugadorController;
	
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {

		//HttpSession session = (HttpSession)req.getSession();		
		//Participante participante = (Participante)session.getAttribute("participante");
		
		List<Jugador> jugadores = jugadorController.obtenerJugadoresDisponibles();
		
		ModelAndView vm = new ModelAndView("/jsp/jugador/listado.jsp");
		vm.addObject("jugadores", jugadores);
		//vm.addObject("participante", participante.getNombre() + " " + participante.getApellido());
		
		return vm;
	}

}
