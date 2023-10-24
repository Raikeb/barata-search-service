package br.com.baratasearch.baratasearchservice.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.baratasearch.baratasearchservice.dto.VooDTO;
import br.com.baratasearch.baratasearchservice.dto.VooGoogleDTO;
import br.com.baratasearch.baratasearchservice.dto.VooResponseDTO;
import br.com.baratasearch.baratasearchservice.entity.Voo;
import br.com.baratasearch.baratasearchservice.exception.BadRequestException;
import br.com.baratasearch.baratasearchservice.exception.NotFoundException;
import br.com.baratasearch.baratasearchservice.repository.VooRepository;

@Service
public class VooService {

	@Autowired
	private AeroportoService aeroportoService;
	
	@Autowired
	private VooRepository vooRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	
	
	public Voo buscarVooId(Long id) {

		return vooRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Nenhum voo encontrado usando ID '" + id +"' informado." ));
	}
	
	public VooResponseDTO listarVoos() {
		VooResponseDTO voos = new VooResponseDTO();
		voos.setVoos(vooRepository.findAll());
		
		return voos;
	}

	public Voo inserirVoo(VooDTO dto) {
		Voo voo = modelMapper.map(dto, Voo.class);
		voo.setSiglaAeroportoPartida(aeroportoService.buscarAeroportoSigla(dto.getNomeAeroportoPartida()));
		voo.setSiglaAeroportoDestino(aeroportoService.buscarAeroportoSigla(dto.getNomeAeroportoDestino()));
							
		return salvarVoo(voo);	
		
	}
	
	private Voo salvarVoo(Voo voo) {
		return vooRepository.save(voo);
	}

	public void alterarVoo(Long id, VooDTO dto) {
		boolean exists = vooRepository.existsById(id);
		
		if (!exists) {
			throw new BadRequestException("ID Inexistente: Não foi possível atualizar o voo.");			
		}
		
		Voo voo = buscarVooId(id);
		voo.setSiglaAeroportoPartida(aeroportoService.buscarAeroportoSigla(dto.getNomeAeroportoPartida()));
		voo.setSiglaAeroportoDestino(aeroportoService.buscarAeroportoSigla(dto.getNomeAeroportoDestino()));
		voo.setCompanhia(dto.getCompanhia());
		voo.setDuracao(dto.getDuracao());
		voo.setStatus(dto.getStatus());
		voo.setEscalas(dto.getEscalas());
		voo.setCarbono(dto.getCarbono());		
		voo.setDataHoraVoo(dto.getDataHoraVoo());
		salvarVoo(voo);	
	}

	public void atualizaVoo(Voo voo, List<VooGoogleDTO> vooGoogleList) {
	    for (VooGoogleDTO vooGoogle : vooGoogleList) {
	        Voo novoVoo = new Voo();
	        novoVoo.setLogoCompanhia(vooGoogle.getLogoCompanhia());
	        novoVoo.setCompanhia(vooGoogle.getCompanhia());
	        novoVoo.setPrevisaoPartida(vooGoogle.getPrevisaoPartida());
	        novoVoo.setPrevisaoChegada(vooGoogle.getPrevisaoChegada());
	        novoVoo.setDuracao(vooGoogle.getDuracao());
	        novoVoo.setStatus(vooGoogle.getStatus());
	        novoVoo.setEscalas(vooGoogle.getEscalas());
	        novoVoo.setCarbono(vooGoogle.getCarbono());
	        novoVoo.setPreco(vooGoogle.getPreco());

	        salvarVoo(novoVoo);
	    }
	}

	public List<Voo> listarVoosPeriodo() {		
		return vooRepository.listarVoosPeriodo();
	}

	public Integer buscarQuantidadeVoosPeriodo() {		
		return vooRepository.buscarQuantidadeVoosPeriodo();
	}




}
