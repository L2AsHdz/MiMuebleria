package com.ayd2.mimuebleria.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Piece")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @Builder
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long pieceId;

    @Column
    private String name;

    @Column
    private double unitPrice;

    @Column
    private int minimumStock;

    @Column
    private boolean state;

}
