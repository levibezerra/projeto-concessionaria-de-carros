package org.example.controller;

import org.example.abstract_factory.CarroEsportivoFactory;
import org.example.abstract_factory.CarroPopularFactory;
import org.example.dto.CarroDto;
import org.example.dto.EstoqueDto;
import org.example.entity.Carro;
import org.example.entity.CarroEsportivo;
import org.example.entity.CarroPopular;
import org.example.service.CarroEsportivoService;
import org.example.service.CarroPopularService;
import org.example.service.EstoqueService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class EstoqueController {

    private final EstoqueService estoqueService;
    private final CarroPopularService carroPopularService;
    private final CarroEsportivoService carroEsportivoService;
    Scanner input = new Scanner(System.in);

    public EstoqueController(CarroPopularService carroPopularService, CarroEsportivoService carroEsportivoService,
                             EstoqueService estoqueService) {
        this.carroPopularService = carroPopularService;
        this.carroEsportivoService = carroEsportivoService;
        this.estoqueService = estoqueService;
    }

    public void adicionarCarroNoEstoque(CarroDto dto) {
        carroPopularService.adicionarCarro(dto);
        carroEsportivoService.adicionarCarro(dto);
    }

    public void listarEstoque() {
        List<EstoqueDto> estoque = estoqueService.listarInfoEstoque();
        if (estoque.isEmpty()) {
            System.out.println("Nenhuma informação no Estoque!");
        } else {
            for (EstoqueDto estoqueDto : estoque) {
                System.out.println(estoqueDto.toString());
            }
        }
    }
}