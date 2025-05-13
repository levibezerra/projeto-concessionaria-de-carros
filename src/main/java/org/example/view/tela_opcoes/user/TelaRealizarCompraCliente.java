package org.example.view.tela_opcoes.user;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.FormaDePagamento;
import org.example.enums.TipoDeCarro;
import org.example.view.tela_opcoes.user.ouvinte.OuvinteTelaRealizarCompraCliente;

import javax.swing.*;
import java.awt.*;

@Getter @Setter

public class TelaRealizarCompraCliente extends JFrame {

    private EntityManager em;
    private JLabel labelIdDoCarro;
    private JTextField textIdDoCarro;
    private JLabel labelIdDoCliente;
    private JTextField textIdDoCliente;
    private JLabel labelValorDoCarro;
    private JTextField textValorDoCarro;
    private JButton botaoVoltar;
    private JButton botaoComprar;
    private JLabel labelTipoCarro;
    private JComboBox<TipoDeCarro> tipoDoCarro;
    private JLabel labelFormaDePagamento;
    private JComboBox<FormaDePagamento> formaDePagamento;
    private JPanel painel;
    private JLabel titulo;

    public TelaRealizarCompraCliente(EntityManager em) {
        this.em = em;
        setTitle("TELA ADICIONAR CARRO");
        setSize(1280, 780);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        adicionarComponentesDoRealizarVenda();
        setVisible(true);
    }

    private void adicionarComponentesDoRealizarVenda() {

        OuvinteTelaRealizarCompraCliente ouvinte = new OuvinteTelaRealizarCompraCliente(this, em);

        painel =new JPanel();
        painel.setBounds(0, 0, 1280, 780);
        painel.setBackground(Color.white);
        painel.setLayout(null);

        titulo = new JLabel();
        titulo.setText("COMPRAR CARRO");
        titulo.setBounds(440, 21, 600, 45);
        titulo.setForeground(Color.BLACK);
        titulo.setFont(new Font("Roboto", Font.BOLD, 40));

        botaoVoltar = new JButton();
        botaoVoltar.setText("VOLTAR");
        botaoVoltar.setBounds(65, 21, 182, 45);
        botaoVoltar.setFont(new Font("Arial", Font.BOLD, 30));
        botaoVoltar.setBackground(Color.BLACK);
        botaoVoltar.setForeground(Color.WHITE);
        botaoVoltar.setBorder(null);
        botaoVoltar.setFocusable(false);
        botaoVoltar.setOpaque(true);
        botaoVoltar.addActionListener(ouvinte);

        botaoComprar = new JButton();
        botaoComprar.setText("FINALIZAR COMPRA");
        botaoComprar.setBounds(315, 640, 650, 60);
        botaoComprar.setFont(new Font("Arial", Font.BOLD, 30));
        botaoComprar.setForeground(Color.WHITE);
        botaoComprar.setBackground(Color.BLACK);
        botaoComprar.setOpaque(true);
        botaoComprar.setBorder(null);
        botaoComprar.setFocusable(false);
        botaoComprar.addActionListener(ouvinte);

        labelIdDoCarro = new JLabel();
        labelIdDoCarro.setText("ID DO CARRO");
        labelIdDoCarro.setBounds(70, 300, 250, 60);
        labelIdDoCarro.setForeground(Color.BLACK);
        labelIdDoCarro.setFont(new Font("Arial", Font.BOLD, 35));

        textIdDoCarro = new JTextField();
        textIdDoCarro.setBounds(70, 350, 500, 50);
        textIdDoCarro.setBackground(Color.LIGHT_GRAY);
        textIdDoCarro.setForeground(Color.BLACK);
        textIdDoCarro.setFont(new Font("Arial", Font.PLAIN, 35));
        textIdDoCarro.setOpaque(true);
        textIdDoCarro.setBorder(null);

        labelIdDoCliente = new JLabel();
        labelIdDoCliente.setText("SEU ID");
        labelIdDoCliente.setBounds(70, 125, 250, 60);
        labelIdDoCliente.setForeground(Color.BLACK);
        labelIdDoCliente.setFont(new Font("Arial", Font.BOLD, 35));

        textIdDoCliente = new JTextField();
        textIdDoCliente.setBounds(70, 175, 500, 50);
        textIdDoCliente.setBackground(Color.LIGHT_GRAY);
        textIdDoCliente.setForeground(Color.BLACK);
        textIdDoCliente.setFont(new Font("Arial", Font.PLAIN, 35));
        textIdDoCliente.setOpaque(true);
        textIdDoCliente.setBorder(null);

        labelValorDoCarro = new JLabel();
        labelValorDoCarro.setText("VALOR DO CARRO");
        labelValorDoCarro.setBounds(70, 480, 500, 60);
        labelValorDoCarro.setForeground(Color.BLACK);
        labelValorDoCarro.setFont(new Font("Arial", Font.BOLD, 35));

        textValorDoCarro = new JTextField();
        textValorDoCarro.setBounds(70, 530, 500, 50);
        textValorDoCarro.setBackground(Color.LIGHT_GRAY);
        textValorDoCarro.setForeground(Color.BLACK);
        textValorDoCarro.setFont(new Font("Arial", Font.PLAIN, 35));
        textValorDoCarro.setOpaque(true);
        textValorDoCarro.setBorder(null);

        labelTipoCarro = new JLabel();
        labelTipoCarro.setText("TIPO DE CARRO");
        labelTipoCarro.setBounds(700, 175, 500, 60);
        labelTipoCarro.setForeground(Color.BLACK);
        labelTipoCarro.setFont(new Font("Arial", Font.BOLD, 36));

        tipoDoCarro = new JComboBox<>(TipoDeCarro.values());
        tipoDoCarro.setBounds(700, 225, 500, 50);
        tipoDoCarro.setFont(new Font("Arial", Font.PLAIN, 35));
        tipoDoCarro.setBackground(Color.WHITE);
        tipoDoCarro.setForeground(Color.BLACK);
        tipoDoCarro.setOpaque(true);
        tipoDoCarro.setBorder(null);

        labelFormaDePagamento = new JLabel();
        labelFormaDePagamento.setText("FORMA DE PAGAMENTO");
        labelFormaDePagamento.setBounds(700, 430, 500, 60);
        labelFormaDePagamento.setForeground(Color.BLACK);
        labelFormaDePagamento.setFont(new Font("Arial", Font.BOLD, 36));

        formaDePagamento = new JComboBox<>(FormaDePagamento.values());
        formaDePagamento.setBounds(700, 480, 500, 50);
        formaDePagamento.setFont(new Font("Arial", Font.PLAIN, 35));
        formaDePagamento.setBackground(Color.WHITE);
        formaDePagamento.setForeground(Color.BLACK);
        formaDePagamento.setOpaque(true);
        formaDePagamento.setBorder(null);

        painel.add(botaoComprar);
        painel.add(botaoVoltar);
        painel.add(titulo);
        painel.add(labelIdDoCarro);
        painel.add(textIdDoCarro);
        painel.add(labelIdDoCliente);
        painel.add(textIdDoCliente);
        painel.add(labelValorDoCarro);
        painel.add(textValorDoCarro);
        painel.add(labelFormaDePagamento);
        painel.add(formaDePagamento);
        painel.add(labelTipoCarro);
        painel.add(tipoDoCarro);
        this.add(painel);
    }
}