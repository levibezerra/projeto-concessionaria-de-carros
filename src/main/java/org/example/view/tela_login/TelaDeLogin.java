package org.example.view.tela_login;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.Setter;
import org.example.view.tela_login.ouvinte.OuvinteTelaDeLogin;

import javax.swing.*;
import java.awt.*;

@Getter @Setter

public class TelaDeLogin extends JFrame {

    private EntityManager em;

    private JLabel labelEmail;
    private JTextField textEmail;
    private JLabel labelSenha;
    private JPasswordField passPassword;
    private JPanel painel;
    private JLabel titulo;
    private JButton botaoVoltar;
    private JButton botaoEntrar;

    public TelaDeLogin(EntityManager em) {
        this.em = em;
        setTitle("TELA DE LOGIN");
        setSize(1280, 780);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        adicionarComponentesDeLogin();
        setVisible(true);
    }

    public void adicionarComponentesDeLogin() {

        OuvinteTelaDeLogin ouvinte = new OuvinteTelaDeLogin(this, em);

        painel = new JPanel();
        painel.setBounds(0, 0, 1280, 780);
        painel.setBackground(Color.white);
        painel.setLayout(null);

        botaoVoltar = new JButton();
        botaoVoltar.setText("VOLTAR");
        botaoVoltar.setBounds(71, 21, 182, 45);
        botaoVoltar.setFont(new Font("Arial", Font.BOLD, 26));
        botaoVoltar.setBackground(Color.BLACK);
        botaoVoltar.setForeground(Color.WHITE);
        botaoVoltar.setBorder(null);
        botaoVoltar.setFocusable(false);
        botaoVoltar.setOpaque(true);
        botaoVoltar.addActionListener(ouvinte);

        titulo = new JLabel();
        titulo.setText("LOGIN");
        titulo.setBounds(530, 21, 600, 45);
        titulo.setForeground(Color.BLACK);
        titulo.setFont(new Font("Arial", Font.BOLD, 52));

        labelEmail = new JLabel();
        labelEmail.setText("Email");
        labelEmail.setBounds(325, 191, 250, 60);
        labelEmail.setForeground(Color.BLACK);
        labelEmail.setFont(new Font("Arial", Font.BOLD, 36));

        textEmail = new JTextField();
        textEmail.setBounds(325, 247, 600, 50);
        textEmail.setBackground(Color.LIGHT_GRAY);
        textEmail.setForeground(Color.BLACK);
        textEmail.setFont(new Font("Arial", Font.PLAIN, 35));
        textEmail.setBorder(null);

        labelSenha = new JLabel();
        labelSenha.setText("Senha");
        labelSenha.setBounds(325, 344, 250, 60);
        labelSenha.setForeground(Color.BLACK);
        labelSenha.setFont(new Font("Arial", Font.BOLD, 36));

        passPassword = new JPasswordField();
        passPassword.setBounds(325, 400, 600, 50);
        passPassword.setBackground(Color.LIGHT_GRAY);
        passPassword.setForeground(Color.BLACK);
        passPassword.setFont(new Font("Arial", Font.PLAIN, 35));
        passPassword.setBorder(null);

        botaoEntrar = new JButton();
        botaoEntrar.setText("ENTRAR");
        botaoEntrar.setBounds(300, 589, 650, 60);
        botaoEntrar.setFont(new Font("Arial", Font.BOLD, 35));
        botaoEntrar.setBackground(Color.BLACK);
        botaoEntrar.setForeground(Color.WHITE);
        botaoEntrar.setBorder(null);
        botaoEntrar.setFocusable(false);
        botaoEntrar.setOpaque(true);
        botaoEntrar.addActionListener(ouvinte);

        painel.add(botaoVoltar);
        painel.add(titulo);
        painel.add(labelEmail);
        painel.add(textEmail);
        painel.add(labelSenha);
        painel.add(passPassword);
        painel.add(botaoEntrar);
        this.add(painel);
    }
}