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
import com.palazzisoft.ligabalonpie.entities.TipoJugador;
import com.palazzisoft.ligabalonpie.enums.ETipoJugador;
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
			String tipoJugadorSeleccionado = req.getParameter("tipoJugadorSeleccionado");
			String estadoSeleccionado = req.getParameter("estadoSeleccionado");
			
			Integer tipoJugadorId = tipoJugadorSeleccionado != null ? Integer.parseInt(tipoJugadorSeleccionado)	: ETipoJugador.ATACANTE.tipoJugador();		
			Integer estado = estadoSeleccionado != null ? Integer.parseInt(estadoSeleccionado)	: 0;		

			
			JugadorCommand datos = (JugadorCommand)command;
			
			if (datos.getId() != null) {
				Jugador jugador = jugadorController.getJugadorById(datos.getId());
				
				TipoJugador tipoJugador = new TipoJugador();
				tipoJugador.setId(tipoJugadorId);
				
				jugador.setTipoJugador(tipoJugador);
				datos.setEstado(estado);
				JugadorConverter.copyFromCommandToJugador(jugador, datos);
				jugadorController.updateJugador(jugador);
				
				mv.addObject("jugadores", jugadorController.obtenerJugadoresDisponibles());
			}
			else {
				Jugador jugador = new Jugador();
				jugador = JugadorConverter.convertirAJugador(datos);
				jugadorController.saveJugador(jugador);
				
				mv.addObject("jugadores", jugadorController.obtenerJugadoresDisponibles());
			}

			mv.setViewName(PageViews.LISTADO_JUGADORES);
		} catch (Exception e) {
			mv.setViewName(PageViews.ERROR_PAGINA);
		}		
		
		return mv;
	}



	
}
