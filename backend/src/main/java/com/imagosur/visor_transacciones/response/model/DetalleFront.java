package com.imagosur.visor_transacciones.response.model;

public class DetalleFront {
	
	private String codigoEAN;
	private String descripcionEAN;
	private String descripcionTipoTransaccion;
	private double cantidad;
	private double monto;

	public DetalleFront(String codigoEAN, String descripcionEAN, String descripcionTipoTransaccion, double cantidad,
			double monto) {
		this.codigoEAN = codigoEAN;
		this.descripcionEAN = descripcionEAN;
		this.descripcionTipoTransaccion = descripcionTipoTransaccion;
		this.cantidad = cantidad;
		this.monto = monto;
	}

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
