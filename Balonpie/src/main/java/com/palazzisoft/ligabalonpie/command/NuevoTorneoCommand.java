package com.palazzisoft.ligabalonpie.command;

import static com.google.common.collect.Sets.newHashSet;

import java.io.Serializable;
import java.util.Set;

/**
 * 
 * @author ppalazzi
 *
 */
public class NuevoTorneoCommand implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nombreTorneo;
	private String nombreEquipo;	
	private String descripcionEquipo;
	
	private Integer idPos0;
	private Integer idPos1;
	private Integer idPos2;
	private Integer idPos3;
	private Integer idPos4;
	private Integer idPos5;
	private Integer idPos6;
	private Integer idPos7;
	private Integer idPos8;
	private Integer idPos9;
	private Integer idPos10;
	private Integer cantidadJugadores;
	private Integer participanteId;
	
	public Integer getIdPos0() {
		return idPos0;
	}

	public void setIdPos0(Integer idPos0) {
		this.idPos0 = idPos0;
	}

	public Integer getIdPos1() {
		return idPos1;
	}

	public void setIdPos1(Integer idPos1) {
		this.idPos1 = idPos1;
	}

	public Integer getIdPos2() {
		return idPos2;
	}

	public void setIdPos2(Integer idPos2) {
		this.idPos2 = idPos2;
	}

	public Integer getIdPos3() {
		return idPos3;
	}

	public void setIdPos3(Integer idPos3) {
		this.idPos3 = idPos3;
	}

	public Integer getIdPos4() {
		return idPos4;
	}

	public void setIdPos4(Integer idPos4) {
		this.idPos4 = idPos4;
	}

	public Integer getIdPos5() {
		return idPos5;
	}

	public void setIdPos5(Integer idPos5) {
		this.idPos5 = idPos5;
	}

	public Integer getIdPos6() {
		return idPos6;
	}

	public void setIdPos6(Integer idPos6) {
		this.idPos6 = idPos6;
	}

	public Integer getIdPos7() {
		return idPos7;
	}

	public void setIdPos7(Integer idPos7) {
		this.idPos7 = idPos7;
	}

	public Integer getIdPos8() {
		return idPos8;
	}

	public void setIdPos8(Integer idPos8) {
		this.idPos8 = idPos8;
	}

	public Integer getIdPos9() {
		return idPos9;
	}

	public void setIdPos9(Integer idPos9) {
		this.idPos9 = idPos9;
	}

	public Integer getIdPos10() {
		return idPos10;
	}

	public void setIdPos10(Integer idPos10) {
		this.idPos10 = idPos10;
	}

	public NuevoTorneoCommand() {
		
	}
	
	public String getNombreTorneo() {
		return nombreTorneo;
	}
	public void setNombreTorneo(String nombreTorneo) {
		this.nombreTorneo = nombreTorneo;
	}
	public String getNombreEquipo() {
		return nombreEquipo;
	}
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	public String getDescripcionEquipo() {
		return descripcionEquipo;
	}
	public void setDescripcionEquipo(String descripcionEquipo) {
		this.descripcionEquipo = descripcionEquipo;
	}
	
	public Integer getCantidadJugadores() {
		this.cantidadJugadores = getPosicionesOcupadas().size(); 
		return this.cantidadJugadores;
	}
	
	public Set<Integer> getPosicionesOcupadas() {
		Set<Integer> posiciones = newHashSet();
		posiciones.add(idPos0);
		posiciones.add(idPos1);
		posiciones.add(idPos2);
		posiciones.add(idPos3);
		posiciones.add(idPos4);
		posiciones.add(idPos5);
		posiciones.add(idPos6);
		posiciones.add(idPos7);
		posiciones.add(idPos8);
		posiciones.add(idPos9);
		posiciones.add(idPos10);
		
		return posiciones;
	}
	
	public Integer getParticipanteId() {
		return participanteId;
	}

	public void setParticipanteId(Integer participanteId) {
		this.participanteId = participanteId;
	}	
}
