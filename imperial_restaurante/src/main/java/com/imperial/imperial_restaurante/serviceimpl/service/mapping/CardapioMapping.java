package com.imperial.imperial_restaurante.serviceimpl.service.mapping;

import com.imperial.imperial_restaurante.dtos.CardapioDTO;
import com.imperial.imperial_restaurante.entidades.Cardapio;
import org.springframework.stereotype.Service;

@Service
public class CardapioMapping {

   public CardapioDTO convertCardapioToDTO(Cardapio cardapio){
        CardapioDTO respostaCardapioDTO = new CardapioDTO();
        respostaCardapioDTO.setId(cardapio.getId());
        respostaCardapioDTO.setNomeItemCardapio(cardapio.getNomeItemCardapio());
        respostaCardapioDTO.setDescricao(cardapio.getDescricao());
        respostaCardapioDTO.setPreco(cardapio.getPreco());

        return respostaCardapioDTO;
    }
    public Cardapio converterCardapioToEntity(CardapioDTO cardapioDTO){
        Cardapio respostaCardapioEntity = new Cardapio();
        respostaCardapioEntity.setId(cardapioDTO.getId());
        respostaCardapioEntity.setNomeItemCardapio(cardapioDTO.getNomeItemCardapio());
        respostaCardapioEntity.setDescricao(cardapioDTO.getDescricao());
        respostaCardapioEntity.setPreco(cardapioDTO.getPreco());

        return respostaCardapioEntity;
    }

}
