package com.example.patriciamarcolino.agenda.modelo;

import java.io.Serializable;

/**
 * Created by patricia.marcolino on 02/06/2017.
 */
// esse implements foi usado por causa do Intent, de click simples.
public class Contato implements Serializable{
    private String nome;
    private String telefone;
    private Long id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getNome() +": " + getTelefone();
    }

}
