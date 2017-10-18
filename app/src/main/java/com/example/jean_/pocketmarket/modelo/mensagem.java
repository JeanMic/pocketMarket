package com.example.jean_.pocketmarket.modelo;

/**
 * Created by jean_ on 11/09/2017.
 */

import java.util.Date;

public class mensagem {

    private int CPFCNPJRemetente;

    private String nomeRazaoSocialRemetente;

    private int CPFCNPJDestinatario;

    private Date DataHoraEnvio;

    private String Mensagem;


    public void setCPFCNPJEnvio(int CPFCNPJremetente) {
        this.CPFCNPJRemetente = CPFCNPJremetente;
    }

    public int getCPFCNPJremetente() {
        return CPFCNPJRemetente;
    }

    public void setCPFCNPJdestinatario(int CPFCNPJdestinatario) {
        this.CPFCNPJDestinatario = CPFCNPJdestinatario;
    }

    public int getCPFCNPJdestinatario() {
        return CPFCNPJDestinatario;
    }

    public void setNomeRazaoSocialRemetente(String nomeRazaoSocialRemetente) {
        this.nomeRazaoSocialRemetente = nomeRazaoSocialRemetente;
    }

    public String getNomeRazaoSocialRemetente() {
        return nomeRazaoSocialRemetente;
    }

    public void setDataHoraEnvio(Date DataHoraEnvio) {
        this.DataHoraEnvio = DataHoraEnvio;
    }

    public Date getDataHoraEnvio() {
        return DataHoraEnvio;
    }

    public void setMensagem(String Mensagem) {
        this.Mensagem = Mensagem;
    }

    public String getMensagem() {
        return Mensagem;
    }

}

