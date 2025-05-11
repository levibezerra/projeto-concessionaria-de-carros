package org.example.view.tela_cadastro;

import jakarta.persistence.EntityManager;
import org.example.view.tela_cadastro.ouvinte.OuvinteTelaDeCadastro;

public class TelaDeCadastroAdmin extends TelaDeCadastroBase {

    public TelaDeCadastroAdmin(EntityManager em) {
        super(em);
        setTitle("CADASTRAR ADMINISTRADOR");
        getTitulo().setText("CADASTRAR ADMINISTRADOR");
        adicionarOuvintes();
    }

    @Override
    public void adicionarOuvintes() {
        getBotaoVoltar().addActionListener(new OuvinteTelaDeCadastro(this, em, true));
        getBotaoCadastrar().addActionListener(new OuvinteTelaDeCadastro(this, em, true));
    }
}