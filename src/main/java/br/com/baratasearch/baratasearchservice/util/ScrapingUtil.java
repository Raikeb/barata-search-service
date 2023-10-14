package br.com.baratasearch.baratasearchservice.util;

import java.io.IOException;
import java.net.URL;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
		String url = BASE_URL_GOOGLE_FLIGHT + "Flights%20to%20JFK%20from%20GRU%20on%202023-10-15" +COMPLEMENTO_URL_IDA+ COMPLEMENTO_URL_MOEDA_BRL + COMPLEMENTO_URL_IDIOMA;
		ScrapingUtil scraping = new ScrapingUtil();
		scraping.obtemInfoVoo(url);
	}
		
	public VoosGoogleDTO obtemInfoVoo(String url) {
		VoosGoogleDTO voo = new VoosGoogleDTO();
		
		Document document = null;
		
		try {
			document = Jsoup.connect(url).get();
			
			String title = document.title();
			LOGGER.info("Informações de melhores Voo {}", title);//titulo da página
			obtemLogoCompanhiaVoo(document);
			obtemCompanhiaVoo(document);
			obtemStatusVoo(document);
			obtemDuracaoVoo(document);
			obtemCarbonoVoo(document);
			obtemPrecoVoo(document);
			
			} catch (IOException e) {
			LOGGER.error("Erro ao tentar conectar com o Google Flights usando JSOUP -> {} ", e.getMessage()) ;
			e.printStackTrace();
		}
		
		return voo;
	}

	public List<String> obtemLogoCompanhiaVoo(Document document) {
        List<String> logos = new ArrayList<>();
        Elements elementos = document.select("div[class=EbY4Pc P2UJoe]");

        for (Element elemento : elementos) {
            String urlLogo = elemento.select("div[class=EbY4Pc P2UJoe]").attr("style");
            int indiceInicio = urlLogo.indexOf("https://");
            int indiceFim = urlLogo.indexOf(".png");
            if (indiceInicio != -1 && indiceFim != -1) {
                urlLogo = urlLogo.substring(indiceInicio, indiceFim + 4);
                logos.add(urlLogo);
            } else {
                logos.add(null);
            }
        }

        LOGGER.info("Logo da companhia aérea: {}", logos);
        return logos;
    }

	public List<String> obtemCompanhiaVoo(Document document) {
	    List<String> companhias = new ArrayList<>();

	    Elements elementos = document.select("div[class=sSHqwe tPgKwe ogfYpf]");
	    for (Element elemento : elementos) {
	        String companhia = "";
	        Elements spans = elemento.select("span");
	        for (Element span : spans) {
	            companhia += span.text() + " ";
	        }
	        companhia = companhia.trim();

	        // Verifica se uma palavra aparece três vezes na mesma string
	        String[] palavras = companhia.split(" ");
	        Map<String, Integer> contagemPalavras = new HashMap<>();
	        for (String palavra : palavras) {
	            contagemPalavras.put(palavra, contagemPalavras.getOrDefault(palavra, 0) + 1);
	        }

	        boolean temPalavraRepetida = contagemPalavras.values().stream().anyMatch(contagem -> contagem >= 3);
	        if (!temPalavraRepetida && !companhia.isEmpty()) {
	            companhias.add(companhia);
	        }
	    }

	    LOGGER.info("Companhia aérea: {}", companhias);
	    return companhias;
	}

    public List<String> obtemStatusVoo(Document document) {
        List<String> statusVoos = new ArrayList<>();
        List<String> escalas = new ArrayList<>();
        Elements elementos = document.select("div[class=BbR8Ec]");

        for (Element elemento : elementos) {
            String pegaStatusVoo = elemento.text().replace("parada", "parada de");
            int indiceMin = pegaStatusVoo.indexOf("min");

            if (indiceMin != -1) {
                String escala = pegaStatusVoo.substring(indiceMin + 3).trim();
                escalas.add(escala);

                if (pegaStatusVoo.contains("parada")) {
                    statusVoos.add("COM_ESCALAS");
                } else {
                    statusVoos.add("SEM_ESCALAS");
                }
            } else {
                escalas.add("Sem escalas");
                statusVoos.add("SEM_ESCALAS");
            }
        }

        LOGGER.info("Status: {}", statusVoos);
        LOGGER.info("Escala efetuada em: {}", escalas);
        
        return statusVoos;
    }

    public List<String> obtemDuracaoVoo(Document document) {
        List<String> duracoes = new ArrayList<>();
        List<String> aeroportosPartida = new ArrayList<>();
        List<String> aeroportosDestino = new ArrayList<>();

        Elements elementos = document.select("div[class=Ak5kof]");
        for (Element elemento : elementos) {
            String duracao = null;
            String aeroportoDePartida = null;
            String aeroportoDestino = null;

            String duracaoText = elemento.text();

            // Verifica se o texto contém a palavra "min" (indicando duração em minutos).
            int indiceMin = duracaoText.indexOf("min");
            
            if (indiceMin != -1) {
                // Obtém a duração em minutos.
                duracao = duracaoText.substring(0, indiceMin + 3).trim();
            } else {
                // Verifica se o texto contém a palavra "h" (indicando duração em horas).
                int indiceHoras = duracaoText.indexOf("h");

                if (indiceHoras != -1) {
                    // Obtém a duração em horas.
                    duracao = duracaoText.substring(0, indiceHoras + 1).trim();
                }
            }

            // Verifica se o texto contém um traço (indicando aeroportos de partida e destino).
            int indiceTraco = duracaoText.indexOf("–");

            if (indiceTraco != -1) {
                // Obtém os aeroportos de partida e destino com base no traço.
                aeroportoDePartida = duracaoText.substring(indiceMin + 3, indiceTraco).trim();
                aeroportoDestino = duracaoText.substring(indiceTraco + 1).trim();
            }

            duracoes.add(duracao);
            aeroportosPartida.add(aeroportoDePartida);
            aeroportosDestino.add(aeroportoDestino);
        }

        LOGGER.info("Duração total: {}", duracoes);
        LOGGER.info("Aeroporto de partida: {}", aeroportosPartida);
        LOGGER.info("Aeroporto de destino: {}", aeroportosDestino);

        return duracoes;
    }

    public List<String> obtemCarbonoVoo(Document document) {
        List<String> carbonos = new ArrayList<>();

        Elements elementos = document.select("div[class=y0NSEe V1iAHe tPgKwe ogfYpf]");
        for (Element elemento : elementos) {
            carbonos.add(elemento.text());
        }

        LOGGER.info("Emissão de carbono: {}", carbonos);
        return carbonos;
    }

    public List<String> obtemPrecoVoo(Document document) {
        List<String> precos = new ArrayList<>();

        Elements elementos = document.select("div[class=BVAVmf I11szd POX3ye]");
        for (Element elemento : elementos) {
            precos.add(elemento.text());
        }

        LOGGER.info("Preço: {}", precos);
        return precos;
    }
}
