package com.imagosur.visor_transacciones.webservice;

public class WebServiceException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private int numeroDeError;
	
	public WebServiceException(){
		super();
	}
	
	public WebServiceException(String message,int error) {
		super(message);
		this.numeroDeError = error;
	}

	public int getNumeroDeError() {
		return this.numeroDeError;
	}

	public void setError(int error) {
		this.numeroDeError = error;
	}
	
}
