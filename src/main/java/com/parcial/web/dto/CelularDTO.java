package com.parcial.web.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CelularDTO {
    private Long id;
    private String marca;
    private LocalDateTime fechaDeCompra;
    private LocalDateTime anoLanzamiento;
    private Double precio;
    private String sistemaOperativo;
    private String gama;
}
