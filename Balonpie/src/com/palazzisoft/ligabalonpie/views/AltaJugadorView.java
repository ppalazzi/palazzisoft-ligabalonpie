package com.palazzisoft.ligabalonpie.views;

import static com.palazzisoft.ligabalonpie.converters.JugadorConverter.convertirACommand;
import static com.palazzisoft.ligabalonpie.converters.JugadorConverter.convertirAJugador;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	private final JugadorController jugadorController;
	private final TipoJugadorController tipoJugadorController;
	private final JugadorValidator jugadorValidator;

	@Autowired	
	public AltaJugadorView(final JugadorController jugadorController,final TipoJugadorController tipoJugadorController,final JugadorValidator jugadorValidator) {
		this.jugadorController = jugadorController;
		this.tipoJugadorController = tipoJugadorController;
		this.jugadorValidator = jugadorValidator;
	}
	
	@RequestMapping(value = "/nuevoJugador.adm", method = GET)
	public String showForm(@ModelAttribute("jugadorCommand") JugadorCommand jugadorCommand, Model model) {		
		if (jugadorCommand.getId() != null) {
			Jugador jugador = this.jugadorController.getJugadorById(jugadorCommand.getId());
			jugadorCommand = convertirACommand(jugador);
		}

		model.addAttribute("jugador", jugadorCommand);
		model.addAttribute("tipoJugador", this.tipoJugadorController.obtenerTodosTipoJugador());			
		
		return VIEW;
	}
	
	@RequestMapping(value = "/nuevoJugador.adm", method = POST)
	public String onSubmit(@ModelAttribute("jugadorCommand") JugadorCommand jugadorCommand, BindingResult bindingResult,  Model model) throws ParseException {
				this.jugadorValidator.validate(jugadorCommand, bindingResult);
				
		if (bindingResult.hasErrors()) {
			return this.showForm(jugadorCommand, model);
		}
		Jugador jugador = convertirAJugador(jugadorCommand);
		
		this.jugadorController.saveJugador(jugador);
		
		return this.showForm(jugadorCommand,model);
	}
}
