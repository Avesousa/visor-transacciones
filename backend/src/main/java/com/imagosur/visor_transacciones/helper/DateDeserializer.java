package com.imagosur.visor_transacciones.helper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public abstract class DateDeserializer extends JsonDeserializer<Date> {
	private DateFormat format;

	public DateDeserializer(DateFormat format) {
		this.format = format;
	}

	@Override
	public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		String dateStr = p.getText();
		try {
			return format.parse(dateStr);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public static class Fecha extends DateDeserializer {
		public Fecha() {
			super(Constants.DateFormat.FECHA);
		}
	}

	public static class HoraMinSec extends DateDeserializer {
		public HoraMinSec() {
			super(Constants.DateFormat.HORA_MIN_SEC);
		}
	}

	public static class FechaConHoraMinSec extends DateDeserializer {
		public FechaConHoraMinSec() {
			super(Constants.DateFormat.FECHA_CON_HORA_MIN_SEC);
		}
	}
}
