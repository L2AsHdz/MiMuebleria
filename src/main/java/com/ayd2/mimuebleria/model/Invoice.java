package com.ayd2.mimuebleria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Invoice", schema = "myfurnituredb")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoiceId", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nit")
    private Client nit;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sellingUserId", nullable = false)
    private User sellingUser;

    @Column(name = "saleDate", nullable = false)
    private Instant saleDate;

    @OneToMany(mappedBy = "invoice")
    private Set<InvoiceDetail> invoiceDetails = new LinkedHashSet<>();

}