package com.imperial.imperial_restaurante.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
public class Comanda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String observacoes;
    @OneToMany
    @JoinColumn(name = "cardapio_id", nullable = false)
    private List<Cardapio> listCardapio = new ArrayList<>();

    private Double totalComprado;
    //private List<Mesa> listMesa =new ArrayList<>();

    public Comanda() {
    }

    public Comanda(Long id, String observacoes, List<Cardapio> listCardapio, Double totalComprado) {
        this.id = id;
        this.observacoes = observacoes;
        this.listCardapio = listCardapio;
        this.totalComprado = totalComprado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public List<Cardapio> getListCardapio() {
        return listCardapio;
    }

    public void setListCardapio(List<Cardapio> listCardapio) {
        this.listCardapio = listCardapio;
    }

    public Double getTotalComprado() {
        return totalComprado;
    }

    public void setTotalComprado(Double totalComprado) {
        this.totalComprado = totalComprado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comanda comanda = (Comanda) o;
        return id == comanda.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
