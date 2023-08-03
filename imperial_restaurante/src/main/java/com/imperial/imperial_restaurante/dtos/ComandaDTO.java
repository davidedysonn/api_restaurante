package com.imperial.imperial_restaurante.dtos;

import com.imperial.imperial_restaurante.entidades.Mesa;

import java.util.ArrayList;
import java.util.List;

public class ComandaDTO {
    private Long id;
    private String observacoes;
    private List<CardapioDTO> listCardapioDTO = new ArrayList<>();
    private Double totalComprado;
    private MesaDTO mesaDTO;


    public ComandaDTO() {
    }

    public ComandaDTO(Long id, String observacoes, List<CardapioDTO> listCardapioDTO, Double totalComprado, MesaDTO mesaDTO) {
        this.id = id;
        this.observacoes = observacoes;
        this.listCardapioDTO = listCardapioDTO;
        this.totalComprado = totalComprado;
        this.mesaDTO = mesaDTO;
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

    public MesaDTO getMesaDTO() {
        return mesaDTO;
    }

    public void setMesaDTO(MesaDTO mesaDTO) {
        this.mesaDTO = mesaDTO;
    }
}

