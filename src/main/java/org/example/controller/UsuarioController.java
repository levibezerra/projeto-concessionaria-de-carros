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

    public void realizarLogin(UsuarioDto dto) {
        usuarioService.login(dto);
        System.out.println("Login realizado!");
    }

    public Object login(UsuarioDto dto) throws IllegalArgumentException{
        return usuarioService.verificarLogin(dto);
    }
}