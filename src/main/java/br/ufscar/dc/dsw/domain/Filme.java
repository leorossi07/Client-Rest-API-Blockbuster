package br.ufscar.dc.dsw.domain;

import java.math.BigDecimal;

public class Filme {

    private Long id;
    private String titulo;
    private String diretor;
    private Integer ano;
    private BigDecimal preco;
    private Produtora produtora;

    // Construtores
    public Filme() {}

    public Filme(Long id, String titulo, String diretor, Integer ano, BigDecimal preco, Produtora produtora) {
        this.id = id;
        this.titulo = titulo;
        this.diretor = diretor;
        this.ano = ano;
        this.preco = preco;
        this.produtora = produtora;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Produtora getProdutora() {
        return produtora;
    }

    public void setProdutora(Produtora produtora) {
        this.produtora = produtora;
    }

    // toString para facilitar a impressão dos dados no cliente
    @Override
    public String toString() {
        return "Filme [id=" + id + ", titulo=" + titulo + ", diretor=" + diretor + ", ano=" + ano + ", preco=" + preco
                + ", produtora=" + produtora + "]";
    }
}
