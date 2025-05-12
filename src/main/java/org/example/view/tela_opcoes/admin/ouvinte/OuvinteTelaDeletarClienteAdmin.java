package org.example.view.tela_opcoes.admin.ouvinte;

import jakarta.persistence.EntityManager;
import org.example.controller.ClienteController;
import org.example.dto.ClienteDto;
import org.example.service.ClienteService;
import org.example.view.tela_opcoes.admin.TelaDeOpcoesDeAdmin;
import org.example.view.tela_opcoes.admin.TelaDeletarClienteAdmin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteTelaDeletarClienteAdmin implements ActionListener {

    private EntityManager em;
    private TelaDeletarClienteAdmin telaDeletar;

    public OuvinteTelaDeletarClienteAdmin(TelaDeletarClienteAdmin telaDeletar, EntityManager em) {
        this.telaDeletar = telaDeletar;
        this.em = em;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object componente = e.getSource();

        ClienteService service = new ClienteService(em);
        ClienteController controller = new ClienteController(service);

        if (componente == telaDeletar.getBotaoVoltar()) {
            new TelaDeOpcoesDeAdmin(em);
            telaDeletar.dispose();
        } else if (componente == telaDeletar.getBotaoBuscar()) {
            String textoId = telaDeletar.getTextAdicionarID().getText();

            if (textoId == null || textoId.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe o ID do cliente para buscar.");
                return;
            }
            Long id = Long.valueOf(textoId);
            ClienteDto dto = controller.buscarClientePorId(id);

            if (dto != null) {
                telaDeletar.preencherCampos(dto);
            }
            else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
            }
        } else if (componente == telaDeletar.getBotaoDeletar()) {
            String textoId = telaDeletar.getTextAdicionarID().getText();

            if (textoId == null || textoId.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe o ID do cliente para deletar.");
                return;
            }
            Long id = Long.valueOf(textoId);

            ClienteDto dto = new ClienteDto();
            dto.setNome(telaDeletar.getTextNome().getText());
            dto.setCpf(telaDeletar.getTextCpf().getText());
            dto.setEndereco(telaDeletar.getTextEndereco().getText());
            dto.setTelefone(telaDeletar.getTextTelefone().getText());
            dto.setEmail(telaDeletar.getTextEmail().getText());
            dto.setPassword(telaDeletar.getPassSenha().getText());

            controller.deletarCliente(id);
            JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso!");
            telaDeletar.limparCampos();
        }
    }
}