package br.com.maceno.pericia.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.maceno.pericia.entity.Acidente;
import br.com.maceno.pericia.services.AcidenteService;

@RestController
@RequestMapping(value="/acidentes")
public class AcidenteController {
	
	@Autowired
	private AcidenteService acidenteService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Acidente>> buscarTodos() {
		List<Acidente> acidente = acidenteService.buscarTodos();
		return ResponseEntity.ok().body(acidente);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Acidente acidente) {
		acidente = acidenteService.inserir(acidente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(acidente.getMarkerId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		acidenteService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
