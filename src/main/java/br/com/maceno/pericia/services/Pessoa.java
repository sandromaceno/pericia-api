package br.com.maceno.pericia.services;

import br.com.maceno.pericia.enums.TipoAcessoEnum;

public abstract class Pessoa {
	public String nome;
    public String email;
    public String telefone;
    public TipoAcessoEnum tipoAcesso;
}
