package org.example.view.tela_opcoes.admin.ouvinte;

import jakarta.persistence.EntityManager;
import org.example.controller.CarroController;
import org.example.dto.CarroDto;
import org.example.enums.TipoDeCarro;
import org.example.service.CarroEsportivoService;
import org.example.service.CarroPopularService;
import org.example.service.EstoqueService;
import org.example.view.tela_opcoes.admin.TelaBuscarCarroAdmin;
import org.example.view.tela_opcoes.admin.TelaDeOpcoesDeAdmin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteTelaBuscarCarroAdmin implements ActionListener {

    private EntityManager em;
    private TelaBuscarCarroAdmin telaBuscarCarro;

    public OuvinteTelaBuscarCarroAdmin(TelaBuscarCarroAdmin telaBuscarCarro, EntityManager em) {
        this.telaBuscarCarro = telaBuscarCarro;
        this.em = em;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object componente = e.getSource();

        if (componente == telaBuscarCarro.getBotaoVoltar()) {
            new TelaDeOpcoesDeAdmin(em);
            telaBuscarCarro.dispose();
        } else if (componente == telaBuscarCarro.getBotaoBuscar()) {
            try {
                Long id = Long.valueOf(telaBuscarCarro.getTextAdicionarID().getText());

                CarroPopularService popularService = new CarroPopularService(em);
                CarroEsportivoService esportivoService = new CarroEsportivoService(em);
                EstoqueService estoqueService = new EstoqueService(em);
                CarroController controller = new CarroController(popularService, esportivoService, estoqueService);

                TipoDeCarro tipo = (TipoDeCarro) telaBuscarCarro.getTipoDoCarro().getSelectedItem();
                CarroDto dto = controller.buscarCarroId(id, tipo);

                if (tipo == TipoDeCarro.POPULAR) {
                   dto = popularService.buscarCarroPorId(id);
                } else {
                    dto = esportivoService.buscarCarroPorId(id);
                }

                if (dto != null) {
                    DefaultTableModel modelo = (DefaultTableModel) telaBuscarCarro.getTabelaCliente().getModel();
                    modelo.setRowCount(0);

                    modelo.addRow(new Object[]{
                            dto.getId(),
                            dto.getMarca(),
                            dto.getModelo(),
                            dto.getAno(),
                            dto.getPreco(),
                            dto.getCor()
                    });
                } else {
                    JOptionPane.showMessageDialog(telaBuscarCarro, "Carro não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(telaBuscarCarro, "ID inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(telaBuscarCarro, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}