package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.dao.*;
import org.example.dto.PagamentoDto;
import org.example.dto.VendaDto;
import org.example.entity.*;
import org.example.enums.Status;
import org.example.enums.StatusDoPagamento;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class VendaService {

    private EstoqueDao estoqueDao;
    private CarroVendidoDao carroVendidoDao;
    private VendaDao vendaDao;
    private CarroDao carroDao;
    private ClienteDao clienteDao;
    private EntityManager em;

    public VendaService(EntityManager em) {
        this.em = em;
        this.carroDao = new CarroDao(em);
        this.clienteDao = new ClienteDao(em);
        this.vendaDao = new VendaDao(em);
        this.carroVendidoDao = new CarroVendidoDao(em);
        this.estoqueDao = new EstoqueDao(em);
    }

    public void realizarVenda(Long idCliente, Long idCarro, VendaDto dto) {
        Cliente cliente = clienteDao.buscarPorId(idCliente);
        Carro carro = carroDao.buscarPorId(idCarro);

        if (cliente == null || carro == null) {
            throw new RuntimeException("Cliente e Carro não encontrados!");
        }

        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setCarro(carro);
        venda.setValorFinalDaVenda(dto.getValorFinalDaVenda());
        venda.dataDaVendaSalva();

        Pagamento pagamento = new Pagamento();
        pagamento.setFormaDePagamento(dto.getPagamento().getFormaDePagamento());
        pagamento.setStatusDoPagamento(StatusDoPagamento.REALIZADO);
        pagamento.setDataDoPagamento(LocalDateTime.now());
        pagamento.setVenda(venda);

        venda.setPagamento(pagamento);

        vendaDao.salvar(venda);

        CarroVendido carroVendido = new CarroVendido();
        carroVendido.setMarca(carro.getMarca());
        carroVendido.setModelo(carro.getModelo());
        carroVendido.setAno(carro.getAno());
        carroVendido.setPreco(carro.getPreco());
        carroVendido.setCor(carro.getCor());
        carroVendidoDao.salvar(carroVendido);

        Estoque estoque = estoqueDao.buscarCarroNoEstoquePorId(carro.getId());
        estoque.setStatus(Status.INDISPONIVEL);
        estoqueDao.atualizar(estoque);
        venda.setEstoque(estoque);
    }

    public List<VendaDto> listarTodasAsVendas() {
        List<Venda> vendas = vendaDao.listarVendas();
        return vendas.stream().map(this::vendasRealizadas).collect(Collectors.toList());
    }

    public VendaDto vendasRealizadas(Venda venda) {
        VendaDto dto = new VendaDto();
        dto.setId(venda.getId());
        dto.setCliente(venda.getCliente());
        dto.setCarro(venda.getCarro());
        dto.setValorFinalDaVenda(venda.getValorFinalDaVenda());
        dto.setDataDaVenda(venda.getDataDaVenda());
        return dto;
    }
}