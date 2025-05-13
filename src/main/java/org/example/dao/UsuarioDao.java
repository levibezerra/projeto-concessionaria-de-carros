package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.example.entity.Usuario;

import java.util.List;
import java.util.Optional;

public class UsuarioDao {

    private EntityManager entityManager;

    public UsuarioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvar(Usuario usuario) {
        entityManager.getTransaction().begin();
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
    }

    public Usuario buscarPorId(Long id) {
        return entityManager.find(Usuario.class, id);
    }

    public List<Usuario> listarTodos() {
        TypedQuery<Usuario> usuarioTypedQuery = entityManager.createQuery("SELECT U FROM Usuario u", Usuario.class);
        return usuarioTypedQuery.getResultList();
    }

    public void atualizar(Usuario usuario) {
        entityManager.getTransaction().begin();
        entityManager.merge(usuario);
        entityManager.getTransaction().commit();
    }

    public void deletar(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        if (usuario != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(usuario);
            entityManager.getTransaction().commit();
        }
    }

    public Usuario buscarPorEmailSenha(String email, String password) {
        try {
                return entityManager.createQuery(
                        "SELECT u FROM Usuario u WHERE u.email = :email AND u.password = :password", Usuario.class)
                        .setParameter("email", email)
                        .setParameter("password", password)
                        .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return entityManager.createQuery("FROM Usuario u WHERE u.email = :email", Usuario.class)
                .setParameter("email", email)
                .getResultStream()
                .findFirst();
    }
}