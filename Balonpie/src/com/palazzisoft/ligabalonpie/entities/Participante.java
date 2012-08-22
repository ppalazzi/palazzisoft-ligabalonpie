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
@Table (name="T_PARTICIPANTE")
public class Participante implements Serializable {

	private static final long serialVersionUID = -6280886379763145897L;

	public Participante() {
		
	}	
	
	@Id
	@Column (name="F_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)		
	private Integer id;
	
	@Column (name="A_NOMBRE")
	private String  nombre;
	
	@Column (name="A_APELLIDO")
	private String apellido;
	
	@Column (name="A_EMAIL")	
	private String email;
	
	@Column (name="A_FECHANACIMIENTO")	
	private Date fechaNacimiento;
	
	@Column (name="A_CALLE")	
	private String calle;
	
	@Column (name="A_NUMERO")	
	private String numero;
		
	@Column (name="A_ESTADO")	
	private Byte estado; 
	
	@Column (name="A_PASSWORD")
	private String password;
	
	@Column (name = "A_CIUDAD")
	private String ciudad;
	
	@OneToMany(mappedBy="participante", fetch=FetchType.EAGER)
	private Set<ParticipanteTorneo> participanteEquipo;
	
	@ManyToOne (fetch = FetchType.EAGER)
	private Pais pais;
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
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

	public Byte getEstado() {
		return estado;
	}

	public void setEstado(Byte estado) {
		this.estado = estado;
	}
		
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
		
	public Set<ParticipanteTorneo> getParticipanteEquipo() {
		return participanteEquipo;
	}

	public void setParticipanteEquipo(Set<ParticipanteTorneo> participanteEquipo) {
		this.participanteEquipo = participanteEquipo;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
		
	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
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
		Participante other = (Participante) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
