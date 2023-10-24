package br.com.baratasearch.baratasearchservice.task;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import br.com.baratasearch.baratasearchservice.service.ScrapingService;
import br.com.baratasearch.baratasearchservice.util.DataUtil;

@Configuration
@EnableScheduling
public class VooTask {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VooTask.class);
	private static final String TIME_ZONE = "America/Sao_Paulo";//será necessário alterar caso seja rodado em outro time_zone
	private static final String PADRAO_DATA_HORA_BRASIL = "dd/MM/yyyy HH:mm:ss";
	
	@Autowired
	private ScrapingService scrapingService;
	
	//@Scheduled(cron = "0/30 * 19-23 * * SUN-SAT", zone = TIME_ZONE)
	@Scheduled(cron = "0/30 * * * * SUN-SAT", zone = TIME_ZONE)
	public void taskVoo() {
	    iniciaTaskSchedule("taskVoo()");
	}
	
	private void iniciaTaskSchedule(String diaSemana) {
		this.salvaLogInfo(String.format("%s: %s", diaSemana, DataUtil.formataDateEmString(new Date(), PADRAO_DATA_HORA_BRASIL)));
		scrapingService.verificaVooPeriodo();
	}
	
	private void salvaLogInfo(String mensagem) {
		LOGGER.info(mensagem);
	}

}
