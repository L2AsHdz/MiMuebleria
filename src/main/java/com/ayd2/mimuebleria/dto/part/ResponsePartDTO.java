package com.ayd2.mimuebleria.dto.part;

import com.ayd2.mimuebleria.model.Piece;
import lombok.Value;

@Value
public class ResponsePartDTO {
    private Long pieceId;
    private String name;
    private double unitPrice;
    private int miniumStock;
    private boolean state;

    public ResponsePartDTO(Piece partEntity){
        this.pieceId = partEntity.getId();
        this.name = partEntity.getName();
        this.unitPrice = partEntity.getUnitPrice();
        this.miniumStock = partEntity.getMinimumStock();
        this.state = partEntity.isState();
    }
}
