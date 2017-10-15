package com.example.jean_.pocketmarket.modelo;

/**
 * Created by jean_ on 11/09/2017.
 */

public class carro extends veiculo {

    private int qtdPortas;

    private String cambio;

    public void setQtdPortas(int qtdPortas) {
        this.qtdPortas = qtdPortas;
    }

    public int getQtdPortas() {
        return qtdPortas;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public String getCambio() {
        return cambio;
    }

}

