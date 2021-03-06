package com.example.patriciamarcolino.agenda.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.example.patriciamarcolino.agenda.modelo.Contato;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by patricia.marcolino on 02/06/2017.
 */

public class ContatoDAO extends SQLiteOpenHelper{


    public ContatoDAO(Context context) {
        super(context, "Agenda", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Contatos (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, telefone TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXIST Contatos";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(Contato contato) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = getContentValuesContato(contato);

        // trata o conteudo
        db.insert("Contatos",null,dados);
    }

    @NonNull
    private ContentValues getContentValuesContato(Contato contato) {
        ContentValues dados = new ContentValues();

        dados.put("nome", contato.getNome());
        dados.put("telefone", contato.getTelefone());
        return dados;
    }

    public List<Contato> buscaContato() {
        String sql = "SELECT * FROM Contatos;";
        SQLiteDatabase db = getReadableDatabase();
        // retorna a primeira linha em branco antes do conteudo
        Cursor cursor = db.rawQuery(sql,null);
        // devolve um boolean se as linhas acabaram ou não
        List<Contato> contatos = new ArrayList<Contato>();

        while(cursor.moveToNext()){
            Contato contato = new Contato();
            contato.setId(cursor.getLong(cursor.getColumnIndex("id")));
            contato.setNome(cursor.getString(cursor.getColumnIndex("nome"))) ;
            contato.setTelefone(cursor.getString(cursor.getColumnIndex("telefone")));
            contatos.add(contato);
        }

        cursor.close();

        return contatos;
    }

    public void deleta(Contato contato) {
        SQLiteDatabase db = getWritableDatabase();
        String [] params = {contato.getId().toString()};
        // essa ? é substituida pelo params
        db.delete("Contatos", "id = ?", params);
    }

    public void altera(Contato contato) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValuesContato(contato);
        String [] params = {contato.getId().toString()};
        db.update("Contatos",dados,"id = ?", params);
    }
}
