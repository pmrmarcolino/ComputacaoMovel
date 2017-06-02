package com.example.patriciamarcolino.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.patriciamarcolino.agenda.dao.ContatoDAO;
import com.example.patriciamarcolino.agenda.modelo.Contato;

import java.util.List;

public class ListaContatosActivity extends AppCompatActivity {

    @Override
    //criação da tela
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contatos);

        ContatoDAO dao = new ContatoDAO(this);
        List<Contato> contatos = dao.buscaContato();
        dao.close();

        ListView listaAlunos = (ListView) findViewById(R.id.lista_alunos);
        // converter um array de string para view
        ArrayAdapter<Contato> adapter =  new ArrayAdapter<Contato>(this,android.R.layout.simple_list_item_1,contatos);
        listaAlunos.setAdapter(adapter);

        Button novoAluno = (Button) findViewById(R.id.novo_aluno);

        novoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVaiProFormulario = new Intent(ListaContatosActivity.this, FormularioActivity.class);
                startActivity(intentVaiProFormulario);
            }
        });
    }


}
