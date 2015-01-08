package com.palazzisoft.ligabalonpie.command;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class ParticipanteCommand {

	private Integer id;
	
	@Size(min=2, max=50) 
	private String nombre;
	
	@Size(min=2, max=50)
	private String apellido;
	
	@Email
	private String email;
	private String fechaNacimiento;
	private String calle;
	private String numero;
	private String ciudad;
	private Integer pais;
	private String password;
	private Integer estado;
	private List<TorneoCommand> torneos;

	public ParticipanteCommand() {
		this.torneos = new ArrayList<TorneoCommand>();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPais() {
		return pais;
	}

	public void setPais(Integer pais) {
		this.pais = pais;
	}

	public void agregarTorneo(TorneoCommand torneoCommand) {
		this.torneos.add(torneoCommand);
	}
	
	public List<TorneoCommand> getTorneos() {
		return this.torneos;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public void setTorneos(List<TorneoCommand> torneos) {
		this.torneos = torneos;
	}
	
	
}
