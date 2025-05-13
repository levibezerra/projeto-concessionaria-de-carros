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

    public void realizarVendaCarro(Long idCliente, Long idCarro, VendaDto dto) {
        vendaService.realizarVenda(idCliente, idCarro, dto);
    }
}