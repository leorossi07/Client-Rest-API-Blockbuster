package br.ufscar.dc.dsw.domain;

import java.util.List;

public class Produtora {

    private Long id;
    private String CNPJ;
    private String nome;
    private List<Filme> filmes;

    // Construtores
    public Produtora() {}

    public Produtora(Long id, String CNPJ, String nome, List<Filme> filmes) {
        this.id = id;
        this.CNPJ = CNPJ;
        this.nome = nome;
        this.filmes = filmes;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    // toString para facilitar a exibição
    @Override
    public String toString() {
        return "Produtora [id=" + id + ", CNPJ=" + CNPJ + ", nome=" + nome + "]";
    }
}
