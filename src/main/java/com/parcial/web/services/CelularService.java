package com.parcial.web.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.parcial.web.dto.CelularDTO;
import com.parcial.web.entities.Celular;
import com.parcial.web.repositories.CelularRepository;

@Service
public class CelularService {
    CelularRepository celularRepository;
    ModelMapper modelMapper;

    public CelularService(CelularRepository celularRepository, ModelMapper modelMapper) {
        this.celularRepository = celularRepository;
        this.modelMapper = modelMapper;
    }

    //Get Celular by id
    public CelularDTO getCelularById(Long id) {
      Optional<Celular> celular = celularRepository.findById(id);
      if(!celular.isPresent()) {
        throw new IllegalArgumentException("Celular no encontrado");
      }
      return modelMapper.map(celular.get(), CelularDTO.class);
    }

    //Get All Celulares
    public List<CelularDTO> getAllCelulares() {
      List<Celular> celularesList = (List<Celular>) celularRepository.findAll();
      List<CelularDTO> celularesDTO = celularesList.stream()
                    .map(Celular -> modelMapper.map(Celular, CelularDTO.class))
                    .toList();
        return celularesDTO;
    }

    //Create Celular
    public CelularDTO createCelular(CelularDTO celularDTO) {
      Celular celular = modelMapper.map(celularDTO, Celular.class);
      celular = celularRepository.save(celular);
      return modelMapper.map(celular, CelularDTO.class);
    }

    //Update Celular
    public CelularDTO updateCelular(CelularDTO celularDTO){
        if(!celularRepository.existsById(celularDTO.getId())) {
            throw new IllegalArgumentException("Celular no encontrado");
        }
        Celular celular = modelMapper.map(celularDTO, Celular.class);
        celular = celularRepository.save(celular);
        return modelMapper.map(celular, CelularDTO.class);
    }

    //Delete Celular
    public void deleteCelular(Long id){
        if(!celularRepository.existsById(id)) {
            throw new IllegalArgumentException("Celular no encontrado");
        }
        celularRepository.deleteById(id);
    }
}
