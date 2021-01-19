package com.imagosur.visor_transacciones.response.model;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class Transaccion {
	
	@SerializedName("SaleTrx_id")
	private BigInteger id;
	
	@SerializedName("AutElectronicCodeExpiration_Dt")
	private String caeExpiration;
	
	@SerializedName("CDay_id")
	private String fecha;
	
	@SerializedName("OpPoint_Description")
	private String descripcionTienda;
	
	@SerializedName("Checkout_id")
	private int codigoCaja;
	
	@SerializedName("PosEvent_id")
	private int codigoTransaccion;
	
	@SerializedName("ReceiptNbr_id")
	private int numeroTicket;
	
	@SerializedName("AutorizationElectronicCode_id")
	private String cae;
	
	@SerializedName("AutorizationElectronicCodeAnt_id")
	private String caeA;
	
	@SerializedName("total_amount")
	private double total;
	
	@SerializedName("TrxEndSecond_Description")
	private String horaOperacion;
	
	@SerializedName("Tender_Description")
	private String descripcionMedioPago;
	
	@SerializedName("DocumentTender_id")
	private String documentoMedioPago;
	
	@SerializedName("AffinityCardNbr_id")
	private String documentoCarrefour;

	@SerializedName("SaleTrxType_Description")
	private String descripcionTipoTransaccion;
	
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDescripcionTienda() {
		return descripcionTienda;
	}

	public void setDescripcionTienda(String descripcionTienda) {
		this.descripcionTienda = descripcionTienda;
	}

	public int getCodigoCaja() {
		return codigoCaja;
	}

	public void setCodigoCaja(int codigoCaja) {
		this.codigoCaja = codigoCaja;
	}

	public int getCodigoTransaccion() {
		return codigoTransaccion;
	}

	public void setCodigoTransaccion(int codigoTransaccion) {
		this.codigoTransaccion = codigoTransaccion;
	}

	public int getNumeroTicket() {
		return numeroTicket;
	}

	public void setNumeroTicket(int numeroTicket) {
		this.numeroTicket = numeroTicket;
	}

	public String getCae() {
		return cae;
	}

	public void setCae(String cae) {
		this.cae = cae;
	}

	public String getCaeA() {
		return caeA;
	}

	public void setCaeA(String caeA) {
		this.caeA = caeA;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getHoraOperacion() {
		return horaOperacion;
	}

	public void setHoraOperacion(String horaOperacion) {
		this.horaOperacion = horaOperacion;
	}

	public String getDescripcionMedioPago() {
		return descripcionMedioPago;
	}

	public void setDescripcionMedioPago(String descripcionMedioPago) {
		this.descripcionMedioPago = descripcionMedioPago;
	}

	public String getDocumentoMedioPago() {
		return documentoMedioPago;
	}

	public void setDocumentoMedioPago(String documentoMedioPago) {
		this.documentoMedioPago = documentoMedioPago;
	}

	public String getDocumentoCarrefour() {
		return documentoCarrefour;
	}

	public void setDocumentoCarrefour(String documentoCarrefour) {
		this.documentoCarrefour = documentoCarrefour;
	}

	public String getDescripcionTipoTransaccion() {
		return descripcionTipoTransaccion;
	}

	public void setDescripcionTipoTransaccion(String descripcionTipoTransaccion) {
		this.descripcionTipoTransaccion = descripcionTipoTransaccion;
	}

	@Override
	public String toString() {
		return "Transaccion [id=" + id + ", fecha=" + fecha + ", descripcionTienda=" + descripcionTienda
				+ ", codigoCaja=" + codigoCaja + ", codigoTransaccion=" + codigoTransaccion + ", numeroTicket="
				+ numeroTicket + ", cae=" + cae + ", caeA=" + caeA + ", total=" + total + ", horaOperacion="
				+ horaOperacion + ", descripcionMedioPago=" + descripcionMedioPago + ", documentoMedioPago="
				+ documentoMedioPago + ", documentoCarrefour=" + documentoCarrefour + ", descripcionTipoTransaccion=" + descripcionTipoTransaccion + "]";
	}
	
	
	

}
