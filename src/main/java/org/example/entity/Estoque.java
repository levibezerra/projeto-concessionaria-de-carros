package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.Status;

import java.time.LocalDateTime;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor

@Entity
@Table(name = "estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_de_chegada")
    private LocalDateTime dataDeChegada;

    @Column(name = "data_de_modificacao")
    private LocalDateTime dataDeModificacao;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    private Carro carro;

    @PrePersist
    public void onCreate() {
        this.dataDeChegada = LocalDateTime.now();
        this.dataDeModificacao = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.dataDeModificacao = LocalDateTime.now();
    }
}