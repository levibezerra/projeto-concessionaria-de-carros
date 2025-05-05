package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.dao.*;
import org.example.dto.PagamentoDto;
import org.example.dto.VendaDto;
import org.example.entity.*;
import org.example.enums.StatusDoPagamento;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class VendaService {

    private CarroVendidoDao carroVendidoDao;
    private VendaDao vendaDao;
    private CarroDao carroDao;
    private ClienteDao clienteDao;
    private EntityManager em;

    public VendaService(EntityManager em) {
        this.em = em;
        this.carroDao = carroDao;
        this.clienteDao = clienteDao;
        this.vendaDao = vendaDao;
        this.carroVendidoDao = carroVendidoDao;
    }

    public void realizarVenda(VendaDto dto) {
        Cliente cliente = clienteDao.buscarPorId(dto.getCliente().getId());
        Carro carro = carroDao.buscarPorId(dto.getCarro().getId());

        if (cliente == null || carro == null) {
            throw new RuntimeException("Cliente e Carro não encontrados!");
        }

        PagamentoDto pagamentoDto = new PagamentoDto();
        Pagamento pagamento = new Pagamento();
        pagamento.setFormaDePagamento(pagamentoDto.getFormaDePagamento());
        pagamento.setStatusDoPagamento(StatusDoPagamento.REALIZADO);
        pagamento.setDataDoPagamento(pagamentoDto.getDataDoPagamento());

        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setCarro(carro);
        venda.setValorFinalDaVenda(dto.getValorFinalDaVenda());
        venda.setPagamento(pagamento);
        venda.dataDaVendaSalva();
        vendaDao.salvar(venda);

        CarroVendido carroVendido = new CarroVendido();
        carroVendido.setMarca(carro.getMarca());
        carroVendido.setModelo(carro.getModelo());
        carroVendido.setAno(carro.getAno());
        carroVendido.setPreco(carro.getPreco());
        carroVendido.setCor(carro.getCor());
        carroVendidoDao.salvar(carroVendido);
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