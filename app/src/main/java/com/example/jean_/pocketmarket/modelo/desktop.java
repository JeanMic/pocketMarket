package com.example.jean_.pocketmarket.modelo;

/**
 * Created by jean_ on 11/09/2017.
 */

public class desktop extends computadoresNotebooks {

    private boolean possuiMonitor;

    private boolean possuiTeclado;

    private boolean possuiEstabilizador;

    private boolean possuieMouse;


    public void setPossuiMonitor(boolean possuiMonitor) {
        this.possuiMonitor = possuiMonitor;
    }

    public boolean isPossuiMonitor() {
        return possuiMonitor;
    }

    public void setPossuiTeclado(boolean possuiTeclado) {
        this.possuiTeclado = possuiTeclado;
    }

    public boolean isPossuiTeclado() {
        return possuiTeclado;
    }

    public void setPossuiEstabilizador(boolean possuiEstabilizador) {
        this.possuiEstabilizador = possuiEstabilizador;
    }

    public boolean isPossuiEstabilizador() {
        return possuiEstabilizador;
    }

    public void setpossuiMouse(boolean possuiMouse) {
        this.possuieMouse = possuiMouse;
    }

    public boolean ispossuiMouse() {
        return possuieMouse;
    }

}

