package com.example.patriciamarcolino.agenda;

import android.widget.EditText;

import com.example.patriciamarcolino.agenda.modelo.Contato;

/**
 * Created by patricia.marcolino on 02/06/2017.
 */

public class FormularioHelper {
    private final EditText campoNome;
    private final EditText campoTelefone;

    public FormularioHelper(FormularioActivity activity){
        campoNome = (EditText) activity.findViewById(R.id.formulario_nome);
        campoTelefone = (EditText) activity.findViewById(R.id.formulario_telefone);
    }

    public Contato pegaContato() {
        Contato contato = new Contato();
        contato.setNome(campoNome.getText().toString());
        contato.setTelefone(campoTelefone.getText().toString());
        return contato;
    }
}
