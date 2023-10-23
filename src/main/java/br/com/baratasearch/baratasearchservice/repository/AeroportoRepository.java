package br.com.baratasearch.baratasearchservice.repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.baratasearch.baratasearchservice.entity.Aeroporto;

@Repository
public interface AeroportoRepository extends JpaRepository<Aeroporto, Long> {

	public Optional<Aeroporto> findBySiglaAeroporto(String siglaAeroporto);
	
	public boolean existsBySiglaAeroporto(String siglaAeroporto);
}
