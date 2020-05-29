package br.com.maceno.pericia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.maceno.pericia.constants.MensagemConstants;
import br.com.maceno.pericia.entity.Acidente;
import br.com.maceno.pericia.repository.AcidenteRepository;
import br.com.maceno.pericia.services.exceptions.ObjectNotFoundException;

@Service
public class AcidenteService {

	@Autowired
	private AcidenteRepository acidenteRepository;
	
	public List<Acidente> buscarTodos() {
		return acidenteRepository.findAll();
	}
	
	public Acidente buscar(Integer id) {
		Optional<Acidente> acidente = acidenteRepository.findById(id);
		return acidente.orElseThrow(() -> new ObjectNotFoundException(MensagemConstants.BUSCA_NAO_ENCONTRADA + "! Id: " + id));
	}
	
	public Acidente inserir(Acidente acidente) {
		acidente.setMarkerId(null);
		return acidenteRepository.save(acidente);
	}
	
	public void deletar(Integer id) {
		buscar(id);
		acidenteRepository.deleteById(id);
	}

	
}
