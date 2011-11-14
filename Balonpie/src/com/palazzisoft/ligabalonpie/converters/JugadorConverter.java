package com.palazzisoft.ligabalonpie.converters;

import com.palazzisoft.ligabalonpie.command.JugadorCommand;
import com.palazzisoft.ligabalonpie.entities.Jugador;

public class JugadorConverter {

	public static JugadorCommand convertToCommand(Jugador jugador) {
		JugadorCommand command = new JugadorCommand();
		command.setApellido(jugador.getApellido());
		command.setId(jugador.getId());
		command.setNombre(jugador.getNombre());
		
		return command;
	}
	
	public static Jugador convertToJugador(JugadorCommand command) {
		Jugador jugador = new Jugador();
		jugador.setApellido(command.getApellido());
		jugador.setNombre(command.getNombre());
		jugador.setId(command.getId());
		
		return jugador;
	}
	
	public static void copyFromCommandToJugador(Jugador jugador, JugadorCommand command) {
		jugador.setApellido(command.getApellido());
		jugador.setNombre(command.getNombre());
		jugador.setId(command.getId());
	}
}
