package com.palazzisoft.ligabalonpie.util;


import static com.palazzisoft.ligabalonpie.enums.EEstado.ACTIVO;

import java.util.List;

import org.springframework.stereotype.Component;

import com.palazzisoft.ligabalonpie.controllers.api.JugadorController;
import com.palazzisoft.ligabalonpie.entities.Equipo;
import com.palazzisoft.ligabalonpie.entities.Torneo;
import com.palazzisoft.ligabalonpie.enums.EEstado;

@Component
public class CrearEquipos {

	private final JugadorController jugarorController;
	
	public CrearEquipos(final JugadorController jugadorController) {
		this.jugarorController = jugadorController;
	}
	
	public List<Equipo> crearEquiposRivales(Equipo equipo) {
		Integer[] jugadoresId = equipo.jugadoresId();
		
		for (int i = 0 ; i < Torneo.CANT_MAX ; i++) {
			Equipo nuevoEquipo = new Equipo();
			nuevoEquipo.setEstado(ACTIVO.getEstado());
			nuevoEquipo.setDescripcion("Descripcion 1");
			nuevoEquipo.setNombre("Nombre 1");
		}
		
		return null;
	} 
}
