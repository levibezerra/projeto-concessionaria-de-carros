package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.dao.ClienteDao;
import org.example.dao.UsuarioDao;
import org.example.dto.ClienteDto;
import org.example.entity.Cliente;
import org.example.entity.Usuario;
import org.example.enums.Perfil;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteService {

    private UsuarioDao usuarioDao;
    private ClienteDao clienteDao;
    private EntityManager em;

    public ClienteService(EntityManager em) {
        this.em = em;
        this.clienteDao = new ClienteDao(em);
        this.usuarioDao = new UsuarioDao(em);
    }

    public void cadastrarCliente(ClienteDto dto) throws IllegalArgumentException{
        if (validarCadastroCliente(dto.getNome()) || validarCadastroCliente(dto.getCpf()) || validarCadastroCliente(dto.getEndereco()) ||
                validarCadastroCliente(dto.getTelefone()) || validarCadastroCliente(dto.getEmail()) || validarCadastroCliente(dto.getPassword())) {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos!");
        }

        if (usuarioDao.buscarPorEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado.");
        }

        if (clienteDao.buscarPorCpf(dto.getCpf()).isPresent()) {
            throw new RuntimeException("CPF já cadastrado.");
        }

        Usuario usuario = new Usuario();
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());
        usuario.setPerfil(Perfil.CLIENTE);
        usuarioDao.salvar(usuario);

        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        cliente.setEndereco(dto.getEndereco());
        cliente.setTelefone(dto.getTelefone());
        cliente.setEmail(dto.getEmail());
        cliente.setPassword(dto.getPassword());
        cliente.setUsuario(usuario);
        clienteDao.salvar(cliente);
    }

    public ClienteDto buscarClientePorId(Long id) {
        Cliente cliente = clienteDao.buscarPorId(id);
        if (cliente == null) {
            return null;
        }

        ClienteDto dto = new ClienteDto();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setCpf(cliente.getCpf());
        dto.setEndereco(cliente.getEndereco());
        dto.setTelefone(cliente.getTelefone());
        dto.setEmail(cliente.getEmail());
        dto.setPassword(cliente.getPassword());
        return dto;
    }

    public List<ClienteDto> listarClientes() {
        return clienteDao.listarTodos().stream().map(cliente -> {
            ClienteDto dto = new ClienteDto();
            dto.setId(cliente.getId());
            dto.setNome(cliente.getNome());
            dto.setCpf(cliente.getCpf());
            dto.setEndereco(cliente.getEndereco());
            dto.setTelefone(cliente.getTelefone());
            dto.setEmail(cliente.getEmail());
            dto.setPassword(cliente.getPassword());
            return dto;
        }).collect(Collectors.toList());
    }

    public void atualizarCliente(Long id, ClienteDto dto) {
        Cliente cliente = clienteDao.buscarPorId(id);
        if (cliente != null) {
            cliente.setNome(dto.getNome());
            cliente.setEndereco(dto.getEndereco());
            cliente.setTelefone(dto.getTelefone());
            cliente.setEmail(dto.getEmail());
            cliente.setPassword(dto.getPassword());
            clienteDao.atualizar(cliente);
        }
    }

    public void deletarCliente(Long id) {
        clienteDao.deletar(id);
    }

    private boolean validarCadastroCliente(String valor) {
        return valor == null || valor.trim().isEmpty();
    }
}