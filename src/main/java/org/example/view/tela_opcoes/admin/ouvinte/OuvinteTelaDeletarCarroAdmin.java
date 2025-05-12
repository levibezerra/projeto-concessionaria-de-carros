package org.example.view.tela_opcoes.admin.ouvinte;

import jakarta.persistence.EntityManager;
import org.example.controller.CarroController;
import org.example.dto.CarroDto;
import org.example.enums.TipoDeCarro;
import org.example.service.CarroEsportivoService;
import org.example.service.CarroPopularService;
import org.example.service.EstoqueService;
import org.example.view.tela_opcoes.admin.TelaDeOpcoesDeAdmin;
import org.example.view.tela_opcoes.admin.TelaDeletarCarroAdmin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class OuvinteTelaDeletarCarroAdmin implements ActionListener {

    private EntityManager em;
    private TelaDeletarCarroAdmin telaDeletarCarro;

    public OuvinteTelaDeletarCarroAdmin(TelaDeletarCarroAdmin telaDeletarCarro, EntityManager em) {
        this.telaDeletarCarro = telaDeletarCarro;
        this.em = em;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object componente = e.getSource();

        CarroPopularService popularService = new CarroPopularService(em);
        CarroEsportivoService esportivoService = new CarroEsportivoService(em);
        EstoqueService estoqueService = new EstoqueService(em);
        CarroController controller = new CarroController(popularService, esportivoService, estoqueService);
        TipoDeCarro tipo = (TipoDeCarro) telaDeletarCarro.getTipoDoCarro().getSelectedItem();

        if (componente == telaDeletarCarro.getBotaoVoltar()) {
            new TelaDeOpcoesDeAdmin(em);
            telaDeletarCarro.dispose();
        } else if (componente == telaDeletarCarro.getBotaoBuscar()) {
            String textoId = telaDeletarCarro.getTextAdicionarID().getText();

            if (textoId == null || textoId.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe o ID do carro para buscar.");
                return;
            }
            Long id = Long.valueOf(textoId);
            CarroDto dto = controller.buscarCarroId(id, tipo);

            if (dto != null) {
                telaDeletarCarro.preencherCampos(dto);
            } else {
                JOptionPane.showMessageDialog(null, "Carro não encontrado.");
            }
        } else if (componente == telaDeletarCarro.getBotaoDeletar()) {
            try {
                String textoId = telaDeletarCarro.getTextAdicionarID().getText();

                if (textoId == null || textoId.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Informe o ID do cliente para atualizar.");
                    return;
                }
                Long id = Long.valueOf(textoId);

                CarroDto dto = new CarroDto();
                dto.setMarca(telaDeletarCarro.getTextMarca().getText());
                dto.setModelo(telaDeletarCarro.getTextModelo().getText());
                dto.setAno(Integer.parseInt(telaDeletarCarro.getTextAno().getText()));
                dto.setPreco(new BigDecimal(telaDeletarCarro.getTextPreco().getText()));
                dto.setCor(telaDeletarCarro.getTextCor().getText());

                if (tipo == TipoDeCarro.POPULAR) {
                    popularService.deletarCarroPopular(id, dto);
                    JOptionPane.showMessageDialog(null, "Carro Popular deletado com sucesso!");
                } else {
                    esportivoService.deletarCarroEsportivo(id, dto);
                    JOptionPane.showMessageDialog(null, "Carro Esportivo deletado com sucesso!");
                }
                telaDeletarCarro.limparCampos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao deletar o carro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}