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
    @JoinColumn(name = "comanda_id", nullable = false)
    //@JoinColumn(name = "comanda_id", nullable = false)
    private List<Cardapio> listCardapio = new ArrayList<>();

    private Double totalComprado;
    @ManyToOne
    @JoinColumn(name = "mesa_id")
    //@JoinColumn(name = "mesa_id")
    private Mesa mesa;

    public Comanda() {
    }

    public Comanda(Long id, String observacoes, List<Cardapio> listCardapio, Double totalComprado, Mesa mesa) {
        this.id = id;
        this.observacoes = observacoes;
        this.listCardapio = listCardapio;
        this.totalComprado = totalComprado;
        this.mesa = mesa;
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

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
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
