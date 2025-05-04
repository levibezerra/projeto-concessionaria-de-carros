package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.enums.Perfil;

import java.time.LocalDateTime;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 200)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "perfil", nullable = false, length = 25)
    private Perfil perfil;

    @OneToOne
    private Cliente cliente;

    @Column(name = "data_de_criacao")
    private LocalDateTime dataDeCriacao;

    @Column(name = "data_de_modificacao")
    private LocalDateTime dataDeModificacao;

    @PrePersist
    public void onCreate() {
        this.dataDeCriacao = LocalDateTime.now();
        this.dataDeModificacao = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.dataDeModificacao = LocalDateTime.now();
    }
}