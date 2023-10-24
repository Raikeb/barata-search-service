package br.com.baratasearch.baratasearchservice.repository;

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
		             + "WHERE p.data_hora_voo BETWEEN DATEADD(HOUR, -3, CURRENT_TIMESTAMP) AND CURRENT_TIMESTAMP " 
		              + "AND ifnull(p.momento_voo, 'Vazio') != 'O voo já ocorreu.' ",
		       nativeQuery = true)
		public Integer buscarQuantidadeVoosPeriodo();

}
