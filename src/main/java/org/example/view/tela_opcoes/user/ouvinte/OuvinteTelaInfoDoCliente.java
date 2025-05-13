package org.example.view.tela_opcoes.user.ouvinte;

import jakarta.persistence.EntityManager;
import org.example.controller.ClienteController;
import org.example.controller.UsuarioController;
import org.example.dto.ClienteDto;
import org.example.dto.UsuarioDto;
import org.example.service.ClienteService;
import org.example.service.UsuarioService;
import org.example.view.tela_opcoes.user.TelaDeOpcoesDeCliente;
import org.example.view.tela_opcoes.user.TelaInfoDoCliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteTelaInfoDoCliente implements ActionListener {

    private EntityManager em;
    private TelaInfoDoCliente telaInfo;
    private Long idClienteLogado;

    public OuvinteTelaInfoDoCliente(TelaInfoDoCliente telaInfo, EntityManager em, Long idClienteLogado) {
        this.telaInfo = telaInfo;
        this.em = em;
        this.idClienteLogado = idClienteLogado;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object componente = e.getSource();

        ClienteService service = new ClienteService(em);
        ClienteController controller = new ClienteController(service);

        if (componente == telaInfo.getBotaoVoltar()) {
            new TelaDeOpcoesDeCliente(em, idClienteLogado);
            telaInfo.dispose();
        } else if (componente == telaInfo.getBotaoListarMinhasInfo()) {
            try {
                ClienteDto dto = controller.buscarClientePorId(idClienteLogado);
                System.out.println("ID : " + idClienteLogado);

                if (dto != null) {
                    telaInfo.preencherCampos(dto);
                } else {
                    JOptionPane.showMessageDialog(null, "Informações do cliente não encontradas.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao buscar informações: " + ex.getMessage());
            }
        }
    }
}