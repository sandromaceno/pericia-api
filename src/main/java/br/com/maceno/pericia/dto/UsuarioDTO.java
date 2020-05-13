package br.com.maceno.pericia.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.maceno.pericia.enums.TipoAcessoEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel("Usuario")
public class UsuarioDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ApiModelProperty(value = "Nome do usuário")
	private String nome;
	
	@ApiModelProperty(value = "Email do usuário")
	private String email;
	
	@ApiModelProperty(value = "Telefone para contato")
	private String telefone;
	
	@ApiModelProperty(value = "Tipo de acesso")
	private TipoAcessoEnum tipoAcesso;
	
	public UsuarioDTO() {
		
	}
	
	public UsuarioDTO(Integer id, String nome, String email, String telefone, TipoAcessoEnum tipoAcesso) {
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
