package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entity.Venda;
import org.example.enums.FormaDePagamento;
import org.example.enums.StatusDoPagamento;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PagamentoDto {

    private Long id;
    private Venda venda;
    private LocalDateTime dataDoPagamento;
    private StatusDoPagamento statusDoPagamento;
    private FormaDePagamento formaDePagamento;
}