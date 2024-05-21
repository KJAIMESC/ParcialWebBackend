package com.parcial.web.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parcial.web.dto.CelularDTO;
import com.parcial.web.services.CelularService;

@RestController
@CrossOrigin
@RequestMapping(value = "/celulares")
public class CelularController {
    CelularService celularService;

    public CelularController(CelularService celularService) {
        this.celularService = celularService;
    }

    //Get Celular by id
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CelularDTO getCelularById(@PathVariable Long id) {
        return celularService.getCelularById(id);
    }

    //Get All Celulares
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CelularDTO> getAllCelulares() {
        return celularService.getAllCelulares();
    }

    //Create Celular
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CelularDTO createCelular(@RequestBody CelularDTO celularDTO) {
        return celularService.createCelular(celularDTO);
    }

    //Update Celular
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CelularDTO updateCelular(@RequestBody CelularDTO celularDTO) {
        return celularService.updateCelular(celularDTO);
    }

    //Delete Celular
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCelular(@PathVariable Long id) {
        celularService.deleteCelular(id);
    }
}
