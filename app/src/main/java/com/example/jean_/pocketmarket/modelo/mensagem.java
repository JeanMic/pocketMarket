package com.example.jean_.pocketmarket.modelo;

/**
 * Created by jean_ on 11/09/2017.
 */

import java.util.Date;

public class mensagem {

    private int CPFCNPJEnvio;

    private int CPFCNPJRecebimento;

    private String nomeRazaoSocialRemetente;

    private Date DataHoraEnvio;

    private String Mensagem;



    public void setCPFCNPJEnvio(int CPFCNPJEnvio) {
        this.CPFCNPJEnvio = CPFCNPJEnvio;
    }

    public int getCPFCNPJEnvio() {
        return CPFCNPJEnvio;
    }

    public void setCPFCNPJRecebimento(int CPFCNPJRecebimento) {
        this.CPFCNPJRecebimento = CPFCNPJRecebimento;
    }

    public int getCPFCNPJRecebimento() {
        return CPFCNPJRecebimento;
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

