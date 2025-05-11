package org.example.view.tela_inicial;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import org.example.view.imagem_config.ImagemFundo;
import org.example.view.tela_inicial.ouvinte.OuvinteTelaInicial;

import javax.swing.*;
import java.awt.*;

@Getter

public class TelaInicial extends JFrame {

    private EntityManager em;

    private ImagemFundo imagemFundo;
    private JLabel titulo;
    private JLabel subTitulo;
    private JButton cadastro;
    private JButton login;

    public TelaInicial(EntityManager em) {
        this.em = em;
        setTitle("TELA INICIAL");
        setSize(1280, 780);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        adicionarImagemDeFundo();
        adicionarComponentes();
        setVisible(true);
    }

    public void adicionarImagemDeFundo() {
        imagemFundo = new ImagemFundo("util/img/tela-inicial.png");
        imagemFundo.setLayout(null);
        imagemFundo.setBounds(0, 0, 1280, 780);
        this.setContentPane(imagemFundo);
    }

    public void adicionarComponentes() {
        OuvinteTelaInicial ouvinte = new OuvinteTelaInicial(this, em);

        titulo = new JLabel();
        titulo.setText("CONCESSIONARIA");
        titulo.setBounds(432, 46, 690, 60);
        titulo.setForeground(Color.BLACK);
        titulo.setFont(new Font("Roboto", Font.BOLD, 40));
        imagemFundo.add(titulo);

        subTitulo = new JLabel();
        subTitulo.setText("BEM VINDO");
        subTitulo.setBounds(500, 650, 690, 60);
        subTitulo.setForeground(Color.BLACK);
        subTitulo.setFont(new Font("Roboto", Font.BOLD, 40));
        imagemFundo.add(subTitulo);


        login = new JButton();
        login.setText("LOGIN");
        login.setBounds(900, 650, 350, 60);
        login.setFont(new Font("Roboto", Font.BOLD, 35));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setBorder(null);
        login.setFocusable(false);
        login.setOpaque(true);
        login.addActionListener(ouvinte);
        imagemFundo.add(login);

        cadastro = new JButton();
        cadastro.setText("CADASTRE-SE");
        cadastro.setBounds(15, 650, 350, 60);
        cadastro.setFont(new Font("Roboto", Font.PLAIN, 39));
        cadastro.setBackground(Color.BLACK);
        cadastro.setForeground(Color.WHITE);
        cadastro.setBorder(null);
        cadastro.setFocusable(false);
        cadastro.setOpaque(true);
        cadastro.addActionListener(ouvinte);
        imagemFundo.add(cadastro);
    }
}