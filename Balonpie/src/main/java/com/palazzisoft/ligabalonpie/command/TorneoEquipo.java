package com.palazzisoft.ligabalonpie.command;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author ppalazzi
 *
 */
public class TorneoEquipo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private TorneoCommand torneo;
	private EquipoCommand equipo;
	private List<JugadorCommand> jugadores;
	
	public TorneoEquipo() {
		this.jugadores = new ArrayList<JugadorCommand>(11);
	}
	
	public TorneoCommand getTorneo() {
		return torneo;
	}
	public void setTorneo(TorneoCommand torneo) {
		this.torneo = torneo;
	}
	public EquipoCommand getEquipo() {
		return equipo;
	}
	public void setEquipo(EquipoCommand equipo) {
		this.equipo = equipo;
	}

	public List<JugadorCommand> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<JugadorCommand> jugadores) {
		this.jugadores = jugadores;
	}
		
}
