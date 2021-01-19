package com.imagosur.visor_transacciones.response.model;

import com.google.gson.annotations.SerializedName;

public class Pago {

	@SerializedName("Tender_Description")
	private String Tender_Description;
	@SerializedName("SubTender_Description")
	private String SubTender_Description;
	@SerializedName("F_TenderAmount")
	private Double F_TenderAmount;
	@SerializedName("DocumentTender_id")
	private int DocumentTender_id;
	@SerializedName("Tender_id")
	private int Tender_id;
	@SerializedName("F_TenderCashReturn")
	private Double F_TenderCashReturn;
	@SerializedName("F_TenderSurcharge")
	private Double F_TenderSurcharge;
	
	public String getTender_Description() {
		return Tender_Description;
	}
	public void setTender_Description(String tender_Description) {
		Tender_Description = tender_Description;
	}
	public String getSubTender_Description() {
		return SubTender_Description;
	}
	public void setSubTender_Description(String subTender_Description) {
		SubTender_Description = subTender_Description;
	}
	public Double getF_TenderAmount() {
		return F_TenderAmount;
	}
	public void setF_TenderAmount(Double f_TenderAmount) {
		F_TenderAmount = f_TenderAmount;
	}
	public int getDocumentTender_id() {
		return DocumentTender_id;
	}
	public void setDocumentTender_id(int documentTender_id) {
		DocumentTender_id = documentTender_id;
	}
	public int getTender_id() {
		return Tender_id;
	}
	public void setTender_id(int tender_id) {
		Tender_id = tender_id;
	}
	public Double getF_TenderCashReturn() {
		return F_TenderCashReturn;
	}
	public void setF_TenderCashReturn(Double f_TenderCashReturn) {
		F_TenderCashReturn = f_TenderCashReturn;
	}
	
	public Double getF_TenderSurcharge() {
		return F_TenderSurcharge;
	}
	public void setF_TenderSurcharge(Double f_TenderSurcharge) {
		F_TenderSurcharge = f_TenderSurcharge;
	}
	@Override
	public String toString() {
		return "Pago [Tender_Description=" + Tender_Description + ", SubTender_Description=" + SubTender_Description
				+ ", F_TenderAmount=" + F_TenderAmount + ", DocumentTender_id=" + DocumentTender_id + ", Tender_id="
				+ Tender_id + ", F_TenderCashReturn=" + F_TenderCashReturn + ", F_TenderSurcharge=" + F_TenderSurcharge + "]";
	}	
	
}
