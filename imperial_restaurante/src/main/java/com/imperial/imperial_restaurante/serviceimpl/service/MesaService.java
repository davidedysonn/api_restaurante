package com.imperial.imperial_restaurante.serviceimpl.service;

import com.imperial.imperial_restaurante.dtos.ComandaDTO;
import com.imperial.imperial_restaurante.dtos.MesaDTO;

public interface MesaService {

    MesaDTO adcMesa(MesaDTO mesaDTO);
    MesaDTO findMesaById(Long id);
    MesaDTO atualizarMesa(Long id, MesaDTO mesaDTO);
    void deletarMesaById(Long id);
}
