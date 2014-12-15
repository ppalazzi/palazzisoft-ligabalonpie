package com.palazzisoft.ligabalonpie.enums;

public enum EEstadoTorneo {

	ACTIVO(1),INACTIVO(0);
	
	private Integer id;
	
	EEstadoTorneo(Integer id) {
		this.id = id;
	}
	
	public Integer getEstadoTorneo() {
		return this.id;
	}
}
