package com.example.patriciamarcolino.agenda;

import android.widget.EditText;

import com.example.patriciamarcolino.agenda.modelo.Contato;

/**
 * Created by patricia.marcolino on 02/06/2017.
 */

public class FormularioHelper {
    private final EditText campoNome;
    private final EditText campoTelefone;
    private Contato contato;

    public FormularioHelper(FormularioActivity activity){
        campoNome = (EditText) activity.findViewById(R.id.formulario_nome);
        campoTelefone = (EditText) activity.findViewById(R.id.formulario_telefone);
        contato = new Contato();
    }

    public Contato pegaContato() {
        contato.setNome(campoNome.getText().toString());
        contato.setTelefone(campoTelefone.getText().toString());
        return contato;
    }

    public void preencheFormulario(Contato contato) {
        campoNome.setText(contato.getNome());
        campoTelefone.setText(contato.getTelefone());
        this.contato = contato;
    }
}
