package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.entity.Administrador;

import java.util.List;

public class AdministradorDao {

    private EntityManager entityManager;

    public AdministradorDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvar(Administrador admin) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(admin);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Erro ao salvar Administrador no banco de dados: " + e.getMessage(), e);
        }
    }

    public Administrador buscarPorId(Long id) {
        return entityManager.find(Administrador.class, id);
    }

    public List<Administrador> listarTodos() {
        TypedQuery<Administrador> adminTypedQuery = entityManager.createQuery("SELECT A FROM Administrador a", Administrador.class);
        return adminTypedQuery.getResultList();
    }

    public void atualizar(Administrador admin) {
        entityManager.getTransaction().begin();
        entityManager.merge(admin);
        entityManager.getTransaction().commit();
    }

    public void deletar(Long id) {
        Administrador admin = entityManager.find(Administrador.class, id);
        if (admin != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(admin);
            entityManager.getTransaction().commit();
        }
    }
}