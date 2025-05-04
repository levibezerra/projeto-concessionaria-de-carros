package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.entity.CarroVendido;

import java.util.List;

public class CarroVendidoDao {

    private EntityManager em;

    public CarroVendidoDao(EntityManager em) {
        this.em = em;
    }

    public void salvar(CarroVendido compra) {
        em.getTransaction().begin();
        em.persist(compra);
        em.getTransaction().commit();
    }

    public List<CarroVendido> listar() {
        return em.createQuery("SELECT MC FROM MinhaCompra mc", CarroVendido.class).getResultList();
    }

    public CarroVendido buscarPorId(Long id) {
        return em.find(CarroVendido.class, id);
    }
}