package br.com.maceno.pericia.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.maceno.pericia.dto.Usuario;
import br.com.maceno.pericia.services.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Usuario> buscar(@PathVariable Integer id) {
		Usuario usuario = usuarioService.buscar(id);
		return ResponseEntity.ok().body(usuario);
	}
	
	@RequestMapping(value="/email", method=RequestMethod.GET)
	public ResponseEntity<Usuario> buscar(@PathVariable String email) {
		Usuario usuario = usuarioService.buscarPorEmail(email);
		return ResponseEntity.ok().body(usuario);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Usuario>> buscarTodos() {
		List<Usuario> usuario = usuarioService.buscarTodos();
		return ResponseEntity.ok().body(usuario);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Usuario>> buscar(
			@RequestParam(value="pagina", defaultValue = "0") Integer pagina, 
			@RequestParam(value="quantidadePorPagina", defaultValue = "1") Integer quantidadePorPagina, 
			@RequestParam(value="ordenarPor", defaultValue = "nome") String ordenarPor, 
			@RequestParam(value="direcao", defaultValue = "ASC") String direcao
	) {
		Page<Usuario> usuario = usuarioService.buscar(pagina, quantidadePorPagina, ordenarPor, direcao);
		return ResponseEntity.ok().body(usuario);
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> insert(@Valid @RequestBody Usuario usuario) {
		usuario = usuarioService.inserir(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Usuario> update(@RequestBody Usuario usuario, @PathVariable Integer id) {
		usuario.setId(id);
		usuario = usuarioService.atualizar(usuario);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		usuarioService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
