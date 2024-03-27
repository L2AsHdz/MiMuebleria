package com.ayd2.mimuebleria.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.ayd2.mimuebleria.model.AssemblyDetail}
 */
@Value
public class AssemblyDetailDto implements Serializable {
    PieceDto piece;
    Integer quantity;
}