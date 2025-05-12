package org.example.view.tela_opcoes.admin.ouvinte;

import jakarta.persistence.EntityManager;
import org.example.view.tela_inicial.TelaInicial;
import org.example.view.tela_opcoes.admin.*;

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
        } else if (componente == telaOpcoes.getBotaoListarCliente()) {
            new TelaListarClienteAdmin(em);
            telaOpcoes.dispose();
        } else if (componente == telaOpcoes.getBotaoAtualizarCliente()) {
            new TelaAtualizarClienteAdmin(em);
            telaOpcoes.dispose();
        } else if (componente == telaOpcoes.getBotaoDeletarCliente()) {
            new TelaDeletarClienteAdmin(em);
            telaOpcoes.dispose();
        } else if (componente == telaOpcoes.getBotaoAdicionarCarro()) {
            new TelaAdicionarCarroAdmin(em);
            telaOpcoes.dispose();
        } else if (componente == telaOpcoes.getBotaoBuscarCarro()) {
            new TelaBuscarCarroAdmin(em);
            telaOpcoes.dispose();
        } else if (componente == telaOpcoes.getBotaoAtualizarCarro()) {
            new TelaAtualizarCarroAdmin(em);
            telaOpcoes.dispose();
        } else if (componente == telaOpcoes.getBotaoDeletarCarro()) {
            new TelaDeletarCarroAdmin(em);
            telaOpcoes.dispose();
        } else if (componente == telaOpcoes.getBotaoSair()) {
            new TelaInicial(em);
            telaOpcoes.dispose();
        }
    }
}