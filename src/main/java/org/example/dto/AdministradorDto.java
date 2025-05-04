package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AdministradorDto {

    private Long id;
    private String nome;
    private String email;
    private String password;

    @Override
    public String toString() {
        return  "--------------------- \n" +
                "Id = " + id  + "\n" +
                "Nome = " + nome + "\n" +
                "Email = " + email + "\n" +
                "Senha = " + password;
    }
}