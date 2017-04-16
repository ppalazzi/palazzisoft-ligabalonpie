package com.palazzisoft.ligabalonpie.views;

import static com.palazzisoft.ligabalonpie.util.PageViews.JUGAR_PRINCIPAL;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.palazzisoft.balonpie.service.model.Equipo;
import com.palazzisoft.balonpie.service.model.Participante;
import com.palazzisoft.balonpie.service.model.Torneo;
import com.palazzisoft.ligabalonpie.controllers.api.EquipoController;
import com.palazzisoft.ligabalonpie.controllers.api.ParticipanteController;
import com.palazzisoft.ligabalonpie.controllers.api.TorneoController;
import com.palazzisoft.ligabalonpie.util.FixtureFactory;

@Controller
@RequestMapping("/jugarTorneo.htm")
public class JugarView {

	Logger log = Logger.getLogger(JugarView.class);
	
	private final ParticipanteController participanteController;
	private final TorneoController torneoController;
	private final EquipoController equipoController;
	private final FixtureFactory fixtureFactory;
	
	@Autowired
	public JugarView(final ParticipanteController participanteController, final TorneoController torneoController,
			final EquipoController equipoController, FixtureFactory fixtureFactory) {
		this.participanteController = participanteController;
		this.torneoController = torneoController;
		this.equipoController = equipoController;
		this.fixtureFactory = fixtureFactory;
	}
	
	
	@RequestMapping (method = RequestMethod.GET)
	public String showForm(@RequestParam Integer participanteId, 
			@RequestParam Integer torneoId, @RequestParam Integer equipoId, ModelMap model) {		
		Participante participante = this.participanteController.obtenerParticipantePorId(participanteId);
		Torneo torneo = this.torneoController.obtenerTorneoPorId(torneoId);
		Equipo equipo = this.equipoController.getById(equipoId);
		
		model.addAttribute("participante" , participante);
		model.addAttribute("torneo", torneo);
		model.addAttribute("equipo", equipo);
				
		return JUGAR_PRINCIPAL;
	}	
}
