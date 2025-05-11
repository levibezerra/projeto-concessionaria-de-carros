package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.example.entity.Administrador;
import org.example.entity.Cliente;
import org.example.entity.Usuario;

import java.util.List;

public class ClienteDao {

    private EntityManager entityManager;

    public ClienteDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvar(Cliente cliente) {
        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
    }

    public Cliente buscarPorId(Long id) {
        return entityManager.find(Cliente.class, id);
    }

    public List<Cliente> listarTodos() {
        TypedQuery<Cliente> clienteTypedQuery = entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class);
        return clienteTypedQuery.getResultList();
    }

    public void atualizar(Cliente cliente) {
        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();
    }

    public void deletar(Long id) {
        Cliente cliente = entityManager.find(Cliente.class, id);
        if (cliente != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(cliente);
            entityManager.getTransaction().commit();
        }
    }

    public Cliente buscarPorEmailESenha(String email, String password) {
        try {
            return entityManager.createQuery("SELECT c FROM Cliente c WHERE c.email = :email AND c.password = :password", Cliente.class)
                    .setParameter("email", email)
                    .setParameter("senha", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}