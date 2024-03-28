package com.ayd2.mimuebleria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Piece")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString @Builder
public class Piece {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pieceId", nullable = false)
    private Long id;

    @Column(name = "name", length = 60)
    private String name;

    @Column(name = "unitPrice", nullable = false)
    private Double unitPrice;

    @Column(name = "minimumStock", nullable = false)
    private Integer minimumStock;

    @OneToMany(mappedBy = "piece", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "assemblyPiece")
    private Set<AssemblyDetail> assemblyDetails = new LinkedHashSet<>();

    @OneToMany(mappedBy = "piece")
    @JsonIgnore
    private Set<FurnitureDetail> furnitureDetails = new LinkedHashSet<>();

    @OneToMany(mappedBy = "piece")
    @JsonIgnore
    private Set<PieceInventory> pieceInventories = new LinkedHashSet<>();


    public void initializeData(){
        Hibernate.initialize(assemblyDetails);
        for( AssemblyDetail detail : this.assemblyDetails){
            detail.initialize();
        }
    }
}
