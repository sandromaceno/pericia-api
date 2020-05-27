package br.com.maceno.pericia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.maceno.pericia.entity.Acidente;

@Repository
public interface AcidenteRepository extends JpaRepository<Acidente, Integer>{
	
}
