package br.com.baratasearch.baratasearchservice.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.baratasearch.baratasearchservice.entity.Aeroporto;


@Repository
public interface AeroportoRepository extends JpaRepository<Aeroporto, Long> {

	public Optional<Aeroporto> findBySiglaAeroporto(String siglaAeroporto);
	
	public boolean existsBySiglaAeroporto(String siglaAeroporto);

	@Query(name = "listar_aeroportos_brasileiros",
			value = "SELECT AEROPORTO_ID AS ID, SIGLA_AEROPORTO AS SIGLA_DO_AEROPORTO, NOME_AEROPORTO AS NOME_DO_AEROPORTO "
					+ "FROM AEROPORTO "
					+ "WHERE NOME_AEROPORTO LIKE '%Brasil%' "
					+ "ORDER BY ID, SIGLA_DO_AEROPORTO, NOME_DO_AEROPORTO; ",
			nativeQuery = true)
	public List<Aeroporto> listarAeroportosBrasileiros();
}
