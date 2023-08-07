package com.imperial.imperial_restaurante.serviceimpl.service.mapping;

import com.imperial.imperial_restaurante.dtos.MesaDTO;
import com.imperial.imperial_restaurante.entidades.Mesa;
import com.imperial.imperial_restaurante.serviceimpl.service.ComandaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MesaMapping {



    private ComandaMapping comandaMapping;
    private ComandaService comandaService;


    public MesaMapping(ComandaMapping comandaMapping, ComandaService comandaService) {
        this.comandaMapping = comandaMapping;
        this.comandaService = comandaService;
    }

    public MesaDTO convertMesaToDTO(Mesa mesa){
        MesaDTO respostaMesaDTO = new MesaDTO();
        respostaMesaDTO.setId(mesa.getId());
        respostaMesaDTO.setNumeroPessoa(mesa.getNumeroPessoa());
        //respostaMesaDTO.setListComandasDTO(mesa.getListComandas());
        respostaMesaDTO.setListComandasDTO(comandaMapping.convertListComandaToDTO(mesa.getListComandas()));

        return respostaMesaDTO;
    }

    public Mesa convertMesaToEntity(MesaDTO mesaDTO){
        Mesa respostaMesaEntity = new Mesa();
        respostaMesaEntity.setId(mesaDTO.getId());
        respostaMesaEntity.setNumeroPessoa(mesaDTO.getNumeroPessoa());
        respostaMesaEntity.setListComandas(comandaMapping.convertListComandaToEntity(mesaDTO.getListComandasDTO()));
       // respostaMesaEntity.setListComandas(mesaDTO.getListComandasDTO());

        return respostaMesaEntity;
    }

    public List<MesaDTO> convertListMesaToDTO (List<Mesa> listMesa){
        List<MesaDTO> respostaMesaDTOList = new ArrayList<>();
        listMesa.stream().forEach(mesa ->{
            respostaMesaDTOList.add(convertMesaToDTO(mesa));
        });
        return respostaMesaDTOList;

    }

    public List<Mesa> convertListMesaToEntity (List<MesaDTO> mesaDTOList){
        List<Mesa> respostaListMesa = new ArrayList<>();
        mesaDTOList.stream().forEach(mesaDTO -> {
            respostaListMesa.add(convertMesaToEntity(mesaDTO));
        });
        return respostaListMesa;
    }

}
