package com.imperial.imperial_restaurante.controllers;

import com.imperial.imperial_restaurante.dtos.CardapioDTO;
import com.imperial.imperial_restaurante.serviceimpl.service.CardapioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;


@RestController
@RequestMapping("/cardapio")
public class CardapioController {


    public CardapioService cardapioService;

    public CardapioController(CardapioService cardapioService) {
        this.cardapioService = cardapioService;
    }

    @PostMapping("/adc-cardapio")
    public ResponseEntity<CardapioDTO> adcCardapio(@RequestBody CardapioDTO produtosDT) throws URISyntaxException {
    CardapioDTO respostaCardapioDTO = cardapioService.adcCardapio(produtosDT);
    return ResponseEntity.created(new URI("/restaurante/adc-produto")).body(respostaCardapioDTO);
    }

    @GetMapping("/buscar-idcardapio/{id}")
    public ResponseEntity<CardapioDTO> buscarIdCardapio(@PathVariable Long id){
        CardapioDTO respostaCardapioDTO = cardapioService.findCardapioById(id);
        return ResponseEntity.ok().body(respostaCardapioDTO);

    }

    @PutMapping("/atualizar-idcardapio/{id}")
    public ResponseEntity<CardapioDTO> atualizarCardapio(@PathVariable Long id, @RequestBody CardapioDTO cardapioDTO){
        CardapioDTO respostaAtualizarProduto = cardapioService.atualizarCardapio(id, cardapioDTO);
        return ResponseEntity.ok().body(respostaAtualizarProduto);
    }

    @DeleteMapping("/deletar-idcardapio/{id}")
    public ResponseEntity<String> deletarIdCardapio(@PathVariable Long id){
        cardapioService.deletarCardapioById(id);
        return ResponseEntity.noContent().build();
    }





}
