package br.com.baratasearch.baratasearchservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.baratasearch.baratasearchservice.entity.Voo;

@Repository
public interface VooRepository extends JpaRepository<Voo, Long> {

}
