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
//        AdministradorDto dto = new AdministradorDto();
//
//        System.out.println("Nome: ");
//        dto.setNome(input.nextLine());
//        System.out.println("CPF: ");
//        dto.setCpf(input.nextLine());
//        System.out.println("Endereço: ");
//        dto.setEndereco(input.nextLine());
//        System.out.println("Telefone: ");
//        dto.setTelefone(input.nextLine());
//        System.out.println("Email: ");
//        dto.setEmail(input.nextLine());
//        System.out.println("Senha: ");
//        dto.setPassword(input.nextLine());

        administradorService.cadastrarAdmin(dto);
        System.out.println("Administrador cadastrado com sucesso!");
    }
}