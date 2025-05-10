package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.config.JpaConfig;
import org.example.controller.*;
import org.example.service.*;
import org.example.view.tela_inicial.TelaInicial;

public class Main {

    public static void main (String [] args) {

        EntityManager em = JpaConfig.entityManager();

        new TelaInicial(em);
    }
}