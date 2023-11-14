package br.com.baratasearch.baratasearchservice.dto;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class VooDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank
	private String nomeAeroportoPartida;

	@NotBlank
	private String nomeAeroportoDestino;

	@NotBlank
	private String companhia;

	@NotBlank
	private String duracao;
	
	@NotBlank
	private String status;
	
	@NotBlank
	private String escalas;
	
	@NotBlank
	private String carbono;
	
	@NotBlank
	private String preco;
	
	@NotNull
	@Schema(example = "dd/mm/yyyy hh:mm", description = "Data e hora do Voo")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "America/Sao_Paulo")
	private Date dataHoraVoo;

}
