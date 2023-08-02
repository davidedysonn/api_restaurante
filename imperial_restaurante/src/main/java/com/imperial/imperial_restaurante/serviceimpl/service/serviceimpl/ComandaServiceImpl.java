package com.imperial.imperial_restaurante.serviceimpl.service.serviceimpl;

import com.imperial.imperial_restaurante.dtos.ComandaDTO;
import com.imperial.imperial_restaurante.entidades.Comanda;
import com.imperial.imperial_restaurante.repository.ComandaRepository;
import com.imperial.imperial_restaurante.serviceimpl.service.ComandaService;
import com.imperial.imperial_restaurante.serviceimpl.service.mapping.ComandaMapping;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComandaServiceImpl implements ComandaService {

    private Comanda altComanda;
    private ComandaDTO altComandaDTO;
    private ComandaMapping comandaMapping;
    private ComandaRepository comandaRepository;

    public ComandaServiceImpl(Comanda altComanda, ComandaDTO altComandaDTO, ComandaMapping comandaMapping, ComandaRepository comandaRepository) {
        this.altComanda = altComanda;
        this.altComandaDTO = altComandaDTO;
        this.comandaMapping = comandaMapping;
        this.comandaRepository = comandaRepository;
    }

    @Override
    public ComandaDTO adcComanda(ComandaDTO comandaDTO) {
        Comanda respostaComanda = comandaMapping.convertComandaToEntity(comandaDTO);
        Comanda respostaComandaSalva = comandaRepository.save(respostaComanda);
        ComandaDTO respostaComandaDTO = comandaMapping.convertComandaToDTO(respostaComandaSalva);

        return respostaComandaDTO;
    }

    @Override
    public ComandaDTO adcAdicional(ComandaDTO comandaDTO) {
        Comanda respostaComandaAdicional = comandaMapping.convertComandaToEntity(comandaDTO);
        Comanda respostaComandaAdicionalSalva = comandaRepository.save(respostaComandaAdicional);
        ComandaDTO respostaComandaAdicionalDTO = comandaMapping.convertComandaToDTO(respostaComandaAdicionalSalva);
        return respostaComandaAdicionalDTO;
    }

    @Override
    public ComandaDTO findComandaById(Long id) {
        Optional<Comanda> respostaComanda = comandaRepository.findById(id);
        if(!respostaComanda.isEmpty()){
            ComandaDTO respostaComandaDTO = comandaMapping.convertComandaToDTO(respostaComanda.get());
            return respostaComandaDTO;
        }else{
            return null;
        }

    }

    @Override
    public ComandaDTO atualizarComanda(Long id, ComandaDTO comandaDTO) {
        Optional<Comanda> respostaComanda = comandaRepository.findById(id);
        if(!respostaComanda.isEmpty()){
            respostaComanda.get().setId(comandaDTO.getId());
            respostaComanda.get().setObservacoes(comandaDTO.getObservacoes());
            respostaComanda.get().setListCardapio(altComanda.getListCardapio());
            ComandaDTO respostaComandaDTO = comandaMapping.convertComandaToDTO(respostaComanda.get());

            return respostaComandaDTO;
        }else{
            return  null;
        }

    }

    @Override
    public void deletarComandaById(Long id) {
        Optional<Comanda> respostaComanda = comandaRepository.findById(id);
        if(!respostaComanda.isEmpty()){
           comandaRepository.deleteById(id);

        }

    }

}
