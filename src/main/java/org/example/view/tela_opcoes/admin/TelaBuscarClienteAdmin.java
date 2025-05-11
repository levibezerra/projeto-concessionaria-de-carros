package org.example.view.tela_opcoes.admin;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.Setter;
import org.example.dto.ClienteDto;
import org.example.view.tela_opcoes.admin.ouvinte.OuvinteTelaBuscarClienteAdmin;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@Getter @Setter

public class TelaBuscarClienteAdmin extends JFrame {

    private EntityManager em;
    private JLabel labelAdicionarID;
    private JTextField textAdicionarID;
    private JButton botaoBuscar;
    private JButton botaoVoltar;
    private JTable tabelaCliente;
    private JLabel titulo;
    private JScrollPane scroll;
    private JPanel painel;

    public TelaBuscarClienteAdmin(EntityManager em) {
        this.em = em;
        setTitle("TELA BUSCAR CLIENTE PELO ID");
        setSize(1280, 780);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        adicionarComponentesDeBuscarCliente();
        setVisible(true);
    }

    public void adicionarComponentesDeBuscarCliente() {

        OuvinteTelaBuscarClienteAdmin ouvinte = new OuvinteTelaBuscarClienteAdmin(this, em);

        painel = new JPanel();
        painel.setBounds(0, 0, 1280, 780);
        painel.setBackground(Color.white);
        painel.setLayout(null);

        titulo = new JLabel();
        titulo.setText("BUSCAR CLIENTE PELO ID");
        titulo.setBounds(330, 21, 800, 45);
        titulo.setForeground(Color.BLACK);
        titulo.setFont(new Font("Arial", Font.BOLD, 52));

        DefaultTableModel modelo = new DefaultTableModel(new Object[] {
                "ID", "NOME", "CPF", "ENDEREÇO", "TELEFONE", "EMAIL", "SENHA"
        }, 0);

        tabelaCliente = new JTable(modelo);
        tabelaCliente.setRowHeight(30);
        tabelaCliente.getTableHeader().setReorderingAllowed(false);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < tabelaCliente.getColumnCount(); i++) {
            tabelaCliente.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        scroll = new JScrollPane(tabelaCliente);
        scroll.setBounds(70, 100, 1140, 500);

        labelAdicionarID = new JLabel();
        labelAdicionarID.setText("ADICIONE O ID");
        labelAdicionarID.setBounds(70, 640, 370, 50);
        labelAdicionarID.setForeground(Color.BLACK);
        labelAdicionarID.setFont(new Font("Arial", Font.BOLD, 36));

        textAdicionarID = new JTextField();
        textAdicionarID.setBounds(335, 640, 400, 50);
        textAdicionarID.setBackground(Color.LIGHT_GRAY);
        textAdicionarID.setForeground(Color.BLACK);
        textAdicionarID.setFont(new Font("Arial", Font.PLAIN, 35));
        textAdicionarID.setBorder(null);

        botaoBuscar = new JButton();
        botaoBuscar.setText("BUSCAR");
        botaoBuscar.setBounds(890, 640, 200, 50);
        botaoBuscar.setFont(new Font("Arial", Font.BOLD, 35));
        botaoBuscar.setBackground(Color.BLACK);
        botaoBuscar.setForeground(Color.WHITE);
        botaoBuscar.setBorder(null);
        botaoBuscar.setFocusable(false);
        botaoBuscar.setOpaque(true);
        botaoBuscar.addActionListener(ouvinte);

        botaoVoltar = new JButton();
        botaoVoltar.setText("VOLTAR");
        botaoVoltar.setBounds(70, 21, 182, 45);
        botaoVoltar.setFont(new Font("Arial", Font.BOLD, 30));
        botaoVoltar.setBackground(Color.BLACK);
        botaoVoltar.setForeground(Color.WHITE);
        botaoVoltar.setBorder(null);
        botaoVoltar.setFocusable(false);
        botaoVoltar.setOpaque(true);
        botaoVoltar.addActionListener(ouvinte);

        painel.add(titulo);
        painel.add(labelAdicionarID);
        painel.add(textAdicionarID);
        painel.add(botaoBuscar);
        painel.add(botaoVoltar);
        painel.add(scroll);
        this.add(painel);
    }
}