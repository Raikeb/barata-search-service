package br.com.baratasearch.baratasearchservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.baratasearch.baratasearchservice.dto.AeroportoDTO;
import br.com.baratasearch.baratasearchservice.dto.AeroportoResponseDTO;
import br.com.baratasearch.baratasearchservice.entity.Aeroporto;
import br.com.baratasearch.baratasearchservice.exception.BadRequestException;
import br.com.baratasearch.baratasearchservice.exception.NotFoundException;
import br.com.baratasearch.baratasearchservice.model.Aeroportos;
import br.com.baratasearch.baratasearchservice.repository.AeroportoRepository;

@Service
public class AeroportoService {

	@Autowired
	private AeroportoRepository aeroportoRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	public Aeroporto buscarAeroportoId(Long id) {

		return aeroportoRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Nenhum aeroporto encontrada usando ID '" + id +"' informado." ));
	}

	public Aeroporto buscarAeroportoSigla(String sigla) {

		return aeroportoRepository.findBySiglaAeroporto(sigla)
				.orElseThrow(() -> new NotFoundException("Nenhum aeroporto encontrada usando sigla '" + sigla +"' informada." ));
	}
	
	public AeroportoResponseDTO listarAeroportos() {
		AeroportoResponseDTO aeroportos = new AeroportoResponseDTO();
		aeroportos.setAeroportos(aeroportoRepository.findAll());
		
		return aeroportos;
	}

	public Aeroporto inserirAeroporto(AeroportoDTO dto) {
		boolean exists = aeroportoRepository.existsBySiglaAeroporto(dto.getSiglaAeroporto());
		
		if (exists) {
			throw new BadRequestException("Já existe um aeroporto com a sigla cadastrada.");			
		}
		
		Aeroporto aeroporto = modelMapper.map(dto, Aeroporto.class);
		
		return aeroportoRepository.save(aeroporto);		
		
	}

	public void alterarAeroporto(Long id, AeroportoDTO dto) {
		boolean exists = aeroportoRepository.existsById(id);
		
		if (!exists) {
			throw new BadRequestException("ID Inexistente: Não foi possível alterar o aeroporto.");			
		}
		Aeroporto aeroporto = modelMapper.map(dto, Aeroporto.class);
		aeroporto.setId(id);
		aeroportoRepository.save(aeroporto);
	}

	public void inserirAeroportos(List<AeroportoDTO> aeroportos) {
        for (AeroportoDTO aeroporto : aeroportos) {
            inserirAeroporto(aeroporto);
        }
    }
	
	public List<AeroportoDTO> listarAeroportosPreSalvos() {
        List<AeroportoDTO> aeroportosDTO = new ArrayList<>();

        for (Map.Entry<String, String> entry : Aeroportos.AEROPORTOS.entrySet()) {
            AeroportoDTO aeroportoDTO = new AeroportoDTO();
            aeroportoDTO.setSiglaAeroporto(entry.getKey());
            aeroportoDTO.setNomeAeroporto(entry.getValue());
            aeroportosDTO.add(aeroportoDTO);
        }

        return aeroportosDTO;
    }
	
	public List<Aeroporto> listarAeroportosBrasileiros(){
		return aeroportoRepository.listarAeroportosBrasileiros();		
	}
}
