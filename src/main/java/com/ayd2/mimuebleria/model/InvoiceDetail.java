package com.ayd2.mimuebleria.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table(name = "InvoiceDetail")
@AllArgsConstructor
@NoArgsConstructor
@Getter  @Setter @Builder
public class InvoiceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoiceDetailId", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "furnitureId")
    private Furniture furniture;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "invoiceId", nullable = false)
    private Invoice invoice;

    @OneToMany(mappedBy = "invoiceDetail")
    private Set<Refund> refunds = new LinkedHashSet<>();

}