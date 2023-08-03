package com.imperial.imperial_restaurante.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Mesa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numeroPessoa;

    @OneToMany(mappedBy = "mesa")
    @JsonIgnoreProperties(value = "mesa")
    private List<Comanda> listComandas = new ArrayList<>();

    public Mesa() {
    }

    public Mesa(Long id, Integer numeroPessoa, List<Comanda> listComandas) {
        this.id = id;
        this.numeroPessoa = numeroPessoa;
        this.listComandas = listComandas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroPessoa() {
        return numeroPessoa;
    }

    public void setNumeroPessoa(Integer numeroPessoa) {
        this.numeroPessoa = numeroPessoa;
    }

    public List<Comanda> getListComandas() {
        return listComandas;
    }

    public void setListComandas(List<Comanda> listComandas) {
        this.listComandas = listComandas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mesa mesa = (Mesa) o;
        return Objects.equals(id, mesa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
