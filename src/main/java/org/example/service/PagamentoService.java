package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.dao.PagamentoDao;
import org.example.dto.PagamentoDto;
import org.example.entity.Pagamento;

import java.util.List;

public class PagamentoService {

    private PagamentoDao pagamentoDao;
    private EntityManager em;

    public PagamentoService(EntityManager em) {
        this.em = em;
        this.pagamentoDao = new PagamentoDao(em);
    }

    public void salvarPagamento(PagamentoDto dto) {
        Pagamento pagamento = new Pagamento();
        pagamento.setId(dto.getId());
        pagamento.setVenda(dto.getVenda());
        pagamento.setDataDoPagamento(dto.getDataDoPagamento());
        pagamento.setFormaDePagamento(dto.getFormaDePagamento());
        pagamentoDao.salvar(pagamento);
    }

    public List<Pagamento> listarPagamentos() {
        return pagamentoDao.listar();
    }

    public Pagamento buscarPagamentoPorId(Long id) {
        return pagamentoDao.buscarPorId(id);
    }

    public void atualizarPagamento(PagamentoDto dto) {
        Pagamento pagamento = pagamentoDao.buscarPorId(dto.getId());
        if (pagamento != null) {
            pagamento.setStatusDoPagamento(dto.getStatusDoPagamento());
            pagamento.setFormaDePagamento(dto.getFormaDePagamento());
            pagamentoDao.atualizar(pagamento);
        }
    }

    public void deletarPagamento(Long id) {
        pagamentoDao.deletar(id);
    }
}