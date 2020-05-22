package br.com.maceno.pericia.services;

class PolicialService extends Pessoa {
    
    public PolicialService(Pessoa pessoa) {
        this.nome = pessoa.nome;
        this.tipoAcesso = pessoa.tipoAcesso;
        System.out.println("Olá " + this.tipoAcesso);
    }
}
