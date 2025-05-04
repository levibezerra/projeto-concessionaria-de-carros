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

    public void adicionarCarroNoEstoque() {
        Carro carro = tipoDeCarro();

        if (carro != null) {
            CarroDto dto = new CarroDto();

            System.out.println("Marca: ");
            dto.setMarca(input.nextLine());
            System.out.println("Modelo: ");
            dto.setModelo(input.nextLine());
            System.out.println("Ano: ");
            dto.setAno(Integer.parseInt(input.nextLine()));
            System.out.println("Preço: ");
            dto.setPreco(new BigDecimal(input.nextLine()));
            System.out.println("Cor: ");
            dto.setCor(input.nextLine());

            if (carro instanceof CarroPopular) {
                carroPopularService.adicionarCarro(dto);
                carro = new CarroPopular(dto.getMarca(), dto.getModelo());
                System.out.println(carro.descricao());
            } else if (carro instanceof CarroEsportivo){
                carroEsportivoService.adicionarCarro(dto);
                carro = new CarroEsportivo(dto.getMarca(), dto.getModelo());
                System.out.println(carro.descricao());
            }
        }
    }

    public static Carro tipoDeCarro() {
        Scanner input = new Scanner(System.in);
        CarroPopularFactory carroPopular = new CarroPopularFactory();
        CarroEsportivoFactory carroEsportivo = new CarroEsportivoFactory();

        Carro carro;

        System.out.println("1- POPULAR \n" +
                           "2- ESPORTIVO");

        System.out.println("Escolha uma opção: ");
        String opcao = input.nextLine();

        switch (opcao) {
            case "1":
                carro = carroPopular.criarCarro();
                break;
            case "2":
                carro = carroEsportivo.criarCarro();
                break;
            default:
                throw new IllegalArgumentException("Tipo de carro não existe!");
        }
        return carro;
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