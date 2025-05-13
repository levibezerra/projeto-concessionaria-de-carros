package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor

@Entity
@Table(name = "carro_vendido")
public class CarroVendido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marca", nullable = false, length = 60)
    private String marca;

    @Column(name = "modelo", nullable = false, length = 60)
    private String modelo;

    @Column(name = "ano", nullable = false, length = 4)
    private int ano;

    @Column(name = "preco", precision = 10, scale = 2, nullable = false)
    private BigDecimal preco;

    @Column(name = "cor", length = 30)
    private String cor;

    @Column(name = "data_de_saida", nullable = false)
    private LocalDateTime dataDeSaida;

    @Transient
    private Carro carro;

    @PrePersist
    public void onCreate() {
        this.dataDeSaida = LocalDateTime.now();
    }
}