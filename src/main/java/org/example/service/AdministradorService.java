package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.dao.AdministradorDao;
import org.example.dto.AdministradorDto;
import org.example.entity.Administrador;
import org.example.enums.Perfil;

import java.util.List;
import java.util.stream.Collectors;

public class AdministradorService {

    private AdministradorDao adminDao;
    private EntityManager em;

    public AdministradorService(EntityManager em) {
        this.em = em;
        this.adminDao = new AdministradorDao(em);
    }

    public void cadastrarAdmin(AdministradorDto dto) throws IllegalArgumentException{

        if (validarCadastroAdmin(dto.getNome()) || validarCadastroAdmin(dto.getCpf()) || validarCadastroAdmin(dto.getEndereco()) ||
                validarCadastroAdmin(dto.getTelefone()) || validarCadastroAdmin(dto.getEmail()) || validarCadastroAdmin(dto.getPassword())) {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos!");
        }

        Administrador admin = new Administrador();
        admin.setNome(dto.getNome());
        admin.setCpf(dto.getCpf());
        admin.setEndereco(dto.getEndereco());
        admin.setTelefone(dto.getTelefone());
        admin.setEmail(dto.getEmail());
        admin.setPassword(dto.getPassword());
        admin.setPerfil(Perfil.ADMIN);
        adminDao.salvar(admin);
    }

    public AdministradorDto buscarAdminPorId(Long id) {
        Administrador admin = adminDao.buscarPorId(id);
        if (admin == null) {
            return null;
        }

        AdministradorDto dto = new AdministradorDto();
        dto.setId(admin.getId());
        dto.setNome(admin.getNome());
        dto.setCpf(admin.getCpf());
        dto.setEndereco(admin.getEndereco());
        dto.setTelefone(admin.getTelefone());
        dto.setEmail(admin.getEmail());
        dto.setPassword(admin.getPassword());
        return dto;
    }

    public List<AdministradorDto> listarAdmin() {
        return adminDao.listarTodos().stream().map(admin -> {
            AdministradorDto dto = new AdministradorDto();
            dto.setId(admin.getId());
            dto.setNome(admin.getNome());
            dto.setCpf(admin.getCpf());
            dto.setEndereco(admin.getEndereco());
            dto.setTelefone(admin.getTelefone());
            dto.setEmail(admin.getEmail());
            dto.setPassword(admin.getPassword());
            return dto;
        }).collect(Collectors.toList());
    }

    public void atualizarAdmin(Long id, AdministradorDto dto) {
        Administrador admin = adminDao.buscarPorId(id);
        if (admin != null) {
            admin.setNome(dto.getNome());
            admin.setCpf(dto.getCpf());
            admin.setEndereco(dto.getEndereco());
            admin.setTelefone(dto.getTelefone());
            admin.setEmail(dto.getEmail());
            admin.setPassword(dto.getPassword());
            adminDao.atualizar(admin);
        }
    }

    public void deletarAdmin(Long id) {
        adminDao.deletar(id);
    }

    private boolean validarCadastroAdmin(String valor) {
        return valor == null || valor.trim().isEmpty();
    }
}