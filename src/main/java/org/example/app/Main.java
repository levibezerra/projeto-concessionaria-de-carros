package org.example.app;

import jakarta.persistence.EntityManager;
import org.example.config.JpaConfig;
import org.example.view.tela_inicial.TelaInicial;

public class Main {

    public static void main (String [] args) {

        EntityManager em = JpaConfig.entityManager();

        new TelaInicial(em);
    }
}