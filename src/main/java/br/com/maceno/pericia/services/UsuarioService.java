package br.com.maceno.pericia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.maceno.pericia.constants.MensagemConstants;
import br.com.maceno.pericia.dto.Usuario;
import br.com.maceno.pericia.enums.TipoAcessoEnum;
import br.com.maceno.pericia.repositories.UsuarioRepository;
import br.com.maceno.pericia.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Page<Usuario> buscar(Integer pagina, Integer quantidadePorPagina, String ordenarPor, String direcao) {
		PageRequest pageRequest = PageRequest.of(pagina, quantidadePorPagina, Direction.valueOf(direcao), ordenarPor);
		return usuarioRepository.findAll(pageRequest);
	}
	
	public List<Usuario> buscarTodos() {
		return usuarioRepository.findAll();
	}
	
	public Usuario buscar(Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.orElseThrow(() -> new ObjectNotFoundException(MensagemConstants.BUSCA_NAO_ENCONTRADA + "! Id: " + id));
	}
	
	public Usuario inserir(Usuario usuario) {
		usuario.setId(null);
		usuario.setTipoAcesso(TipoAcessoEnum.CIVIL);
		return usuarioRepository.save(usuario);
	}

	public Usuario atualizar(Usuario usuario) {
		Usuario novoUsuario = buscar(usuario.getId());
		updateData(novoUsuario, usuario);
		buscar(usuario.getId());
		return usuarioRepository.save(usuario);
	}
	
	private void updateData(Usuario novoUsuario, Usuario usuario) {
		if(null != usuario.getNome()) {
			novoUsuario.setNome(usuario.getNome());
		}
		if(null != usuario.getTelefone()) {
			novoUsuario.setTelefone(usuario.getTelefone());
		}
		if(null != usuario.getTipoAcesso()) {
			novoUsuario.setTipoAcesso(usuario.getTipoAcesso());
		}
	}

	public void deletar(Integer id) {
		buscar(id);
		usuarioRepository.deleteById(id);
	}
	
}
