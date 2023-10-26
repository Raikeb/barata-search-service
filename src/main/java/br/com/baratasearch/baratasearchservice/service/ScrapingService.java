package br.com.baratasearch.baratasearchservice.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.baratasearch.baratasearchservice.dto.VooGoogleDTO;
import br.com.baratasearch.baratasearchservice.entity.Voo;
import org.springframework.stereotype.Service;

import br.com.baratasearch.baratasearchservice.util.DataUtil;
import br.com.baratasearch.baratasearchservice.util.ScrapingUtil;
import br.com.baratasearch.baratasearchservice.util.StatusVoo;

@Service
public class ScrapingService {
	
	private DataUtil dataUtil;
	
	@Autowired
	private ScrapingUtil scrapingUtil;

	@Autowired
	private VooService vooService;
	
//	public void verificaVooPeriodo() {
//		Integer quantidadeVoo = vooService.buscarQuantidadeVoosPeriodo();
//
//		if (quantidadeVoo > 0) {
//			List<Voo> voos = vooService.listarVoosPeriodo();
//			voos.forEach(voo -> verificaVoo(voo));
//		}
//	}
//	private void verificaVoo(Voo voo) {
//		String urlVoo;
//		if (voo.getDataVooDestino() == null) {
//			urlVoo = scrapingUtil.agrupaUrl(
//					voo.getSiglaAeroportoPartida().getSiglaAeroporto(),
//					voo.getSiglaAeroportoDestino().getSiglaAeroporto(),
//					voo.getDataVooPartida(),
//					null);
//		} else {
//			urlVoo = scrapingUtil.agrupaUrl(
//					voo.getSiglaAeroportoPartida().getSiglaAeroporto(),
//					voo.getSiglaAeroportoDestino().getSiglaAeroporto(),
//					voo.getDataVooPartida(),
//					voo.getDataVooDestino());
//		}
//
//		List<VooGoogleDTO> vooGoogle = scrapingUtil.obtemInfoVoo(urlVoo);
//		for (VooGoogleDTO vooIndividual : vooGoogle) {
//			if (vooIndividual.getTemOuNaoVoos() == StatusVoo.COM_VOO) {
//				vooService.atualizaVoo(voo, vooGoogle);
//				break;
//			}
//		}
//	}	
	public void verificaVooPeriodo() {
		Integer quantidadeVoo = vooService.buscarQuantidadeVoosPeriodo();

		if (quantidadeVoo > 0) {

			List<Voo> voos = vooService.listarVoosPeriodo();

			voos.forEach(voo -> {
				String dataConvertida = dataUtil.converteDataHoraParaData(voo.getDataHoraVoo());
				String urlVoo;
				if (voo.getDataVooDestino() == null) {
					urlVoo = scrapingUtil.agrupaUrl(
							voo.getSiglaAeroportoPartida().getSiglaAeroporto(),
							voo.getSiglaAeroportoDestino().getSiglaAeroporto(),
							dataConvertida, 
							null);
					List<VooGoogleDTO> vooGoogle = scrapingUtil.obtemInfoVoo(urlVoo);
					try {
						vooService.atualizaVoo(voo, vooGoogle);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				} else {
					urlVoo = scrapingUtil.agrupaUrl(
							voo.getSiglaAeroportoPartida().getSiglaAeroporto(),
							voo.getSiglaAeroportoDestino().getSiglaAeroporto(),
							dataConvertida,
							voo.getDataVooDestino());
					List<VooGoogleDTO> vooGoogle = scrapingUtil.obtemInfoVoo(urlVoo);
					try {
						vooService.atualizaVoo(voo, vooGoogle);
					} catch (ParseException e) {						
						e.printStackTrace();
					}
				}
			});
		}
	}
	
	public ArrayList<VooGoogleDTO> buscaVoosDefinidos(String aeroportoPartida,String aeroportoDestino,String dataPartida,
			String dataDestino, ArrayList<VooGoogleDTO> voosDefinidos){
		
		try {
			
			List<VooGoogleDTO> voos = new ArrayList<>();
			
			String url = scrapingUtil.agrupaUrl(aeroportoPartida, aeroportoDestino, dataPartida, dataDestino);
			
			voos = scrapingUtil.obtemInfoVoo(url);
			
			voosDefinidos = scrapingUtil.consultaVoosDefinidos(voos, voosDefinidos);
			
		} catch (NullPointerException nullPointerException) {
			
			
		} catch (Exception exception) {
			
		}
		
		return voosDefinidos;
	}

}
