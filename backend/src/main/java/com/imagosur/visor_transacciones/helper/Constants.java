package com.imagosur.visor_transacciones.helper;

import java.text.SimpleDateFormat;

public class Constants {
    private Constants() {}

    public static class DateFormat {
        private DateFormat() {}

        public static final SimpleDateFormat FECHA = new SimpleDateFormat(DateFormatValues.FECHA);
        public static final SimpleDateFormat HORA_MIN_SEC =
                new SimpleDateFormat(DateFormatValues.HORA_MIN_SEC);
        public static final SimpleDateFormat FECHA_CON_HORA_MIN_SEC =
                new SimpleDateFormat(DateFormatValues.FECHA_CON_HORA_MIN_SEC);
    }

    public static class DateFormatValues {
        private DateFormatValues() {}

        public static final String FECHA = "yyyy-MM-dd";
        public static final String HORA_MIN_SEC = "HH:mm:ss";
        public static final String FECHA_CON_HORA_MIN_SEC = "yyyy-MM-dd HH:mm:ss";
    }

}
