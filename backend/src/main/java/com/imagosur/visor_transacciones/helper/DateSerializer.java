package com.imagosur.visor_transacciones.helper;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public abstract class DateSerializer extends JsonSerializer<Date> {

	private DateFormat format;

	public DateSerializer(DateFormat format) {
		this.format = format;
	}

	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		String dateStr = format.format(value);
		gen.writeString(dateStr);
	}

	public static class Fecha extends DateSerializer {
		public Fecha() {
			super(Constants.DateFormat.FECHA);
		}
	}

	public static class HoraMinSec extends DateSerializer {
		public HoraMinSec() {
			super(Constants.DateFormat.HORA_MIN_SEC);
		}
	}

	public static class FechaConHoraMinSec extends DateSerializer {
		public FechaConHoraMinSec() {
			super(Constants.DateFormat.FECHA_CON_HORA_MIN_SEC);
		}
	}
}
