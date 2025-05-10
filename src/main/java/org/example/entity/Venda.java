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
@Table(name = "vendas")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Carro carro;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;

    @OneToOne(mappedBy = "venda", cascade = CascadeType.ALL)
    private Pagamento pagamento;

    @OneToOne
    @JoinColumn(name = "estoque_id")
    private Estoque estoque;

    @Column(name = "data_da_venda", nullable = false)
    private LocalDateTime dataDaVenda;

    @Column(name = "valor_final_da_venda", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorFinalDaVenda;

    @PrePersist
    public void dataDaVendaSalva() {
        this.dataDaVenda = LocalDateTime.now();
    }
}