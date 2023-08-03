package com.imperial.imperial_restaurante.controllers;

import com.imperial.imperial_restaurante.dtos.MesaDTO;
import com.imperial.imperial_restaurante.serviceimpl.service.MesaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/mesa")
public class MesaController {

    private MesaService mesaService;

    public MesaController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    @PostMapping("/adc-mesa")
    public ResponseEntity<MesaDTO> adcMesa (@RequestBody MesaDTO mesaDTO) throws URISyntaxException {
        MesaDTO respostaMesaDTO = mesaService.adcMesa(mesaDTO);
        return ResponseEntity.created(new URI("/mesa/adc-mesa")).body(respostaMesaDTO);
    }

    @PutMapping("/atualizar-mesa")
    public ResponseEntity<MesaDTO> atualizarMesa (@PathVariable Long id, @RequestBody MesaDTO mesaDTO){
        MesaDTO respostaMesaDTO = mesaService.atualizarMesa(id, mesaDTO);
        return ResponseEntity.ok().body(respostaMesaDTO);
    }
    @DeleteMapping("/deletar-mesa")
    public ResponseEntity<Void> deletarMesa (@PathVariable Long id){
        mesaService.deletarMesaById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/mesa-id")
    public ResponseEntity<MesaDTO> mesaId (@PathVariable Long id){
        MesaDTO respostaMesaDTO = mesaService.findMesaById(id);
        return ResponseEntity.ok().body(respostaMesaDTO);
    }

}
