package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.entity.Estoque;

import java.util.ArrayList;
import java.util.List;

public class EstoqueDao {

    private EntityManager entityManager;

    public EstoqueDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvar(Estoque estoque) {
        entityManager.getTransaction().begin();
        entityManager.persist(estoque);
        entityManager.getTransaction().commit();
    }

    public List<Estoque> listarCarrosNoEstoque() {
        List<Estoque> estoque = new ArrayList<>();
        estoque.addAll(entityManager.createQuery("SELECT e FROM estoque e", Estoque.class).getResultList());
        return estoque;
    }
}