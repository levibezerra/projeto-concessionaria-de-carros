package org.example.view.tela_opcoes.admin.ouvinte;

import jakarta.persistence.EntityManager;
import org.example.abstract_factory.CarroEsportivoFactory;
import org.example.abstract_factory.CarroPopularFactory;
import org.example.controller.CarroController;
import org.example.dto.CarroDto;
import org.example.entity.Carro;
import org.example.entity.CarroEsportivo;
import org.example.entity.CarroPopular;
import org.example.enums.TipoDeCarro;
import org.example.service.CarroEsportivoService;
import org.example.service.CarroPopularService;
import org.example.service.EstoqueService;
import org.example.view.tela_opcoes.admin.TelaAdicionarCarroAdmin;
import org.example.view.tela_opcoes.admin.TelaDeOpcoesDeAdmin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Scanner;

public class OuvinteTelaAdicionarCarroAdmin implements ActionListener {

    private EntityManager em;
    private TelaAdicionarCarroAdmin telaAdicionarCarro;

    public OuvinteTelaAdicionarCarroAdmin(TelaAdicionarCarroAdmin telaAdicionarCarro, EntityManager em) {
        this.telaAdicionarCarro = telaAdicionarCarro;
        this.em = em;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object componente = e.getSource();

        if (componente == telaAdicionarCarro.getBotaoVoltar()) {
            new TelaDeOpcoesDeAdmin(em);
            telaAdicionarCarro.dispose();
        } else if (componente == telaAdicionarCarro.getBotaoAdicionar()) {
            try {
                CarroPopularService servicePopular = new CarroPopularService(em);
                CarroEsportivoService serviceEsportivo = new CarroEsportivoService(em);
                EstoqueService estoqueService = new EstoqueService(em);
                CarroController controller = new CarroController(servicePopular, serviceEsportivo, estoqueService);

                String marca = telaAdicionarCarro.getTextMarca().getText();
                String modelo = telaAdicionarCarro.getTextModelo().getText();
                String anoText = telaAdicionarCarro.getTextAno().getText();
                String precoText = telaAdicionarCarro.getTextPreco().getText();
                String cor = telaAdicionarCarro.getTextCor().getText();
                TipoDeCarro tipo = (TipoDeCarro) telaAdicionarCarro.getTipoDoCarro().getSelectedItem();

                if (marca.isEmpty() || modelo.isEmpty() || anoText.isEmpty() || precoText.isEmpty() || cor.isEmpty()) {
                    JOptionPane.showMessageDialog(telaAdicionarCarro,
                            "Todos os campos devem ser preenchidos.",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int ano = Integer.parseInt(anoText);
                BigDecimal preco = new BigDecimal(precoText);

                CarroDto dto = new CarroDto();
                dto.setMarca(marca);
                dto.setModelo(modelo);
                dto.setAno(ano);
                dto.setPreco(preco);
                dto.setCor(cor);

                Carro carro = tipoDeCarro();
                if (carro instanceof CarroPopular) {
                    carro = new CarroPopularFactory().criarCarro();
                    servicePopular.adicionarCarro(dto);
                    carro = new CarroPopular(dto.getMarca(), dto.getModelo());
                } else if (carro instanceof CarroEsportivo){
                    carro = new CarroEsportivoFactory().criarCarro();
                    serviceEsportivo.adicionarCarro(dto);
                    carro = new CarroEsportivo(dto.getMarca(), dto.getModelo());
                }
                JOptionPane.showMessageDialog(telaAdicionarCarro, carro.descricao(), "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(telaAdicionarCarro,"Erro ao adicionar carro: " + ex.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public Carro tipoDeCarro() {
        Scanner input = new Scanner(System.in);
        CarroPopularFactory carroPopular = new CarroPopularFactory();
        CarroEsportivoFactory carroEsportivo = new CarroEsportivoFactory();

        TipoDeCarro tipo = (TipoDeCarro) telaAdicionarCarro.getTipoDoCarro().getSelectedItem();

        Carro carro;

        if (tipo == TipoDeCarro.POPULAR) {
            carro = carroPopular.criarCarro();
            return carro;
        } else if (tipo == TipoDeCarro.ESPORTIVO) {
            carro = carroEsportivo.criarCarro();
            return carro;
        }
        return null;
    }
}