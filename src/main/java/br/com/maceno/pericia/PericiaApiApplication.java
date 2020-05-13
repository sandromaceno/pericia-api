package br.com.maceno.pericia;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.maceno.pericia.dto.UsuarioDTO;
import br.com.maceno.pericia.enums.TipoAcessoEnum;
import br.com.maceno.pericia.repositories.UsuarioRepository;

@SpringBootApplication
public class PericiaApiApplication implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(PericiaApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		UsuarioDTO usu1 = new UsuarioDTO(null, "Sandro", "smaceno@gmail.com", "996767030", TipoAcessoEnum.POLICIAL);
		UsuarioDTO usu2 = new UsuarioDTO(null, "Luis", "luis@gmail.com", "9685741414", TipoAcessoEnum.CIVIL);
		
		usuarioRepository.saveAll(Arrays.asList(usu1, usu2));
		
	}
	


}
