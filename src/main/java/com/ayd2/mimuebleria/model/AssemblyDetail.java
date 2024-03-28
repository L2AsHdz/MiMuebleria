package com.ayd2.mimuebleria.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;


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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pieceId")
    @JsonBackReference(value = "assemblyPiece")
    private Piece piece;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "assemblyId", nullable = false)
    @JsonBackReference(value = "assemblyDetails")
    private Assembly assembly;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    public void initialize(){
        Hibernate.initialize(this.piece);
    }
}