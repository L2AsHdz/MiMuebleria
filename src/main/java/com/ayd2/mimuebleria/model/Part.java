package com.ayd2.mimuebleria.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Pieza")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @Builder
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idPieza;

    @Column
    private String nombre;

    @Column
    private double precioUnidad;

    @Column
    private int existencias;

    @Column
    private int minimoExitencias;

}
