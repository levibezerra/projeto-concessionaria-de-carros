package org.example.view.tela_opcoes.admin.ouvinte;

import jakarta.persistence.EntityManager;
import org.example.controller.CarroController;
import org.example.dto.CarroDto;
import org.example.enums.TipoDeCarro;
import org.example.service.CarroEsportivoService;
import org.example.service.CarroPopularService;
import org.example.service.EstoqueService;
import org.example.view.tela_opcoes.admin.TelaAtualizarCarroAdmin;
import org.example.view.tela_opcoes.admin.TelaDeOpcoesDeAdmin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class OuvinteTelaAtualizarCarroAdmin implements ActionListener {

    private EntityManager em;
    private TelaAtualizarCarroAdmin telaAtualizarCarro;

    public OuvinteTelaAtualizarCarroAdmin(TelaAtualizarCarroAdmin telaAtualizarCarro, EntityManager em) {
        this.telaAtualizarCarro = telaAtualizarCarro;
        this.em = em;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object componente = e.getSource();

        CarroPopularService popularService = new CarroPopularService(em);
        CarroEsportivoService esportivoService = new CarroEsportivoService(em);
        EstoqueService estoqueService = new EstoqueService(em);
        CarroController controller = new CarroController(popularService, esportivoService, estoqueService);
        TipoDeCarro tipo = (TipoDeCarro) telaAtualizarCarro.getTipoDoCarro().getSelectedItem();

        if (componente == telaAtualizarCarro.getBotaoVoltar()) {
            new TelaDeOpcoesDeAdmin(em);
            telaAtualizarCarro.dispose();
        } else if (componente == telaAtualizarCarro.getBotaoBuscar()) {
            String textoId = telaAtualizarCarro.getTextAdicionarID().getText();

            if (textoId == null || textoId.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe o ID do carro para buscar.");
                return;
            }
            Long id = Long.valueOf(textoId);
            CarroDto dto = controller.buscarCarroId(id, tipo);

            if (dto != null) {
                telaAtualizarCarro.preencherCampos(dto);
            } else {
                JOptionPane.showMessageDialog(null, "Carro não encontrado.");
            }
        } else if (componente == telaAtualizarCarro.getBotaoSalvar()) {
            try {
                String textoId = telaAtualizarCarro.getTextAdicionarID().getText();

                if (textoId == null || textoId.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Informe o ID do cliente para atualizar.");
                    return;
                }
                Long id = Long.valueOf(textoId);

                CarroDto dto = new CarroDto();
                dto.setMarca(telaAtualizarCarro.getTextMarca().getText());
                dto.setModelo(telaAtualizarCarro.getTextModelo().getText());
                dto.setAno(Integer.parseInt(telaAtualizarCarro.getTextAno().getText()));
                dto.setPreco(new BigDecimal(telaAtualizarCarro.getTextPreco().getText()));
                dto.setCor(telaAtualizarCarro.getTextCor().getText());

                if (tipo == TipoDeCarro.POPULAR) {
                    popularService.atualizarCarroPopular(id, dto);
                    JOptionPane.showMessageDialog(null, "Carro Popular atualizado com sucesso!");
                } else {
                    esportivoService.atualizarCarroEsportivo(id, dto);
                    JOptionPane.showMessageDialog(null, "Carro Esportivo atualizado com sucesso!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar carro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}