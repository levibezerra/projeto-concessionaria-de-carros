package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "cpf", nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(name = "endereco", length = 200, nullable = false)
    private String endereco;

    @Column(name = "telefone", length = 20, nullable = false)
    private String telefone;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 200)
    private String password;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

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