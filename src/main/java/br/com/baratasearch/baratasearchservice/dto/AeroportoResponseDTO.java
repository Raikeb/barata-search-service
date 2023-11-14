package br.com.baratasearch.baratasearchservice.dto;

import java.io.Serializable;
import java.util.List;

import br.com.baratasearch.baratasearchservice.entity.Aeroporto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AeroportoResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Aeroporto> aeroportos;
}
