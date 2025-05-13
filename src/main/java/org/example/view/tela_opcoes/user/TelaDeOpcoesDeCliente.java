package org.example.view.tela_opcoes.user;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.Setter;
import org.example.view.tela_opcoes.user.ouvinte.OuvinteTelaDeOpcoesDeCliente;

import javax.swing.*;
import java.awt.*;

@Getter @Setter

public class TelaDeOpcoesDeCliente extends JFrame {

    private EntityManager em;
    Long idClienteLogado;
    private JButton botaoListarCarro;
    private JButton botaoRealizarCompra;
    private JButton botaoMinhasInfo;
    private JButton botaoSair;
    private JLabel titulo;
    private JPanel painel;

    public TelaDeOpcoesDeCliente(EntityManager em, Long idClienteLogado) {
        this.em = em;
        this.idClienteLogado = idClienteLogado;
        setTitle("TELA OPÇÕES DE CLIENTE");
        setSize(1280, 780);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        adicionarComponentesDeOpcoesCliente();
        setVisible(true);
    }

    private void adicionarComponentesDeOpcoesCliente() {

        OuvinteTelaDeOpcoesDeCliente ouvinte = new OuvinteTelaDeOpcoesDeCliente(this, em, idClienteLogado);

        painel = new JPanel();
        painel.setBounds(0, 0, 1280, 780);
        painel.setBackground(Color.white);
        painel.setLayout(null);

        titulo = new JLabel();
        titulo.setText("OPÇÕES DE CLIENTE");
        titulo.setBounds(365, 21, 800, 45);
        titulo.setForeground(Color.BLACK);
        titulo.setFont(new Font("Arial", Font.BOLD, 52));

        botaoListarCarro = new JButton();
        botaoListarCarro.setText("LISTAR CARROS");
        botaoListarCarro.setBounds(390, 150, 500, 50);
        botaoListarCarro.setFont(new Font("Arial", Font.BOLD, 35));
        botaoListarCarro.setBackground(Color.BLACK);
        botaoListarCarro.setForeground(Color.WHITE);
        botaoListarCarro.setBorder(null);
        botaoListarCarro.setFocusable(false);
        botaoListarCarro.setOpaque(true);
        botaoListarCarro.addActionListener(ouvinte);

        botaoRealizarCompra = new JButton();
        botaoRealizarCompra.setText("REALIZAR COMPRA");
        botaoRealizarCompra.setBounds(390, 310, 500, 50);
        botaoRealizarCompra.setFont(new Font("Arial", Font.BOLD, 35));
        botaoRealizarCompra.setBackground(Color.BLACK);
        botaoRealizarCompra.setForeground(Color.WHITE);
        botaoRealizarCompra.setBorder(null);
        botaoRealizarCompra.setFocusable(false);
        botaoRealizarCompra.setOpaque(true);
        botaoRealizarCompra.addActionListener(ouvinte);

        botaoMinhasInfo = new JButton();
        botaoMinhasInfo.setText("MINHAS INFORMAÇÕES");
        botaoMinhasInfo.setBounds(390, 470, 500, 50);
        botaoMinhasInfo.setFont(new Font("Arial", Font.BOLD, 35));
        botaoMinhasInfo.setBackground(Color.BLACK);
        botaoMinhasInfo.setForeground(Color.WHITE);
        botaoMinhasInfo.setBorder(null);
        botaoMinhasInfo.setFocusable(false);
        botaoMinhasInfo.setOpaque(true);
        botaoMinhasInfo.addActionListener(ouvinte);

        botaoSair = new JButton();
        botaoSair.setText("SAIR");
        botaoSair.setBounds(465, 630, 350, 50);
        botaoSair.setFont(new Font("Arial", Font.BOLD, 35));
        botaoSair.setBackground(Color.BLACK);
        botaoSair.setForeground(Color.WHITE);
        botaoSair.setBorder(null);
        botaoSair.setFocusable(false);
        botaoSair.setOpaque(true);
        botaoSair.addActionListener(ouvinte);

        painel.add(botaoListarCarro);
        painel.add(botaoRealizarCompra);
        painel.add(botaoMinhasInfo);
        painel.add(botaoSair);
        painel.add(titulo);
        this.add(painel);
    }
}