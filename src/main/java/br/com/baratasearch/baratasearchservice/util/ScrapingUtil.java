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
import java.util.stream.Collectors;
import java.text.ParseException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.modelmapper.spi.StrongTypeConditionalConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;

import br.com.baratasearch.baratasearchservice.dto.VooGoogleDTO;
import br.com.baratasearch.baratasearchservice.model.Aeroportos;

@Service	
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
	private static final String DIV_HORARIOS = "div.zxVSec.YMlIz.tPgKwe.ogfYpf";
	private static final String DIV_ESCALAS = "div.sSHqwe.tPgKwe.ogfYpf";
	private static final String DIV_STATUS_VOO = "div.EfT7Ae.AdWm1c.tPgKwe";
	private static final String DIV_DURACAO_VOO = "div.Ak5kof";
	private static final String DIV_CARBONO_VOO = "div.y0NSEe.V1iAHe.tPgKwe.ogfYpf";
	private static final String DIV_PRECO_VOO = "div.U3gSDe";
	
//	public static void main(String[] args) throws InterruptedException {  
//		//String url = BASE_URL_GOOGLE_FLIGHT + "Flights%20to%20JFK%20from%20SSA%20on%202023-10-19" +COMPLEMENTO_URL_IDA_E_VOLTA+"2023-11-24"+ COMPLEMENTO_URL_MOEDA_BRL + COMPLEMENTO_URL_IDIOMA;
//		String saida = "GIG";
//		String chegada = "HEL";
//		
//		String dataIda = "20/10/2023";
//		String dataVolta= "05/11/2023";
//		
//		String url =  agrupaUrl(saida, chegada, dataIda, dataVolta);
//		//String url = agrupaUrlIdaEVolta(saida,chegada,dataIda,dataVolta);
//		ScrapingUtil scraping = new ScrapingUtil();
//		scraping.obtemInfoVoo(url);
//	}
	
			
	public List<VooGoogleDTO> obtemInfoVoo(String url) {
	    List<VooGoogleDTO> voos = new ArrayList<>();

	    try (Playwright playwright = Playwright.create()) {
	        Browser browser = playwright.firefox().launch();
	        Page page = browser.newPage();
	        page.navigate(url);
	        page.waitForLoadState(LoadState.NETWORKIDLE);
	        
	        String title = page.title();
	        LOGGER.info("Informações de melhores Voo {}", title);//titulo da página
	        List<String> logos = obtemLogoCompanhiaVoo(page);
	        List<String> companhias = obtemCompanhiaVoo(page);
	        List<String> status = obtemStatusVoo(page);
	        List<String> escalas = obtemStatusEscalasVoo(page);
	        List<String> horariosPartida = obtemHorariosPartida(page);
	        List<String> horariosChegada = obtemHorariosChegada(page);
	        List<String> duracoes = obtemDuracaoVoo(page);
	        List<String> carbonos = obtemCarbonoVoo(page);
	        List<String> precos = obtemPrecoVoo(page);

	        Map<String, Integer> mapQuantidades = new HashMap<>();
	        mapQuantidades.put("logos", logos.size());
	        mapQuantidades.put("companhias", companhias.size());
	        mapQuantidades.put("status", status.size());
	        mapQuantidades.put("escalas", escalas.size());
	        mapQuantidades.put("horariosPartida", horariosPartida.size());
	        mapQuantidades.put("horariosChegada", horariosChegada.size());
	        mapQuantidades.put("duracoes", duracoes.size());
	        mapQuantidades.put("carbonos", carbonos.size());
	        mapQuantidades.put("precos", precos.size());

	        int quantidadeReferencia = logos.size();
	        boolean todasIguais = mapQuantidades.values().stream().allMatch(quantidade -> quantidade == quantidadeReferencia);

	        if (todasIguais) {
	            LOGGER.info("Quantidade igual de elementos nas listas, foram {} voos.", quantidadeReferencia);

	            for (int i = 0; i < quantidadeReferencia; i++) {
	                VooGoogleDTO voo = new VooGoogleDTO();
	                voo.setLogoCompanhia(logos.get(i));
	                voo.setCompanhia(companhias.get(i));
	                voo.setStatus(status.get(i));
	                voo.setEscalas(escalas.get(i));
	                voo.setPrevisaoPartida(horariosPartida.get(i));
	                voo.setPrevisaoChegada(horariosChegada.get(i));
	                voo.setDuracao(duracoes.get(i));
	                voo.setCarbono(carbonos.get(i));
	                voo.setPreco(precos.get(i));

	                voos.add(voo);
	            }
	        } else {
	            String listasDivergentes = mapQuantidades.entrySet().stream()
	                    .filter(entry -> entry.getValue() != quantidadeReferencia)
	                    .map(Map.Entry::getKey)
	                    .collect(Collectors.joining(", "));
	            LOGGER.info("A quantidade não foi igual! As listas de {} foram diferentes das demais em quantidade.", listasDivergentes);
	        }
	    return voos;
	    
	    } catch (Exception e) {
	        LOGGER.error("Erro ao tentar conectar com o Google Flights usando Playwright -> {} ", e.getMessage());
	        e.printStackTrace();
	    }

	    return null;
	}


	public List<String> obtemHorarios(Page page, String tipo) {
	    List<String> horarios = new ArrayList<>();
	    // Seleciona a div com a classe especificada
	    List<ElementHandle> divs = page.querySelectorAll(DIV_HORARIOS);
	    
	    for (ElementHandle div : divs) {
	        // Seleciona as spans com o atributo jscontroller="cNtv4b" dentro da div
	        List<ElementHandle> elementos = div.querySelectorAll("span[jscontroller='cNtv4b']");
	        
	        for (ElementHandle elemento : elementos) {
	            String ariaLabel = elemento.getAttribute("aria-label");
	            if (ariaLabel != null && ariaLabel.toLowerCase().contains(tipo)) {
	                // Adiciona um espaço entre caracteres de caixa baixa e caixa alta
	                ariaLabel = ariaLabel.replaceAll("(\\p{Ll})(\\p{Lu})", "$1 $2");
	                horarios.add(ariaLabel);
	            }
	        }
	    }

	    // Remover elementos vazios ou que contêm apenas espaços em branco
	    horarios.removeIf(String::isBlank);

	    LOGGER.info("Horarios de {}: {}", tipo, horarios);

	    return horarios;
	}

	public List<String> obtemHorariosPartida(Page page) {
	    return obtemHorarios(page, "partida");
	}

	public List<String> obtemHorariosChegada(Page page) {
	    return obtemHorarios(page, "chegada");
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

	    // Selecione os elementos
	    List<ElementHandle> elementos = page.querySelectorAll(DIV_COMPANHIAS);
	    for (ElementHandle elemento : elementos) {
	        String companhia = "";
	        // Selecione os spans dentro do elemento
	        List<ElementHandle> spans = elemento.querySelectorAll("span");
	        for (int i = 0; i < spans.size(); i++) {
	            ElementHandle span = spans.get(i);
	            String spanClass = span.getAttribute("class");
	            if (spanClass != null && spanClass.equals("qeoz6e U325Rc")) {
	                i++; // Ignora o próximo span
	                continue;
	            }
	            companhia += span.innerText() + " ";
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

	        // Verifica o atributo aria-label
	        ElementHandle ariaLabelElement = elemento.querySelector("[aria-label*='Passagens separadas']");
	        if (ariaLabelElement != null) {
	            String ariaLabel = ariaLabelElement.getAttribute("aria-label");
	            int index = ariaLabel.indexOf(".");
	            if (index != -1) {
	                companhias.add(ariaLabel.substring(0, index));
	            }
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
	        if (ariaLabel != null) {
	            // Adiciona um espaço entre caracteres de caixa baixa e caixa alta
	            ariaLabel = ariaLabel.replaceAll("(\\p{Ll})(\\p{Lu})", "$1 $2");
	            statusEscalasVoo.add(ariaLabel);
	        }
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

	        if ((pegaStatusVoo.contains("parada"))||(pegaStatusVoo.contains("paradas"))) {
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




	public static List<String> obtemDuracaoVoo(Page page) {
	    List<String> duracoes = new ArrayList<>();
	    List<String> aeroportosPartida = new ArrayList<>();
	    List<String> aeroportosDestino = new ArrayList<>();

	    // Substitua 'seletor' pelo seletor CSS apropriado.
	    List<ElementHandle> elementos = page.querySelectorAll(DIV_DURACAO_VOO);

	    for (ElementHandle elemento : elementos) {
	        String duracao = null;
	        String aeroportoDePartida = null;
	        String aeroportoDestino = null;

	        String duracaoText = elemento.innerText();
	        
	        // Verifica se o texto contém a palavra "min" (indicando duração em minutos).
	        int indiceMin = duracaoText.indexOf("min");

	        if (indiceMin != -1) {
	            // Obtém a duração em minutos.
	            duracao = duracaoText.substring(0, indiceMin + 3).trim();
	            duracaoText = duracaoText.substring(indiceMin + 3).trim(); // Atualiza o texto removendo a duração.
	        } else {
	            // Verifica se o texto contém a palavra "h" (indicando duração em horas).
	            int indiceHoras = duracaoText.indexOf("h");

	            if (indiceHoras != -1) {
	                // Obtém a duração em horas.
	                duracao = duracaoText.substring(0, indiceHoras + 1).trim();
	                duracaoText = duracaoText.substring(indiceHoras + 1).trim(); // Atualiza o texto removendo a duração.
	            }
	        }

	        // Verifica se o texto contém um traço (indicando aeroportos de partida e destino).
	        int indiceTraco = duracaoText.indexOf("–");

	        if (indiceTraco != -1) {
	            // Obtém os aeroportos de partida e destino com base no traço.
	            aeroportoDePartida = duracaoText.substring(0, indiceTraco).trim();
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

	public List<String> obtemCarbonoVoo(Page page) {
	    List<String> carbonos = new ArrayList<>();

	    // Substitua 'seletor' pelo seletor CSS apropriado.
	    List<ElementHandle> elementos = page.querySelectorAll(DIV_CARBONO_VOO);

	    for (ElementHandle elemento : elementos) {
	        String texto = elemento.innerText();
	        texto = texto.replace("\n", " "); // Remove as quebras de linha.
	        carbonos.add(texto);
	    }

	    LOGGER.info("Emissão de carbono: {}", carbonos);
	    return carbonos;
	}

	public List<String> obtemPrecoVoo(Page page) {
	    List<String> precos = new ArrayList<>();

	    // Substitua 'seletor' pelo seletor CSS apropriado.
	    List<ElementHandle> elementos = page.querySelectorAll(DIV_PRECO_VOO);

	    for (ElementHandle elemento : elementos) {
	        String texto = elemento.innerText();
	        String preco = texto.split("\n")[0]; 
	        precos.add(preco);
	    }

	    LOGGER.info("Preço: {}", precos);
	    return precos;
	}
    
	public static String agrupaUrl(String defSaida, String defChegada, String defDataIda, String defDataVolta) {	
    	
    	String saida;
    	String chegada;
    	String dataIda;
    	String dataVolta = null;
    	Aeroportos aeroportos = new Aeroportos();
    	
    	try {   		
    		saida = aeroportos.getSiglaAeroporto(defSaida);
    		chegada = aeroportos.getSiglaAeroporto(defChegada);
			dataIda = converteData(defDataIda);
			if (defDataVolta != null) {
				dataVolta = converteData(defDataVolta);
			}
			URL_COMPLETA_GOOGLE_FLIGHT =
					BASE_URL_GOOGLE_FLIGHT + "Flights%20to%20" +
					chegada + "%20from%20" + saida + "%20on%20" + dataIda;
			if (dataVolta != null) {
				URL_COMPLETA_GOOGLE_FLIGHT += COMPLEMENTO_URL_IDA_E_VOLTA + dataVolta;
			} else {
				URL_COMPLETA_GOOGLE_FLIGHT += COMPLEMENTO_URL_IDA;
			}
			URL_COMPLETA_GOOGLE_FLIGHT += COMPLEMENTO_URL_MOEDA_BRL + COMPLEMENTO_URL_IDIOMA;
			
		} catch (Exception e) {
			if (dataVolta != null) {
			LOGGER.error("Erro ao agrupar URL de ida e volta: ", e.getMessage());
			}else {
				LOGGER.error("Erro ao agrupar URL de apenas ida: ", e.getMessage());
			}
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
