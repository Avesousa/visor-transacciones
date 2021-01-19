package com.imagosur.visor_transacciones.controller;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.imagosur.visor_transacciones.helper.MapUtil;
import com.imagosur.visor_transacciones.helper.UserHelper;
import com.imagosur.visor_transacciones.request.model.Consulta;
import com.imagosur.visor_transacciones.request.model.ConsultaFront;
import com.imagosur.visor_transacciones.response.model.Store;
import com.imagosur.visor_transacciones.response.model.Transaccion;
import com.imagosur.visor_transacciones.response.view.Detalles;
import com.imagosur.visor_transacciones.webservice.WebService;
import com.imagosur.visor_transacciones.webservice.WebServiceException;

import net.sf.jasperreports.engine.JRException;

@CrossOrigin()
@RestController
@RequestMapping("/")
public class Controller {

	@Autowired
	private WebService webService;
	
	public static final Logger logger = LoggerFactory.getLogger(Controller.class);
	
	private UserHelper userHelper;
	
	private String errorDesconocido = "Ha ocurrido un error desconocido";

	@Value("${security.service.portal.url}")
	private String urlPortal;

	@PostMapping("/test")
	public ResponseEntity<?> test() {
		logger.info("test() Ha generado una conexión a test correctamente");
		return ResponseEntity.ok("SUCCESS");
	}

	@GetMapping(path = "/form")
	public ModelAndView getView() {
		logger.info("getView() Ha generado la vista");
		return new ModelAndView("formQuery");
	}

	@PostMapping("/tipo_transacciones")
	public ResponseEntity<?> consultarTiposTransacciones() {
		logger.info("consultarTiposTransacciones() Ha comenzado a generar la consulta.");
		return ResponseEntity.ok("Ha realizado una búsqueda correctamente");
	}

	@PostMapping("/consultar")
	public ResponseEntity<?> consultar(@RequestBody ConsultaFront request) {
		Consulta consulta = MapUtil.mapearConsulta(request);
		logger.info("consultar() Ha comenzado a generar la consulta. Y ha generado el siguiente mapeo: " + consulta);
		try{
			ResponseEntity<Transaccion[]> respuesta = new ResponseEntity<>(webService.getTransacciones(consulta),getHeaders(), HttpStatus.OK);
			logger.info("consultar() Ha realizado la conexión correctamente, y ha generado un resultado");
			return respuesta;
		}catch(WebServiceException e) {
			return ResponseEntity.badRequest().body(manejarError(e.getMessage(),e.getNumeroDeError(),"consultar()",e.getMessage()));
		}catch(GeneralSecurityException e) {
			return ResponseEntity.badRequest().body(manejarError(this.errorDesconocido,513,"consultar()",e.getMessage()));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(manejarError(this.errorDesconocido,511,"consultar()",e.getMessage()));
		}
	}
	
	@PostMapping("/mediosPagos")
	public ResponseEntity<?> traerMediosDePago() {
		logger.info("traerMediosDePago() Ha comenzado a generar la consulta de los medios de pagos");
		try{
		    ResponseEntity<String> respuesta = new ResponseEntity<>(webService.getMediosPago(),getHeaders(), HttpStatus.OK);
			logger.info("traerMediosDePago() Ha realizado la conexión correctamente, y ha generado un resultado");
			return respuesta;
		}catch(WebServiceException e) {
			return ResponseEntity.badRequest().body(manejarError(e.getMessage(),e.getNumeroDeError(),"traerMediosDePago()",e.getMessage()));
		}catch(GeneralSecurityException e) {
			return ResponseEntity.badRequest().body(manejarError(this.errorDesconocido,513,"traerMediosDePago()",e.getMessage()));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(manejarError(this.errorDesconocido,511,"traerMediosDePago()",e.getMessage()));
		}
	}


	@GetMapping("/detallar")
	public ResponseEntity<?> detallar(@RequestParam BigInteger id_transaccion) {
		logger.info("detallar() Ha comenzado a generar la consulta con el siguiente id: " + id_transaccion);
		try{
			ResponseEntity<String> respuesta = new ResponseEntity<>(webService.getDetalles(id_transaccion),getHeaders(), HttpStatus.OK);
			logger.info("detallar() Ha realizado la conexión correctamente, y ha generado un resultado");
			return respuesta;
		}catch(WebServiceException e) {
			return ResponseEntity.badRequest().body(manejarError(e.getMessage(), e.getNumeroDeError(), "detallar()", e.getMessage()));
		}catch(GeneralSecurityException e) {
			return ResponseEntity.badRequest().body(manejarError(this.errorDesconocido,513,"consultar()",e.getMessage()));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(manejarError(this.errorDesconocido, 511, "detallar()", e.getMessage()));
		}
	}
	
	@PostMapping("/getPdf")
	public ResponseEntity<?> generarPdf(@RequestBody String all){
		logger.info("Ha comenzado a generar el pdf");
		Gson gDetalles = new Gson();
		Detalles detalles = gDetalles.fromJson(all, Detalles.class);
		try {
			logger.info("generarPdf() Ha comenzado a generar el pdf");
			ResponseEntity<String> respuesta = new ResponseEntity<>(webService.generarPdf(detalles),getHeaders(), HttpStatus.OK);
			logger.info("generarPdf() Ha generado correctamente el pdf");
			return respuesta;
		} catch (JRException e) {
			return ResponseEntity.badRequest().body(manejarError("Ha ocurrido un error con JRE", 500, "generarPdf()",e.getMessage()));
		} catch (FileNotFoundException e) {
			return ResponseEntity.badRequest().body(manejarError("Ha ocurrido un error con el archivo", 501, "generarPdf()", e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(manejarError(this.errorDesconocido, 502, "generarPdf()", e.getMessage()));
		}
	}
	
	@GetMapping("/getStore")
	public ResponseEntity<?> getStore(){
		logger.info("getStore() Ha comenzado a traer los datos de sucursales asociados");
		try {
			ResponseEntity<Store> response = new ResponseEntity<>(webService.getStore(),getHeaders(),HttpStatus.OK);
			logger.info("getStore() Se ha enviado la tienda correctamente");
			return response;
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(manejarError("No se ha encontrado la tienda del usuario", 409, "getStore()", e.getLocalizedMessage()));
		}
	} 
	
	private Map<String, Object> manejarError(String error, int num, String sector, String logueo) {
		logger.error(sector + " Ha ocurrido un error: ("+num+") " + logueo);
		Map<String, Object> ob = new HashMap<>();
		ob.put("error", num);
		ob.put("mensaje",error);
		Log.info("manejarError() El mapeo generado es: " + ob.toString());
		return ob;
	} 
	
	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Access-Control-Allow-Origin", this.urlPortal);
	    headers.add("X-XSS-Protection", "0");
	    headers.add("X-Imago", "true");
	    return headers;
	}

}
