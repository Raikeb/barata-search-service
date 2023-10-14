package br.com.baratasearch.baratasearchservice.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import org.jsoup.nodes.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class VoosGoogleDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//informações sobre o Voo
	private String companhia;
	private String previsaoSaida;
	private String previsaoChegada;
	private String duracao;
	private Document status;
	private String carbono;
	private String preco;
	//sem a necessidade de definir os getters e setters pois será usado o lombok
}
