package com.example.patriciamarcolino.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.patriciamarcolino.agenda.dao.ContatoDAO;
import com.example.patriciamarcolino.agenda.modelo.Contato;

import java.util.List;

public class ListaContatosActivity extends AppCompatActivity {

    private ListView listaContatos;

    @Override
    //criação da tela
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contatos);
        listaContatos = (ListView) findViewById(R.id.lista_alunos);

        //click simples
        listaContatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
                Contato contato = (Contato) listaContatos.getItemAtPosition(position);
                Intent intentVaiProFormulario = new Intent(ListaContatosActivity.this, FormularioActivity.class);
                //enviar o contato para formulario, com uma etiqueta, serializando (tranformando em binario)
                intentVaiProFormulario.putExtra("contato",contato);
                startActivity(intentVaiProFormulario);
            }
        });

        Button novoAluno = (Button) findViewById(R.id.novo_aluno);

        novoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVaiProFormulario = new Intent(ListaContatosActivity.this, FormularioActivity.class);
                startActivity(intentVaiProFormulario);
            }
        });
        // chamada do menu de contesto, para a lista de contatos
        registerForContextMenu(listaContatos);
    }

    private void carregaLista() {
        ContatoDAO dao = new ContatoDAO(this);
        List<Contato> contatos = dao.buscaContato();
        dao.close();


        // converter um array de string para view
        ArrayAdapter<Contato> adapter =  new ArrayAdapter<Contato>(this,android.R.layout.simple_list_item_1,contatos);
        listaContatos.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }

    @Override
    //menu de contexto
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(){
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Contato contato = (Contato) listaContatos.getItemAtPosition(info.position);

                ContatoDAO dao = new ContatoDAO(ListaContatosActivity.this);
                dao.deleta(contato);
                dao.close();
                carregaLista();
                Toast.makeText(ListaContatosActivity.this,"Deletar o contato:"+ contato.getNome(),Toast.LENGTH_LONG);
                return false;
            }
        });
    }

}
