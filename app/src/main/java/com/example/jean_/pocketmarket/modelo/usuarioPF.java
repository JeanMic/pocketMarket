package com.example.jean_.pocketmarket.modelo;

/**
 * Created by jean_ on 11/09/2017.
 */

import java.util.Date;

public class usuarioPF extends usuario {

    private String nome; //ok

    private String sexo; //ok

    private String dataNascimento; // ok

    private int idade; // ok


    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

}

