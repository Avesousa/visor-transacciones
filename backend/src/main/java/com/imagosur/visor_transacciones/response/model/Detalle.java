package com.imagosur.visor_transacciones.response.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class Detalle {
	
	@SerializedName("ProductBarCode_id")
	private String codigoEAN;
	
	@SerializedName("product_description")
	private String descripcionEAN;
	
	@SerializedName("ItemType_description")
	private String descripcionTipoTransaccion;
	
	@SerializedName("SaleQty")
	private double cantidad;
	
	@SerializedName("TotAmount")
	private double monto;

	public String getCodigoEAN() {
		return codigoEAN;
	}

	public void setCodigoEAN(String codigoEAN) {
		this.codigoEAN = codigoEAN;
	}

	public String getDescripcionEAN() {
		return descripcionEAN;
	}

	public void setDescripcionEAN(String descripcionEAN) {
		this.descripcionEAN = descripcionEAN;
	}

	public String getDescripcionTipoTransaccion() {
		return descripcionTipoTransaccion;
	}

	public void setDescripcionTipoTransaccion(String descripcionTipoTransaccion) {
		this.descripcionTipoTransaccion = descripcionTipoTransaccion;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	@Override
	public String toString() {
		return "Detalle [codigoEAN=" + codigoEAN + ", descripcionEAN=" + descripcionEAN
				+ ", descripcionTipoTransaccion=" + descripcionTipoTransaccion + ", cantidad=" + cantidad + ", monto="
				+ monto + "]";
	}
	
	

}
