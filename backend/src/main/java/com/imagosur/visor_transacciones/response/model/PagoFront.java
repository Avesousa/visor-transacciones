package com.imagosur.visor_transacciones.response.model;


public class PagoFront {

	private String descripcion;
	private String subDescripcion;
	private Double monto;
	private int documento;
	
	

	public PagoFront(String descripcion, String subDescripcion, Double monto) {
		this.descripcion = descripcion;
		this.subDescripcion = subDescripcion;
		this.monto = monto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getSubDescripcion() {
		return subDescripcion;
	}

	public void setSubDescripcion(String subDescripcion) {
		this.subDescripcion = subDescripcion;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	@Override
	public String toString() {
		return "Pago [descripcion=" + descripcion + ", subDescripcion=" + subDescripcion + ", monto=" + monto
				+ ", documento=" + documento + "]";
	}
	
	
}
