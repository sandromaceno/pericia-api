package br.com.maceno.pericia.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.maceno.pericia.domain.Categoria;
import br.com.maceno.pericia.repositories.CategoriaRepository;
import br.com.maceno.pericia.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("ops, busca não encontrada! Id: " + id
			+ " Tipo: " + Categoria.class.getName()));
	}
}
