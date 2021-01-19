package com.imagosur.visor_transacciones.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;


@Component
public class WebServiceErrorHandler implements ResponseErrorHandler{
	
	final static Logger log = LoggerFactory.getLogger(WebServiceErrorHandler.class);
	
	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		return response.getRawStatusCode() != 200;
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		log.error("Ha comenzado a generar la excepción por error");
		StringBuilder inputStringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getBody(), "UTF-8"));
        String line = bufferedReader.readLine();
        while (line != null) {
            inputStringBuilder.append(line);
            inputStringBuilder.append('\n');
            line = bufferedReader.readLine();
        }
        log.error("El error" + inputStringBuilder.toString());
        JSONObject resultado = new JSONObject(inputStringBuilder.toString());
		throw new WebServiceException(resultado.getString("message"),resultado.getInt("error"));
	}
}