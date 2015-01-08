package com.palazzisoft.ligabalonpie.command;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author ppalazzi
 *
 */
public class TorneoCommand {

	private Integer id;
	
	@Size (min = 2, max = 250)
	private String descripcion;
	
	private String fechaCreacion;
	
	@NotNull
	private Integer estado;
	
	@DateTimeFormat(pattern="dd/MM/YY")
	private String fechaInicio;
	
	@DateTimeFormat(pattern="dd/MM/YY")
	private String fechaFin;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
}
