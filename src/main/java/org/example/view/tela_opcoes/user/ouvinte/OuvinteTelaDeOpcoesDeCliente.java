package org.example.view.tela_opcoes.user.ouvinte;

import jakarta.persistence.EntityManager;
import org.example.view.tela_inicial.TelaInicial;
import org.example.view.tela_opcoes.user.TelaDeOpcoesDeCliente;
import org.example.view.tela_opcoes.user.TelaListarCarroCliente;
import org.example.view.tela_opcoes.user.TelaRealizarCompraCliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteTelaDeOpcoesDeCliente implements ActionListener {

    private EntityManager em;
    private TelaDeOpcoesDeCliente telaOpcoes;

    public OuvinteTelaDeOpcoesDeCliente(TelaDeOpcoesDeCliente telaOpcoes, EntityManager em) {
        this.telaOpcoes = telaOpcoes;
        this.em = em;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object componente = e.getSource();

        if (componente == telaOpcoes.getBotaoSair()) {
            new TelaInicial(em);
            telaOpcoes.dispose();
        } else if (componente == telaOpcoes.getBotaoListarCarro()) {
            new TelaListarCarroCliente(em);
            telaOpcoes.dispose();
        } else if (componente == telaOpcoes.getBotaoRealizarCompra()) {
            new TelaRealizarCompraCliente(em);
            telaOpcoes.dispose();
        }
    }
}