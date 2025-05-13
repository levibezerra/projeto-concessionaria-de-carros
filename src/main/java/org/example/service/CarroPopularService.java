package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.dao.CarroDao;
import org.example.dao.ClienteDao;
import org.example.dao.EstoqueDao;
import org.example.dao.UsuarioDao;
import org.example.dto.CarroDto;
import org.example.entity.*;
import org.example.enums.Status;

import java.util.List;
import java.util.stream.Collectors;

public class CarroPopularService {

    private EstoqueDao estoqueDao;
    private CarroDao carroDao;
    private EntityManager em;

    public CarroPopularService(EntityManager em) {
        this.em = em;
        this.carroDao = new CarroDao(em);
        this.estoqueDao = new EstoqueDao(em);
    }

    public void adicionarCarro(CarroDto dto) {
        CarroPopular carro = new CarroPopular();
        carro.setId(dto.getId());
        carro.setMarca(dto.getMarca());
        carro.setModelo(dto.getModelo());
        carro.setAno(dto.getAno());
        carro.setPreco(dto.getPreco());
        carro.setCor(dto.getCor());
        carroDao.salvar(carro);

        Estoque estoque = new Estoque();
        estoque.setCarro(carro);
        estoque.setStatus(Status.DISPONIVEL);
        carro.setEstoque(estoque);
        estoqueDao.salvar(estoque);
    }

    public CarroDto buscarCarroPorId(Long id) {
        CarroPopular carro = em.find(CarroPopular.class, id);
        if (carro == null) {
            return null;
        }

        CarroDto dto = new CarroDto();
        dto.setId(carro.getId());
        dto.setMarca(carro.getMarca());
        dto.setModelo(carro.getModelo());
        dto.setAno(carro.getAno());
        dto.setPreco(carro.getPreco());
        dto.setCor(carro.getCor());
        return dto;
    }

    public List<CarroDto> listarCarroPopular() {
        return carroDao.listarTodosPopulares().stream().map(carro -> {
            CarroDto dto = new CarroDto();
            dto.setId(carro.getId());
            dto.setMarca(carro.getMarca());
            dto.setModelo(carro.getModelo());
            dto.setAno(carro.getAno());
            dto.setPreco(carro.getPreco());
            dto.setCor(carro.getCor());
            return dto;
        }).collect(Collectors.toList());
    }

    public void atualizarCarroPopular(Long id, CarroDto dto) {
        Carro carro = carroDao.buscarPorId(id);
        if (carro != null) {
            carro.setPreco(dto.getPreco());
            carroDao.atualizar(carro);
        }
    }

    public void removerDaTabelaPopular(Long id) {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM CarroPopular cp WHERE cp.id = :id")
                .setParameter("id", id)
                .executeUpdate();
        em.getTransaction().commit();
    }

    public void deletarCarroPopular(Long id, CarroDto dto) {
        carroDao.deletar(id);
    }
}