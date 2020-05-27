package br.com.maceno.pericia.services;

class CivilService extends Pessoa {
    
    public CivilService(Pessoa pessoa) {
        this.nome = pessoa.nome;
        this.tipoAcesso = pessoa.tipoAcesso;
        System.out.println("Olá " + this.tipoAcesso);
    }
 
}
