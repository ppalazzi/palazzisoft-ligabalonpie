package com.palazzisoft.ligabalonpie.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_TORNEO")
public class Torneo implements Serializable {

	private static final long serialVersionUID = 8522747450091068307L;

	public static final Integer CANT_MAX = 10;

	@Id
	@Column(name = "F_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "A_DESCRIPCION")
	private String descripcion;

	@Column(name = "A_FECHACREACION")
	private Date fechaCreacion;

	@Column(name = "A_ESTADO")
	private Integer estado;

	@Column(name = "A_FECHAINICIO")
	private Date fechaInicio;

	@Column(name = "A_FECHAFIN")
	private Date fechaFin;

	public Torneo() {

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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
