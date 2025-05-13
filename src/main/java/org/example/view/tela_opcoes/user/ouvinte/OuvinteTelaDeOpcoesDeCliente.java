package org.example.view.tela_opcoes.user.ouvinte;

import jakarta.persistence.EntityManager;
import org.example.view.tela_inicial.TelaInicial;
import org.example.view.tela_opcoes.user.TelaDeOpcoesDeCliente;
import org.example.view.tela_opcoes.user.TelaInfoDoCliente;
import org.example.view.tela_opcoes.user.TelaListarCarroCliente;
import org.example.view.tela_opcoes.user.TelaRealizarCompraCliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteTelaDeOpcoesDeCliente implements ActionListener {

    private EntityManager em;
    private TelaDeOpcoesDeCliente telaOpcoes;
    private Long idClienteLogado;

    public OuvinteTelaDeOpcoesDeCliente(TelaDeOpcoesDeCliente telaOpcoes, EntityManager em, Long idClienteLogado) {
        this.telaOpcoes = telaOpcoes;
        this.em = em;
        this.idClienteLogado = idClienteLogado;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object componente = e.getSource();

        if (componente == telaOpcoes.getBotaoSair()) {
            new TelaInicial(em);
            telaOpcoes.dispose();
        } else if (componente == telaOpcoes.getBotaoListarCarro()) {
            System.out.println("ID : " + idClienteLogado);
            new TelaListarCarroCliente(em, idClienteLogado);
            telaOpcoes.dispose();
        } else if (componente == telaOpcoes.getBotaoRealizarCompra()) {
            System.out.println("ID : " + idClienteLogado);
            new TelaRealizarCompraCliente(em, idClienteLogado);
            telaOpcoes.dispose();
        } else if (componente == telaOpcoes.getBotaoMinhasInfo()) {
            System.out.println("ID : " + idClienteLogado);
            new TelaInfoDoCliente(em, idClienteLogado);
            telaOpcoes.dispose();
        }
    }
}