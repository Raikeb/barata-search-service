package br.com.baratasearch.baratasearchservice.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.baratasearch.baratasearchservice.dto.VooDTO;
import br.com.baratasearch.baratasearchservice.dto.VooGoogleDTO;
import br.com.baratasearch.baratasearchservice.dto.VooResponseDTO;
import br.com.baratasearch.baratasearchservice.entity.Aeroporto;
import br.com.baratasearch.baratasearchservice.entity.Voo;
import br.com.baratasearch.baratasearchservice.exception.BadRequestException;
import br.com.baratasearch.baratasearchservice.exception.NotFoundException;
import br.com.baratasearch.baratasearchservice.model.Aeroportos;
import br.com.baratasearch.baratasearchservice.repository.VooRepository;
import br.com.baratasearch.baratasearchservice.util.DataUtil;
import br.com.baratasearch.baratasearchservice.util.ScrapingUtil;
import br.com.baratasearch.baratasearchservice.util.StatusVoo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.Valid;

@Service
public class VooService {

	private static final Logger LOGGER = LoggerFactory.getLogger(VooService.class);

	@Autowired
	private DataUtil dataUtil;
	
	@Autowired
	private Aeroportos modelAeroportos;

	@Autowired
	private AeroportoService aeroportoService;

	@Autowired
	private VooRepository vooRepository;

	@Autowired
	private ModelMapper modelMapper;

	public Voo buscarVooId(Long id) {

		return vooRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Nenhum voo encontrado usando ID '" + id + "' informado."));
	}

	public VooResponseDTO listarVoos() {
		VooResponseDTO voos = new VooResponseDTO();
		voos.setVoos(vooRepository.findAll());

		return voos;
	}

	private ArrayList<Voo> inserirListaVoo(ArrayList<VooGoogleDTO> infosObtidas, String aeroportoPartida, String aeroportoDestino,
			String dataPartida, String dataDestino) {
		ArrayList<Voo> voos = new ArrayList<>();;
		Voo voo = null;

		for (@SuppressWarnings("unused")
		VooGoogleDTO infoObtida : infosObtidas) {
			 voo = modelMapper.map(infosObtidas, Voo.class);
				
			Date dataPartidaConvertida = null;
			try {
				dataPartidaConvertida = dataUtil.converteStringParaData(infoObtida.getDataVooPartida());
			} catch (ParseException e) {
				LOGGER.error("Não foi possível converter a data do voo de partida no método inserirListaVoo: {}",
						e);
				e.printStackTrace();
			}
			boolean idVooJaExiste = vooRepository.buscarIdPorCampos(
					infoObtida.getMomentoVoo(),
					aeroportoService.buscarAeroportoSigla(aeroportoPartida).getId(),
					aeroportoService.buscarAeroportoSigla(aeroportoDestino).getId(),
					dataPartidaConvertida,
					infoObtida.getDataVooRetorno(),
					infoObtida.getLogoCompanhia(),
					infoObtida.getCompanhia(),
					infoObtida.getPrevisaoPartida(),
					infoObtida.getPrevisaoChegada(),
					infoObtida.getDuracao(),
					infoObtida.getStatus(),
					infoObtida.getEscalas(),
					infoObtida.getCarbono(),
					infoObtida.getPreco()
				);

			if (idVooJaExiste != true) {				
				voo.setMomentoVoo(infoObtida.getMomentoVoo());
				voo.setSiglaAeroportoPartida(aeroportoService.buscarAeroportoSigla(aeroportoPartida));
				voo.setSiglaAeroportoDestino(aeroportoService.buscarAeroportoSigla(aeroportoDestino));			
				voo.setDataHoraVoo(dataPartidaConvertida);
				voo.setDataVooDestino(infoObtida.getDataVooRetorno());
				voo.setLogoCompanhia(infoObtida.getLogoCompanhia());
				voo.setCompanhia(infoObtida.getCompanhia());
				voo.setPrevisaoPartida(infoObtida.getPrevisaoPartida());
				voo.setPrevisaoChegada(infoObtida.getPrevisaoChegada());
				voo.setDuracao(infoObtida.getDuracao());
				voo.setStatus(infoObtida.getStatus());
				voo.setEscalas(infoObtida.getEscalas());
				voo.setCarbono(infoObtida.getCarbono());
				voo.setPreco(infoObtida.getPreco());
				
				voos.add(voo);
				salvarVoo(voo);
			}
			else {
			LOGGER.info("Voo não inserido no banco pois esse voo já consta como salvo.");
			}
		}

		return voos;
	}

	public ArrayList<Voo> inserirListaVooIda(ArrayList<VooGoogleDTO> dto, String aeroportoPartida, String aeroportoDestino,
			String dataPartida) {
		return inserirListaVoo(dto, aeroportoPartida, aeroportoDestino, dataPartida, null);
	}

	public ArrayList<Voo> inserirVooListaIdaEvolta(ArrayList<VooGoogleDTO> dto, String aeroportoPartida, String aeroportoDestino,
			String dataPartida, String dataDestino) {
		return inserirListaVoo(dto, aeroportoPartida, aeroportoDestino, dataPartida, dataDestino);
	}

	private Voo inserirVoo(VooDTO dto, String dataPartida, String dataDestino) {
//		boolean exists = vooRepository.existsById(id);
//
//		if (!exists) {
//			throw new BadRequestException("ID Inexistente: Não foi possível atualizar o voo.");
//		}

		Voo voo = modelMapper.map(dto, Voo.class);
		voo.setSiglaAeroportoPartida(aeroportoService.buscarAeroportoSigla(dto.getNomeAeroportoPartida()));
		voo.setSiglaAeroportoDestino(aeroportoService.buscarAeroportoSigla(dto.getNomeAeroportoDestino()));
		Date dataPartidaConvertida = null;
		try {
			dataPartidaConvertida = dataUtil.converteStringParaData(dataPartida);
		} catch (ParseException e) {
			LOGGER.error("Não foi possível converter a data do voo de partida no método inserirVoo: {}",
					e);
			e.printStackTrace();
		}
		voo.setDataHoraVoo(dataPartidaConvertida);
		voo.setDataVooDestino(dataDestino);
		return salvarVoo(voo);
	}

	public Voo inserirVooIda(VooDTO dto, String dataPartida) {
		return inserirVoo(dto, dataPartida, null);
	}

	public Voo inserirVooIdaEvolta(VooDTO dto, String dataPartida, String dataDestino) {
		return inserirVoo(dto, dataPartida, dataDestino);
	}

	private Voo salvarVoo(Voo voo) {
		return vooRepository.save(voo);
	}

	private List<Voo> salvarListaVoos(ArrayList<Voo> voo) {
		return vooRepository.saveAll(voo);
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

	public void atualizaVoo(Voo voo, List<VooGoogleDTO> vooGoogleList) throws ParseException {
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
			Date dataConvertida = dataUtil.converteStringParaData(vooGoogle.getDataVooPartida());
			novoVoo.setDataHoraVoo(dataConvertida);

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
