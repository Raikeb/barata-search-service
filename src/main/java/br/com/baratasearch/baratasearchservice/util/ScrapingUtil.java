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
			LOGGER.info("Informações de melhor Voo {}", title);//titulo da página
			
			obtemCompanhiaVoo(document);
			obtemDuracaoVoo(document);
			StatusVoo statusVoo =  obtemStatusVoo(document);
			obtemCarbonoVoo(document);
			obtemPrecoVoo(document);
			
			} catch (IOException e) {
			LOGGER.error("Erro ao tentar conectar com o Google Flights usando JSOUP -> {} ", e.getMessage()) ;
			e.printStackTrace();
		}
		
		return voo;
	}
	
	public String obtemCompanhiaVoo(Document document) {
		String companhia = null;
		
		boolean isCompanhia = document.select("div[class=sSHqwe tPgKwe ogfYpf]").isEmpty();
		if (!isCompanhia) {
			companhia = document.select("div[class=sSHqwe tPgKwe ogfYpf]").first().text();			
		}
		LOGGER.info("Companhia aérea: {}", companhia);
		
		return companhia;
		}
	
	public String obtemDuracaoVoo(Document document) {
		String duracao = null;
		
		boolean isDuracao = document.select("div[class=gvkrdb AdWm1c tPgKwe ogfYpf]").isEmpty();
		if (!isDuracao) {
			duracao = document.select("div[class=gvkrdb AdWm1c tPgKwe ogfYpf]").first().text();			
		}
		LOGGER.info("Duracao total: {}", duracao);
		
		return duracao;
		}
	
	public StatusVoo obtemStatusVoo(Document document) {
		//		SEM_VOO,
		//		SEM_ESCALAS,
		//		SEM_ESCALAS_ATRASADO,
		//		COM_ESCALAS,
		//		COM_ESCALAS_ATRASADO;
		
		StatusVoo statusVoo = StatusVoo.SEM_VOO;
		boolean averiguaStatus;
		
		boolean isStatusVoo = document.select("span[class=ogfYpf]").isEmpty();
		if (!isStatusVoo) {
			String pegaStatusVoo = document.select("span[class=ogfYpf]").first().text();
			
			if (averiguaStatus = pegaStatusVoo.contains("parada")) {
				statusVoo = StatusVoo.COM_ESCALAS;
			} else {
				statusVoo = StatusVoo.SEM_ESCALAS;
			}
			LOGGER.info("Status: {}", pegaStatusVoo);
			
			
		}
		return statusVoo;
	}
	
	
	public String obtemCarbonoVoo(Document document) {
		String carbono = null;
		
		boolean isCarbono = document.select("div[class=AdWm1c lc3qH ogfYpf  Jucbnc PtgtFe]").isEmpty();
		if (!isCarbono) {
			carbono = document.select("div[class=AdWm1c lc3qH ogfYpf  Jucbnc PtgtFe]").first().text();			
		}
		LOGGER.info("Emissão de carbono: {}", carbono);
		
		return carbono;
	}
	
	public String obtemPrecoVoo(Document document) {
		String preco = null;
		
		boolean isPreco = document.select("div[class=YMlIz FpEdX]").isEmpty();
		if (!isPreco) {
			preco = document.select("div[class=YMlIz FpEdX]").first().text();			
		}
		LOGGER.info("Preço: {}", preco);
		
		return preco;
	}
	
	
		

}
