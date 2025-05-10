package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.FormaDePagamento;
import org.example.enums.StatusDoPagamento;

import java.time.LocalDateTime;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor

@Entity
@Table(name = "pagamentos")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "venda_id", nullable = false)
    private Venda venda;

    @Column(name = "data_do_pagamento", nullable = false)
    private LocalDateTime dataDoPagamento;

    @Enumerated(EnumType.STRING)
    private StatusDoPagamento statusDoPagamento;

    @Enumerated(EnumType.STRING)
    private FormaDePagamento formaDePagamento;

    @PrePersist
    public void onCreate() {
        this.dataDoPagamento = LocalDateTime.now();
    }
}