 package com.imagosur.visor_transacciones.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Documento {
	
	@Value("${pdf.documento.guardado}")
	private String guardar;
	
	@Value("${pdf.documento.main}")
	private String principal;
	
	@Value("${pdf.documento.pagos}")
	private String pagos;
	
	@Value("${pdf.documento.texto}")
	private String pieTexto;

	public String getGuardar() {
		return guardar;
	}

	public String getPrincipal() {
		return principal;
	}

	public String getPagos() {
		return pagos;
	}

	public String getPieTexto() {
		return pieTexto;
	}
	
	
	
	

}
