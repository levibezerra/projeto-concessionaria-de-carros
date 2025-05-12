package org.example.view.tela_opcoes.admin;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.Setter;
import org.example.view.tela_opcoes.admin.ouvinte.OuvinteTelaListarEstoqueAdmin;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@Getter @Setter

public class TelaListarEstoqueAdmin extends JFrame {

    private EntityManager em;
    private JButton botaoListar;
    private JButton botaoVoltar;
    private JTable tabelaEstoque;
    private JLabel titulo;
    private JScrollPane scroll;
    private JPanel painel;

    public TelaListarEstoqueAdmin(EntityManager em) {
        this.em = em;
        setTitle("TELA LISTAR ESTOQUE");
        setSize(1280, 780);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        adicionarComponentesDeListarEstoque();
        setVisible(true);
    }

    private void adicionarComponentesDeListarEstoque() {

        OuvinteTelaListarEstoqueAdmin ouvinte = new OuvinteTelaListarEstoqueAdmin(this, em);

        painel = new JPanel();
        painel.setBounds(0, 0, 1280, 780);
        painel.setBackground(Color.white);
        painel.setLayout(null);

        titulo = new JLabel();
        titulo.setText("LISTAR ESTOQUE");
        titulo.setBounds(420, 21, 800, 45);
        titulo.setForeground(Color.BLACK);
        titulo.setFont(new Font("Arial", Font.BOLD, 52));

        DefaultTableModel modelo = new DefaultTableModel(new Object[] {
                "ID", "MARCA", "MODELO", "STATUS", "DATA DE CHEGADA", "DATA DE MODIFICAÇÃO"
        }, 0);

        tabelaEstoque = new JTable(modelo);
        tabelaEstoque.setRowHeight(30);
        tabelaEstoque.getTableHeader().setReorderingAllowed(false);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < tabelaEstoque.getColumnCount(); i++) {
            tabelaEstoque.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        scroll = new JScrollPane(tabelaEstoque);
        scroll.setBounds(70, 100, 1140, 500);

        botaoListar = new JButton();
        botaoListar.setText("LISTAR");
        botaoListar.setBounds(380, 645, 550, 50);
        botaoListar.setFont(new Font("Arial", Font.BOLD, 35));
        botaoListar.setBackground(Color.BLACK);
        botaoListar.setForeground(Color.WHITE);
        botaoListar.setBorder(null);
        botaoListar.setFocusable(false);
        botaoListar.setOpaque(true);
        botaoListar.addActionListener(ouvinte);

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
        painel.add(botaoListar);
        painel.add(botaoVoltar);
        painel.add(scroll);
        this.add(painel);
    }
}