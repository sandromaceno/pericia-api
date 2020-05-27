package br.com.maceno.pericia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.maceno.pericia.constants.MensagemConstants;
import br.com.maceno.pericia.enums.TipoAcessoEnum;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Length(min=3, max=120, message=MensagemConstants.CAMPO_TAMANHO_NOME)
	private String nome;
	
	@NotEmpty(message=MensagemConstants.CAMPO_OBRIGATORIO)
	@Email(message=MensagemConstants.EMAIL_INVALIDO)
	@Column(unique = true)
	private String email;
	
	private String telefone;
	
	private TipoAcessoEnum tipoAcesso;
	
	
	public Usuario() {
		super();
	}

	public Usuario(Integer id, String nome, String email, String senha, String telefone, TipoAcessoEnum tipoAcesso) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.tipoAcesso = tipoAcesso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoAcessoEnum getTipoAcesso() {
		return tipoAcesso;
	}

	public void setTipoAcesso(TipoAcessoEnum tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
