package com.imperial.imperial_restaurante.serviceimpl.service.mapping;

import com.imperial.imperial_restaurante.dtos.CardapioDTO;
import com.imperial.imperial_restaurante.dtos.ComandaDTO;
import com.imperial.imperial_restaurante.entidades.Cardapio;
import com.imperial.imperial_restaurante.entidades.Comanda;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComandaMapping {


    private MesaMapping mesaMapping;
    private CardapioMapping cardapioMapping;

    public ComandaMapping(MesaMapping mesaMapping, CardapioMapping cardapioMapping) {
        this.mesaMapping = mesaMapping;
        this.cardapioMapping = cardapioMapping;
    }

    //    private ComandaDTO altComandaDTO;
//    private Comanda altComanda;
//
//    public ComandaMapping(ComandaDTO altComandaDTO, Comanda altComanda) {
//        this.altComandaDTO = altComandaDTO;
//        this.altComanda = altComanda;
//    }

    public ComandaDTO convertComandaToDTO(Comanda comanda){
        ComandaDTO respostaComandaDTO = new ComandaDTO();
        respostaComandaDTO.setId(comanda.getId());
        respostaComandaDTO.setObservacoes(comanda.getObservacoes());
        respostaComandaDTO.setListCardapioDTO(convertListCardapioToDTO(comanda.getListCardapio()));

        respostaComandaDTO.setTotalComprado(comanda.getTotalComprado());
//        respostaComandaDTO.setMesaDTO(comanda.getMesa());

        return respostaComandaDTO;
    }

    public Comanda convertComandaToEntity (ComandaDTO comandaDTO){
        Comanda respostaComanda = new Comanda();
        respostaComanda.setId(comandaDTO.getId());
        respostaComanda.setObservacoes(comandaDTO.getObservacoes());
    //    respostaComanda.setListCardapio(altComanda.getListCardapio());
        respostaComanda.setTotalComprado(comandaDTO.getTotalComprado());
        respostaComanda.setListCardapio(convertListCardapioToEntity(comandaDTO.getListCardapioDTO()));
//        respostaComanda.setMesa(comandaDTO.getMesaDTO());

        return respostaComanda;
    }

    public List<ComandaDTO> convertListComandaToDTO (List<Comanda> comandaList){
        List<ComandaDTO> respostaListComandaDTO = new ArrayList<>();
        comandaList.stream().forEach(listComandaEntity ->{
            respostaListComandaDTO.add(convertComandaToDTO(listComandaEntity));
        });
        return respostaListComandaDTO;
    }

    public List<Comanda> convertListComandaToEntity (List<ComandaDTO> comandaDTOList){
        List<Comanda> respostaListComandaEntity = new ArrayList<>();
        comandaDTOList.stream().forEach(listComandaDTO ->{
            respostaListComandaEntity.add(convertComandaToEntity(listComandaDTO));
        });
        return respostaListComandaEntity;
    }
    //Tentar entender como eu fiz isso
    public List<CardapioDTO> convertListCardapioToDTO(List<Cardapio> cardapioList){
        List<CardapioDTO> respostaCardapioDTO = new ArrayList<>();
        cardapioList.stream().forEach(listCardapioEntity ->{
            respostaCardapioDTO.add(cardapioMapping.convertCardapioToDTO(listCardapioEntity));
        });
        return respostaCardapioDTO;
    }

    public List<Cardapio> convertListCardapioToEntity(List<CardapioDTO> cardapioDTOList){
        List<Cardapio> respostaCardapioEntity = new ArrayList<>();
        cardapioDTOList.stream().forEach(listCardapioDTO ->{
            respostaCardapioEntity.add(cardapioMapping.converterCardapioToEntity(listCardapioDTO));
        });
        return respostaCardapioEntity;
    }

}
