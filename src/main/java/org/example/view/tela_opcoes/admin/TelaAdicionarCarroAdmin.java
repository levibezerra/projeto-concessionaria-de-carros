package org.example.view.tela_opcoes.admin;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.TipoDeCarro;
import org.example.view.tela_opcoes.admin.ouvinte.OuvinteTelaAdicionarCarroAdmin;

import javax.swing.*;
import java.awt.*;

@Getter @Setter

public class TelaAdicionarCarroAdmin extends JFrame {

    private EntityManager em;

    private JLabel labelMarca;
    private JTextField textMarca;
    private JLabel labelModelo;
    private JTextField textModelo;
    private JLabel labelAno;
    private JTextField textAno;
    private JLabel labelPreco;
    private JTextField textPreco;
    private JLabel labelCor;
    private JTextField textCor;
    private JButton botaoVoltar;
    private JButton botaoAdicionar;
    private JLabel labelTipoCarro;
    private JComboBox<TipoDeCarro> tipoDoCarro;
    private JPanel painel;
    private JLabel titulo;

    public TelaAdicionarCarroAdmin(EntityManager em) {
        this.em = em;
        setTitle("TELA ADICIONAR CARRO");
        setSize(1280, 780);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        adicionarComponentesDoCarro();
        setVisible(true);
    }
    private void adicionarComponentesDoCarro() {

        OuvinteTelaAdicionarCarroAdmin ouvinte = new OuvinteTelaAdicionarCarroAdmin(this, em);

        painel =new JPanel();
        painel.setBounds(0, 0, 1280, 780);
        painel.setBackground(Color.white);
        painel.setLayout(null);

        titulo = new JLabel();
        titulo.setText("ADICIONAR CARRO");
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

        botaoAdicionar = new JButton();
        botaoAdicionar.setText("ADICIONAR");
        botaoAdicionar.setBounds(315, 667, 650, 60);
        botaoAdicionar.setFont(new Font("Arial", Font.BOLD, 30));
        botaoAdicionar.setForeground(Color.WHITE);
        botaoAdicionar.setBackground(Color.BLACK);
        botaoAdicionar.setOpaque(true);
        botaoAdicionar.setBorder(null);
        botaoAdicionar.setFocusable(false);
        botaoAdicionar.addActionListener(ouvinte);

        labelTipoCarro = new JLabel();
        labelTipoCarro.setText("TIPO DE CARRO");
        labelTipoCarro.setBounds(700, 480, 500, 60);
        labelTipoCarro.setForeground(Color.BLACK);
        labelTipoCarro.setFont(new Font("Arial", Font.BOLD, 36));

        tipoDoCarro = new JComboBox<>(TipoDeCarro.values());
        tipoDoCarro.setBounds(700, 530, 500, 50);
        tipoDoCarro.setFont(new Font("Arial", Font.PLAIN, 35));
        tipoDoCarro.setBackground(Color.WHITE);
        tipoDoCarro.setForeground(Color.BLACK);
        tipoDoCarro.setOpaque(true);
        tipoDoCarro.setBorder(null);

        labelMarca = new JLabel();
        labelMarca.setText("MARCA");
        labelMarca.setBounds(70, 125, 250, 60);
        labelMarca.setForeground(Color.BLACK);
        labelMarca.setFont(new Font("Arial", Font.BOLD, 35));

        textMarca = new JTextField();
        textMarca.setBounds(70, 175, 500, 50);
        textMarca.setBackground(Color.LIGHT_GRAY);
        textMarca.setForeground(Color.BLACK);
        textMarca.setFont(new Font("Arial", Font.PLAIN, 35));
        textMarca.setOpaque(true);
        textMarca.setBorder(null);

        labelModelo = new JLabel();
        labelModelo.setText("MODELO");
        labelModelo.setBounds(70, 300, 250, 60);
        labelModelo.setForeground(Color.BLACK);
        labelModelo.setFont(new Font("Arial", Font.BOLD, 35));

        textModelo = new JTextField();
        textModelo.setBounds(70, 350, 500, 50);
        textModelo.setBackground(Color.LIGHT_GRAY);
        textModelo.setForeground(Color.BLACK);
        textModelo.setFont(new Font("Arial", Font.PLAIN, 35));
        textModelo.setOpaque(true);
        textModelo.setBorder(null);

        labelAno = new JLabel();
        labelAno.setText("ANO");
        labelAno.setBounds(70, 480, 250, 60);
        labelAno.setForeground(Color.BLACK);
        labelAno.setFont(new Font("Arial", Font.BOLD, 35));

        textAno = new JTextField();
        textAno.setBounds(70, 530, 500, 50);
        textAno.setBackground(Color.LIGHT_GRAY);
        textAno.setForeground(Color.BLACK);
        textAno.setFont(new Font("Arial", Font.PLAIN, 35));
        textAno.setOpaque(true);
        textAno.setBorder(null);

        labelPreco = new JLabel();
        labelPreco.setText("PREÇO");
        labelPreco.setBounds(700, 125, 250, 60);
        labelPreco.setForeground(Color.BLACK);
        labelPreco.setFont(new Font("Arial", Font.BOLD, 35));

        textPreco = new JTextField();
        textPreco.setBounds(700, 175, 500, 50);
        textPreco.setBackground(Color.LIGHT_GRAY);
        textPreco.setForeground(Color.BLACK);
        textPreco.setFont(new Font("Arial", Font.PLAIN, 35));
        textPreco.setOpaque(true);
        textPreco.setBorder(null);

        labelCor = new JLabel();
        labelCor.setText("COR");
        labelCor.setBounds(700, 300, 250, 60);
        labelCor.setForeground(Color.BLACK);
        labelCor.setFont(new Font("Arial", Font.BOLD, 35));

        textCor = new JTextField();
        textCor.setBounds(700, 350, 500, 50);
        textCor.setBackground(Color.LIGHT_GRAY);
        textCor.setForeground(Color.BLACK);
        textCor.setFont(new Font("Arial", Font.PLAIN, 35));
        textCor.setOpaque(true);
        textCor.setBorder(null);

        painel.add(botaoAdicionar);
        painel.add(botaoVoltar);
        painel.add(titulo);
        painel.add(labelMarca);
        painel.add(textMarca);
        painel.add(labelModelo);
        painel.add(textModelo);
        painel.add(labelAno);
        painel.add(textAno);
        painel.add(labelPreco);
        painel.add(textPreco);
        painel.add(labelCor);
        painel.add(textCor);
        painel.add(labelTipoCarro);
        painel.add(tipoDoCarro);
        this.add(painel);
    }
}