package org.example.view.tela_inicial.ouvinte;

import jakarta.persistence.EntityManager;
import org.example.dao.AdministradorDao;
import org.example.view.tela_cadastro.TelaCadastroCliente;
import org.example.view.tela_cadastro.TelaDeCadastroAdmin;
import org.example.view.tela_inicial.TelaInicial;
import org.example.view.tela_login.TelaDeLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteTelaInicial implements ActionListener {

    private EntityManager em;
    private TelaInicial tela;
    private Long idClienteLogado;

    public OuvinteTelaInicial(TelaInicial tela, EntityManager em, Long idClienteLogado) {
        this.tela = tela;
        this.em = em;
        this.idClienteLogado = idClienteLogado;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object componente = e.getSource();

        if (componente == tela.getCadastro()) {
            AdministradorDao adminDao = new AdministradorDao(em);
            int numAdmin = adminDao.verificarSeExisteAdminNoBanco();
            System.out.println("Número de Admins: " + numAdmin);
            if (numAdmin == 0) {
                new TelaDeCadastroAdmin(em);
            } else {
                new TelaCadastroCliente(em);
            }
            tela.dispose();
        } else if (componente == tela.getLogin()){
            new TelaDeLogin(em, idClienteLogado);
            tela.dispose();
        }
    }
}