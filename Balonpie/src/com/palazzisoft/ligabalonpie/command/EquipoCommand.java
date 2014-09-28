package com.palazzisoft.ligabalonpie.command;


public class EquipoCommand {

	private Integer id;
	private String nombre;
	private String descripcion;
	private String fechaCreacion;
	private Integer estado;
	private Integer participanteId;
	private Long presupuesto;
	private Integer torneoId;
	private Long puntos;

	public EquipoCommand() {

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

	public Integer getParticipanteId() {
		return participanteId;
	}

	public void setParticipanteId(Integer participanteId) {
		this.participanteId = participanteId;
	}

	public Long getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(Long presupuesto) {
		this.presupuesto = presupuesto;
	}

	public Integer getTorneoId() {
		return torneoId;
	}

	public void setTorneoId(Integer torneoId) {
		this.torneoId = torneoId;
	}

	public Long getPuntos() {
		return puntos;
	}

	public void setPuntos(Long puntos) {
		this.puntos = puntos;
	}

}
