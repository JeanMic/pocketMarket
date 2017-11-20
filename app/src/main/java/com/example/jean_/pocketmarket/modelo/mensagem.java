package com.example.jean_.pocketmarket.modelo;

/**
 * Created by jean_ on 11/09/2017.
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class mensagem {

    private String CPFCNPJRemetente;

    private String nomeRazaoSocialRemetente;

    private String CPFCNPJDestinatario;

    private Date DataEnvio;

    private SimpleDateFormat datacadastroFormatada;

    private String Mensagem;

    private String TituloMensagem;


    public void setCPFCNPJdestinatario(String CPFCNPJdestinatario) {
        this.CPFCNPJDestinatario = CPFCNPJdestinatario;
    }

    public String getCPFCNPJdestinatario() {
        return CPFCNPJDestinatario;
    }

    public String getCPFCNPJRemetente() {
        return CPFCNPJRemetente;
    }

    public void setCPFCNPJRemetente(String CPFCNPJRemetente) {
        this.CPFCNPJRemetente = CPFCNPJRemetente;
    }

    public void setNomeRazaoSocialRemetente(String nomeRazaoSocialRemetente) {
        this.nomeRazaoSocialRemetente = nomeRazaoSocialRemetente;
    }

    public String getNomeRazaoSocialRemetente() {
        return nomeRazaoSocialRemetente;
    }

    public void setDataEnvio(Date DataHoraEnvio) {
        this.DataEnvio = DataHoraEnvio;
    }

    public Date getDataEnvio() {
        return DataEnvio;
    }

    public void setMensagem(String Mensagem) {
        this.Mensagem = Mensagem;
    }

    public String getMensagem() {
        return Mensagem;
    }

    public String getTituloMensagem() {
        return TituloMensagem;
    }

    public void setTituloMensagem(String tituloMensagem) {
        TituloMensagem = tituloMensagem;
    }


    public SimpleDateFormat getDatacadastroFormatada() {
        return datacadastroFormatada;
    }

    public void setDatacadastroFormatada(SimpleDateFormat datacadastroFormatada) {
        this.datacadastroFormatada = datacadastroFormatada;
    }

}

