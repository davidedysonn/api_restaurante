package com.imperial.imperial_restaurante.dtos;

import com.imperial.imperial_restaurante.entidades.Comanda;

import java.util.ArrayList;
import java.util.List;

public class MesaDTO {

    private Long id;
    private Integer numeroPessoa;

    private List<ComandaDTO> listComandasDTO = new ArrayList<>();

    public MesaDTO() {
    }

    public MesaDTO(Long id, Integer numeroPessoa, List<ComandaDTO> listComandasDTO) {
        this.id = id;
        this.numeroPessoa = numeroPessoa;
        this.listComandasDTO = listComandasDTO;
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

    public List<ComandaDTO> getListComandasDTO() {
        return listComandasDTO;
    }

    public void setListComandasDTO(List<ComandaDTO> listComandasDTO) {
        this.listComandasDTO = listComandasDTO;
    }
}
