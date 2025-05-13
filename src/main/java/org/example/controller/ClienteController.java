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
        clienteService.cadastrarCliente(dto);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public ClienteDto buscarClientePorId(Long id) {
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
        System.out.println("Cliente atualizado com sucesso!");
    }

    public void deletarCliente(Long id) {
        ClienteDto cliente = clienteService.buscarClientePorId(id);
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }
        clienteService.deletarCliente(id);
    }
}