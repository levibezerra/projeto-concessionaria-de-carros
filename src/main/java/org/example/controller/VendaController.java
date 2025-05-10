package org.example.controller;

import org.example.dao.CarroDao;
import org.example.dto.*;
import org.example.entity.*;
import org.example.enums.FormaDePagamento;
import org.example.enums.Status;
import org.example.enums.StatusDoPagamento;
import org.example.service.CarroEsportivoService;
import org.example.service.CarroPopularService;
import org.example.service.VendaService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class VendaController {

    private final VendaService vendaService;
    private final CarroPopularService carroPopularService;
    private final CarroEsportivoService carroEsportivoService;

    VendaDto dto = new VendaDto();
    ClienteDto clienteDto = new ClienteDto();
    CarroDto carroDto = new CarroDto();
    Pagamento pagamento = new Pagamento();
    PagamentoDto pagamentoDto = new PagamentoDto();
    Estoque estoque = new Estoque();
    EstoqueDto estoqueDto = new EstoqueDto();

    Scanner input = new Scanner(System.in);

    public VendaController(VendaService vendaService, CarroPopularService carroPopularService, CarroEsportivoService carroEsportivoService) {
        this.vendaService = vendaService;
        this.carroPopularService = carroPopularService;
        this.carroEsportivoService = carroEsportivoService;
    }

    BigDecimal preco = BigDecimal.valueOf(0);

    public void realizarVendaCarro() {
        System.out.println("Informe o ID do CLIENTE: ");
        Long idCliente =  Long.parseLong(input.nextLine());

        System.out.println("Informe o ID do CARRO: ");
        Long idCarro = Long.parseLong(input.nextLine());

        System.out.println("Informe a forma de pagamento: \n" +
                "1 - PIX \n" +
                "2 - CARTÃO");
        System.out.println("Escolha uma opção: ");
        String opcao = input.nextLine();

        System.out.println("Informe o valor: ");
        BigDecimal valor = new BigDecimal(input.nextLine());

        System.out.println("O tipo do CARRO é: \n" +
                "1- POPULAR \n" +
                "2- ESPORTIVO");
        String opcaoCarro = input.nextLine();

        if (opcaoCarro.equals("1")) {
            List<CarroDto> carroPopular = carroPopularService.listarCarroPopular();
            for (CarroDto carros : carroPopular) {
                preco = carros.getPreco();
            }
            if (preco.compareTo(valor) == 0) {
                dto.setValorFinalDaVenda(valor);
                if (opcao.equals("1")) {
                    pagamentoDto.setFormaDePagamento(FormaDePagamento.PIX);
                } else {
                    pagamentoDto.setFormaDePagamento(FormaDePagamento.CARTAO);
                }
            } else {
                System.out.println("Valor informado não corresponde com o valor do CARRO!");
            }
        } else if (opcaoCarro.equals("2")) {
            List<CarroDto> carroPopular = carroEsportivoService.listarCarroEsportivo();
            for (CarroDto carros : carroPopular) {
                preco = carros.getPreco();
            }
            if (preco.compareTo(valor) == 0) {
                dto.setValorFinalDaVenda(valor);
                if (opcao.equals("1")) {
                    pagamentoDto.setFormaDePagamento(FormaDePagamento.PIX);
                } else {
                    pagamentoDto.setFormaDePagamento(FormaDePagamento.CARTAO);
                }
            } else {
                System.out.println("Valor informado não corresponde com o valor do CARRO!");
            }
        } else {
            System.out.println("Opção invalida!");
        }
        pagamento.setFormaDePagamento(pagamentoDto.getFormaDePagamento());
        estoque.setStatus(Status.INDISPONIVEL);
        dto.setValorFinalDaVenda(valor);
        dto.setPagamento(pagamento);
        dto.setEstoque(estoque);
        vendaService.realizarVenda(idCliente, idCarro, dto);
        System.out.println("Compra realizada com sucesso!");
    }
}