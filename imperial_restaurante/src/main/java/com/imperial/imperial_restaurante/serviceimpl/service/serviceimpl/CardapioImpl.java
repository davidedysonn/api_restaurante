package com.imperial.imperial_restaurante.serviceimpl.service.serviceimpl;

import com.imperial.imperial_restaurante.dtos.CardapioDTO;
import com.imperial.imperial_restaurante.entidades.Cardapio;
import com.imperial.imperial_restaurante.repository.CardapioRepository;
import com.imperial.imperial_restaurante.serviceimpl.service.CardapioService;
import com.imperial.imperial_restaurante.serviceimpl.service.mapping.CardapioMapping;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardapioImpl implements CardapioService {

     private CardapioMapping cardapioMapping;
     private CardapioRepository cardapioRepository;

    public CardapioImpl(CardapioMapping cardapioMapping, CardapioRepository cardapioRepository) {
        this.cardapioMapping = cardapioMapping;
        this.cardapioRepository = cardapioRepository;
    }

    @Override
    public CardapioDTO adcCardapio(CardapioDTO cardapioDTO) {
        Cardapio adc_cardapio = cardapioMapping.converterCardapioToEntity(cardapioDTO);
        Cardapio respostaCardapio = cardapioRepository.save(adc_cardapio);
        CardapioDTO respostaCardapioDTO = cardapioMapping.convertCardapioToDTO(respostaCardapio);

        return respostaCardapioDTO;
    }

    @Override
    public CardapioDTO findCardapioById(Long id) {
        Optional<Cardapio> respostaBuscaCardapio = cardapioRepository.findById(id);
        if(!respostaBuscaCardapio.isEmpty()){
            respostaBuscaCardapio.get();
            CardapioDTO respostaCardapioDTO = cardapioMapping.convertCardapioToDTO(respostaBuscaCardapio.get());
            return respostaCardapioDTO;
        }else{
            return null;
        }

    }

    @Override
    public CardapioDTO atualizarCardapio(Long id, CardapioDTO cardapioDTO) {
        Optional<Cardapio> respostaAtualizarCardapio = cardapioRepository.findById(id);
        if(!respostaAtualizarCardapio.isEmpty()){
            respostaAtualizarCardapio.get().setNomeItemCardapio(cardapioDTO.getNomeItemCardapio());
            respostaAtualizarCardapio.get().setDescricao(cardapioDTO.getDescricao());
            respostaAtualizarCardapio.get().setPreco(cardapioDTO.getPreco());

            Cardapio respostaCardapio = cardapioRepository.save(respostaAtualizarCardapio.get());
            CardapioDTO respostaCardapioDTO = cardapioMapping.convertCardapioToDTO(respostaCardapio);
            return respostaCardapioDTO;

        }

        return null;
    }

    @Override
    public void deletarCardapioById(Long id) {
        Optional<Cardapio> respostaDeletarCardapio = cardapioRepository.findById(id);
        if(!respostaDeletarCardapio.isEmpty()){
            cardapioRepository.deleteById(id);
        }

    }


}
