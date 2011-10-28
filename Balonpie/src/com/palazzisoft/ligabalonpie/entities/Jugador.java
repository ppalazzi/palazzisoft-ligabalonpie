package com.palazzisoft.ligabalonpie.entities;

import java.io.Serializable;
import java.util.HashSet;

public class Jugador implements Serializable {

	private static final long serialVersionUID = 9189577911540530290L;
	
	private Integer id;
	private String  nombre;
	
	public Jugador() {
		
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
		Jugador other = (Jugador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public static void main(String args[]) {
		Jugador j = new Jugador();
		j.setId(1);
		
		Jugador j2 = new Jugador();
		j2.setId(2);
		
		Participante p = new Participante();
		p.setId(1);
		
		System.out.println(j.hashCode());
		System.out.println(j2.hashCode());
		System.out.println(p.hashCode());
		
		HashSet<? super Serializable> hash = new HashSet<Serializable>();
		hash.add(j);
		hash.add(j2);
		hash.add(p);
		
		System.out.println(hash.toString());
	}
}
