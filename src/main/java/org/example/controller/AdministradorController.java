package org.example.controller;

import org.example.dto.AdministradorDto;
import org.example.service.AdministradorService;

import java.util.Scanner;

public class AdministradorController {

    private final AdministradorService administradorService;
    Scanner input = new Scanner(System.in);

    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    public void cadastrarAdmin(AdministradorDto dto) throws IllegalArgumentException {
        administradorService.cadastrarAdmin(dto);
        System.out.println("Administrador cadastrado com sucesso!");
    }
}