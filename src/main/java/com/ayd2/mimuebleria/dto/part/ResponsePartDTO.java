package com.ayd2.mimuebleria.dto.part;

import com.ayd2.mimuebleria.model.Part;
import com.ayd2.mimuebleria.model.Piece;
import lombok.Value;

@Value
public class ResponsePartDTO {
    private Long idPieza;
    private String nombre;
    private double precioUnidad;
    private int minimoExistencias;
    private boolean estado;

    public ResponsePartDTO(Piece partEntity){
        this.idPieza = partEntity.getId();
        this.nombre = partEntity.getName();
        this.precioUnidad = partEntity.getUnitPrice();
        this.minimoExistencias = partEntity.getMinimumStock();
        this.estado = partEntity.isState();
    }
}
