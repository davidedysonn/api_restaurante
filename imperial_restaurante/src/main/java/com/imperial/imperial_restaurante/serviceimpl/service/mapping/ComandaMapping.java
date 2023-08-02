package com.imperial.imperial_restaurante.serviceimpl.service.mapping;

import com.imperial.imperial_restaurante.dtos.ComandaDTO;
import com.imperial.imperial_restaurante.entidades.Comanda;
import org.springframework.stereotype.Service;

@Service
public class ComandaMapping {

    private ComandaDTO altComandaDTO;
    private Comanda altComanda;

    public ComandaMapping(ComandaDTO altComandaDTO, Comanda altComanda) {
        this.altComandaDTO = altComandaDTO;
        this.altComanda = altComanda;
    }

    public ComandaDTO convertComandaToDTO(Comanda comanda){
        ComandaDTO respostaComandaDTO = new ComandaDTO();
        respostaComandaDTO.setId(comanda.getId());
        respostaComandaDTO.setObservacoes(comanda.getObservacoes());
        respostaComandaDTO.setListCardapioDTO(altComandaDTO.getListCardapioDTO());
        respostaComandaDTO.setTotalComprado(comanda.getTotalComprado());

        return respostaComandaDTO;
    }

    public Comanda convertComandaToEntity (ComandaDTO comandaDTO){
        Comanda respostaComanda = new Comanda();
        respostaComanda.setId(comandaDTO.getId());
        respostaComanda.setObservacoes(comandaDTO.getObservacoes());
        respostaComanda.setListCardapio(altComanda.getListCardapio());
        respostaComanda.setTotalComprado(comandaDTO.getTotalComprado());

        return respostaComanda;
    }
}
