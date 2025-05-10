package org.example.view.tela_cadastro;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.Setter;
import org.example.view.tela_cadastro.ouvinte.OuvinteTelaDeCadastroAdmim;
import org.example.view.tela_inicial.TelaInicial;

import javax.swing.*;
import java.awt.*;

@Getter @Setter

public class TelaDeCadastroAdmin extends JFrame {

    private EntityManager em;

    private JLabel labelNome;
    private JTextField textNome;
    private JLabel labelCpf;
    private JTextField textCpf;
    private JLabel labelEndereco;
    private JTextField textEndereco;
    private JLabel labelTelefone;
    private JTextField textTelefone;
    private JLabel labelEmail;
    private JTextField textEmail;
    private JLabel labelSenha;
    private JPasswordField passSenha;
    private JButton botaoVoltar;
    private JButton botaoCadastrar;
    private JPanel painel;
    private JLabel titulo;

    public TelaDeCadastroAdmin(EntityManager em) {
        this.em = em;
        setTitle("CADASTRAR ADMINISTRADOR");
        setSize(1280, 780);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        adicionarComponentesAdmin();
        setVisible(true);
    }

    public void adicionarComponentesAdmin() {
        OuvinteTelaDeCadastroAdmim ouvinte = new OuvinteTelaDeCadastroAdmim(this, em);

        painel =new JPanel();
        painel.setBounds(0, 0, 1280, 780);
        painel.setBackground(Color.white);
        painel.setLayout(null);

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

        botaoCadastrar = new JButton();
        botaoCadastrar.setText("CADASTRAR");
        botaoCadastrar.setBounds(315, 667, 650, 60);
        botaoCadastrar.setFont(new Font("Arial", Font.BOLD, 30));
        botaoCadastrar.setForeground(Color.WHITE);
        botaoCadastrar.setBackground(Color.BLACK);
        botaoCadastrar.setOpaque(true);
        botaoCadastrar.setBorder(null);
        botaoCadastrar.setFocusable(false);
        botaoCadastrar.addActionListener(ouvinte);

        titulo = new JLabel();
        titulo.setText("CADASTRAR ADMINISTRADOR");
        titulo.setBounds(420, 21, 600, 45);
        titulo.setForeground(Color.BLACK);
        titulo.setFont(new Font("Roboto", Font.BOLD, 40));

        labelNome = new JLabel();
        labelNome.setText("NOME");
        labelNome.setBounds(70, 125, 250, 60);
        labelNome.setForeground(Color.BLACK);
        labelNome.setFont(new Font("Arial", Font.BOLD, 35));

        textNome = new JTextField();
        textNome.setBounds(70, 175, 500, 30);
        textNome.setBackground(Color.LIGHT_GRAY);
        textNome.setForeground(Color.BLACK);
        textNome.setFont(new Font("Arial", Font.PLAIN, 20));
        textNome.setOpaque(true);
        textNome.setBorder(null);

        labelCpf = new JLabel();
        labelCpf.setText("CPF");
        labelCpf.setBounds(70, 310, 250, 60);
        labelCpf.setForeground(Color.BLACK);
        labelCpf.setFont(new Font("Arial", Font.BOLD, 35));

        textCpf = new JTextField();
        textCpf.setBounds(70, 360, 500, 30);
        textCpf.setBackground(Color.LIGHT_GRAY);
        textCpf.setForeground(Color.BLACK);
        textCpf.setFont(new Font("Arial", Font.PLAIN, 20));
        textCpf.setOpaque(true);
        textCpf.setBorder(null);

        labelEndereco = new JLabel();
        labelEndereco.setText("ENDEREÇO");
        labelEndereco.setBounds(70, 500, 250, 60);
        labelEndereco.setForeground(Color.BLACK);
        labelEndereco.setFont(new Font("Arial", Font.BOLD, 35));

        textEndereco = new JTextField();
        textEndereco.setBounds(70, 550, 500, 30);
        textEndereco.setBackground(Color.LIGHT_GRAY);
        textEndereco.setForeground(Color.BLACK);
        textEndereco.setFont(new Font("Arial", Font.PLAIN, 20));
        textEndereco.setOpaque(true);
        textEndereco.setBorder(null);

        labelTelefone = new JLabel();
        labelTelefone.setText("TELEFONE");
        labelTelefone.setBounds(700, 125, 250, 60);
        labelTelefone.setForeground(Color.BLACK);
        labelTelefone.setFont(new Font("Arial", Font.BOLD, 35));

        textTelefone = new JTextField();
        textTelefone.setBounds(700, 175, 500, 30);
        textTelefone.setBackground(Color.LIGHT_GRAY);
        textTelefone.setForeground(Color.BLACK);
        textTelefone.setFont(new Font("Arial", Font.PLAIN, 20));
        textTelefone.setOpaque(true);
        textTelefone.setBorder(null);

        labelEmail = new JLabel();
        labelEmail.setText("EMAIL");
        labelEmail.setBounds(700, 310, 250, 60);
        labelEmail.setForeground(Color.BLACK);
        labelEmail.setFont(new Font("Arial", Font.BOLD, 35));

        textEmail = new JTextField();
        textEmail.setBounds(700, 360, 500, 30);
        textEmail.setBackground(Color.LIGHT_GRAY);
        textEmail.setForeground(Color.BLACK);
        textEmail.setFont(new Font("Arial", Font.PLAIN, 20));
        textEmail.setOpaque(true);
        textEmail.setBorder(null);

        labelSenha = new JLabel();
        labelSenha.setText("SENHA");
        labelSenha.setBounds(700, 500, 250, 60);
        labelSenha.setForeground(Color.BLACK);
        labelSenha.setFont(new Font("Arial", Font.BOLD, 35));

        passSenha = new JPasswordField();
        passSenha.setBounds(700, 550, 500, 30);
        passSenha.setBackground(Color.LIGHT_GRAY);
        passSenha.setForeground(Color.BLACK);
        passSenha.setFont(new Font("Arial", Font.PLAIN, 20));
        passSenha.setOpaque(true);
        passSenha.setBorder(null);

        painel.add(botaoCadastrar);
        painel.add(botaoVoltar);
        painel.add(titulo);
        painel.add(labelNome);
        painel.add(textNome);
        painel.add(labelCpf);
        painel.add(textCpf);
        painel.add(labelEndereco);
        painel.add(textEndereco);
        painel.add(labelTelefone);
        painel.add(textTelefone);
        painel.add(labelEmail);
        painel.add(textEmail);
        painel.add(labelSenha);
        painel.add(passSenha);
        this.add(painel);
    }
}