package com.imagosur.visor_transacciones.request.model;

public class ConsultaFront {
	private String documentoCarrefour;
	private String fecha;
	private String numeroCaja;
	private String documentoMedioPago;
	private String codigoTienda;
	private String codigoTransaccion;
	private String codigoEAN;
	
	private String tipoMedioPago;
	
	public String getDocumentoCarrefour() {
		return documentoCarrefour;
	}
	public void setDocumentoCarrefour(String documentoCarrefour) {
		this.documentoCarrefour = documentoCarrefour;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getNumeroCaja() {
		return numeroCaja;
	}
	public void setNumeroCaja(String numeroCaja) {
		this.numeroCaja = numeroCaja;
	}
	public String getDocumentoMedioPago() {
		return documentoMedioPago;
	}
	public void setDocumentoMedioPago(String documentoMedioPago) {
		this.documentoMedioPago = documentoMedioPago;
	}
	public String getCodigoTienda() {
		return codigoTienda;
	}
	public void setCodigoTienda(String codigoTienda) {
		this.codigoTienda = codigoTienda;
	}
	public String getCodigoTransaccion() {
		return codigoTransaccion;
	}
	public void setCodigoTransaccion(String codigoTransaccion) {
		this.codigoTransaccion = codigoTransaccion;
	}
	public String getCodigoEAN() {
		return codigoEAN;
	}
	public void setCodigoEAN(String codigoEAN) {
		this.codigoEAN = codigoEAN;
	}
	public String getTipoMedioPago() {
		return tipoMedioPago;
	}
	public void setTipoMedioPago(String tipoMedioPago) {
		this.tipoMedioPago = tipoMedioPago;
	}
	@Override
	public String toString() {
		return "Consulta Front [documentoCarrefour=" + documentoCarrefour + ", fecha=" + fecha + ", numeroCaja=" + numeroCaja
				+ ", documentoMedioPago=" + documentoMedioPago + ", codigoTienda=" + codigoTienda
				+ ", codigoTransaccion=" + codigoTransaccion + ", codigoEAN=" + codigoEAN + ", tipoMedioPago="
				+ tipoMedioPago + "]";
	}
	
	

}
