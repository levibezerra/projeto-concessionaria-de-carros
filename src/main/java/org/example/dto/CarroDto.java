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

public class CarroDto {

    private Long id;
    private String marca;
    private String modelo;
    private int ano;
    private BigDecimal preco;
    private String cor;

    @Override
    public String toString() {
        return  "--------------------- \n" +
                "Id = " + id  + "\n" +
                "Marca = " + marca + "\n" +
                "Modelo = " + modelo + "\n" +
                "Ano = " + ano + "\n" +
                "Preço = " + preco + "\n" +
                "Cor = " + cor;
    }
}