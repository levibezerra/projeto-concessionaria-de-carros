package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CarroVendidoDto {

    private Long id;
    private String marca;
    private String modelo;
    private int ano;
    private BigDecimal preco;
    private String cor;
    private Long idCarro;
}