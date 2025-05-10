package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.example.entity.Carro;
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
        estoque.addAll(entityManager.createQuery("SELECT e FROM Estoque e JOIN FETCH e.carro", Estoque.class).getResultList());
        return estoque;
    }

    public Estoque buscarCarroNoEstoquePorId(Long id) {
        try {
            return entityManager.createQuery(
                    "SELECT e FROM Estoque e WHERE e.carro.id = :id", Estoque.class)
                    .setParameter("id", id)
                    .getSingleResult();

        } catch (NoResultException e) {
            return null;
        }
    }

    public void atualizar(Estoque estoque) {
        entityManager.getTransaction().begin();
        entityManager.merge(estoque);
        entityManager.getTransaction().commit();
    }
}