package br.com.empresaaleatoria.cadastrocia.util;

import static java.time.LocalDate.parse;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.Objects.nonNull;
import static lombok.AccessLevel.PRIVATE;

import java.time.LocalDate;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public class DataUtils {

	public static String formatarDataLocalDateToString(LocalDate data) {
		return nonNull(data) ? data.format(ofPattern("dd/MM/yyyy")) : null;
	}

	public static LocalDate formatarStringToLocalDate(String data) {
		return nonNull(data) ? parse(data, ofPattern("dd/MM/yyyy")) : null;
	}

}
