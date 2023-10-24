package br.com.baratasearch.baratasearchservice.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.baratasearch.baratasearchservice.dto.VooGoogleDTO;
import br.com.baratasearch.baratasearchservice.entity.Voo;
import org.springframework.stereotype.Service;

import br.com.baratasearch.baratasearchservice.util.ScrapingUtil;
import br.com.baratasearch.baratasearchservice.util.StatusVoo;

@Service
public class ScrapingService {

	@Autowired
	private ScrapingUtil scrapingUtil;

	@Autowired
	private VooService vooService;

	public void verificaVooPeriodo() {
		Integer quantidadeVoo = vooService.buscarQuantidadeVoosPeriodo();

		if (quantidadeVoo > 0) {
			List<Voo> voos = vooService.listarVoosPeriodo();
			voos.forEach(voo -> verificaVoo(voo));
		}
	}

	private void verificaVoo(Voo voo) {
		String urlVoo;
		if (voo.getDataVooDestino() == null) {
			urlVoo = scrapingUtil.agrupaUrl(
					voo.getSiglaAeroportoPartida().getSiglaAeroporto(),
					voo.getSiglaAeroportoDestino().getSiglaAeroporto(),
					voo.getDataVooPartida(),
					null);
		} else {
			urlVoo = scrapingUtil.agrupaUrl(
					voo.getSiglaAeroportoPartida().getSiglaAeroporto(),
					voo.getSiglaAeroportoDestino().getSiglaAeroporto(),
					voo.getDataVooPartida(),
					voo.getDataVooDestino());
		}

		List<VooGoogleDTO> vooGoogle = scrapingUtil.obtemInfoVoo(urlVoo);
		for (VooGoogleDTO vooIndividual : vooGoogle) {
			if (vooIndividual.getTemOuNaoVoos() == StatusVoo.COM_VOO) {
				vooService.atualizaVoo(voo, vooGoogle);
				break;
			}
		}
	}

}
