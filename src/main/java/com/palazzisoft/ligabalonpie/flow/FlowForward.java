package com.palazzisoft.ligabalonpie.flow;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.palazzisoft.ligabalonpie.command.EquipoCommand;
import com.palazzisoft.ligabalonpie.command.TorneoCommand;

@Service("flowForward")
public class FlowForward {
	
	public String guardarTorneo(@ModelAttribute TorneoCommand torneoCommand) {		
		return "nuevoEquipo";
	}
	
	public String guardarEquipo(@ModelAttribute EquipoCommand equipoCommand) {
		System.out.println("mivi hermo");
		
		return "fin";
	}
}
