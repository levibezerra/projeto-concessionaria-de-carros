package org.example.view.tela_inicial.ouvinte;

import jakarta.persistence.EntityManager;
import org.example.view.tela_cadastro.TelaDeCadastroAdmin;
import org.example.view.tela_inicial.TelaInicial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteTelaInicial implements ActionListener {

    private EntityManager em;
    private TelaInicial tela;

    public OuvinteTelaInicial(TelaInicial tela, EntityManager em) {
        this.tela = tela;
        this.em = em;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object componente = e.getSource();

        if (componente == tela.getCadastro()) {
            new TelaDeCadastroAdmin(em);
            tela.dispose();
        }
    }
}