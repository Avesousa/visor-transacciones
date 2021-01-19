package com.imagosur.visor_transacciones.response.view;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import com.imagosur.visor_transacciones.response.model.Transaccion;
import com.imagosur.visor_transacciones.response.model.Cabecera;
import com.imagosur.visor_transacciones.response.model.Detalle;
import com.imagosur.visor_transacciones.response.model.Pago;

public class Detalles {
	
	@SerializedName("header")
	private Transaccion[] cabeceras;
	
	@SerializedName("detail")
	private Detalle[] detalles;
	
	@SerializedName("payment")
	private Pago[] pagos;

	public Transaccion[] getCabeceras() {
		return cabeceras;
	}

	public void setCabeceras(Transaccion[] cabeceras) {
		this.cabeceras = cabeceras;
	}

	public Detalle[] getDetalles() {
		return detalles;
	}

	public void setDetalles(Detalle[] detalles) {
		this.detalles = detalles;
	}

	public Pago[] getPagos() {
		return pagos;
	}

	public void setPagos(Pago[] pagos) {
		this.pagos = pagos;
	}

	@Override
	public String toString() {
		return "Detalles [cabeceras=" + cabeceras + ", detalles=" + detalles + ", pagos=" + pagos + "]";
	}
	
	
}
