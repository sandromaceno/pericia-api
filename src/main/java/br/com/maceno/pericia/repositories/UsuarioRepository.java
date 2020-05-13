package br.com.maceno.pericia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.maceno.pericia.dto.UsuarioDTO;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioDTO, Integer>{

}
