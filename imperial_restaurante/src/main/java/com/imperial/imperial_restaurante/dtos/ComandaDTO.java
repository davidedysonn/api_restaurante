package com.imperial.imperial_restaurante.dtos;

import java.util.ArrayList;
import java.util.List;

public class ComandaDTO {
    private Long id;
    private String observacoes;
    private List<CardapioDTO> listCardapioDTO = new ArrayList<>();
    private Double totalComprado;
    //private List<Mesa> listMesa =new ArrayList<>();


    public ComandaDTO() {
    }

    public ComandaDTO(Long id, String observacoes, List<CardapioDTO> listCardapioDTO, Double totalComprado) {
        this.id = id;
        this.observacoes = observacoes;
        this.listCardapioDTO = listCardapioDTO;
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

    public List<CardapioDTO> getListCardapioDTO() {
        return listCardapioDTO;
    }

    public void setListCardapioDTO(List<CardapioDTO> listCardapioDTO) {
        this.listCardapioDTO = listCardapioDTO;
    }

    public Double getTotalComprado() {
        return totalComprado;
    }

    public void setTotalComprado(Double totalComprado) {
        this.totalComprado = totalComprado;
    }
}

