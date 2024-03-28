package com.ayd2.mimuebleria.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

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

    @OneToMany(mappedBy = "assembly",  cascade = CascadeType.ALL)
    @JsonManagedReference(value = "assemblyDetails")
    private Set<AssemblyDetail> assemblyDetails = new LinkedHashSet<>();

    @OneToMany(mappedBy = "assembly")
    @JsonBackReference(value = "assembly")
    private Set<Furniture> furnitures = new LinkedHashSet<>();
    public void initializeData(){
        Hibernate.initialize(assemblyDetails);

        for( AssemblyDetail detail : this.assemblyDetails){
            detail.initialize();
        }
    }

}
