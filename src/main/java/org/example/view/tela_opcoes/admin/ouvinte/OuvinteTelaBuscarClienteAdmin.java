package org.example.view.tela_opcoes.admin.ouvinte;

import jakarta.persistence.EntityManager;
import org.example.controller.ClienteController;
import org.example.dto.ClienteDto;
import org.example.service.ClienteService;
import org.example.view.tela_opcoes.admin.TelaBuscarClienteAdmin;
import org.example.view.tela_opcoes.admin.TelaDeOpcoesDeAdmin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteTelaBuscarClienteAdmin implements ActionListener {

    private EntityManager em;
    private TelaBuscarClienteAdmin telaBuscar;

    public OuvinteTelaBuscarClienteAdmin(TelaBuscarClienteAdmin telaBuscar, EntityManager em) {
        this.telaBuscar = telaBuscar;
        this.em = em;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object componente = e.getSource();

        if (componente == telaBuscar.getBotaoVoltar()) {
            new TelaDeOpcoesDeAdmin(em);
            telaBuscar.dispose();
        } else if (componente == telaBuscar.getBotaoBuscar()) {
            try {
                Long id = Long.valueOf(telaBuscar.getTextAdicionarID().getText());
                ClienteService service = new ClienteService(em);
                ClienteController controller = new ClienteController(service);
                ClienteDto dto = controller.buscarClientePorId(id);

                if (dto != null) {
                    DefaultTableModel modelo = (DefaultTableModel)  telaBuscar.getTabelaCliente().getModel();
                    modelo.setRowCount(0);

                    modelo.addRow(new Object[] {
                            dto.getId(),
                            dto.getNome(),
                            dto.getCpf(),
                            dto.getEndereco(),
                            dto.getTelefone(),
                            dto.getEmail(),
                            dto.getPassword()
                    });
                } else {
                    JOptionPane.showMessageDialog(telaBuscar, "Cliente não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(telaBuscar, "ID inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(telaBuscar, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}