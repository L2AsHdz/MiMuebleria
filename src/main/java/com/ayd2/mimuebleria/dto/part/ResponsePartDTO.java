package com.ayd2.mimuebleria.dto.part;

import com.ayd2.mimuebleria.model.Part;
import lombok.Value;

@Value
public class ResponsePartDTO {
    private Long idPieza;
    private String nombre;
    private double precioUnidad;
    private int existencias;
    private int minimoExistencias;

    public ResponsePartDTO(Part partEntity){
        this.idPieza = partEntity.getIdPieza();
        this.nombre = partEntity.getNombre();
        this.precioUnidad = partEntity.getPrecioUnidad();
        this.existencias = partEntity.getExistencias();
        this.minimoExistencias = partEntity.getMinimoExitencias();
    }
}
