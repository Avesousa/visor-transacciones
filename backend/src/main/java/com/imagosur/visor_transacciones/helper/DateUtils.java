package com.imagosur.visor_transacciones.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static Date date(String fechaStr, String format) {
        try {
            DateFormat df = new SimpleDateFormat(format);
            return df.parse(fechaStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Date date(String fechaStr, DateFormat format) {
        try {
            return format.parse(fechaStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Date fechaAlInicioDelDia(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    public static Date fechaAlFinalDelDia(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static class Format {
        public static final DateFormat COMPLETO_SIN_MILLIS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
