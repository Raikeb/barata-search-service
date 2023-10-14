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
		String url = BASE_URL_GOOGLE_FLIGHT + "Flights%20to%20GIG%20from%20GRU%20on%202023-10-15" +COMPLEMENTO_URL_IDA+ COMPLEMENTO_URL_MOEDA_BRL + COMPLEMENTO_URL_IDIOMA;
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
			StatusVoo statusVoo =  obtemStatusVoo(document);
			obtemDuracaoVoo(document);
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

	public String obtemEscala(String pegaStatusVoo) {
	    int indiceMin = pegaStatusVoo.indexOf("min");
	    String escala = null;
	    if (indiceMin != -1) {
	        escala = pegaStatusVoo.substring(indiceMin + 3).trim();
	    }
	    return escala;
	}

	public StatusVoo obtemStatusVoo(Document document) {
	    // SEM_VOO,
	    // SEM_ESCALAS,
	    // SEM_ESCALAS_ATRASADO,
	    // COM_ESCALAS,
	    // COM_ESCALAS_ATRASADO;

	    StatusVoo statusVoo = StatusVoo.SEM_VOO;
	    boolean averiguaStatus;
	    String escala = null;
	    
	    boolean isStatusVoo = document.select("div[class=BbR8Ec]").isEmpty();
	    if (!isStatusVoo) {
	        String pegaStatusVoo = document.select("div[class=BbR8Ec]").first().text();

	        pegaStatusVoo = pegaStatusVoo.replace("parada", "parada de");

	        String pegaStatusVooCopia = new String(pegaStatusVoo);

	        int indiceMin = pegaStatusVoo.indexOf("min");
	        if (indiceMin != -1) {
	            pegaStatusVoo = pegaStatusVoo.substring(0, indiceMin + 3);
	        }

	        if (averiguaStatus = pegaStatusVoo.contains("parada")) {
	            statusVoo = StatusVoo.COM_ESCALAS;
	            escala = obtemEscala(pegaStatusVooCopia);
	            
	        } else {
	            statusVoo = StatusVoo.SEM_ESCALAS;
	        }
	        LOGGER.info("Status: {}", pegaStatusVoo);
	        if(escala != null) {
	        LOGGER.info("Escala efetuada em: {}", escala);
	    
	        }
		}
	    return statusVoo;
	}
	
	public String obtemDuracaoVoo(Document document) {
	    String duracao = null;
	    String aeroportoDePartida = null;
	    String aeroportoDestino = null;
	    
	    boolean isDuracao = document.select("div[class=Ak5kof]").isEmpty();
	    if (!isDuracao) {
	        duracao = document.select("div[class=Ak5kof]").first().text();
	        
	        int indiceMin = duracao.indexOf("min");
	        int indiceTraco = duracao.indexOf("–");
	        
	        if (indiceMin != -1 && indiceTraco != -1) {
	            aeroportoDePartida = duracao.substring(indiceMin + 3, indiceTraco).trim();
	            aeroportoDestino = duracao.substring(indiceTraco + 1).trim();
	        }
	        
	        if (indiceMin != -1) {
	        	duracao = duracao.substring(0, indiceMin + 3);
	        }           
	    }
	    
	    LOGGER.info("Duracao total: {}", duracao);
	    LOGGER.info("Aeroporto de partida: {}", aeroportoDePartida);
	    LOGGER.info("Aeroporto de destino: {}", aeroportoDestino);
	    
	    return duracao;
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
