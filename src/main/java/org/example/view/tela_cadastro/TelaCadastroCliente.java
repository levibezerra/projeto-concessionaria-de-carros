package org.example.view.tela_cadastro;

import jakarta.persistence.EntityManager;
import org.example.view.tela_cadastro.ouvinte.OuvinteTelaDeCadastro;

public class TelaCadastroCliente extends TelaDeCadastroBase {

    public TelaCadastroCliente(EntityManager em) {
        super(em);
        setTitle("CADASTRAR CLIENTE");
        getTitulo().setText("CADASTRAR CLIENTE");
        adicionarOuvintes();

    }

    @Override
    public void adicionarOuvintes() {
        getBotaoVoltar().addActionListener(new OuvinteTelaDeCadastro(this, em, false));
        getBotaoCadastrar().addActionListener(new OuvinteTelaDeCadastro(this, em, false));
    }
}
