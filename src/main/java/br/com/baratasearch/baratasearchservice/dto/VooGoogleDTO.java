package br.com.baratasearch.baratasearchservice.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import java.util.ArrayList;
import br.com.baratasearch.baratasearchservice.entity.Voo;
import br.com.baratasearch.baratasearchservice.util.StatusVoo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class VooGoogleDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//informações sobre o Voo
	private StatusVoo temOuNaoVoos;
	private String momentoVoo;
	private String dataVooPartida;//dataVooPartida e dataVooRetorno definidos como String para facilitar o uso
	private String dataVooRetorno;
	private String aeroportoPartida;
	private String aeroportoDestino;	
	private String logoCompanhia;
	private String companhia;
	private String previsaoPartida;
	private String previsaoChegada;
	private String duracao;
	private String status;
	private String escalas;
	private String carbono;
	private String preco;
	//sem a necessidade de definir os getters e setters pois será usado o lombok
	
    public static ArrayList<VooGoogleDTO> defineVoos(ArrayList<VooGoogleDTO> listaVoos, VooGoogleDTO voos) {


    	listaVoos.add(voos);

	    return listaVoos;
	}
}
