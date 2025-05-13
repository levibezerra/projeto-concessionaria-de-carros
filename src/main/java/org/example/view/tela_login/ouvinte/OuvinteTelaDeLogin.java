package org.example.view.tela_login.ouvinte;

import jakarta.persistence.EntityManager;
import org.example.controller.UsuarioController;
import org.example.dto.UsuarioDto;
import org.example.entity.Administrador;
import org.example.entity.Cliente;
import org.example.service.UsuarioService;
import org.example.view.tela_inicial.TelaInicial;
import org.example.view.tela_login.TelaDeLogin;
import org.example.view.tela_opcoes.admin.TelaDeOpcoesDeAdmin;
import org.example.view.tela_opcoes.user.TelaDeOpcoesDeCliente;
import org.example.view.tela_opcoes.user.ouvinte.OuvinteTelaDeOpcoesDeCliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteTelaDeLogin implements ActionListener {

    private EntityManager em;
    private TelaDeLogin telaDeLogin;
    private Long idClienteLogado;

    public OuvinteTelaDeLogin(TelaDeLogin telaDeLogin, EntityManager em, Long idClienteLogado) {
        this.em =em;
        this.telaDeLogin = telaDeLogin;
        this.idClienteLogado = idClienteLogado;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object componente = e.getSource();

        String email = telaDeLogin.getTextEmail().getText();
        String senha =String.valueOf(telaDeLogin.getPassPassword().getPassword()).trim();

        if (componente == telaDeLogin.getBotaoVoltar()) {
            new TelaInicial(em);
            telaDeLogin.dispose();
        } else if (componente == telaDeLogin.getBotaoEntrar()) {
            try {
                UsuarioDto dto = new UsuarioDto();
                UsuarioService service = new UsuarioService(em);
                UsuarioController controller = new UsuarioController(service);

                dto.setEmail(email);
                dto.setPassword(senha);
                Object usuario = controller.login(dto);

                if (usuario instanceof Administrador) {
                    new TelaDeOpcoesDeAdmin(em);
                    telaDeLogin.dispose();
                } else if (usuario instanceof Cliente) {
                    Cliente clienteLogado = (Cliente) usuario;
                    Long idClienteLogado = clienteLogado.getId();
                    new TelaDeOpcoesDeCliente(em, idClienteLogado);
                    telaDeLogin.dispose();
                }
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(telaDeLogin, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}