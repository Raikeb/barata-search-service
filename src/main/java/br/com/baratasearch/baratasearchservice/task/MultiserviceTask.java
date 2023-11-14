package br.com.baratasearch.baratasearchservice.task;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import br.com.baratasearch.baratasearchservice.dto.AeroportoDTO;
import br.com.baratasearch.baratasearchservice.service.AeroportoService;
import br.com.baratasearch.baratasearchservice.service.ScrapingService;
import br.com.baratasearch.baratasearchservice.util.DataUtil;

@Configuration
@EnableScheduling
public class MultiserviceTask {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MultiserviceTask.class);
	private static final String TIME_ZONE = "America/Sao_Paulo";//será necessário alterar caso seja rodado em outro time_zone
	private static final String PADRAO_DATA_HORA_BRASIL = "dd/MM/yyyy HH:mm:ss";
	
	@Autowired
	private ScrapingService scrapingService;
	
	@Autowired
    private AeroportoService aeroportoService;
	
//	//@Scheduled(cron = "0/30 * 19-23 * * SUN-SAT", zone = TIME_ZONE)
//	@Scheduled(cron = "0/30 * * * * SUN-SAT", zone = TIME_ZONE)
//	public void taskVoo() {
//	    iniciaTaskSchedule("taskVoo()");
//	    
//	}
	
	@Scheduled(initialDelay = 1000, fixedDelay = Long.MAX_VALUE)
	public void taskAeroporto() {
        iniciaTaskSchedule("taskAeroporto()");
    }
	
//	private void iniciaTaskSchedule(String taskName)  {
//		this.salvaLogInfo(String.format("%s: %s", taskName, DataUtil.formataDateEmString(new Date(), PADRAO_DATA_HORA_BRASIL)));
//		
//		scrapingService.verificaVooPeriodo();
//	}
//	
	
	private void iniciaTaskSchedule(String taskName) {
		this.salvaLogInfo(String.format("%s: %s", taskName, DataUtil.formataDateEmString(new Date(), PADRAO_DATA_HORA_BRASIL)));

		if ("taskVoo()".equals(taskName)) {
			scrapingService.verificaVooPeriodo();
		} else if ("taskAeroporto()".equals(taskName)) {
			List<AeroportoDTO> aeroportos = aeroportoService.listarAeroportosPreSalvos();

	        if (aeroportos != null && !aeroportos.isEmpty()) {
	            aeroportoService.inserirAeroportos(aeroportos);
	            LOGGER.info("Inseridos " + aeroportos.size() + " aeroportos com sucesso.");
	        } else {
	            LOGGER.error("Erro: Não foi possível obter a lista de aeroportos da classe Aeroportos.");
	        }
		}
    }
	
	private void salvaLogInfo(String mensagem) {
		LOGGER.info(mensagem);
	}

}
