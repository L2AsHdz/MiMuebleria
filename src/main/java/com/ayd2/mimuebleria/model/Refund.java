package com.ayd2.mimuebleria.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name = "Refund")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString @Builder
public class Refund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "refundId", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoiceDetailId")
    private InvoiceDetail invoiceDetail;

    @Column(name = "description", nullable = false, length = 60)
    private String description;

    @Column(name = "refundDate", nullable = false)
    private LocalDate refundDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(name = "loss", nullable = false)
    private Double loss;

}