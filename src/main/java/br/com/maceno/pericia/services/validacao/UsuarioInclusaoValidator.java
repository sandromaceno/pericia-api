package br.com.maceno.pericia.services.validacao;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.maceno.pericia.constants.MensagemConstants;
import br.com.maceno.pericia.controller.exeption.FieldMessage;
import br.com.maceno.pericia.dto.Usuario;
import br.com.maceno.pericia.repositories.UsuarioRepository;

public class UsuarioInclusaoValidator implements ConstraintValidator<UsuarioInclusao, Usuario> {
	
	@Autowired
	private UsuarioRepository usuarioRespository;
	
	@Override
	public void initialize(UsuarioInclusao ann) {
	}

	@Override
	public boolean isValid(Usuario usuario, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		Usuario usuarioAux = usuarioRespository.findByEmail(usuario.getEmail());
		
		if(usuarioAux != null) {
			list.add(new FieldMessage(MensagemConstants.EMAIL, MensagemConstants.EMAIL_EXISTENTE));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
