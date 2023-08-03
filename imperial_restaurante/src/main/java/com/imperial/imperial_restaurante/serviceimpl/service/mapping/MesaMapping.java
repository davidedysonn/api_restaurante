package com.imperial.imperial_restaurante.serviceimpl.service.mapping;

import com.imperial.imperial_restaurante.dtos.ComandaDTO;
import com.imperial.imperial_restaurante.dtos.MesaDTO;
import com.imperial.imperial_restaurante.entidades.Comanda;
import com.imperial.imperial_restaurante.entidades.Mesa;
import com.imperial.imperial_restaurante.repository.MesaRepository;
import com.imperial.imperial_restaurante.serviceimpl.service.ComandaService;
import org.springframework.stereotype.Service;

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
       // respostaMesaDTO.setListComandasDTO(mesa.getListComandas());

        return respostaMesaDTO;
    }

    public Mesa convertToEntity (MesaDTO mesaDTO){
        Mesa respostaMesaEntity = new Mesa();
        respostaMesaEntity.setId(mesaDTO.getId());
        respostaMesaEntity.setNumeroPessoa(mesaDTO.getNumeroPessoa());
       // respostaMesaEntity.setListComandas(mesaDTO.getListComandasDTO());

        return respostaMesaEntity;
    }
}
