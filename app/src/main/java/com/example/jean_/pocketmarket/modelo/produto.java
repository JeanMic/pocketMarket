package com.example.jean_.pocketmarket.modelo;

/**
 * Created by jean_ on 11/09/2017.
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class produto {

    private String tituloProduto;

    private String descricaoProduto;

    private String categoriaProduto;

    private Byte fotoProduto;

    private float precoProduto;

    private Date dataDeCadastro;

    private SimpleDateFormat datacadastroFormatada;


    public void setTituloProduto(String tituloProduto) {
        this.tituloProduto = tituloProduto;
    }

    public String getTituloProduto() {
        return tituloProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setCategoriaProduto(String categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    public String getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setFotoProduto(Byte fotoProduto) {
        this.fotoProduto = fotoProduto;
    }

    public Byte getFotoProduto() {
        return fotoProduto;
    }

    public void setPrecoProduto(float precoProduto) {
        this.precoProduto = precoProduto;
    }

    public float getPrecoProduto() {
        return precoProduto;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDatacadastroFormatada(SimpleDateFormat datacadastroFormatada) {

        this.datacadastroFormatada = datacadastroFormatada;
    }

    public SimpleDateFormat getDatacadastroFormatada() {

        return datacadastroFormatada;
    }
}

