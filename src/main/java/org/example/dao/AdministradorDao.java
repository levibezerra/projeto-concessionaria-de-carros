package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
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

    public int verificarSeExisteAdminNoBanco() {
        String jpql = "SELECT COUNT(a) FROM Administrador a";
        Long count = entityManager.createQuery(jpql, Long.class).getSingleResult();
        return count.intValue();
    }

    public Administrador buscarPorEmailESenha(String email, String password) {
        try {
            return entityManager.createQuery("SELECT a FROM Administrador a WHERE a.email = :email AND a.password = :password", Administrador.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}