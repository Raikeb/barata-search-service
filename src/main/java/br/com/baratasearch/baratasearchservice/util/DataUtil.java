package br.com.baratasearch.baratasearchservice.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DataUtil {

	public static String formataDateEmString(Date data, String mask) {
		DateFormat formatter = new SimpleDateFormat(mask);
		return formatter.format(data);
	}
	
	public Date converteStringParaData(String dataEmTexto) throws ParseException {
	    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	    Date data = formato.parse(dataEmTexto);
	    return data;
	}

	public String converteDataHoraParaData(Date dataHora) {
	    SimpleDateFormat formatoSaida = new SimpleDateFormat("dd/MM/yyyy");
	    return formatoSaida.format(dataHora);
	}	
}