package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.config.JpaConfig;
import org.example.controller.*;
import org.example.service.*;

public class Main {

    public static void main (String [] args) {

        EntityManager em = JpaConfig.entityManager();

        ClienteService clienteService = new ClienteService(em);
        UsuarioService usuarioService = new UsuarioService(em);
        CarroPopularService carroPopularService = new CarroPopularService(em);
        CarroEsportivoService carroEsportivoService = new CarroEsportivoService(em);
        EstoqueService estoqueService = new EstoqueService(em);
        AdministradorService administradorService = new AdministradorService(em);
        VendaService vendaService = new VendaService(em);

        ClienteController clienteController = new ClienteController(clienteService);
        UsuarioController usuarioController  = new UsuarioController(usuarioService);
        EstoqueController estoqueController = new EstoqueController(carroPopularService, carroEsportivoService, estoqueService);
        CarroController carroController = new CarroController(carroPopularService, carroEsportivoService, estoqueService);
        AdministradorController administradorController = new AdministradorController(administradorService);
        VendaController vendaController = new VendaController(vendaService);

        MenuController menuController = new MenuController(clienteController, usuarioController, estoqueController, carroController,
                administradorController, vendaController);

        menuController.menu();

        em.close();
        JpaConfig.closeFactory();
    }
}