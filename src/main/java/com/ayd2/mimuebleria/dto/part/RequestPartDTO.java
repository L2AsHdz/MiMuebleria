package com.ayd2.mimuebleria.dto.part;

import lombok.Value;

@Value
public class RequestPartDTO {
    private String nombre;
    private double precioUnidad;
    private int existencias;
    private int minimoExistencias;
}
