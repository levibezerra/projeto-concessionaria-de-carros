package org.example.view.tela_opcoes.user.ouvinte;

import jakarta.persistence.EntityManager;
import org.example.controller.VendaController;
import org.example.dto.CarroDto;
import org.example.dto.PagamentoDto;
import org.example.dto.VendaDto;
import org.example.entity.Estoque;
import org.example.entity.Pagamento;
import org.example.enums.FormaDePagamento;
import org.example.enums.Status;
import org.example.enums.TipoDeCarro;
import org.example.service.CarroEsportivoService;
import org.example.service.CarroPopularService;
import org.example.service.VendaService;
import org.example.view.tela_opcoes.user.TelaDeOpcoesDeCliente;
import org.example.view.tela_opcoes.user.TelaRealizarCompraCliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

public class OuvinteTelaRealizarCompraCliente implements ActionListener {

    private EntityManager em;
    private TelaRealizarCompraCliente telaCompra;

    public OuvinteTelaRealizarCompraCliente(TelaRealizarCompraCliente telaCompra, EntityManager em) {
        this.telaCompra = telaCompra;
        this.em = em;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object componente = e.getSource();

        if (componente == telaCompra.getBotaoVoltar()) {
            new TelaDeOpcoesDeCliente(em);
            telaCompra.dispose();
        } else if (componente == telaCompra.getBotaoComprar()) {
            try {
                VendaDto dto = new VendaDto();
                Estoque estoque = new Estoque();
                PagamentoDto pagamentoDto = new PagamentoDto();
                Pagamento pagamento = new Pagamento();
                VendaService vendaService = new VendaService(em);
                CarroPopularService popularService = new CarroPopularService(em);
                CarroEsportivoService esportivoService = new CarroEsportivoService(em);
                VendaController controller = new VendaController(vendaService, popularService, esportivoService);

                TipoDeCarro tipo = (TipoDeCarro) telaCompra.getTipoDoCarro().getSelectedItem();
                FormaDePagamento forma = (FormaDePagamento) telaCompra.getFormaDePagamento().getSelectedItem();

                BigDecimal preco = BigDecimal.valueOf(0);

                Long idCliente = Long.parseLong(telaCompra.getTextIdDoCliente().getText());
                Long idCarro = Long.parseLong(telaCompra.getTextIdDoCarro().getText());
                BigDecimal valorDoCarro = new BigDecimal(telaCompra.getTextValorDoCarro().getText());

                if (tipo == TipoDeCarro.POPULAR) {
                    List<CarroDto> carroPopular = popularService.listarCarroPopular();
                    for (CarroDto carros : carroPopular) {
                        preco = carros.getPreco();
                    }
                    if (preco.compareTo(valorDoCarro) == 0) {
                        dto.setValorFinalDaVenda(valorDoCarro);
                        if (forma == FormaDePagamento.PIX) {
                            pagamentoDto.setFormaDePagamento(FormaDePagamento.PIX);
                        } else {
                            pagamentoDto.setFormaDePagamento(FormaDePagamento.CARTAO);
                        }
                    } else {
                        JOptionPane.showMessageDialog(telaCompra, "Valor informado não corresponde com o valor do CARRO!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (tipo == TipoDeCarro.ESPORTIVO) {
                    List<CarroDto> carroEsportivo = esportivoService.listarCarroEsportivo();
                    for (CarroDto carros : carroEsportivo) {
                        preco = carros.getPreco();
                    }
                    if (preco.compareTo(valorDoCarro) == 0) {
                        dto.setValorFinalDaVenda(valorDoCarro);
                        if (forma == FormaDePagamento.PIX) {
                            pagamentoDto.setFormaDePagamento(FormaDePagamento.PIX);
                        } else {
                            pagamentoDto.setFormaDePagamento(FormaDePagamento.CARTAO);
                        }
                    } else {
                        JOptionPane.showMessageDialog(telaCompra, "Valor informado não corresponde com o valor do CARRO!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
                pagamento.setFormaDePagamento(pagamentoDto.getFormaDePagamento());
                estoque.setStatus(Status.INDISPONIVEL);
                dto.setValorFinalDaVenda(valorDoCarro);
                dto.setPagamento(pagamento);
                dto.setEstoque(estoque);
                vendaService.realizarVenda(idCliente, idCarro, dto);
                JOptionPane.showMessageDialog(telaCompra, "Compra realizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(telaCompra, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}