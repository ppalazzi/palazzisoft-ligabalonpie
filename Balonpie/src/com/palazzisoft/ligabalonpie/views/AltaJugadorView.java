package com.palazzisoft.ligabalonpie.views;

import static com.palazzisoft.ligabalonpie.converters.JugadorConverter.convertirAJugador;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.palazzisoft.ligabalonpie.command.JugadorCommand;
import com.palazzisoft.ligabalonpie.controllers.api.JugadorController;
import com.palazzisoft.ligabalonpie.controllers.api.TipoJugadorController;
import com.palazzisoft.ligabalonpie.entities.Jugador;
import com.palazzisoft.ligabalonpie.validators.JugadorValidator;
/**
 * 
 * @author pablo
 *
 */
@Controller
public class AltaJugadorView  {

	private static final String VIEW = "/backend/jugador/nuevo";
	
	private JugadorController jugadorController;
	private TipoJugadorController tipoJugadorController;
	private JugadorValidator jugadorValidator;

	@Autowired	
	public AltaJugadorView(JugadorController jugadorController, TipoJugadorController tipoJugadorController, JugadorValidator jugadorValidator) {
		this.jugadorController = jugadorController;
		this.tipoJugadorController = tipoJugadorController;
		this.jugadorValidator = jugadorValidator;
	}
	
	@RequestMapping(value = "/nuevoJugador.adm", method = GET)
	public String showForm(@ModelAttribute JugadorCommand jugadorCommand, Model model) {
		model.addAttribute("jugador", jugadorCommand);
		model.addAttribute("tipoJugador", this.tipoJugadorController.obtenerTodosTipoJugador());			
		
		return VIEW;
	}
	
	@RequestMapping(value = "/nuevoJugador.adm", method = POST)
	public String onSubmit(@ModelAttribute JugadorCommand jugadorCommand, Errors errors, Model model) {
		this.jugadorValidator.validate(jugadorCommand, errors);

		if (errors.hasErrors()) {
			return this.showForm(jugadorCommand, model);
		}
		
		Jugador jugador = convertirAJugador(jugadorCommand);
		
		this.jugadorController.saveJugador(jugador);
		
		return this.showForm(jugadorCommand, model);
	}

	
}
