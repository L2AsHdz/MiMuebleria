package com.ayd2.mimuebleria.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "PieceInventory")
@AllArgsConstructor
@NoArgsConstructor
@Getter  @Setter @Builder
public class PieceInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pieceInventoryId", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pieceId")
    private Piece piece;


    @Column(name = "cost", nullable = false)
    private Double cost;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

}