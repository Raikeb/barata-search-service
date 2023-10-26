package br.com.baratasearch.baratasearchservice.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.baratasearch.baratasearchservice.entity.Voo;

@Repository
public interface VooRepository extends JpaRepository<Voo, Long> {

	//As querys abaixo estão utilizando caracteristicas específicas para o banco h2,
	//precisando ser refatoradas caso eu altere o banco
	
	@Query(name = "listar_voos_periodo",
			value = "SELECT * FROM voo AS p "
					+ "WHERE p.data_hora_voo BETWEEN DATEADD(HOUR, -3, CURRENT_TIMESTAMP) AND CURRENT_TIMESTAMP "
					+ "AND ifnull(p.momento_voo, 'Vazio') != 'O voo já ocorreu.' ",
			nativeQuery = true)
	public List<Voo> listarVoosPeriodo();
	
	
	@Query(name = "buscar_quantidade_partidas_periodo",
		       value = "SELECT COUNT(*) FROM voo AS p " 
		             + "WHERE p.data_hora_voo BETWEEN DATEADD(HOUR, -3, CURRENT_TIMESTAMP) AND CURRENT_TIMESTAMP ",
		       nativeQuery = true)
		public Integer buscarQuantidadeVoosPeriodo();


	@Query(name = "buscar_id_por_campos",
		       value = "SELECT CASE WHEN COUNT(p.voo_id) > 0 THEN true ELSE false END FROM voo AS p "
		             + "WHERE p.momento_voo = :momentoVoo AND p.sigla_aeroporto_partida_id = :siglaAeroportoPartida "
		             + "AND p.sigla_aeroporto_destino_id = :siglaAeroportoDestino AND p.data_hora_voo = :dataHoraVoo "
		             + "AND p.data_voo_destino = :dataVooDestino AND p.logo_companhia_voo = :logoCompanhia "
		             + "AND p.companhia_voo = :companhia AND p.previsao_partida_voo = :previsaoPartida "
		             + "AND p.previsao_chegada_voo = :previsaoChegada AND p.duracao_voo = :duracao "
		             + "AND p.status_voo = :status AND p.escalas_voo = :escalas AND p.carbono_voo = :carbono "
		             + "AND p.preco_voo = :preco", 		             
		       nativeQuery = true)
		public boolean buscarIdPorCampos(String momentoVoo, Long siglaAeroportoPartida, Long siglaAeroportoDestino,
                                      Date dataHoraVoo, String dataVooDestino, String logoCompanhia,
                                      String companhia, String previsaoPartida, String previsaoChegada,
                                      String duracao, String status, String escalas,
                                      String carbono, String preco);


}
