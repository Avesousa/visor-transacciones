package com.imagosur.visor_transacciones.request.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Consulta {
	
	@JsonProperty("AffinityCardNbr_id")
	private String documentoCarrefour;
	
	@JsonProperty("CDay_id")
	private String fecha;
	
	@JsonProperty("Checkout_id")
	private String numeroCaja;
	
	@JsonProperty("DocumentTender_id")
	private String documentoMedioPago;
	
	@JsonProperty("OpPoint_id")
	private String codigoTienda;
	
	@JsonProperty("PosEvent_id")
	private String codigoTransaccion;
	
	@JsonProperty("ProductBarCode_id")
	private String codigoEAN;
	
	//@JsonProperty("Tender_id")
	//private int tipoMedioPago;
	
	@JsonProperty("Tender_id")
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
		return "Consulta [documentoCarrefour=" + documentoCarrefour + ", fecha=" + fecha + ", numeroCaja=" + numeroCaja
				+ ", documentoMedioPago=" + documentoMedioPago + ", codigoTienda=" + codigoTienda
				+ ", codigoTransaccion=" + codigoTransaccion + ", codigoEAN=" + codigoEAN + ", tipoMedioPago="
				+ tipoMedioPago + "]";
	}
	
	

}
