package org.example.view.tela_opcoes.admin.ouvinte;

import jakarta.persistence.EntityManager;
import org.example.controller.ClienteController;
import org.example.dto.ClienteDto;
import org.example.service.ClienteService;
import org.example.view.tela_opcoes.admin.TelaDeOpcoesDeAdmin;
import org.example.view.tela_opcoes.admin.TelaListarClienteAdmin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class OuvinteTelaListarClienteAdmin implements ActionListener {

    private EntityManager em;
    private TelaListarClienteAdmin telaListar;

    public OuvinteTelaListarClienteAdmin(TelaListarClienteAdmin telaListar, EntityManager em) {
        this.telaListar = telaListar;
        this.em = em;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object componente = e.getSource();

        if (componente == telaListar.getBotaoVoltar()) {
            new TelaDeOpcoesDeAdmin(em);
            telaListar.dispose();
        } else if (componente == telaListar.getBotaoListar()) {
            try {
                ClienteService service = new ClienteService(em);
                ClienteController controller = new ClienteController(service);
                List<ClienteDto> clientes = controller.listarTodosClientes();

                DefaultTableModel modelo = (DefaultTableModel) telaListar.getTabelaCliente().getModel();
                modelo.setRowCount(0);

                if (clientes.isEmpty()) {
                    JOptionPane.showMessageDialog(telaListar, "Nenhum cliente encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    for (ClienteDto dto : clientes) {
                        modelo.addRow(new Object[] {
                                dto.getId(),
                                dto.getNome(),
                                dto.getCpf(),
                                dto.getEndereco(),
                                dto.getTelefone(),
                                dto.getEmail(),
                                dto.getPassword()
                        });
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(telaListar, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}