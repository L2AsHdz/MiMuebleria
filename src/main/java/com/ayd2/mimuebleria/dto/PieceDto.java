package com.ayd2.mimuebleria.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.ayd2.mimuebleria.model.Piece}
 */
@Value
public class PieceDto implements Serializable {
    Long id;
    String name;
}