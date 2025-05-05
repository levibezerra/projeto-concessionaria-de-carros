package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.Status;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EstoqueDto {

    private Long id;
    private Status status;
    private String modeloDoCarro;
    private LocalDateTime dataDeChegada;
    private LocalDateTime dataDeModificacao;

    @Override
    public String toString() {
        return  "--------------------- \n" +
                "Id = " + id  + "\n" +
                "Status = " + status + "\n" +
                "Modelo = " + modeloDoCarro + "\n" +
                "Data de Chegada = " + dataDeChegada + "\n" +
                "Data de Modificação = " + dataDeModificacao;
    }
}