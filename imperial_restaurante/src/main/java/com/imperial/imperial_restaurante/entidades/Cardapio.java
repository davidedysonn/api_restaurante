package com.imperial.imperial_restaurante.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
@Entity
public class Cardapio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeItemCardapio;
    private String descricao;
    private Double preco;

    public Cardapio(){

    }

    public Cardapio(long id, String nomeItemCardapio, String descricao, Double preco) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cardapio cardapio = (Cardapio) o;
        return id == cardapio.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
