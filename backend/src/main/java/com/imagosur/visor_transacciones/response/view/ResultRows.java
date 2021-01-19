package com.imagosur.visor_transacciones.response.view;

import java.util.List;

import com.imagosur.visor_transacciones.response.model.Pago;

public class ResultRows {
	
	private List<Pago> tipos;

	public List<Pago> getTipos() {
		return tipos;
	}

	public void setTipos(List<Pago> tipos) {
		this.tipos = tipos;
	}

	@Override
	public String toString() {
		return "ResultRows [tipos=" + tipos + "]";
	}
	
}
