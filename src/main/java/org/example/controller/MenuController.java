package org.example.controller;

import org.example.entity.Usuario;
import org.example.service.ClienteService;
import org.example.service.UsuarioService;

import java.util.Scanner;

public class MenuController {

    private final ClienteController clienteController;
    private final UsuarioController usuarioController;
    private final EstoqueController estoqueController;
    private final CarroController carroController;

    public MenuController(ClienteController clienteController, UsuarioController usuarioController, EstoqueController estoqueController,
                           CarroController carroController) {
        this.clienteController = clienteController;
        this.usuarioController = usuarioController;
        this.estoqueController = estoqueController;
        this.carroController = carroController;
    }

    public void menu() {
        boolean cont = true;
        Scanner input = new Scanner(System.in);

        while (cont) {

            System.out.println("----Tela Inicial----");
            System.out.println("1 - Cadastre-se \n" +
                               "2 - Realizar Login \n" +
                               "3 - Adicionar Carro \n" +
                               "4 - Buscar carro \n" +
                               "5 - Listar carros por tipo \n" +
                               "6 - Atualizar carro \n" +
                               "7 - Deletar carro \n" +
                               "0 - Sair");

            System.out.println("Informe uma opcao: ");
            String opcao = input.nextLine();

            switch (opcao) {
                case "1":
                    clienteController.cadastrar();
                    break;
                case "2":
                    usuarioController.realizarLogin();
                    break;
                case "3":
                    estoqueController.adicionarCarroNoEstoque();
                    break;
                case "4":
                    carroController.buscarCarroId();
                    break;
                case "5":
                    carroController.listarCarros();
                    break;
                case "6":
                    carroController.atualizarCarro();
                    break;
                case "7":
                    carroController.deletarCarro();
                    break;
                case "0":
                    cont = false;
                    break;
            }
        }
    }
}