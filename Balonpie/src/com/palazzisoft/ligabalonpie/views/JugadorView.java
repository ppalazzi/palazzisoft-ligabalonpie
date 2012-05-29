package com.palazzisoft.ligabalonpie.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.palazzisoft.ligabalonpie.controllers.api.EquipoController;
import com.palazzisoft.ligabalonpie.controllers.api.JugadorController;
import com.palazzisoft.ligabalonpie.controllers.api.TipoJugadorController;
import com.palazzisoft.ligabalonpie.entities.Equipo;

@Controller
public class JugadorView {

	@Autowired
	private JugadorController jugadorController;
	
	@Autowired
	private TipoJugadorController tipoJugadorController;
	
	@Autowired
	private EquipoController equipoController;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Model model) {
		Equipo equipo = equipoController.getById(1);
		
		System.out.println(equipo.getDescripcion());
		
		return null;
	}	
	
//	@SuppressWarnings("unchecked")
//	public ModelAndView handleRequest(HttpServletRequest req,
//			HttpServletResponse res) throws Exception {
//
//		String jugadorId = req.getParameter("jugadorId");
//
//		ModelAndView mv = new ModelAndView();
//		
//			// Caso alta/edicion
//		if (jugadorId != null) { 
//			Jugador jugador = jugadorController.getJugadorById(Integer.parseInt(jugadorId));
//			List<TipoJugador> tipoJugadores = tipoJugadorController.obtenerTodosTipoJugador();
//			
//			if (jugador == null)
//				jugador = new Jugador();
//				
//			mv.getModelMap().put("jugadorCommand", JugadorConverter.convertToCommand(jugador));
//			mv.addObject("tipoJugadores", tipoJugadores);			
//			mv.setViewName(PageViews.EDICION_ALTA_JUGADOR);			
//		}
//		else {   // Caso consulta
//			List<Jugador> jugadores         = jugadorController.obtenerJugadoresDisponibles();
//			List<TipoJugador> tipoJugadores = tipoJugadorController.obtenerTodosTipoJugador();			
//			mv.setViewName(PageViews.LISTADO_JUGADORES);							
//			mv.addObject("jugadores", jugadores);
//			mv.addObject("tipoJugadores", tipoJugadores);
//		}
//								
//		return mv;
//	}

}
