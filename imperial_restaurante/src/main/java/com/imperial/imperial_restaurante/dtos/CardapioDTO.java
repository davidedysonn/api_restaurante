package com.imperial.imperial_restaurante.dtos;

public class CardapioDTO {

    private long id;
    private String nomeItemCardapio;
    private String descricao;
    private Double preco;
    public CardapioDTO(){

    }

    public CardapioDTO(long id, String nomeItemCardapio, String descricao, Double preco) {
        this.id = id;
        this.nomeItemCardapio = nomeItemCardapio;
        this.descricao = descricao;
        this.preco = preco;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeItemCardapio() {
        return nomeItemCardapio;
    }

    public void setNomeItemCardapio(String nomeItemCardapio) {
        this.nomeItemCardapio = nomeItemCardapio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
