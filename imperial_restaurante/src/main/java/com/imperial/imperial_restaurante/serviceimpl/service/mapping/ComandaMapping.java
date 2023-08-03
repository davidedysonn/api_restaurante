package com.imperial.imperial_restaurante.serviceimpl.service.mapping;

import com.imperial.imperial_restaurante.dtos.ComandaDTO;
import com.imperial.imperial_restaurante.entidades.Comanda;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComandaMapping {


    private MesaMapping mesaMapping;

    public ComandaMapping(MesaMapping mesaMapping) {
        this.mesaMapping = mesaMapping;
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
      //  respostaComandaDTO.setListCardapioDTO(altComandaDTO.getListCardapioDTO());

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


}
