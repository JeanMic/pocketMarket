package com.example.jean_.pocketmarket.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jean_ on 11/09/2017.
 */

public class servico {

    private String tituloServico;

    private String descricaoServico;

    private String categoriaServico;

    private float precoServico;

    private String CPFCNPJVendedor;

    private Date dataDeCadastro;

    private String Idservico;

    private SimpleDateFormat datacadastroFormatada;


    public void setTituloServico(String tituloServico) {
        this.tituloServico = tituloServico;
    }

    public String getTituloServico() {
        return tituloServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setCategoriaServico(String categoriaServico) {
        this.categoriaServico = categoriaServico;
    }

    public String getCategoriaServico() {
        return categoriaServico;
    }

    public void setPrecoServico(float precoServico) {
        this.precoServico = precoServico;
    }

    public float getPrecoServico() {
        return precoServico;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public SimpleDateFormat getDatacadastroFormatada() {
        return datacadastroFormatada;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public void setDatacadastroFormatada(SimpleDateFormat datacadastroFormatada) {
        this.datacadastroFormatada = datacadastroFormatada;
    }

    public String getCPFCNPJVendedor() {
        return CPFCNPJVendedor;
    }

    public void setCPFCNPJVendedor(String CPFCNPJVendedor) {
        this.CPFCNPJVendedor = CPFCNPJVendedor;
    }

    public String getIdservico() {
        return Idservico;
    }

    public void setIdservico(String idservico) {
        Idservico = idservico;
    }

}

