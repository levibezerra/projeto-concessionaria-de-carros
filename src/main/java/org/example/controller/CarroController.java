package org.example.controller;

import org.example.dto.CarroDto;
import org.example.dto.EstoqueDto;
import org.example.entity.Carro;
import org.example.entity.Estoque;
import org.example.enums.Status;
import org.example.enums.TipoDeCarro;
import org.example.service.CarroEsportivoService;
import org.example.service.CarroPopularService;
import org.example.service.EstoqueService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class CarroController {

    private final CarroPopularService carroPopularService;
    private final CarroEsportivoService carroEsportivoService;
    private final EstoqueService estoqueService;

    Scanner input = new Scanner(System.in);

    public CarroController(CarroPopularService carroPopularService, CarroEsportivoService carroEsportivoService, EstoqueService estoqueService) {
        this.carroPopularService = carroPopularService;
        this.carroEsportivoService = carroEsportivoService;
        this.estoqueService = estoqueService;
    }

    public CarroDto buscarCarroId(Long id, TipoDeCarro tipo) {
        if (tipo == TipoDeCarro.POPULAR) {
            return carroPopularService.buscarCarroPorId(id);
        } else if (tipo == TipoDeCarro.ESPORTIVO) {
            return carroEsportivoService.buscarCarroPorId(id);
        } else {
            throw new IllegalArgumentException("Tipo de carro não reconhecido!");
        }
    }

    public List<CarroDto> listarCarros(TipoDeCarro tipo) {
        if (tipo == TipoDeCarro.POPULAR) {
            return carroPopularService.listarCarroPopular();
        } else if (tipo == TipoDeCarro.ESPORTIVO) {
            return carroEsportivoService.listarCarroEsportivo();
        } else {
            throw new IllegalArgumentException("Nenhum carro disponivel no momento!");
        }
    }

    public void atualizarCarro(Long id, TipoDeCarro tipo, CarroDto dto) {
        if (tipo == TipoDeCarro.POPULAR) {
            carroPopularService.atualizarCarroPopular(id, dto);
        } else if (tipo == TipoDeCarro.ESPORTIVO) {
            carroEsportivoService.atualizarCarroEsportivo(id, dto);
        } else {
            throw new IllegalArgumentException("Este carro ainda não foi adicionado.");
        }
    }

    public void deletarCarro(Long id, TipoDeCarro tipo, CarroDto dto) {
        if (tipo == TipoDeCarro.POPULAR) {
            carroPopularService.deletarCarroPopular(id, dto);
        } else if (tipo == TipoDeCarro.ESPORTIVO) {
            carroEsportivoService.deletarCarroEsportivo(id, dto);
        } else {
            throw new IllegalArgumentException("Este carro ainda não foi adicionado .");
        }
    }
}