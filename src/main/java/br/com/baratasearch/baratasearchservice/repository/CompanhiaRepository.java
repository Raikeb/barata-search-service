package br.com.baratasearch.baratasearchservice.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.baratasearch.baratasearchservice.entity.Companhia;

@Repository
public interface CompanhiaRepository extends JpaRepository<Companhia, Long> {

}
