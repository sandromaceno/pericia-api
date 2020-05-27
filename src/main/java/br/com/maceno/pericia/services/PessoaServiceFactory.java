package br.com.maceno.pericia.services;

import br.com.maceno.pericia.enums.TipoAcessoEnum;

public class PessoaServiceFactory {

	public Pessoa getPessoa(Pessoa pessoa) {
		
        if (pessoa.tipoAcesso.equals(TipoAcessoEnum.POLICIAL)) {
        	return new PolicialService(pessoa);
        }
        if (pessoa.tipoAcesso.equals(TipoAcessoEnum.CIVIL)) {
        	return new CivilService(pessoa);
        }
        
		return null;
    }

}
