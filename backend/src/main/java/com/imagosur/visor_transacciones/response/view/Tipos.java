package com.imagosur.visor_transacciones.response.view;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tipos {
	
	@JsonProperty("ResultRows")
	private ResultRows tipos;

	public ResultRows getTipos() {
		return tipos;
	}

	public void setTipos(ResultRows tipos) {
		this.tipos = tipos;
	}

	@Override
	public String toString() {
		return "Tipos [tipos=" + tipos + "]";
	} 
	
	
}
