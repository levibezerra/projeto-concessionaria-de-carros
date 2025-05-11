package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.dao.AdministradorDao;
import org.example.dao.ClienteDao;
import org.example.dao.UsuarioDao;
import org.example.dto.UsuarioDto;
import org.example.entity.Administrador;
import org.example.entity.Cliente;
import org.example.entity.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioService {

    private UsuarioDao usuarioDao;
    private EntityManager em;
    private AdministradorDao administradorDao;
    private ClienteDao clienteDao;

    public UsuarioService(EntityManager em) {
        this.em = em;
        this.usuarioDao = new UsuarioDao(em);
        this.administradorDao = new AdministradorDao(em);
        this.clienteDao = new ClienteDao(em);
    }

    public void cadastrarUsuario(UsuarioDto dto) {
        Usuario usuario = new Usuario();
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());
        usuarioDao.salvar(usuario);
    }

    public UsuarioDto buscarUsuarioPorId(Long id) {
        Usuario usuario = usuarioDao.buscarPorId(id);
        if (usuario == null) {
            return null;
        }

        UsuarioDto dto = new UsuarioDto();
        dto.setId(usuario.getId());
        dto.setPassword(usuario.getPassword());
        dto.setPassword(usuario.getPassword());
        dto.setPerfil(usuario.getPerfil());
        return dto;
    }

    public List<UsuarioDto> listarUsuarios() {
        return usuarioDao.listarTodos().stream().map(usuario -> {
            UsuarioDto dto = new UsuarioDto();
            dto.setId(usuario.getId());
            dto.setPassword(usuario.getPassword());
            dto.setPassword(usuario.getPassword());
            dto.setPerfil(usuario.getPerfil());
            return dto;
        }).collect(Collectors.toList());
    }

    public void atualizarUsuario(Long id, UsuarioDto dto) {
        Usuario usuario = usuarioDao.buscarPorId(id);
        if (usuario != null) {
            usuario.setId(dto.getId());
            usuario.setPassword(dto.getPassword());
            usuario.setPassword(dto.getPassword());
            usuario.setPerfil(dto.getPerfil());
            usuarioDao.atualizar(usuario);
        }
    }

    public void deletarUsuario(Long id) {
        usuarioDao.deletar(id);
    }

    public Usuario login(UsuarioDto dto){
        Usuario usuario = usuarioDao.buscarPorEmailSenha(dto.getEmail(), dto.getPassword());
        return usuario;
    }

    public Object verificarLogin(UsuarioDto dto){
        if (dto.getEmail() == null || dto.getEmail().isBlank() || dto.getPassword() == null || dto.getPassword().isBlank()) {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos!");
        }

        Administrador admin = administradorDao.buscarPorEmailESenha(dto.getEmail(), dto.getPassword());
        if (admin != null) {
            return admin;
        }

        Cliente cliente = clienteDao.buscarPorEmailESenha(dto.getEmail(), dto.getPassword());
        if (cliente != null) {
            return cliente;
        }
        throw new IllegalArgumentException("Email ou senha inválidos!");
    }
}