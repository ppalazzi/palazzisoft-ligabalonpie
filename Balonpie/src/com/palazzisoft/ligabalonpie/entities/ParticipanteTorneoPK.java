package com.palazzisoft.ligabalonpie.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ParticipanteTorneoPK implements Serializable {

	private static final long serialVersionUID = -7185771403882268835L;

	@ManyToOne
	private Participante participante;
	
	@ManyToOne
	private Torneo torneo;

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public Torneo getTorneo() {
		return torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}

}
