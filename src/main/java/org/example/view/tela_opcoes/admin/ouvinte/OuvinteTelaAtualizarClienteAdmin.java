package org.example.view.tela_opcoes.admin.ouvinte;

import jakarta.persistence.EntityManager;
import org.example.controller.ClienteController;
import org.example.dto.ClienteDto;
import org.example.service.ClienteService;
import org.example.view.tela_opcoes.admin.TelaAtualizarClienteAdmin;
import org.example.view.tela_opcoes.admin.TelaDeOpcoesDeAdmin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteTelaAtualizarClienteAdmin implements ActionListener {

    private EntityManager em;
    private TelaAtualizarClienteAdmin telaAtualizar;

    public OuvinteTelaAtualizarClienteAdmin(TelaAtualizarClienteAdmin telaAtualizar, EntityManager em) {
        this.telaAtualizar = telaAtualizar;
        this.em = em;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object componente = e.getSource();

        ClienteService service = new ClienteService(em);
        ClienteController controller = new ClienteController(service);

        if (componente == telaAtualizar.getBotaoVoltar()) {
            new TelaDeOpcoesDeAdmin(em);
            telaAtualizar.dispose();
        } else if (componente == telaAtualizar.getBotaoBuscar()) {
            String textoId = telaAtualizar.getTextAdicionarID().getText();

            if (textoId == null || textoId.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe o ID do cliente para buscar.");
                return;
            }
            Long id = Long.valueOf(textoId);
            ClienteDto dto = controller.buscarClientePorId(id);

            if (dto != null) {
                telaAtualizar.preencherCampos(dto);
            }
            else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
            }

        } else if (componente == telaAtualizar.getBotaoSalvar()) {
            String textoId = telaAtualizar.getTextAdicionarID().getText();

            if (textoId == null || textoId.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe o ID do cliente para atualizar.");
                return;
            }

            Long id = Long.valueOf(textoId);

            ClienteDto dto = new ClienteDto();
            dto.setNome(telaAtualizar.getTextNome().getText());
            dto.setCpf(telaAtualizar.getTextCpf().getText());
            dto.setEndereco(telaAtualizar.getTextEndereco().getText());
            dto.setTelefone(telaAtualizar.getTextTelefone().getText());
            dto.setEmail(telaAtualizar.getTextEmail().getText());
            dto.setPassword(telaAtualizar.getPassSenha().getText());

            controller.atualizarCliente(id, dto);
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
        }
    }
}