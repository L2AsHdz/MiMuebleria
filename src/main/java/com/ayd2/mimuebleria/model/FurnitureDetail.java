package com.ayd2.mimuebleria.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "FurnitureDetail")
@AllArgsConstructor
@NoArgsConstructor
@Getter  @Setter @Builder
public class FurnitureDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "furnitureDetailId", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pieceId")
    private Piece piece;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "furnitureId", nullable = false)
    private Furniture furniture;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

}