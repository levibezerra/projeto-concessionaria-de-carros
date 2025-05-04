package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.entity.Venda;

import java.util.List;

public class VendaDao {

    private EntityManager entityManager;

    public VendaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvar(Venda venda) {
        entityManager.getTransaction().begin();
        entityManager.persist(venda);
        entityManager.getTransaction().commit();
    }

    public List<Venda> listarVendas() {
        TypedQuery<Venda> vendaTypedQuery = entityManager.createQuery("SELECT V FROM Venda v", Venda.class);
        return vendaTypedQuery.getResultList();
    }

    public Venda buscarVendaPorId(Long id) {
        return entityManager.find(Venda.class, id);
    }
}