package br.com.baratasearch.baratasearchservice.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AeroportoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String siglaAeroporto;
	
	@NotBlank
	private String nomeAeroporto;
}
