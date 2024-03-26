package com.ayd2.mimuebleria.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table(name = "Furniture")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString @Builder
public class Furniture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "furnitureId", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assemblyId")
    private Assembly assembly;

    @Column(name = "assemblyDate", nullable = false)
    private Instant assemblyDate;

    @Column(name = "sellingPrice", nullable = false)
    private Double sellingPrice;

    @Column(name = "assemblyCost", nullable = false)
    private Double assemblyCost;

    @Column(name = "status")
    private Boolean status;

    @OneToMany(mappedBy = "furniture")
    private Set<FurnitureDetail> furnitureDetails = new LinkedHashSet<>();

    @OneToMany(mappedBy = "furniture")
    private Set<InvoiceDetail> invoiceDetails = new LinkedHashSet<>();

}