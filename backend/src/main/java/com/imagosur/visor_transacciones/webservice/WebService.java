package com.imagosur.visor_transacciones.webservice;

import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;

import com.imagosur.visor_transacciones.request.model.Consulta;
import com.imagosur.visor_transacciones.response.model.Store;
import com.imagosur.visor_transacciones.response.model.Transaccion;
import com.imagosur.visor_transacciones.response.view.*;

import java.util.List;
import net.sf.jasperreports.engine.JRException;

public interface WebService {
	Tipos getTipos() throws GeneralSecurityException;
	String getDetalles(BigInteger id) throws GeneralSecurityException;
	Transaccion[] getTransacciones(Consulta request) throws GeneralSecurityException;
	String getMediosPago() throws GeneralSecurityException;
	String generarPdf(Detalles detail) throws JRException, IOException;
	Store getStore();
}
