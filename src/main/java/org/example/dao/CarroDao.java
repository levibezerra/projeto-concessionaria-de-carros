package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.entity.Carro;
import org.example.entity.CarroEsportivo;
import org.example.entity.CarroPopular;
import org.example.entity.Estoque;
import org.example.enums.Status;

import java.util.ArrayList;
import java.util.List;

public class CarroDao {

    private EntityManager entityManager;

    public CarroDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvar(Carro carro) {
        entityManager.getTransaction().begin();
        entityManager.persist(carro);
        entityManager.getTransaction().commit();
    }

    public Carro buscarPorId(Long id) {
        return entityManager.find(Carro.class, id);
    }

    public List<Carro> listarTodosPopulares() {
        List<Carro> carrosList = new ArrayList<>();
        carrosList.addAll(entityManager.createQuery("SELECT c FROM carro_popular c WHERE c.estoque.status = :status", CarroPopular.class)
                .setParameter("status", Status.DISPONIVEL).getResultList());
        return carrosList;
    }

    public List<Carro> listarTodosEsportivos() {
        List<Carro> carroList = new ArrayList<>();
        carroList.addAll(entityManager.createQuery("SELECT c FROM carro_esportivo c WHERE c.estoque.status = :status", CarroEsportivo.class)
                .setParameter("status", Status.DISPONIVEL).getResultList());
        return carroList;
    }

    public void atualizar(Carro carro) {
        entityManager.getTransaction().begin();
        entityManager.merge(carro);
        entityManager.getTransaction().commit();
    }

    public void deletar(Long id) {
        Carro carro = entityManager.find(Carro.class, id);
        if (carro != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(carro);
            entityManager.getTransaction().commit();
        }
    }
}