package org.example.view.tela_opcoes.admin;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.Setter;
import org.example.dto.ClienteDto;
import org.example.view.tela_opcoes.admin.ouvinte.OuvinteTelaAtualizarClienteAdmin;

import javax.swing.*;
import java.awt.*;

@Getter @Setter

public class TelaAtualizarClienteAdmin extends JFrame {

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
    private JButton botaoSalvar;
    private JLabel labelAdicionarID;
    private JTextField textAdicionarID;
    private JButton botaoBuscar;
    private JPanel painel;
    private JLabel titulo;

    public TelaAtualizarClienteAdmin(EntityManager em) {
        this.em = em;
        setTitle("TELA ATUALIZAR CLIENTE");
        setSize(1280, 780);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        adicionarComponentesDeAtualizacao();
        setVisible(true);
    }

    public void adicionarComponentesDeAtualizacao() {

        OuvinteTelaAtualizarClienteAdmin ouvinte = new OuvinteTelaAtualizarClienteAdmin(this, em);

        painel =new JPanel();
        painel.setBounds(0, 0, 1280, 780);
        painel.setBackground(Color.white);
        painel.setLayout(null);

        titulo = new JLabel();
        titulo.setText("ATUALIZAR CLIENTE");
        titulo.setBounds(420, 21, 600, 45);
        titulo.setForeground(Color.BLACK);
        titulo.setFont(new Font("Roboto", Font.BOLD, 40));

        labelNome = new JLabel();
        labelNome.setText("NOME");
        labelNome.setBounds(70, 125, 250, 60);
        labelNome.setForeground(Color.BLACK);
        labelNome.setFont(new Font("Arial", Font.BOLD, 35));

        textNome = new JTextField();
        textNome.setBounds(70, 175, 500, 50);
        textNome.setBackground(Color.LIGHT_GRAY);
        textNome.setForeground(Color.BLACK);
        textNome.setFont(new Font("Arial", Font.PLAIN, 35));
        textNome.setOpaque(true);
        textNome.setBorder(null);

        labelCpf = new JLabel();
        labelCpf.setText("CPF");
        labelCpf.setBounds(70, 285, 250, 60);
        labelCpf.setForeground(Color.BLACK);
        labelCpf.setFont(new Font("Arial", Font.BOLD, 35));

        textCpf = new JTextField();
        textCpf.setBounds(70, 335, 500, 50);
        textCpf.setBackground(Color.LIGHT_GRAY);
        textCpf.setForeground(Color.BLACK);
        textCpf.setFont(new Font("Arial", Font.PLAIN, 35));
        textCpf.setOpaque(true);
        textCpf.setBorder(null);

        labelEndereco = new JLabel();
        labelEndereco.setText("ENDEREÇO");
        labelEndereco.setBounds(70, 465, 250, 60);
        labelEndereco.setForeground(Color.BLACK);
        labelEndereco.setFont(new Font("Arial", Font.BOLD, 35));

        textEndereco = new JTextField();
        textEndereco.setBounds(70, 515, 500, 50);
        textEndereco.setBackground(Color.LIGHT_GRAY);
        textEndereco.setForeground(Color.BLACK);
        textEndereco.setFont(new Font("Arial", Font.PLAIN, 35));
        textEndereco.setOpaque(true);
        textEndereco.setBorder(null);

        labelTelefone = new JLabel();
        labelTelefone.setText("TELEFONE");
        labelTelefone.setBounds(700, 125, 250, 60);
        labelTelefone.setForeground(Color.BLACK);
        labelTelefone.setFont(new Font("Arial", Font.BOLD, 35));

        textTelefone = new JTextField();
        textTelefone.setBounds(700, 175, 500, 50);
        textTelefone.setBackground(Color.LIGHT_GRAY);
        textTelefone.setForeground(Color.BLACK);
        textTelefone.setFont(new Font("Arial", Font.PLAIN, 35));
        textTelefone.setOpaque(true);
        textTelefone.setBorder(null);

        labelEmail = new JLabel();
        labelEmail.setText("EMAIL");
        labelEmail.setBounds(700, 285, 250, 60);
        labelEmail.setForeground(Color.BLACK);
        labelEmail.setFont(new Font("Arial", Font.BOLD, 35));

        textEmail = new JTextField();
        textEmail.setBounds(700, 335, 500, 50);
        textEmail.setBackground(Color.LIGHT_GRAY);
        textEmail.setForeground(Color.BLACK);
        textEmail.setFont(new Font("Arial", Font.PLAIN, 35));
        textEmail.setOpaque(true);
        textEmail.setBorder(null);

        labelSenha = new JLabel();
        labelSenha.setText("SENHA");
        labelSenha.setBounds(700, 465, 250, 60);
        labelSenha.setForeground(Color.BLACK);
        labelSenha.setFont(new Font("Arial", Font.BOLD, 35));

        passSenha = new JPasswordField();
        passSenha.setBounds(700, 515, 500, 50);
        passSenha.setBackground(Color.LIGHT_GRAY);
        passSenha.setForeground(Color.BLACK);
        passSenha.setFont(new Font("Arial", Font.PLAIN, 35));
        passSenha.setOpaque(true);
        passSenha.setBorder(null);

        labelAdicionarID = new JLabel();
        labelAdicionarID.setText("ADICIONE O ID");
        labelAdicionarID.setBounds(70, 655, 370, 50);
        labelAdicionarID.setForeground(Color.BLACK);
        labelAdicionarID.setFont(new Font("Arial", Font.BOLD, 36));

        textAdicionarID = new JTextField();
        textAdicionarID.setBounds(335, 655, 235, 50);
        textAdicionarID.setBackground(Color.LIGHT_GRAY);
        textAdicionarID.setForeground(Color.BLACK);
        textAdicionarID.setFont(new Font("Arial", Font.PLAIN, 35));
        textAdicionarID.setBorder(null);

        botaoBuscar = new JButton();
        botaoBuscar.setText("BUSCAR");
        botaoBuscar.setBounds(700, 655, 200, 50);
        botaoBuscar.setFont(new Font("Arial", Font.BOLD, 35));
        botaoBuscar.setBackground(Color.BLACK);
        botaoBuscar.setForeground(Color.WHITE);
        botaoBuscar.setBorder(null);
        botaoBuscar.setFocusable(false);
        botaoBuscar.setOpaque(true);
        botaoBuscar.addActionListener(ouvinte);

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

        botaoSalvar = new JButton();
        botaoSalvar.setText("SALVAR");
        botaoSalvar.setBounds(1000, 655, 200, 50);
        botaoSalvar.setFont(new Font("Arial", Font.BOLD, 30));
        botaoSalvar.setForeground(Color.WHITE);
        botaoSalvar.setBackground(Color.BLACK);
        botaoSalvar.setOpaque(true);
        botaoSalvar.setBorder(null);
        botaoSalvar.setFocusable(false);
        botaoSalvar.addActionListener(ouvinte);

        painel.add(botaoSalvar);
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
        painel.add(labelAdicionarID);
        painel.add(textAdicionarID);
        painel.add(botaoBuscar);
        this.add(painel);
    }

    public void preencherCampos(ClienteDto dto) {
        textNome.setText(dto.getNome());
        textCpf.setText(dto.getCpf());
        textEndereco.setText(dto.getEndereco());
        textTelefone.setText(dto.getTelefone());
        textEmail.setText(dto.getEmail());
        passSenha.setText(dto.getPassword());

        textCpf.setEditable(false);
        textCpf.setFocusable(false);
    }
}