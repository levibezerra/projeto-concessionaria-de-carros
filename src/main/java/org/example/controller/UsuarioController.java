package org.example.controller;

import org.example.dto.UsuarioDto;
import org.example.service.UsuarioService;

import java.util.Scanner;

public class UsuarioController {

    private UsuarioService usuarioService;
    Scanner input = new Scanner(System.in);

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void realizarLogin() {
        UsuarioDto dto = new UsuarioDto();

        System.out.println("Email: ");
        dto.setEmail(input.nextLine());
        System.out.println("Senha: ");
        dto.setPassword(input.nextLine());

        System.out.println("Login realizado!" + usuarioService.login(dto).toString());
    }
}