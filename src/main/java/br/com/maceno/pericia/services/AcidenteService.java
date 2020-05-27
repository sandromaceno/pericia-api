package br.com.maceno.pericia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.maceno.pericia.entity.Acidente;
import br.com.maceno.pericia.repository.AcidenteRepository;

@Service
public class AcidenteService {

	@Autowired
	private AcidenteRepository acidenteRepository;
	
	public List<Acidente> buscarTodos() {
		return acidenteRepository.findAll();
	}
	
	
	public Acidente inserir(Acidente acidente) {
		acidente.setMarkerId(null);
		return acidenteRepository.save(acidente);
	}

	
}
