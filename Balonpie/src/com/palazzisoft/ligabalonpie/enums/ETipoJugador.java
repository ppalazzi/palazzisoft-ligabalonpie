package com.palazzisoft.ligabalonpie.enums;

public enum ETipoJugador {

	ARQUERO(1),DEFENSOR(2),MEDIOCAMPISTA(3),ATACANTE(4);	
	
	private Integer id;
		
	ETipoJugador(Integer id) {
		this.id = id;
	}
	
	public Integer tipoJugador() {
		return id;
	}
	
}
