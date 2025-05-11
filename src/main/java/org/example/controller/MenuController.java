package org.example.controller;

import org.example.entity.Usuario;
import org.example.service.ClienteService;
import org.example.service.UsuarioService;

import java.util.Scanner;

public class MenuController {

//    private final VendaController vendaController;
////    private final AdministradorController administradorController;
////    private final ClienteController clienteController;
//    private final UsuarioController usuarioController;
//    private final EstoqueController estoqueController;
//    private final CarroController carroController;
//
//    public MenuController(ClienteController clienteController, UsuarioController usuarioController, EstoqueController estoqueController,
//                           CarroController carroController, AdministradorController administradorController, VendaController vendaController) {
////        this.clienteController = clienteController;
//        this.usuarioController = usuarioController;
//        this.estoqueController = estoqueController;
//        this.carroController = carroController;
////        this.administradorController = administradorController;
//        this.vendaController = vendaController;
//    }
//
//    public void menu() {
//        boolean cont = true;
//        Scanner input = new Scanner(System.in);
//
//        while (cont) {
//
//            System.out.println("----Tela Inicial----");
//            System.out.println("1 - Cadastre-se \n" +
//                               "2 - Realizar Login \n" +
//                               "3 - Adicionar Carro \n" +
//                               "4 - Buscar Carro \n" +
//                               "5 - Listar Carros por tipo \n" +
//                               "6 - Atualizar Carro \n" +
//                               "7 - Deletar Carro \n" +
//                               "8 - Buscar Cliente: \n" +
//                               "9 - Listar todos Clientes \n" +
//                               "10 - Atualizar Cliente \n" +
//                               "11 - Deletar Cliente \n" +
//                               "12 - Cadastrar Administrador \n" +
//                               "13 - Realizar uma Venda \n" +
//                               "14 - Listar Estoque \n" +
//                               "0 - Sair");
//
//            System.out.println("Informe uma opcao: ");
//            String opcao = input.nextLine();
//
//            switch (opcao) {
//                case "1":
////                    clienteController.cadastrar();
//                    break;
//                case "2":
//                    usuarioController.realizarLogin();
//                    break;
//                case "3":
//                    estoqueController.adicionarCarroNoEstoque();
//                    break;
//                case "4":
//                    carroController.buscarCarroId();
//                    break;
//                case "5":
//                    carroController.listarCarros();
//                    break;
//                case "6":
//                    carroController.atualizarCarro();
//                    break;
//                case "7":
//                    carroController.deletarCarro();
//                    break;
//                case "8":
//                    clienteController.buscarClientePorId();
//                    break;
//                case "9":
//                    clienteController.listarTodosClientes();
//                    break;
//                case "10":
//                    clienteController.atualizarCliente();
//                    break;
//                case "11":
//                    clienteController.deletarCliente();
//                    break;
//                case "12":
////                    administradorController.cadastrarAdmin();
//                    break;
//                case "13":
//                    vendaController.realizarVendaCarro();
//                    break;
//                case "14":
//                    estoqueController.listarEstoque();
//                    break;
//                case "0":
//                    cont = false;
//                    break;
//            }
//        }
//    }
}