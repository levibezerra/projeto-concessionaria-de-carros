package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.entity.Pagamento;

import java.util.List;

public class PagamentoDao {

    private EntityManager entityManager;

    public PagamentoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvar(Pagamento pagamento) {
        entityManager.getTransaction().begin();
        entityManager.persist(pagamento);
        entityManager.getTransaction().commit();
    }

    public List<Pagamento> listar() {
        TypedQuery<Pagamento> pagamentoTypedQuery = entityManager.createQuery("SELECT P FROM Pagamento p", Pagamento.class);
        return pagamentoTypedQuery.getResultList();
    }

    public Pagamento buscarPorId(Long id) {
        return entityManager.find(Pagamento.class, id);
    }

    public void atualizar(Pagamento pagamento) {
        entityManager.getTransaction().begin();
        entityManager.merge(pagamento);
        entityManager.getTransaction().commit();
    }

    public void deletar(Long id) {
        Pagamento pagamento = entityManager.find(Pagamento.class, id);
        if (pagamento != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(pagamento);
            entityManager.getTransaction().commit();
        }
    }
 }