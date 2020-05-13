package br.com.maceno.pericia.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.maceno.pericia.dto.UsuarioDTO;
import br.com.maceno.pericia.services.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> buscar() {
		List<UsuarioDTO> usuario = usuarioService.buscar();
		return ResponseEntity.ok().body(usuario);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UsuarioDTO> buscar(@PathVariable Integer id) {
		UsuarioDTO usuario = usuarioService.buscar(id);
		return ResponseEntity.ok().body(usuario);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UsuarioDTO usuario) {
		usuario = usuarioService.inserir(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<UsuarioDTO> update(@RequestBody UsuarioDTO usuario, @PathVariable Integer id) {
		usuario.setId(id);
		usuario = usuarioService.atualizar(usuario);
		return ResponseEntity.noContent().build();
	}

}
