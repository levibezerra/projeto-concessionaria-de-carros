package org.example.view.tela_cadastro.ouvinte;

import jakarta.persistence.EntityManager;
import org.example.controller.AdministradorController;
import org.example.controller.ClienteController;
import org.example.dto.AdministradorDto;
import org.example.dto.ClienteDto;
import org.example.service.AdministradorService;
import org.example.service.ClienteService;
import org.example.view.tela_cadastro.TelaDeCadastroBase;
import org.example.view.tela_inicial.TelaInicial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteTelaDeCadastro implements ActionListener {

    private EntityManager em;
    private TelaDeCadastroBase tela;
    private boolean cadastroAdmin;

    public OuvinteTelaDeCadastro(TelaDeCadastroBase tela, EntityManager em, boolean cadastroAdmin) {
        this.tela = tela;
        this.em = em;
        this.cadastroAdmin = cadastroAdmin;
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
            try {
                if (cadastroAdmin) {
                    AdministradorDto dto = new AdministradorDto();
                    AdministradorService service = new AdministradorService(em);
                    AdministradorController controller = new AdministradorController(service);

                    dto.setNome(nome);
                    dto.setCpf(cpf);
                    dto.setEndereco(endereco);
                    dto.setTelefone(telefone);
                    dto.setEmail(email);
                    dto.setPassword(senha);
                    controller.cadastrarAdmin(dto);
                    JOptionPane.showMessageDialog(tela, "Administrador cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    ClienteDto dto = new ClienteDto();
                    ClienteService service = new ClienteService(em);
                    ClienteController controller = new ClienteController(service);

                    dto.setNome(nome);
                    dto.setCpf(cpf);
                    dto.setEndereco(endereco);
                    dto.setTelefone(telefone);
                    dto.setEmail(email);
                    dto.setPassword(senha);
                    controller.cadastrar(dto);
                    JOptionPane.showMessageDialog(tela, "Cliente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
                new TelaInicial(em);
                tela.dispose();

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(tela, ex.getMessage(), "Campos inválidos", JOptionPane.WARNING_MESSAGE);
                ex.printStackTrace();
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}