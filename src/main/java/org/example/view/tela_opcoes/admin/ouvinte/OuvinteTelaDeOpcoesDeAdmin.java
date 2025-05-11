package org.example.view.tela_opcoes.admin.ouvinte;

import jakarta.persistence.EntityManager;
import org.example.view.tela_inicial.TelaInicial;
import org.example.view.tela_opcoes.admin.TelaBuscarClienteAdmin;
import org.example.view.tela_opcoes.admin.TelaDeOpcoesDeAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteTelaDeOpcoesDeAdmin implements ActionListener {

    private EntityManager em;
    private TelaDeOpcoesDeAdmin telaOpcoes;

    public OuvinteTelaDeOpcoesDeAdmin(TelaDeOpcoesDeAdmin telaOpcoes, EntityManager em) {
        this.telaOpcoes = telaOpcoes;
        this.em = em;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object componente = e.getSource();

        if (componente == telaOpcoes.getBotaoBuscarCliente()) {
            new TelaBuscarClienteAdmin(em);
            telaOpcoes.dispose();
        } else if (componente == telaOpcoes.getBotaoSair()) {
            new TelaInicial(em);
            telaOpcoes.dispose();
        }
    }
}