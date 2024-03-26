package com.ayd2.mimuebleria.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Assembly")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString @Builder
public class Assembly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assemblyId", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @Column(name = "instructions", nullable = false, length = 1000)
    private String instructions;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    @OneToMany(mappedBy = "assembly")
    private Set<AssemblyDetail> assemblyDetails = new LinkedHashSet<>();

    @OneToMany(mappedBy = "assembly")
    private Set<Furniture> furnitures = new LinkedHashSet<>();

}
