package com.palazzisoft.ligabalonpie.views;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.palazzisoft.ligabalonpie.controllers.api.EquipoController;
import com.palazzisoft.ligabalonpie.controllers.api.EquipoJugadorController;
import com.palazzisoft.ligabalonpie.controllers.api.JugadorController;
import com.palazzisoft.ligabalonpie.entities.Jugador;
import com.palazzisoft.ligabalonpie.util.PageViews;

public class CompraJugadorView implements Controller {

	@Autowired
	private EquipoController equipoController;
	
	@Autowired
	private EquipoJugadorController equipoJugadorController;
	
	@Autowired
	private JugadorController jugadorController;
	
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		ModelAndView mv = new ModelAndView(PageViews.COMPRAR_EQUIPOS);
		
		try {
			String equipoId    = req.getParameter("equipoId");
			String jugadorId   = req.getParameter("jugadorId");
			Integer presupuesto = req.getParameter("presupuesto") == null ? 0 : Integer.parseInt(req.getParameter("presupuesto"));
			
			if (equipoId == null || jugadorId == null) {
				mv.setViewName(PageViews.ERROR_PAGINA);
			}
			else {				
				String mensaje = "Jugador Agregado con éxito";
				
				if (this.perteneceJugadorAlEquipo(Integer.parseInt(jugadorId), Integer.parseInt(equipoId))) {					
					mensaje = "EL Jugador ya participa del Equipo";
				} 
				else if (!this.permitePresupuesto(presupuesto,Integer.parseInt(equipoId),Integer.parseInt((jugadorId)))) {				
					mensaje = "Presupuesto inválido";					
				}	
				else {
					equipoJugadorController.agregarJugadorAlEquipo(Integer.parseInt(jugadorId), Integer.parseInt(equipoId));					
				}
				
				this.cargarMenues(Integer.parseInt(equipoId), Integer.parseInt(jugadorId), mv);
				mv.addObject("mensaje", mensaje);
				mv.addObject("equipoId", equipoId);		
				mv.addObject("presupuesto", presupuesto);									
			}
			
		}
		catch (Exception e) {
			mv.setViewName(PageViews.ERROR_PAGINA);
		}
		
		return mv;
	}
	
	private boolean perteneceJugadorAlEquipo(Integer jugadorId,Integer equipoId) {
		return equipoJugadorController.perteneceJugadorAlEquipo(jugadorId, equipoId);
	}
	
	private boolean permitePresupuesto(Integer presupuesto,Integer equipoId,Integer jugadorId) {
		Integer valorEquipo = equipoJugadorController.obtenerValorEquipo(equipoId);
		Jugador jugador     = jugadorController.getJugadorById(jugadorId);
				
		return (valorEquipo + jugador.getValor()) <= presupuesto;
	}
		
	private void cargarMenues(Integer equipoId, Integer jugadorId, ModelAndView mv) {
		List<Jugador> disponibles = equipoController.obtenerJugadoresDeEquipo(equipoId);
		List<Jugador> jugadores   = jugadorController.obtenerJugadoresDisponibles();
		
		mv.addObject("jugadores", jugadores);
		mv.addObject("disponibles", disponibles);
	}

}
