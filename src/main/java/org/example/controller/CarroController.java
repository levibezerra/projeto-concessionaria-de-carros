package org.example.controller;

import org.example.dto.CarroDto;
import org.example.dto.EstoqueDto;
import org.example.entity.Carro;
import org.example.entity.Estoque;
import org.example.enums.Status;
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

    public void buscarCarroId() {
            System.out.println("Informe o tipo do carro que deseja BUSCAR: \n" +
                               "1 - POPULAR \n" +
                               "2 - ESPORTIVO");

            System.out.println("Informe uma opção: ");
            String opcao = input.nextLine();

        CarroDto dto = new CarroDto();

            if (opcao.equals("1")) {
                System.out.println("Informe o ID: ");
                Long id = Long.parseLong(input.nextLine());
                dto = carroPopularService.buscarCarroPorId(id);
                System.out.println(dto.toString());
            } else if (opcao.equals("2")){
                System.out.println("Informe o ID: ");
                Long id = Long.parseLong(input.nextLine());
                dto = carroEsportivoService.buscarCarroPorId(id);
                System.out.println(dto.toString());
            } else {
                System.out.println("Carro não encontrado!");
            }
    }

    public void listarCarros() {
        System.out.println("Informe o tipo do carro que deseja LISTAR: \n" +
                           "1 - POPULAR \n" +
                           "2 - ESPORTIVO");

        System.out.println("Informe uma opção: ");
        String opcao = input.nextLine();

        switch (opcao) {
            case "1":
                List<CarroDto> carroPopular = carroPopularService.listarCarroPopular();
                if (carroPopular.isEmpty()) {
                    System.out.println("Nenhum carro popular cadastrado!");
                } else {
                    for (CarroDto carros : carroPopular) {
                        System.out.println(carros.toString());
                    }
                }
                break;
            case "2":
                List<CarroDto> carroEsportivo = carroEsportivoService.listarCarroEsportivo();
                if (carroEsportivo.isEmpty()) {
                    System.out.println("Nenhum carro esportivo cadastrado!");
                } else {
                    for (CarroDto carros : carroEsportivo) {
                        System.out.println(carros.toString());
                    }
                }
                break;
        }
    }

    public void atualizarCarro() {
        System.out.println("Informe o tipo do carro que deseja ATUALIZAR: \n" +
                "1 - POPULAR \n" +
                "2 - ESPORTIVO");

        System.out.println("Informe uma opção: ");
        String opcao = input.nextLine();

        System.out.println("Informe o ID do carro: ");
        Long id = Long.parseLong(input.nextLine());

        System.out.println("Informe o novo preço do carro: ");
        BigDecimal preco = new BigDecimal(input.nextLine());

        CarroDto dto = new CarroDto();

        dto.setPreco(preco);

        if (opcao.equals("1")) {
            carroPopularService.atualizarCarroPopular(id, dto);
            System.out.println("Preço do Carro Popular atualizado com sucesso!");
        } else {
            carroEsportivoService.atualizarCarroEsportivo(id, dto);
            System.out.println("Preço do Carro Esportivo atualizado com sucesso!");
        }
    }

    public void deletarCarro() {
        EstoqueDto dto = new EstoqueDto();

        System.out.println("Informe o tipo do carro que deseja DELETAR: \n" +
                "1 - POPULAR \n" +
                "2 - ESPORTIVO");

        System.out.println("Informe uma opção: ");
        String opcao = input.nextLine();

        System.out.println("Informe o ID do carro: ");
        Long id = Long.parseLong(input.nextLine());

        if (opcao.equals("1")) {
            carroPopularService.deletarCarroPopular(id);
            dto.setStatus(Status.INDISPONIVEL);
            System.out.println("Carro Popular deletado com sucesso!");
        } else {
            carroEsportivoService.deletarCarroEsportivo(id);
            dto.setStatus(Status.INDISPONIVEL);
            System.out.println("Carro Esportivo deletado com sucesso!");
        }
    }
}