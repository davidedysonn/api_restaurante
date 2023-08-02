package com.imperial.imperial_restaurante.controllers;

import com.imperial.imperial_restaurante.dtos.ComandaDTO;
import com.imperial.imperial_restaurante.serviceimpl.service.ComandaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/comanda")
public class ComandaController {

    private ComandaService comandaService;

    public ComandaController(ComandaService comandaService) {
        this.comandaService = comandaService;
    }
    @PostMapping("/adc-comanda")
    public ResponseEntity<ComandaDTO> salvarComanda (@RequestBody ComandaDTO comandaDTO) throws URISyntaxException {
        ComandaDTO respostaComandaDTO = comandaService.adcComanda(comandaDTO);
        return ResponseEntity.created(new URI("/comanda/adc-comanda")).body(respostaComandaDTO);
    }

    @GetMapping("/busca-comanda")
    public ResponseEntity<ComandaDTO> buscarComandaId(@PathVariable Long id){
        ComandaDTO respostaComandaDTO = comandaService.findComandaById(id);
        return ResponseEntity.ok().body(respostaComandaDTO);
    }

    @DeleteMapping("/delete-id/{id}")
    public ResponseEntity<Void> deletarComandaId(@PathVariable Long id){
        comandaService.deletarComandaById(id);
        return ResponseEntity.noContent().build();
    }



}
