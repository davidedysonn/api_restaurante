package com.imperial.imperial_restaurante.serviceimpl.service.mapping;

import com.imperial.imperial_restaurante.dtos.CardapioDTO;
import com.imperial.imperial_restaurante.dtos.ComandaDTO;
import com.imperial.imperial_restaurante.dtos.MesaDTO;
import com.imperial.imperial_restaurante.entidades.Cardapio;
import com.imperial.imperial_restaurante.entidades.Comanda;
import com.imperial.imperial_restaurante.entidades.Mesa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComandaMapping {



    private CardapioMapping cardapioMapping;

    public ComandaMapping(CardapioMapping cardapioMapping) {
        this.cardapioMapping = cardapioMapping;
    }

    public ComandaDTO convertComandaToDTO(Comanda comanda){
        ComandaDTO respostaComandaDTO = new ComandaDTO();
        respostaComandaDTO.setId(comanda.getId());
        respostaComandaDTO.setObservacoes(comanda.getObservacoes());
        respostaComandaDTO.setListCardapioDTO(convertListCardapioToDTO(comanda.getListCardapio()));

        respostaComandaDTO.setTotalComprado(comanda.getTotalComprado());
        // pornto de possivel looping 1
        respostaComandaDTO.setMesaDTO(convertMesaToDTOComanda(comanda.getMesa()));

        return respostaComandaDTO;
    }

    public Comanda convertComandaToEntity (ComandaDTO comandaDTO){
        Comanda respostaComanda = new Comanda();
        respostaComanda.setId(comandaDTO.getId());
        respostaComanda.setObservacoes(comandaDTO.getObservacoes());

        respostaComanda.setTotalComprado(comandaDTO.getTotalComprado());
        respostaComanda.setListCardapio(convertListCardapioToEntity(comandaDTO.getListCardapioDTO()));
        // pornto de possivel looping 2
        respostaComanda.setMesa(convertMesaToEntityComanda(comandaDTO.getMesaDTO()));
        //test



        //
        return respostaComanda;
    }
    public Mesa convertMesaToEntityComanda(MesaDTO mesaDTO){
        Mesa respostaMesa = new Mesa();
        respostaMesa.setId(mesaDTO.getId());
        respostaMesa.setListComandas(convertListComandaToEntity(mesaDTO.getListComandasDTO()));
        respostaMesa.setNumeroPessoa(mesaDTO.getNumeroPessoa());
        return respostaMesa;
    }
    public MesaDTO convertMesaToDTOComanda(Mesa mesa){
        MesaDTO respostaMesaDTO = new MesaDTO();
        respostaMesaDTO.setId(mesa.getId());
        respostaMesaDTO.setListComandasDTO(convertListComandaToDTO(mesa.getListComandas()));
        respostaMesaDTO.setNumeroPessoa(mesa.getNumeroPessoa());
        return respostaMesaDTO;
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
