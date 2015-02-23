package com.palazzisoft.ligabalonpie.command;

import static com.google.common.collect.Sets.newHashSet;
import static com.palazzisoft.ligabalonpie.util.FechaMascara.DATE_PATTERN;

import java.util.Set;

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
	
	@NotNull
	@DateTimeFormat(pattern="dd/MM/YY")
	private String fechaInicio;
	
	@NotNull
	@DateTimeFormat(pattern=DATE_PATTERN)
	private String fechaFin;
	
	private Set<EquipoCommand> equipos;
	
	private Integer participanteId;
	
	public TorneoCommand() {
		this.equipos = newHashSet();
	}
	
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

	public Set<EquipoCommand> getEquipos() {
		return equipos;
	}

	public void setEquipos(Set<EquipoCommand> equipos) {
		this.equipos = equipos;
	}

	public Integer getParticipanteId() {
		return participanteId;
	}

	public void setParticipanteId(Integer participanteId) {
		this.participanteId = participanteId;
	}
	
}
