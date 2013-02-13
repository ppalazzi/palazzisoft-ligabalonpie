package com.palazzisoft.ligabalonpie.enums;

public enum ETipoJugador {

	ARQUERO(0),DEFENSOR(1),MEDIOCAMPISTA(2),ATACANTE(3);	
	
	private Integer id;
		
	ETipoJugador(Integer id) {
		this.id = id;
	}
	
	public Integer tipoJugador() {
		return id;
	}
	
}
