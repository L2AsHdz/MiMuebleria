package com.ayd2.mimuebleria.dto.part;

import lombok.Value;

@Value
public class RequestPartUpdateDTO {
    private String nombre;
    private double precioUnidad;
    private int existencias;
    private int minimoExistencias;
    private boolean estado;
}
