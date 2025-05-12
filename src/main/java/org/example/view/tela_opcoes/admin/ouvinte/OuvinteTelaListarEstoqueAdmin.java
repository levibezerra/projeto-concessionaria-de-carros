package org.example.view.tela_opcoes.admin.ouvinte;

import jakarta.persistence.EntityManager;
import org.example.controller.EstoqueController;
import org.example.dto.EstoqueDto;
import org.example.service.CarroEsportivoService;
import org.example.service.CarroPopularService;
import org.example.service.EstoqueService;
import org.example.view.tela_opcoes.admin.TelaDeOpcoesDeAdmin;
import org.example.view.tela_opcoes.admin.TelaListarEstoqueAdmin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class OuvinteTelaListarEstoqueAdmin implements ActionListener {

    private EntityManager em;
    private TelaListarEstoqueAdmin telaListarEstoque;

    public OuvinteTelaListarEstoqueAdmin(TelaListarEstoqueAdmin telaListarEstoque, EntityManager em) {
        this.telaListarEstoque = telaListarEstoque;
        this.em = em;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object componente = e.getSource();

        if (componente == telaListarEstoque.getBotaoVoltar()) {
            new TelaDeOpcoesDeAdmin(em);
            telaListarEstoque.dispose();
        } else if (componente == telaListarEstoque.getBotaoListar()) {
            CarroPopularService popularService = new CarroPopularService(em);
            CarroEsportivoService esportivoService = new CarroEsportivoService(em);
            EstoqueService estoqueService = new EstoqueService(em);
            EstoqueController controller = new EstoqueController(popularService, esportivoService, estoqueService);
            List<EstoqueDto> estoque = controller.listarEstoque();

            DefaultTableModel modelo = (DefaultTableModel) telaListarEstoque.getTabelaEstoque().getModel();
            modelo.setRowCount(0);

            if (estoque.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhuma informação no Estoque!");
            } else {
                for (EstoqueDto dto : estoque) {
                    modelo.addRow(new Object[] {
                            dto.getId(),
                            dto.getMarcaDoCarro(),
                            dto.getModeloDoCarro(),
                            dto.getStatus(),
                            dto.getDataDeChegada(),
                            dto.getDataDeModificacao()
                    });
                }
            }
        }
    }
}