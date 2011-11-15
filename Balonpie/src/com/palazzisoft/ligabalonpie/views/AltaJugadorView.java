package com.palazzisoft.ligabalonpie.views;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.palazzisoft.ligabalonpie.command.JugadorCommand;
import com.palazzisoft.ligabalonpie.controllers.api.JugadorController;
import com.palazzisoft.ligabalonpie.converters.JugadorConverter;
import com.palazzisoft.ligabalonpie.entities.Jugador;
import com.palazzisoft.ligabalonpie.util.PageViews;

public class AltaJugadorView extends SimpleFormController {

	@Autowired
	private JugadorController jugadorController;
	
	
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest req,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		
		ModelAndView mv = new ModelAndView(PageViews.ERROR_PAGINA);
		try {			
			JugadorCommand datos = (JugadorCommand)command;
			
			if (datos.getId() != null) {
				Jugador jugador = jugadorController.getJugadorById(datos.getId());
				JugadorConverter.copyFromCommandToJugador(jugador, datos);
				jugadorController.updateJugador(jugador);
				
				mv.addObject("jugadores", jugadorController.obtenerJugadoresDisponibles());
			}
			else {
				Jugador jugador = new Jugador();
				jugador = JugadorConverter.convertToJugador(datos);
				jugadorController.saveJugador(jugador);
				
				mv.addObject("jugadores", jugadorController.obtenerJugadoresDisponibles());
			}

			mv.setViewName(PageViews.LISTADO_JUGADORES);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return mv;
	}



	
}
