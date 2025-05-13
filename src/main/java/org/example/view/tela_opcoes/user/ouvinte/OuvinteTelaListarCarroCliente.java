package org.example.view.tela_opcoes.user.ouvinte;

import jakarta.persistence.EntityManager;
import org.example.controller.CarroController;
import org.example.dto.CarroDto;
import org.example.enums.TipoDeCarro;
import org.example.service.CarroEsportivoService;
import org.example.service.CarroPopularService;
import org.example.service.EstoqueService;
import org.example.view.tela_opcoes.user.TelaDeOpcoesDeCliente;
import org.example.view.tela_opcoes.user.TelaListarCarroCliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class OuvinteTelaListarCarroCliente implements ActionListener {

    private EntityManager em;
    private TelaListarCarroCliente telaListarCarro;
    private Long idClienteLogado;

    public OuvinteTelaListarCarroCliente(TelaListarCarroCliente telaListarCarro, EntityManager em, Long idClienteLogado) {
        this.telaListarCarro = telaListarCarro;
        this.em = em;
        this.idClienteLogado = idClienteLogado;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object componente = e.getSource();

        if (componente == telaListarCarro.getBotaoVoltar()) {
            new TelaDeOpcoesDeCliente(em, idClienteLogado);
            telaListarCarro.dispose();
        } else if (componente == telaListarCarro.getBotaoListar()) {
            try {
                CarroPopularService popularService = new CarroPopularService(em);
                CarroEsportivoService esportivoService = new CarroEsportivoService(em);
                EstoqueService estoqueService = new EstoqueService(em);
                CarroController controller = new CarroController(popularService, esportivoService, estoqueService);

                TipoDeCarro tipo = (TipoDeCarro) telaListarCarro.getTipoDoCarro().getSelectedItem();
                List<CarroDto> carros = controller.listarCarros(tipo);

                DefaultTableModel modelo = (DefaultTableModel) telaListarCarro.getTabelaCliente().getModel();
                modelo.setRowCount(0);

                if (carros.isEmpty()) {
                    JOptionPane.showMessageDialog(telaListarCarro, "Nenhum carro encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    for (CarroDto dto : carros) {
                        modelo.addRow(new Object[]{
                                dto.getId(),
                                dto.getMarca(),
                                dto.getModelo(),
                                dto.getAno(),
                                dto.getPreco(),
                                dto.getCor()
                        });
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(telaListarCarro, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}