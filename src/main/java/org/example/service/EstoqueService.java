package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.dao.CarroDao;
import org.example.dao.EstoqueDao;
import org.example.dto.CarroDto;
import org.example.dto.EstoqueDto;
import org.example.entity.Carro;
import org.example.entity.CarroEsportivo;
import org.example.entity.CarroPopular;
import org.example.entity.Estoque;
import org.example.enums.Status;

import java.util.List;
import java.util.stream.Collectors;

public class EstoqueService {

    private EntityManager em;
    private final EstoqueDao estoqueDao;

    public EstoqueService(EntityManager em) {
        this.em = em;
        this.estoqueDao = new EstoqueDao(em);
    }

    public void adicionarCarroAoEstoque(EstoqueDto dto) {
        Estoque estoque = new Estoque();
        estoque.setStatus(dto.getStatus());
        estoqueDao.salvar(estoque);
    }

    public List<EstoqueDto> listarInfoEstoque() {
        return estoqueDao.listarCarrosNoEstoque().stream().map(estoque -> {
            EstoqueDto dto = new EstoqueDto();
            dto.setId(estoque.getId());
            dto.setStatus(estoque.getStatus());
            dto.setDataDeChegada(estoque.getDataDeChegada());
            dto.setDataDeModificacao(estoque.getDataDeModificacao());

            if (estoque.getCarro() != null) {
                dto.setMarcaDoCarro(estoque.getCarro().getMarca());
                dto.setModeloDoCarro(estoque.getCarro().getModelo());
            } else {
                dto.setMarcaDoCarro("");
                dto.setModeloDoCarro("Carro não associado!");
            }
            return dto;
        }).collect(Collectors.toList());
    }
}