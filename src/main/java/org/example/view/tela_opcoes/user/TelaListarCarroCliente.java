package org.example.view.tela_opcoes.user;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.TipoDeCarro;
import org.example.view.tela_opcoes.user.ouvinte.OuvinteTelaListarCarroCliente;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@Getter @Setter

public class TelaListarCarroCliente extends JFrame {

    private EntityManager em;
    private Long idClienteLogado;
    private JButton botaoListar;
    private JButton botaoVoltar;
    private JTable tabelaCliente;
    private JLabel labelTipoCarro;
    private JComboBox<TipoDeCarro> tipoDoCarro;
    private JLabel titulo;
    private JScrollPane scroll;
    private JPanel painel;

    public TelaListarCarroCliente(EntityManager em, Long idClienteLogado) {
        this.em = em;
        this.idClienteLogado = idClienteLogado;
        setTitle("TELA LISTAR CARROS");
        setSize(1280, 780);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        adicionarComponentesDeListarCarro();
        setVisible(true);
    }

    private void adicionarComponentesDeListarCarro() {

        OuvinteTelaListarCarroCliente ouvinte = new OuvinteTelaListarCarroCliente(this, em, idClienteLogado);

        painel = new JPanel();
        painel.setBounds(0, 0, 1280, 780);
        painel.setBackground(Color.white);
        painel.setLayout(null);

        titulo = new JLabel();
        titulo.setText("LISTAR CARRO");
        titulo.setBounds(460, 21, 800, 45);
        titulo.setForeground(Color.BLACK);
        titulo.setFont(new Font("Arial", Font.BOLD, 52));

        DefaultTableModel modelo = new DefaultTableModel(new Object[] {
                "ID", "MARCA", "MODELO", "ANO", "PREÇO", "COR"
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

        botaoListar = new JButton();
        botaoListar.setText("LISTAR");
        botaoListar.setBounds(770, 640, 200, 50);
        botaoListar.setFont(new Font("Arial", Font.BOLD, 35));
        botaoListar.setBackground(Color.BLACK);
        botaoListar.setForeground(Color.WHITE);
        botaoListar.setBorder(null);
        botaoListar.setFocusable(false);
        botaoListar.setOpaque(true);
        botaoListar.addActionListener(ouvinte);

        labelTipoCarro = new JLabel();
        labelTipoCarro.setText("TIPO DE CARRO");
        labelTipoCarro.setBounds(270, 640, 500, 50);
        labelTipoCarro.setForeground(Color.BLACK);
        labelTipoCarro.setFont(new Font("Arial", Font.BOLD, 36));

        tipoDoCarro = new JComboBox<>(TipoDeCarro.values());
        tipoDoCarro.setBounds(560, 640, 200, 50);
        tipoDoCarro.setFont(new Font("Arial", Font.PLAIN, 35));
        tipoDoCarro.setBackground(Color.WHITE);
        tipoDoCarro.setForeground(Color.BLACK);
        tipoDoCarro.setOpaque(true);
        tipoDoCarro.setBorder(null);

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
        painel.add(labelTipoCarro);
        painel.add(tipoDoCarro);
        this.add(painel);
    }
}