package org.example.view.tela_cadastro.ouvinte;

import jakarta.persistence.EntityManager;
import jakarta.persistence.JoinColumn;
import org.example.config.JpaConfig;
import org.example.controller.AdministradorController;
import org.example.dto.AdministradorDto;
import org.example.service.AdministradorService;
import org.example.view.tela_cadastro.TelaDeCadastroAdmin;
import org.example.view.tela_inicial.TelaInicial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteTelaDeCadastroAdmim implements ActionListener {

    private EntityManager em;
    private TelaDeCadastroAdmin tela;

    public OuvinteTelaDeCadastroAdmim(TelaDeCadastroAdmin tela, EntityManager em) {
        this.tela = tela;
        this.em = em;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object componente = e.getSource();

        String nome = tela.getTextNome().getText();
        String cpf = tela.getTextCpf().getText();
        String endereco = tela.getTextEndereco().getText();
        String telefone = tela.getTextTelefone().getText();
        String email = tela.getTextEmail().getText();
        String senha =String.valueOf(tela.getPassSenha().getPassword()).trim();

        if (componente == tela.getBotaoVoltar()) {
            new TelaInicial(em);
            tela.dispose();
        } else if (componente == tela.getBotaoCadastrar()) {
            AdministradorDto dto = new AdministradorDto();
            AdministradorService service = new AdministradorService(em);
            AdministradorController controller = new AdministradorController(service);

            dto.setNome(nome);
            dto.setCpf(cpf);
            dto.setEndereco(endereco);
            dto.setTelefone(telefone);
            dto.setEmail(email);
            dto.setPassword(senha);

            try {
                controller.cadastrarAdmin(dto);
                JOptionPane.showMessageDialog(tela, "Administrador cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                new TelaInicial(em);
                tela.dispose();
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(tela, ex.getMessage(), "Campos inválidos", JOptionPane.WARNING_MESSAGE);
                ex.printStackTrace();
            }
        }
    }
}