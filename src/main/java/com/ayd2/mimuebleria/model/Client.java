package com.ayd2.mimuebleria.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Client")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString @Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nit", nullable = false, length = 15)
    private String nit;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "phone", nullable = false, length = 10)
    private String phone;

    @OneToMany(mappedBy = "nit")
    private Set<Invoice> invoices = new LinkedHashSet<>();

}
