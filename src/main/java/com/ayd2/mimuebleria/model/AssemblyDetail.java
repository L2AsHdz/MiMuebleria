package com.ayd2.mimuebleria.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "AssemblyDetail")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString @Builder
public class AssemblyDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assemblyDetailId", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pieceId")
    private Piece piece;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "assemblyId", nullable = false)
    private Assembly assembly;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

}