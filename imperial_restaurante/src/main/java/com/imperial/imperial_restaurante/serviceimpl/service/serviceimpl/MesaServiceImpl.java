package com.imperial.imperial_restaurante.serviceimpl.service.serviceimpl;

import com.imperial.imperial_restaurante.dtos.MesaDTO;
import com.imperial.imperial_restaurante.entidades.Mesa;
import com.imperial.imperial_restaurante.repository.MesaRepository;
import com.imperial.imperial_restaurante.serviceimpl.service.MesaService;
import com.imperial.imperial_restaurante.serviceimpl.service.mapping.MesaMapping;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MesaServiceImpl implements MesaService {


    private MesaRepository mesaRepository;
    private MesaMapping mesaMapping;

    public MesaServiceImpl(MesaRepository mesaRepository, MesaMapping mesaMapping) {
        this.mesaRepository = mesaRepository;
        this.mesaMapping = mesaMapping;
    }

    @Override
    public MesaDTO adcMesa(MesaDTO mesaDTO) {
        Mesa respostaMesa = mesaMapping.convertMesaToEntity(mesaDTO);
        Mesa respostaMesaSalva = mesaRepository.save(respostaMesa);
        MesaDTO respostaMesaDTO = mesaMapping.convertMesaToDTO(respostaMesaSalva);

        return respostaMesaDTO;
    }

    @Override
    public MesaDTO findMesaById(Long id) {
        Optional<Mesa> respostaMesa = mesaRepository.findById(id);
        if(!respostaMesa.isEmpty()){
            MesaDTO respostaMesaDTO = mesaMapping.convertMesaToDTO(respostaMesa.get());
            return respostaMesaDTO;
        }else{
            return null;
        }


    }

    @Override
    public MesaDTO atualizarMesa(Long id, MesaDTO mesaDTO) {
        Optional<Mesa> respostaMesa = mesaRepository.findById(id);
        if(!respostaMesa.isEmpty()){
            respostaMesa.get().setId(mesaDTO.getId());
            respostaMesa.get().setNumeroPessoa(mesaDTO.getNumeroPessoa());
           // respostaMesa.get().setListComandas(mesaDTO.getListComandasDTO());
            MesaDTO respostaMesaDTO = mesaMapping.convertMesaToDTO(respostaMesa.get());
            return respostaMesaDTO;
        }else{
            return null;
        }
    }

    @Override
    public void deletarMesaById(Long id) {
        Optional<Mesa> respostaMesa = mesaRepository.findById(id);
        if(!respostaMesa.isEmpty()){
            mesaRepository.deleteById(id);
        }


    }
}
