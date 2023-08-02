package com.imperial.imperial_restaurante.serviceimpl.service;
import com.imperial.imperial_restaurante.dtos.ComandaDTO;

public interface ComandaService {

    ComandaDTO adcComanda(ComandaDTO comandaDTO);
    ComandaDTO adcAdicional(ComandaDTO comandaDTO);
    ComandaDTO findComandaById(Long id);
    ComandaDTO atualizarComanda(Long id, ComandaDTO comandaDTO);
    void deletarComandaById(Long id);
}
