package com.palazzisoft.ligabalonpie.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.palazzisoft.ligabalonpie.enums.EEstado;
import com.palazzisoft.ligabalonpie.exception.BalonpieException;
/**
 * 
 * @author ppalazzi
 *
 */
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

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "T_EQUIPO_TORNEO", joinColumns = { 
			@JoinColumn(name = "TORNEO_F_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "EQUIPO_F_ID", 
					nullable = false, updatable = false) })
	private List<Equipo> equipos;
		
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
	
	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public boolean desligarEquipo(Integer equipoId) throws BalonpieException {
		if (this.getEstado().equals(EEstado.ACTIVO.getEstado())) {
			throw new BalonpieException("El Torneo se encuentra en estado Activo");
		}
		
		for (Equipo equipo : this.equipos) {
			if (equipo.getId().equals(equipoId)) {
				return this.equipos.remove(equipo);
			}
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Torneo other = (Torneo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
