package com.imagosur.visor_transacciones.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imagosur.visor_transacciones.response.model.Detalle;
import com.imagosur.visor_transacciones.response.model.Pago;
import com.imagosur.visor_transacciones.response.model.Transaccion;
import com.imagosur.visor_transacciones.response.view.Detalles;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class Report {
	public static final Logger logger = LoggerFactory.getLogger(Report.class);

	private Transaccion cabecera;
	private Detalle[] detalles;
	private Pago[] pagos;
	private String ubicacion;
	
	private String losPagos;
	private String mensaje;
	
	public Report(Detalles detail, String guardar) {
		this.cabecera = detail.getCabeceras()[0];
		this.detalles = detail.getDetalles();
		this.pagos = detail.getPagos();
		System.out.println("Guardar: " + guardar);
		this.ubicacion = guardar + this.cabecera.getId() + ".pdf";
	}

	public String crear(String prin, String pago, String mensa) throws JRException, IOException{
		logger.info("Comienza a crear documento de PDF");
		logger.info("La ubicación : " + this.ubicacion);
		this.losPagos = pago;
		logger.info("Información final: " + mensa);
		this.mensaje = mensa;
		JRBeanCollectionDataSource source_main = new JRBeanCollectionDataSource(this.crearCampos());
		System.out.println("El mensaje principal es: " + prin);
		final InputStream is_main = this.getClass().getResourceAsStream("/report/report_main.jrxml");
		JasperReport report_main = JasperCompileManager.compileReport(is_main);
		logger.info("Ha realizado la compilación de archivo");
		JasperPrint print = JasperFillManager.fillReport(report_main,this.crearParametros(),source_main);
		logger.info("Ha enviado el print_payment al print_main y ha ejecutado todo el proceso");
		JasperExportManager.exportReportToPdfFile(print,ubicacion);
		return codear(new File(ubicacion));
	}
	
	private List<Map<String,Object>> crearCampos(){
		List<Map<String,Object>> campos = new ArrayList<Map<String,Object>>();
		for(Detalle detalle : this.detalles) {
			Map<String,Object> campo = new HashMap<String,Object>();
			campo.put("tipo",detalle.getDescripcionTipoTransaccion());
			campo.put("ean",detalle.getCodigoEAN());
			campo.put("descripcion",detalle.getDescripcionEAN());
			campo.put("cantidad",String.valueOf(this.getMonto(detalle.getCantidad())));
			campo.put("subtotal",String.valueOf(this.getMonto(detalle.getMonto())));
			campos.add(campo);
		}
		logger.info("Ha generado los siguientes campos: " + campos.size());
		return campos;
	}
	
	private List<Map<String,Object>> crearCamposPago(){
		List<Map<String,Object>> campos = new ArrayList<Map<String,Object>>();
		for(Pago pago : this.pagos) {
			Map<String,Object> res = new HashMap<String,Object>();
			res.put("tipoPago_payment", pago.getTender_Description());
			res.put("medioPago_payment", pago.getSubTender_Description());
			res.put("importe_payment", this.getMonto(pago.getF_TenderAmount()));
			campos.add(res);
		}
		return campos;
	}
	
	private Map<String,Object> crearParametros() throws FileNotFoundException, JRException{
		Map<String,Object> campos = new HashMap<String,Object>();
		final InputStream is_payment = this.getClass().getResourceAsStream("/report/report_payment.jrxml");
		logger.info("Ha comenzado a generar los parametros, y ya compilo información");
		JasperReport payment = JasperCompileManager.compileReport(is_payment);
		campos.put("fecha", getFecha(this.cabecera.getFecha()));
		campos.put("tienda",this.cabecera.getDescripcionTienda());
		campos.put("transaccion",String.valueOf(cabecera.getCodigoTransaccion()));
		campos.put("caja",String.valueOf(cabecera.getCodigoCaja()));
		campos.put("total",this.getMonto(cabecera.getTotal()));
		campos.put("mensaje",this.mensaje);
		campos.put("payment",payment);
		campos.put("conexionPayment",new JRBeanCollectionDataSource(this.crearCamposPago()));
		logger.info("Ha realizado la subida de todos los parámetros");
		return campos;
	}
	
	
	
	private String codear(File archivo) throws IOException {
		byte[] contenido = Files.readAllBytes(archivo.toPath());
		return Base64.getEncoder().encodeToString(contenido);
	}
	
	private String getFecha(String actual) {
		return actual.length() == 10 ? 
				actual.charAt(8) + "" +actual.charAt(9) + "/" +
				actual.charAt(5) + actual.charAt(6) + "/" +
				actual.charAt(0) + actual.charAt(1) + actual.charAt(2) + actual.charAt(3) : "Error";
	}
	
	private String getMonto(Double actual) {
		String[] valor = String.valueOf(actual).split("\\.");
		String entero = getMil(valor[0]);
		String decimal = getDecimal(valor);
		return entero + "," + decimal;
	}
	
	private String getDecimal(String[] valor) {
		return valor.length > 1 ? ( valor[1].length() > 1 ? valor[1] : (valor[1] + "0") ) : "00";
	}
	
	private String getMil(String monto) {
		String respuesta = "";
		Object[] valor = reversa(monto.split(""));
		for(int i = 0; i < valor.length; i++) {
			respuesta = i > 0 ? valorizar(i, letrear(valor[i])) + respuesta : valor[i] + respuesta;
		}
		return respuesta;
	}
	
	private String valorizar(int i, String valor) {
		return terciar(i) ? valor : ( valor + ".");
	}
	
	private String letrear(Object valor) {
		return String.valueOf(valor);
	}
	
	private boolean terciar(int num) {
		String[] valor = String.valueOf((((double)num)/3)).split("\\.");
		return Integer.parseInt(String.valueOf(valor[1].charAt(0))) > 0;
	}
	
	private Object[] reversa(String[] valor) {
		return IntStream.rangeClosed(1, valor.length)
				.mapToObj(i -> valor[valor.length- i])
				.toArray();
	}
}
