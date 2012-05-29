package com.palazzisoft.ligabalonpie.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_EQUIPO")
public class Equipo implements Serializable {

	private static final long serialVersionUID = 6358813478617236529L;

	@Id
	@Column(name = "F_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "A_NOMBRE")
	private String nombre;

	@Column(name = "A_DESCRIPCION")
	private String descripcion;

	@Column(name = "A_FECHA_CREACION")
	private Date fechaCreacion;

	@Column(name = "A_ESTADO")
	private Integer estado;

	@ManyToOne(fetch = FetchType.EAGER)
	private Participante participante;

	@Column(name = "A_PRESUPUESTO")
	private Long presupuesto;

	@OneToMany(mappedBy = "equipo", fetch = FetchType.EAGER)
	private Set<EquipoJugador> equipoJugadores;

	@Column(name = "A_PUNTOS")
	private Long puntos;

	public Equipo() {

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public Long getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(Long presupuesto) {
		this.presupuesto = presupuesto;
	}

	public Set<EquipoJugador> getEquipoJugadores() {
		return equipoJugadores;
	}

	public void setEquipoJugadores(Set<EquipoJugador> equipoJugadores) {
		this.equipoJugadores = equipoJugadores;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Long getPuntos() {
		return puntos;
	}

	public void setPuntos(Long puntos) {
		this.puntos = puntos;
	}

}
