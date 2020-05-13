package br.com.maceno.pericia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.maceno.pericia.dto.UsuarioDTO;
import br.com.maceno.pericia.enums.TipoAcessoEnum;
import br.com.maceno.pericia.repositories.UsuarioRepository;
import br.com.maceno.pericia.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<UsuarioDTO> buscar() {
		return usuarioRepository.findAll();
	}
	
	public UsuarioDTO buscar(Integer id) {
		Optional<UsuarioDTO> usuario = usuarioRepository.findById(id);
		return usuario.orElseThrow(() -> new ObjectNotFoundException("Ops, busca não encontrada! Id: " + id));
	}
	
	public UsuarioDTO inserir(UsuarioDTO usuario) {
		usuario.setId(null);
		usuario.setTipoAcesso(TipoAcessoEnum.CIVIL);
		return usuarioRepository.save(usuario);
	}

	public UsuarioDTO atualizar(UsuarioDTO usuario) {
		buscar(usuario.getId());
		return usuarioRepository.save(usuario);
	}
}
