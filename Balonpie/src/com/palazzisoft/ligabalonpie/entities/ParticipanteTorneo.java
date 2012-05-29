package com.palazzisoft.ligabalonpie.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "T_PARTICIPANTE_EQUIPO")
@IdClass(ParticipanteTorneoPK.class)
public class ParticipanteTorneo implements Serializable {

	private static final long serialVersionUID = -6092390815160233352L;

	@Id
	private Torneo torneo;

	@Id
	private Participante participante;

	@Column(name = "A_ESCREADOR")
	private Boolean esCreador;

	public Boolean getEsCreador() {
		return esCreador;
	}

	public void setEsCreador(Boolean esCreador) {
		this.esCreador = esCreador;
	}

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
