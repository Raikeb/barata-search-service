package br.com.baratasearch.baratasearchservice.util;

import java.io.IOException;
import java.net.URL;
import java.security.PublicKey;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.modelmapper.spi.StrongTypeConditionalConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.baratasearch.baratasearchservice.dto.VoosGoogleDTO;

public class ScrapingUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ScrapingUtil.class);
	
	private static final String BASE_URL_GOOGLE_FLIGHT ="https://www.google.com/travel/flights?q=";
	private static final String COMPLEMENTO_URL_IDA = "%20oneway";
	private static final String COMPLEMENTO_URL_IDA_E_VOLTA = "%20roundtrip%20";
	
	private static final String COMPLEMENTO_URL_MOEDA_BRL = "&curr=BRL";
	private static final String COMPLEMENTO_URL_MOEDA_USD = "&curr=USD";
	private static final String COMPLEMENTO_URL_IDIOMA="&hl=pt-BR";
	
	
	public static void main(String[] args) {
		String url = BASE_URL_GOOGLE_FLIGHT + "Flights%20to%20CGH%20from%20GIG%20on%202023-10-15" +COMPLEMENTO_URL_IDA+ COMPLEMENTO_URL_MOEDA_BRL + COMPLEMENTO_URL_IDIOMA;
		ScrapingUtil scraping = new ScrapingUtil();
		scraping.obtemInfoVoo(url);
	}
		
	public VoosGoogleDTO obtemInfoVoo(String url) {
		VoosGoogleDTO voo = new VoosGoogleDTO();
		
		Document document = null;
		
		try {
			document = Jsoup.connect(url).get();
			
			String title = document.title();
			LOGGER.info("Titulo da página: {}", title);
			
		} catch (IOException e) {
			LOGGER.error("Erro ao tentar conectar com o Google Flights usando JSOUP -> {} ", e.getMessage()) ;
			e.printStackTrace();
		}
		
		return voo;
	}

}
