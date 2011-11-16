package com.palazzisoft.ligabalonpie.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
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
@Table (name="T_EQUIPO")
public class Equipo implements Serializable {

	private static final long serialVersionUID = 6358813478617236529L;
	
	@Id
	@Column (name="F_ID")
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name="A_NOMBRE")
	private String  nombre;
	
	@Column (name="A_DESCRIPCION")
	private String  descripcion;
	
	@Column (name="A_ESTADO")
	private Integer estado;
	
	@ManyToOne (fetch=FetchType.EAGER)
	private Participante participante;
	
	@Column (name="A_PRESUPUESTO")
	private Integer presupuesto;
	
	@OneToMany(mappedBy = "equipo", fetch=FetchType.EAGER)
	private Set<EquipoJugador> equipoJugadores;
            
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

	public Integer getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(Integer presupuesto) {
		this.presupuesto = presupuesto;
	}

	public Set<EquipoJugador> getEquipoJugadores() {
		return equipoJugadores;
	}

	public void setEquipoJugadores(Set<EquipoJugador> equipoJugadores) {
		this.equipoJugadores = equipoJugadores;
	}
	
}
