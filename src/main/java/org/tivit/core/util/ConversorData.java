package org.tivit.core.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@UtilityClass
public class ConversorData {

    private static final String PATTERN_DD_MM_YYYY_HH_MM_SEPARADOR_BARRA = "dd/MM/yyyy HH:mm";

    public static LocalDateTime converterStringParaLocalDateTime(String dataHoraString) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_DD_MM_YYYY_HH_MM_SEPARADOR_BARRA);
        return LocalDateTime.parse(dataHoraString, formatter);
    }

    public static String converterLocalDateTimeParaString(LocalDateTime dataHora) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dataHora.format(formatter);
    }
}
