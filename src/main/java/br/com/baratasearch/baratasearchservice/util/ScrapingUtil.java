package br.com.baratasearch.baratasearchservice.util;

import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channel;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.modelmapper.spi.StrongTypeConditionalConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;

import br.com.baratasearch.baratasearchservice.dto.VoosGoogleDTO;
import br.com.baratasearch.baratasearchservice.model.Aeroportos;

public class ScrapingUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ScrapingUtil.class);
	//MONTAGEM DA URL
	private static final String BASE_URL_GOOGLE_FLIGHT ="https://www.google.com/travel/flights?q=";
	private static String URL_COMPLETA_GOOGLE_FLIGHT = "";
	private static final String COMPLEMENTO_URL_IDA = "%20oneway";
	private static final String COMPLEMENTO_URL_IDA_E_VOLTA = "%20roundtrip%20";
	
	private static final String COMPLEMENTO_URL_MOEDA_BRL = "&curr=BRL";
	private static final String COMPLEMENTO_URL_MOEDA_USD = "&curr=USD";
	private static final String COMPLEMENTO_URL_IDIOMA="&hl=pt-BR";
	
	//DIVS DA PÁGINA
	private static final String DIV_LOGO_COMPANHIAS = "div.EbY4Pc.P2UJoe";
	private static final String DIV_COMPANHIAS = "div.sSHqwe.tPgKwe.ogfYpf";
	private static final String DIV_ESCALAS = ".sSHqwe.tPgKwe.ogfYpf";
	private static final String DIV_STATUS_VOO = "div.BbR8Ec";
	private static final String DIV_DURACAO_VOO = "div.Ak5kof";
	private static final String DIV_CARBONO_VOO = "div.y0NSEe.V1iAHe.tPgKwe.ogfYpf";
	private static final String DIV_PRECO_VOO = "div.BVAVmf.I11szd.POX3ye";
	
	public static void main(String[] args) throws InterruptedException {  
		//String url = BASE_URL_GOOGLE_FLIGHT + "Flights%20to%20JFK%20from%20SSA%20on%202023-10-19" +COMPLEMENTO_URL_IDA_E_VOLTA+"2023-11-24"+ COMPLEMENTO_URL_MOEDA_BRL + COMPLEMENTO_URL_IDIOMA;
		String saida = "SSA";
		String chegada = "JFK";
		
		String dataIda = "19/10/2023";
		String dataVolta= "24/11/2023";
		
		//String url =  agrupaUrlSomenteIda(saida, chegada, dataIda);
		String url = agrupaUrlIdaEVolta(saida,chegada,dataIda,dataVolta);
		ScrapingUtil scraping = new ScrapingUtil();
		scraping.obtemInfoVoo(url);
	}
	
			
	public VoosGoogleDTO obtemInfoVoo(String url) {
	    VoosGoogleDTO voo = new VoosGoogleDTO();
	           
	    try (Playwright playwright = Playwright.create()) {
	        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge"));
	        Page page = browser.newPage();
	        page.navigate(url);
	        page.waitForLoadState(LoadState.NETWORKIDLE);
	       

	        String title = page.title();
	        LOGGER.info("Informações de melhores Voo {}", title);//titulo da página
	        
	        obtemLogoCompanhiaVoo(page);
	        obtemCompanhiaVoo(page);
	        obtemStatusVoo(page);
	        obtemStatusEscalasVoo(page);
//	        obtemDuracaoVoo(page);
//	        obtemCarbonoVoo(page);
//	        obtemPrecoVoo(page);

	    } catch (Exception e) {
	        LOGGER.error("Erro ao tentar conectar com o Google Flights usando Playwright -> {} ", e.getMessage());
	        e.printStackTrace();
	    }
	   
	    return voo;
	}

	public List<String> obtemLogoCompanhiaVoo(Page page) {
	    List<String> logos = new ArrayList<>();
	    List<ElementHandle> elementos = page.querySelectorAll(DIV_LOGO_COMPANHIAS);
	    String lastLogo = null;
	    int count = 0;

	    for (ElementHandle elemento : elementos) {
	        String urlLogo = elemento.getAttribute("style");
	        Pattern pattern = Pattern.compile("default: url\\((https://.*?\\.png)\\)");
	        Matcher matcher = pattern.matcher(urlLogo);
	        if (matcher.find()) {
	            String logoUrl = matcher.group(1);
	            if (logoUrl.equals(lastLogo)) {
	                count++;
	                if (count == 5) {
	                    logos.add(logoUrl);
	                    count = 0;
	                }
	            } else {
	                count = 1;
	                lastLogo = logoUrl;
	            }
	        }
	    }

	    LOGGER.info("Logo da companhia aérea: {}", logos);
	    return logos;
	}


	public List<String> obtemCompanhiaVoo(Page page) {
	    List<String> companhias = new ArrayList<>();

	    List<ElementHandle> elementos = page.querySelectorAll(DIV_COMPANHIAS);
	    for (ElementHandle elemento : elementos) {
	        String companhia = "";
	        List<ElementHandle> spans = elemento.querySelectorAll("span");
	        for (ElementHandle span : spans) {
	            companhia += span.textContent() + " ";
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

	public List<String> obtemStatusEscalasVoo(Page page) {
	    List<String> statusEscalasVoo = new ArrayList<>();
	    List<ElementHandle> elementos = page.querySelectorAll(DIV_ESCALAS);

	    for (ElementHandle elemento : elementos) {
	        String ariaLabel = elemento.getAttribute("aria-label");
	        
	        // Adiciona um espaço entre caracteres de caixa baixa e caixa alta
	        ariaLabel = ariaLabel.replaceAll("(\\p{Ll})(\\p{Lu})", "$1 $2");
	        statusEscalasVoo.add(ariaLabel);
	    }

	    // Remover elementos vazios ou que contêm apenas espaços em branco
	    statusEscalasVoo.removeIf(String::isBlank);

	    // Obter o status do voo
	    List<String> statusVoos = obtemStatusVoo(page);
	    
	    LOGGER.info("Status: {}", statusVoos);
	    
	    // Unir as informações de statusEscalasVoo e statusVoos
	    List<String> statusFinal = new ArrayList<>();
	    Iterator<String> iteratorStatusEscalasVoo = statusEscalasVoo.iterator();

	    for (String statusVoo : statusVoos) {
	        if (statusVoo.equals("COM_ESCALAS") && iteratorStatusEscalasVoo.hasNext()) {
	            statusFinal.add(iteratorStatusEscalasVoo.next());
	        } else if (!statusVoo.equals("COM_ESCALAS")) {
	            statusFinal.add(statusVoo);
	        }
	    }

	    LOGGER.info("Escalas: {}", statusFinal);

	    return statusFinal;
	}

	public List<String> obtemStatusVoo(Page page) {
	    List<String> statusVoos = new ArrayList<>();
	    List<ElementHandle> elementos = page.querySelectorAll(DIV_STATUS_VOO);

	    for (ElementHandle elemento : elementos) {
	        String pegaStatusVoo = elemento.textContent();

	        if (pegaStatusVoo.contains("parada")) {
	            statusVoos.add("COM_ESCALAS");
	        } else {
	            statusVoos.add("SEM_ESCALAS");
	        }

	        if (statusVoos.isEmpty()) {
	            statusVoos.add("SEM_ESCALAS");
	        }
	    }
	  
	    return statusVoos;
	}




    public List<String> obtemDuracaoVoo(Document document) {
        List<String> duracoes = new ArrayList<>();
        List<String> aeroportosPartida = new ArrayList<>();
        List<String> aeroportosDestino = new ArrayList<>();

        Elements elementos = document.select(DIV_DURACAO_VOO);
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

        Elements elementos = document.select(DIV_CARBONO_VOO);
        for (Element elemento : elementos) {
            carbonos.add(elemento.text());
        }

        LOGGER.info("Emissão de carbono: {}", carbonos);
        return carbonos;
    }

    public List<String> obtemPrecoVoo(Document document) {
        List<String> precos = new ArrayList<>();

        Elements elementos = document.select(DIV_PRECO_VOO);
        for (Element elemento : elementos) {
            precos.add(elemento.text());
        }

        LOGGER.info("Preço: {}", precos);
        return precos;
    }
    
    public static String agrupaUrlSomenteIda(String defSaida, String defChegada,  String defData) {	
    	
    	String saida;
    	String chegada;
    	String data;
    	Aeroportos aeroportos = new Aeroportos();
    	
    	
    	try {   		
    		saida = aeroportos.getSiglaAeroporto(defSaida);
    		chegada = aeroportos.getSiglaAeroporto(defChegada);
			data = converteData(defData);
			URL_COMPLETA_GOOGLE_FLIGHT =
					BASE_URL_GOOGLE_FLIGHT + "Flights%20to%20" +
					chegada + "%20from%20" + saida + "%20on%20" + data +
					COMPLEMENTO_URL_IDA+ COMPLEMENTO_URL_MOEDA_BRL + COMPLEMENTO_URL_IDIOMA;
			
		} catch (Exception e) {
			LOGGER.error("Erro ao agrupar URL de somente ida: ", e.getMessage());
		}
    	
    	return URL_COMPLETA_GOOGLE_FLIGHT;
    }
    
    public static String agrupaUrlIdaEVolta(String defSaida, String defChegada,  String defDataIda, String defDataVolta) {	
    	
    	String saida;
    	String chegada;
    	String dataIda;
    	String dataVolta;
    	Aeroportos aeroportos = new Aeroportos();
    	
    	try {   		
    		saida = aeroportos.getSiglaAeroporto(defSaida);
    		chegada = aeroportos.getSiglaAeroporto(defChegada);
			dataIda = converteData(defDataIda);
			dataVolta = converteData(defDataVolta);
			URL_COMPLETA_GOOGLE_FLIGHT =
					BASE_URL_GOOGLE_FLIGHT + "Flights%20to%20" +
					chegada + "%20from%20" + saida + "%20on%20" + dataIda +
					COMPLEMENTO_URL_IDA_E_VOLTA + dataVolta +
					COMPLEMENTO_URL_MOEDA_BRL + COMPLEMENTO_URL_IDIOMA;
			
		} catch (Exception e) {
			LOGGER.error("Erro ao agrupar URL de somente ida: ", e.getMessage());
		}
    	
    	return URL_COMPLETA_GOOGLE_FLIGHT;
    }
    
    public static String removeDuploEspaco(String original) {
        return original.replaceAll("%20%20", "%20");
    }
    
    public static String converteData(String dataOriginal) throws Exception {
        SimpleDateFormat formatoOriginal = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoDesejado = new SimpleDateFormat("yyyy-MM-dd");

        // Verifica se a data já está no formato desejado
        if (dataOriginal.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return dataOriginal;
        }

        // Tenta converter a data para o formato original
        Date data;
        try {
            data = formatoOriginal.parse(dataOriginal);
        } catch (ParseException e) {
            throw new Exception("Erro: A data não está no formato dd/MM/yyyy");
        }

        // Retorna a data no formato desejado
        return formatoDesejado.format(data);
    }
    
    
}
