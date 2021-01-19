package com.imagosur.visor_transacciones.response.model;

import java.util.Arrays;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class DetalleTransaccion {
	@SerializedName("Head")
	private Cabecera[] cabecera;
	
	@SerializedName("detail")
	private Detalle[] detalles;
	
	@SerializedName("payment")
	private Pago[] pagos;

	public Cabecera[] getCabecera() {
		return cabecera;
	}

	public void setCabecera(Cabecera[] cabecera) {
		this.cabecera = cabecera;
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
		return "DetalleTransaccion [cabecera=" + Arrays.toString(cabecera) + ", detalles=" + Arrays.toString(detalles)
				+ ", pagos=" + Arrays.toString(pagos) + "]";
	}
}
