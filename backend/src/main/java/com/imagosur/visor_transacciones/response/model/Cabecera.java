package com.imagosur.visor_transacciones.response.model;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class Cabecera {
	
	@SerializedName("AutElectronicCodeExpiration_Dt")
	private String AutElectronicCodeExpiration_Dt;
	
	@SerializedName("AutorizationElectronicCode_id")
	private String AutorizationElectronicCode_id;
	
	@SerializedName("AutorizationElectronicCodeAnt_id")
	private String AutorizationElectronicCodeAnt_id;
	
	@SerializedName("CDay_id")
	private String fecha;
	
	@SerializedName("Checkout_id")
	private int Checkout_id;
	
	@SerializedName("OpPoint_Description")
	private String OpPoint_Description;
	
	@SerializedName("PosEvent_id")
	private int PosEvent_id;
	
	@SerializedName("ReceiptNbr_id")
	private int ReceiptNbr_id;
	
	@SerializedName("SaleTrx_id")
	private BigInteger SaleTrx_id;
	
	@SerializedName("total_amount")
	private double total_amount;
	
	public BigInteger getSaleTrx_id() {
		return SaleTrx_id;
	}

	public void setSaleTrx_id(BigInteger saleTrx_id) {
		SaleTrx_id = saleTrx_id;
	}

	public String getCDay_id() {
		return fecha;
	}

	public void setCDay_id(String cDay_id) {
		fecha = cDay_id;
	}

	public String getOpPoint_Description() {
		return OpPoint_Description;
	}

	public void setOpPoint_Description(String opPoint_Description) {
		OpPoint_Description = opPoint_Description;
	}

	public int getCheckout_id() {
		return Checkout_id;
	}

	public void setCheckout_id(int checkout_id) {
		Checkout_id = checkout_id;
	}

	public int getPosEvent_id() {
		return PosEvent_id;
	}

	public void setPosEvent_id(int posEvent_id) {
		PosEvent_id = posEvent_id;
	}

	public int getReceiptNbr_id() {
		return ReceiptNbr_id;
	}

	public void setReceiptNbr_id(int receiptNbr_id) {
		ReceiptNbr_id = receiptNbr_id;
	}

	public String getAutorizationElectronicCode_id() {
		return AutorizationElectronicCode_id;
	}

	public void setAutorizationElectronicCode_id(String autorizationElectronicCode_id) {
		AutorizationElectronicCode_id = autorizationElectronicCode_id;
	}

	public String getAutorizationElectronicCodeAnt_id() {
		return AutorizationElectronicCodeAnt_id;
	}

	public void setAutorizationElectronicCodeAnt_id(String autorizationElectronicCodeAnt_id) {
		AutorizationElectronicCodeAnt_id = autorizationElectronicCodeAnt_id;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	@Override
	public String toString() {
		return "Cabecera [AutElectronicCodeExpiration_Dt=" + AutElectronicCodeExpiration_Dt
				+ ", AutorizationElectronicCode_id=" + AutorizationElectronicCode_id
				+ ", AutorizationElectronicCodeAnt_id=" + AutorizationElectronicCodeAnt_id + ", CDay_id=" + fecha
				+ ", Checkout_id=" + Checkout_id + ", OpPoint_Description=" + OpPoint_Description + ", PosEvent_id="
				+ PosEvent_id + ", ReceiptNbr_id=" + ReceiptNbr_id + ", SaleTrx_id=" + SaleTrx_id + ", total_amount="
				+ total_amount + "]";
	}

	
	
	
	

}
