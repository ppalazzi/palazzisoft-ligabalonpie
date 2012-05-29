package com.palazzisoft.ligabalonpie.converters;

import com.palazzisoft.ligabalonpie.command.JugadorCommand;
import com.palazzisoft.ligabalonpie.entities.Jugador;

public class JugadorConverter {

	public static JugadorCommand convertirACommand(Jugador jugador) {
		JugadorCommand command = new JugadorCommand();
		command.setApellido(jugador.getApellido());
		command.setId(jugador.getId());
		command.setNombre(jugador.getNombre());
		command.setEstado(jugador.getEstado());
		command.setFisico(jugador.getFisico());
		command.setHabilidad(jugador.getHabilidad());
		command.setRemate(jugador.getRemate());
		command.setValor(jugador.getValor());
		command.setVelocidad(jugador.getVelocidad());
		
		return command;
	}
	
	public static Jugador convertirAJugador(JugadorCommand command) {
		Jugador jugador = new Jugador();
		jugador.setApellido(command.getApellido());
		jugador.setNombre(command.getNombre());
		jugador.setId(command.getId());
		jugador.setEstado(command.getEstado());
		jugador.setFisico(command.getFisico());
		jugador.setHabilidad(command.getHabilidad());
		jugador.setRemate(command.getRemate());
		jugador.setValor(command.getValor());
		jugador.setVelocidad(command.getVelocidad());
		
		return jugador;
	}
	
	public static void copyFromCommandToJugador(Jugador jugador, JugadorCommand command) {
		jugador.setApellido(command.getApellido());
		jugador.setNombre(command.getNombre());
		jugador.setId(command.getId());
		jugador.setEstado(command.getEstado());
		jugador.setFisico(command.getFisico());
		jugador.setHabilidad(jugador.getHabilidad());
		jugador.setRemate(command.getRemate());
		jugador.setVelocidad(command.getVelocidad());
		jugador.setHabilidad(command.getHabilidad());
		jugador.setValor(command.getValor());
	}
}
