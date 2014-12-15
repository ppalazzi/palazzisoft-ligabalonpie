package com.palazzisoft.ligabalonpie.command;

import java.util.Date;

public class JugadorCommand {

	private Integer id;
	private String  nombre;
	private String  apellido;
	private String  fechaNacimiento;
	private Integer velocidad;
	private Integer remate;
	private Integer habilidad;
	private Integer fisico;
	private Integer estado;
	private Integer valor;
	private Integer tipoJugadorId;
	private String  tipoJugadorDescripcion;
	
	public JugadorCommand() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(Integer velocidad) {
		this.velocidad = velocidad;
	}

	public Integer getRemate() {
		return remate;
	}

	public void setRemate(Integer remate) {
		this.remate = remate;
	}

	public Integer getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(Integer habilidad) {
		this.habilidad = habilidad;
	}

	public Integer getFisico() {
		return fisico;
	}

	public void setFisico(Integer fisico) {
		this.fisico = fisico;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}
		
	public Integer getTipoJugadorId() {
		return tipoJugadorId;
	}

	public void setTipoJugadorId(Integer tipoJugadorId) {
		this.tipoJugadorId = tipoJugadorId;
	}

	public String getTipoJugadorDescripcion() {
		return tipoJugadorDescripcion;
	}

	public void setTipoJugadorDescripcion(String tipoJugadorDescripcion) {
		this.tipoJugadorDescripcion = tipoJugadorDescripcion;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
}
