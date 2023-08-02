package com.imperial.imperial_restaurante.serviceimpl.service;

import com.imperial.imperial_restaurante.dtos.CardapioDTO;

public interface CardapioService {

    CardapioDTO adcCardapio(CardapioDTO cardapioDTO);
    CardapioDTO findCardapioById(Long id);
    CardapioDTO atualizarCardapio(Long id, CardapioDTO cardapioDTO);
    void deletarCardapioById(Long id);

}
