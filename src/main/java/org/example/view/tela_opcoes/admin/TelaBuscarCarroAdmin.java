package org.example.view.tela_opcoes.admin;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.TipoDeCarro;
import org.example.view.tela_opcoes.admin.ouvinte.OuvinteTelaBuscarCarroAdmin;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@Getter @Setter

public class TelaBuscarCarroAdmin extends JFrame {

    private EntityManager em;
    private JLabel labelAdicionarID;
    private JTextField textAdicionarID;
    private JButton botaoBuscar;
    private JButton botaoVoltar;
    private JTable tabelaCliente;
    private JLabel labelTipoCarro;
    private JComboBox<TipoDeCarro> tipoDoCarro;
    private JLabel titulo;
    private JScrollPane scroll;
    private JPanel painel;

    public TelaBuscarCarroAdmin(EntityManager em) {
        this.em = em;
        setTitle("TELA BUSCAR CLIENTE PELO ID");
        setSize(1280, 780);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        adicionarComponentesDeBuscarCarro();
        setVisible(true);
    }

    private void adicionarComponentesDeBuscarCarro() {

        OuvinteTelaBuscarCarroAdmin ouvinte = new OuvinteTelaBuscarCarroAdmin(this, em);

        painel = new JPanel();
        painel.setBounds(0, 0, 1280, 780);
        painel.setBackground(Color.white);
        painel.setLayout(null);

        titulo = new JLabel();
        titulo.setText("BUSCAR CARRO PELO ID");
        titulo.setBounds(330, 21, 800, 45);
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

        labelAdicionarID = new JLabel();
        labelAdicionarID.setText("ADICIONE O ID");
        labelAdicionarID.setBounds(70, 640, 370, 50);
        labelAdicionarID.setForeground(Color.BLACK);
        labelAdicionarID.setFont(new Font("Arial", Font.BOLD, 36));

        textAdicionarID = new JTextField();
        textAdicionarID.setBounds(335, 640, 100, 50);
        textAdicionarID.setBackground(Color.LIGHT_GRAY);
        textAdicionarID.setForeground(Color.BLACK);
        textAdicionarID.setFont(new Font("Arial", Font.PLAIN, 35));
        textAdicionarID.setBorder(null);

        botaoBuscar = new JButton();
        botaoBuscar.setText("BUSCAR");
        botaoBuscar.setBounds(1010, 640, 200, 50);
        botaoBuscar.setFont(new Font("Arial", Font.BOLD, 35));
        botaoBuscar.setBackground(Color.BLACK);
        botaoBuscar.setForeground(Color.WHITE);
        botaoBuscar.setBorder(null);
        botaoBuscar.setFocusable(false);
        botaoBuscar.setOpaque(true);
        botaoBuscar.addActionListener(ouvinte);

        labelTipoCarro = new JLabel();
        labelTipoCarro.setText("TIPO DE CARRO");
        labelTipoCarro.setBounds(460, 640, 500, 50);
        labelTipoCarro.setForeground(Color.BLACK);
        labelTipoCarro.setFont(new Font("Arial", Font.BOLD, 36));

        tipoDoCarro = new JComboBox<>(TipoDeCarro.values());
        tipoDoCarro.setBounds(775, 640, 200, 50);
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
        painel.add(labelAdicionarID);
        painel.add(textAdicionarID);
        painel.add(botaoBuscar);
        painel.add(botaoVoltar);
        painel.add(scroll);
        painel.add(labelTipoCarro);
        painel.add(tipoDoCarro);
        this.add(painel);
    }
}