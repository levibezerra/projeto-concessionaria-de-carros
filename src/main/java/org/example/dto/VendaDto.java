package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entity.Carro;
import org.example.entity.Cliente;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class VendaDto {

    private Long id;
    private Carro carro;
    private Cliente cliente;
    private LocalDateTime dataDaVenda;
    private BigDecimal valorFinalDaVenda;
}