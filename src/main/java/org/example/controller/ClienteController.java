package org.example.controller;

import org.example.dto.ClienteDto;
import org.example.entity.Cliente;
import org.example.entity.Usuario;
import org.example.service.ClienteService;

import java.util.List;
import java.util.Scanner;

public class ClienteController {

    private final ClienteService clienteService;
    Scanner input = new Scanner(System.in);

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void cadastrar(ClienteDto dto) throws IllegalArgumentException{
//        ClienteDto dto = new ClienteDto();
//
////        System.out.println("Nome: ");
////        dto.setNome(input.nextLine());
////        System.out.println("CPF: ");
////        dto.setCpf(input.nextLine());
////        System.out.println("Endereço: ");
////        dto.setEndereco(input.nextLine());
////        System.out.println("Telefone: ");
////        dto.setTelefone(input.nextLine());
////        System.out.println("Email: ");
////        dto.setEmail(input.nextLine());
////        System.out.println("Senha: ");
////        dto.setPassword(input.nextLine());

        clienteService.cadastrarCliente(dto);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public ClienteDto buscarClientePorId(Long id) {
//        ClienteDto dto = new ClienteDto();
//        System.out.println("Informe o ID do Cliente: ");
//        Long id = Long.parseLong(input.nextLine());
//        System.out.println(dto.toString());
        return clienteService.buscarClientePorId(id);
    }

    public List<ClienteDto> listarTodosClientes() {
        return clienteService.listarClientes();
    }

    public void atualizarCliente(Long id, ClienteDto dto) {

        ClienteDto cliente = clienteService.buscarClientePorId(id);

        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        cliente.setEndereco(dto.getEndereco());
        cliente.setTelefone(dto.getTelefone());
        cliente.setEmail(dto.getEmail());
        cliente.setPassword(dto.getPassword());

        clienteService.atualizarCliente(id, cliente);

//        ClienteDto dto = new ClienteDto();
//        System.out.println("Informe o ID do Cliente: ");
//        Long id = Long.parseLong(input.nextLine());
//
//        System.out.println("Digite o novo NOME do Cliente: ");
//        String nome = input.nextLine();
//        dto.setEndereco(nome);
//        clienteService.atualizarCliente(id, dto);
//
//        System.out.println("Digite o novo ENDEREÇO do Cliente: ");
//        String endereco = input.nextLine();
//        dto.setEndereco(endereco);
//        clienteService.atualizarCliente(id, dto);
//
//        System.out.println("Digite o novo número de TELEFONE do Cliente: ");
//        String telefone = input.nextLine();
//        dto.setTelefone(telefone);
//        clienteService.atualizarCliente(id, dto);
//
//        System.out.println("Digite o novo EMAIL do Cliente: ");
//        String email = input.nextLine();
//        dto.setEmail(email);
//        clienteService.atualizarCliente(id, dto);
//
//        System.out.println("Digite a nova SENHA do Cliente: ");
//        String senha = input.nextLine();
//        dto.setPassword(senha);
//        clienteService.atualizarCliente(id, dto);

        System.out.println("Cliente atualizado com sucesso!");
    }

    public void deletarCliente(Long id) {
        ClienteDto cliente = clienteService.buscarClientePorId(id);

        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        clienteService.deletarCliente(id);
//        System.out.println("Informe o ID do Cliente para deletar: ");
//        Long id = Long.parseLong(input.nextLine());
//        clienteService.deletarCliente(id);
//        System.out.println("Cliente deletado com sucesso!");
    }
}