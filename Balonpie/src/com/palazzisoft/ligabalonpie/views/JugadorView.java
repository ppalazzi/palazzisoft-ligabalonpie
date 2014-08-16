package com.palazzisoft.ligabalonpie.views;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.palazzisoft.ligabalonpie.command.JugadorCommand;
import com.palazzisoft.ligabalonpie.controllers.api.JugadorController;
import com.palazzisoft.ligabalonpie.util.PageViews;

@Controller
public class JugadorView {

	private JugadorController jugadorController;

	@Autowired
	public JugadorView(JugadorController jugadorController) {
		this.jugadorController = jugadorController;
	}

	@RequestMapping(value = "/listadoJugador.adm", method = GET)
	public String showBack(Model model) {
		List<JugadorCommand> jugadores = this.jugadorController.obtenerJugadoresDisponibles();

		model.addAttribute("jugadores", jugadores);

		return PageViews.LISTADO_JUGADORES_BACK;
	}

	@RequestMapping(value = "/borrarJugador.adm", method = GET) 
	public String onDelete(@ModelAttribute JugadorCommand jugadorCommand, BindingResult bindingResult, Model model) {
				
		if (bindingResult.hasErrors()) {
			bindingResult.rejectValue("id", "error.jugador.id");
			// errors.rejectValue("fisico", "error.jugador.fisico.valores");
			return this.showBack(model);
		}
		
		this.jugadorController.eliminarJugadorById(jugadorCommand.getId());
		
		return this.showBack(model);
	}
	
}
