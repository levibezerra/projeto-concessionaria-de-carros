package org.example.view.tela_opcoes.admin;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.Setter;
import org.example.view.tela_opcoes.admin.ouvinte.OuvinteTelaDeOpcoesDeAdmin;

import javax.swing.*;
import java.awt.*;

@Getter @Setter

public class TelaDeOpcoesDeAdmin extends JFrame {

    private EntityManager em;

    private JButton botaoBuscarCliente;
    private JButton botaoListarCliente;
    private JButton botaoAtualizarCliente;
    private JButton botaoDeletarCliente;
    private JButton botaoAdicionarCarro;
    private JButton botaoBuscarCarro;
    private JButton botaoAtualizarCarro;
    private JButton botaoDeletarCarro;
    private JButton botaoListarEstoque;
    private JButton botaoSair;
    private JLabel titulo;
    private JPanel painel;

    public TelaDeOpcoesDeAdmin(EntityManager em) {
        this.em = em;
        setTitle("TELA OPÇÕES DE ADMINISTRADOR");
        setSize(1280, 780);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        adicionarComponentesDeOpcoesAdm();
        setVisible(true);
    }

    private void adicionarComponentesDeOpcoesAdm() {

        OuvinteTelaDeOpcoesDeAdmin ouvinte = new OuvinteTelaDeOpcoesDeAdmin(this, em);

        painel = new JPanel();
        painel.setBounds(0, 0, 1280, 780);
        painel.setBackground(Color.white);
        painel.setLayout(null);

        titulo = new JLabel();
        titulo.setText("OPÇÕES DE ADMINISTRADOR");
        titulo.setBounds(240, 21, 800, 45);
        titulo.setForeground(Color.BLACK);
        titulo.setFont(new Font("Arial", Font.BOLD, 52));

        botaoBuscarCliente = new JButton();
        botaoBuscarCliente.setText("BUSCAR CLIENTE");
        botaoBuscarCliente.setBounds(25, 150, 370, 50);
        botaoBuscarCliente.setFont(new Font("Arial", Font.BOLD, 35));
        botaoBuscarCliente.setBackground(Color.BLACK);
        botaoBuscarCliente.setForeground(Color.WHITE);
        botaoBuscarCliente.setBorder(null);
        botaoBuscarCliente.setFocusable(false);
        botaoBuscarCliente.setOpaque(true);
        botaoBuscarCliente.addActionListener(ouvinte);

        botaoListarCliente = new JButton();
        botaoListarCliente.setText("LISTAR CLIENTE");
        botaoListarCliente.setBounds(25, 310, 370, 50);
        botaoListarCliente.setFont(new Font("Arial", Font.BOLD, 35));
        botaoListarCliente.setBackground(Color.BLACK);
        botaoListarCliente.setForeground(Color.WHITE);
        botaoListarCliente.setBorder(null);
        botaoListarCliente.setFocusable(false);
        botaoListarCliente.setOpaque(true);
        botaoListarCliente.addActionListener(ouvinte);

        botaoAtualizarCliente = new JButton();
        botaoAtualizarCliente.setText("ATUALIZAR CLIENTE");
        botaoAtualizarCliente.setBounds(25, 470, 370, 50);
        botaoAtualizarCliente.setFont(new Font("Arial", Font.BOLD, 35));
        botaoAtualizarCliente.setBackground(Color.BLACK);
        botaoAtualizarCliente.setForeground(Color.WHITE);
        botaoAtualizarCliente.setBorder(null);
        botaoAtualizarCliente.setFocusable(false);
        botaoAtualizarCliente.setOpaque(true);
        botaoAtualizarCliente.addActionListener(ouvinte);

        botaoDeletarCliente = new JButton();
        botaoDeletarCliente.setText("DELETAR CLIENTE");
        botaoDeletarCliente.setBounds(448, 150, 370, 50);
        botaoDeletarCliente.setFont(new Font("Arial", Font.BOLD, 35));
        botaoDeletarCliente.setBackground(Color.BLACK);
        botaoDeletarCliente.setForeground(Color.WHITE);
        botaoDeletarCliente.setBorder(null);
        botaoDeletarCliente.setFocusable(false);
        botaoDeletarCliente.setOpaque(true);
        botaoDeletarCliente.addActionListener(ouvinte);

        botaoAdicionarCarro = new JButton();
        botaoAdicionarCarro.setText("ADICIONAR CARRO");
        botaoAdicionarCarro.setBounds(448, 310, 370, 50);
        botaoAdicionarCarro.setFont(new Font("Arial", Font.BOLD, 35));
        botaoAdicionarCarro.setBackground(Color.BLACK);
        botaoAdicionarCarro.setForeground(Color.WHITE);
        botaoAdicionarCarro.setBorder(null);
        botaoAdicionarCarro.setFocusable(false);
        botaoAdicionarCarro.setOpaque(true);
        botaoAdicionarCarro.addActionListener(ouvinte);

        botaoBuscarCarro = new JButton();
        botaoBuscarCarro.setText("BUSCAR CARRO");
        botaoBuscarCarro.setBounds(448, 470, 370, 50);
        botaoBuscarCarro.setFont(new Font("Arial", Font.BOLD, 35));
        botaoBuscarCarro.setBackground(Color.BLACK);
        botaoBuscarCarro.setForeground(Color.WHITE);
        botaoBuscarCarro.setBorder(null);
        botaoBuscarCarro.setFocusable(false);
        botaoBuscarCarro.setOpaque(true);
        botaoBuscarCarro.addActionListener(ouvinte);

        botaoAtualizarCarro = new JButton();
        botaoAtualizarCarro.setText("ATUALIZAR CARRO");
        botaoAtualizarCarro.setBounds(870, 150, 370, 50);
        botaoAtualizarCarro.setFont(new Font("Arial", Font.BOLD, 35));
        botaoAtualizarCarro.setBackground(Color.BLACK);
        botaoAtualizarCarro.setForeground(Color.WHITE);
        botaoAtualizarCarro.setBorder(null);
        botaoAtualizarCarro.setFocusable(false);
        botaoAtualizarCarro.setOpaque(true);
        botaoAtualizarCarro.addActionListener(ouvinte);

        botaoDeletarCarro = new JButton();
        botaoDeletarCarro.setText("DELETAR CARRO");
        botaoDeletarCarro.setBounds(870, 310, 370, 50);
        botaoDeletarCarro.setFont(new Font("Arial", Font.BOLD, 35));
        botaoDeletarCarro.setBackground(Color.BLACK);
        botaoDeletarCarro.setForeground(Color.WHITE);
        botaoDeletarCarro.setBorder(null);
        botaoDeletarCarro.setFocusable(false);
        botaoDeletarCarro.setOpaque(true);
        botaoDeletarCarro.addActionListener(ouvinte);

        botaoListarEstoque = new JButton();
        botaoListarEstoque.setText("LISTAR ESTOQUE");
        botaoListarEstoque.setBounds(870, 470, 370, 50);
        botaoListarEstoque.setFont(new Font("Arial", Font.BOLD, 35));
        botaoListarEstoque.setBackground(Color.BLACK);
        botaoListarEstoque.setForeground(Color.WHITE);
        botaoListarEstoque.setBorder(null);
        botaoListarEstoque.setFocusable(false);
        botaoListarEstoque.setOpaque(true);
//        botaoListarEstoque.addActionListener(ouvinte);
//
        botaoSair = new JButton();
        botaoSair.setText("SAIR");
        botaoSair.setBounds(448, 630, 370, 50);
        botaoSair.setFont(new Font("Arial", Font.BOLD, 35));
        botaoSair.setBackground(Color.BLACK);
        botaoSair.setForeground(Color.WHITE);
        botaoSair.setBorder(null);
        botaoSair.setFocusable(false);
        botaoSair.setOpaque(true);
        botaoSair.addActionListener(ouvinte);

        painel.add(botaoBuscarCliente);
        painel.add(botaoListarCliente);
        painel.add(botaoAtualizarCliente);
        painel.add(botaoDeletarCliente);
        painel.add(botaoAdicionarCarro);
        painel.add(botaoBuscarCarro);
        painel.add(botaoAtualizarCarro);
        painel.add(botaoDeletarCarro);
        painel.add(botaoListarEstoque);
        painel.add(botaoSair);
        painel.add(titulo);
        this.add(painel);
    }
}