package com.palazzisoft.ligabalonpie.converters;

import static com.palazzisoft.ligabalonpie.converters.ConverterUtil.getFormat;

import java.text.ParseException;

import com.palazzisoft.ligabalonpie.command.JugadorCommand;
import com.palazzisoft.ligabalonpie.entities.Jugador;
import com.palazzisoft.ligabalonpie.entities.TipoJugador;

public class JugadorConverter  {

	public static JugadorCommand convertirACommand(Jugador jugador) {				
		JugadorCommand command = new JugadorCommand();
		command.setApellido(jugador.getApellido());
		command.setId(jugador.getId());		
		command.setFechaNacimiento(getFormat().format(jugador.getFechaNacimiento()));
		command.setNombre(jugador.getNombre());
		command.setEstado(jugador.getEstado());
		command.setFisico(jugador.getFisico());
		command.setHabilidad(jugador.getHabilidad());
		command.setRemate(jugador.getRemate());
		command.setValor(jugador.getValor());
		command.setVelocidad(jugador.getVelocidad());
		command.setTipoJugadorDescripcion(jugador.getTipoJugador().getDescripcion());
		
		return command;
	}
	
	public static Jugador convertirAJugador(JugadorCommand command) throws ParseException {		
		Jugador jugador = new Jugador();
		jugador.setApellido(command.getApellido());
		jugador.setFechaNacimiento(getFormat().parse(command.getFechaNacimiento()));
		jugador.setNombre(command.getNombre());
		jugador.setId(command.getId());
		jugador.setEstado(command.getEstado());
		jugador.setFisico(command.getFisico());
		jugador.setHabilidad(command.getHabilidad());
		jugador.setRemate(command.getRemate());
		jugador.setValor(command.getValor());
		jugador.setVelocidad(command.getVelocidad());
		
		TipoJugador tipoJugador = new TipoJugador(command.getTipoJugadorId());
		jugador.setTipoJugador(tipoJugador);			
		
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
