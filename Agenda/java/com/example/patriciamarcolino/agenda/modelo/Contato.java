package com.example.patriciamarcolino.agenda.modelo;

/**
 * Created by patricia.marcolino on 02/06/2017.
 */

public class Contato {
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

    public Long getId(long id) {
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
