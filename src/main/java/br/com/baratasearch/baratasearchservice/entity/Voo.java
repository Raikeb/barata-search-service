package br.com.baratasearch.baratasearchservice.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "voo")
public class Voo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "voo_id")
	private Long id;
		
	@Column(name = "companhia_voo")
	private String companhia;
	
	@ManyToOne
	@JoinColumn(name = "sigla_aeroporto_partida_id")
	private Aeroporto siglaAeroportoPartida;
	
	@ManyToOne
	@JoinColumn(name = "sigla_aeroporto_destino_id")
	private Aeroporto siglaAeroportoDestino;
	
	@Column (name = "previsao_partida_voo")
	private String previsaoPartida;
	
	@Column (name = "previsao_chegada_voo")
	private String previsaoChegada;
	
	@Column (name = "duracao_voo")
	private String duracao;
	
	@Column(name= "status_voo")
	private String status;
	
	@Column (name = "escalas_voo")
	private String escalas;
	
	@Column (name = "carbono_voo")
	private String carbono;
	
	@Column (name = "preco_voo")
	private String preco;

    @Schema(example = "dd/MM/yyyy HH:mm", description = "Data e hora da requisição")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "America/Sao_Paulo")
    @Temporal(TemporalType.TIMESTAMP)
    @Column (name = "data_hora_voo")
    private Date dataHoraVoo;	
}
