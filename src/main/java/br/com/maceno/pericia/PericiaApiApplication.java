package br.com.maceno.pericia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.maceno.pericia.entity.Usuario;
import br.com.maceno.pericia.enums.TipoAcessoEnum;
import br.com.maceno.pericia.repository.UsuarioRepository;

@SpringBootApplication
public class PericiaApiApplication implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(PericiaApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Usuario usu1 = new Usuario(null, "Sandro", "smaceno@gmail.com", "123", "996767030", TipoAcessoEnum.POLICIAL);
		Usuario usu2 = new Usuario(null, "Luis", "luis@gmail.com", "123", "9685741414", TipoAcessoEnum.CIVIL);
		Usuario usu3 = new Usuario(null, "Gustavo", "gustavo@gmail.com", "123", "3333741414", TipoAcessoEnum.CIVIL);
		Usuario usu4 = new Usuario(null, "Isabella", "isabella@gmail.com", "123", "4444741414", TipoAcessoEnum.CIVIL);
		Usuario usu5 = new Usuario(null, "Beatriz", "beatriz@gmail.com", "123", "5555741414", TipoAcessoEnum.CIVIL);
		Usuario usu6 = new Usuario(null, "Gisele", "gisele@gmail.com", "123", "6666741414", TipoAcessoEnum.CIVIL);
		Usuario usu7 = new Usuario(null, "Andressa", "andressa@gmail.com", "123", "7777741414", TipoAcessoEnum.CIVIL);
		Usuario usu8 = new Usuario(null, "Andrielle", "andrielle@gmail.com", "123", "8888741414", TipoAcessoEnum.CIVIL);
		
		//usuarioRepository.saveAll(Arrays.asList(usu1, usu2, usu3, usu4, usu5, usu6, usu7, usu8));
		
	}
	


}
