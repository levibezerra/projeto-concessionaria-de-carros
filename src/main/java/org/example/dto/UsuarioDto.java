package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.Perfil;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioDto {

    private Long id;
    private String email;
    private String password;
    private Perfil perfil;
}