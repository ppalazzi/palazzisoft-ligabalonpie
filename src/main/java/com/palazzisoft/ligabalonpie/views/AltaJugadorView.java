package com.palazzisoft.ligabalonpie.views;

import static com.palazzisoft.ligabalonpie.converters.JugadorConverter.convertirACommand;
import static com.palazzisoft.ligabalonpie.converters.JugadorConverter.convertirAJugador;
import static com.palazzisoft.ligabalonpie.util.PageViews.ALTA_BAJA_JUGADOR;
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
public class AltaJugadorView {

	private final JugadorController jugadorController;
	private final TipoJugadorController tipoJugadorController;
	private final JugadorValidator jugadorValidator;

	@Autowired
	public AltaJugadorView(final JugadorController jugadorController,
			final TipoJugadorController tipoJugadorController,
			final JugadorValidator jugadorValidator) {
		this.jugadorController = jugadorController;
		this.tipoJugadorController = tipoJugadorController;
		this.jugadorValidator = jugadorValidator;
	}

}
