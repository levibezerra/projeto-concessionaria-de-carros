package org.example.controller;

import org.example.dto.CarroDto;
import org.example.dto.ClienteDto;
import org.example.dto.VendaDto;
import org.example.entity.Pagamento;
import org.example.enums.FormaDePagamento;
import org.example.service.VendaService;

import java.math.BigDecimal;
import java.util.Scanner;

public class VendaController {

    private final VendaService vendaService;
    Scanner input = new Scanner(System.in);

    VendaDto dto = new VendaDto();
    ClienteDto clienteDto = new ClienteDto();
    CarroDto carroDto = new CarroDto();
    Pagamento pagamento = new Pagamento();

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    public void realizarVendaCarro() {

        System.out.println("Informe o ID do CLIENTE: ");
        Long idCliente =  Long.parseLong(input.nextLine());
        clienteDto.setId(idCliente);

        System.out.println("Informe o ID do CARRO: ");
        Long idCarro = Long.parseLong(input.nextLine());
        carroDto.setId(idCarro);

        System.out.println("Informe a forma de pagamento: \n" +
                           "1 - PIX \n" +
                           "2 - CARTÃO");
        System.out.println("Escolha uma opção: ");
        String opcao = input.nextLine();


        System.out.println("Informe o valor: ");
        BigDecimal valor = new BigDecimal(input.nextLine());

        switch (opcao) {
            case "1":
                if (carroDto.getPreco().equals(valor)) {
                    dto.setValorFinalDaVenda(valor);
                    pagamento.setFormaDePagamento(FormaDePagamento.PIX);
                    System.out.println("Carro comprado no PIX com sucesso!");
                } else {
                    System.out.println("O valor informado não corresponde com preço do CARRO!");
                }
                break;
            case "2":
                if (carroDto.getPreco().equals(valor)) {
                    dto.setValorFinalDaVenda(valor);
                    pagamento.setFormaDePagamento(FormaDePagamento.CARTAO);
                    System.out.println("Carro comprado no CARTÃO com sucesso!");
                } else {
                    System.out.println("O valor informado não corresponde com preço do CARRO!");
                }
                break;
            default:
                System.out.println("Opção invalida!");
        }
    }
}