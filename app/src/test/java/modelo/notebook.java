package modelo;

/**
 * Created by jean_ on 11/09/2017.
 */

public class notebook extends computadoresNotebooks {

    private float tamanhoTela;

    private boolean possuiTecladoNumerico;

    private boolean possuiCarregador;


    public void setTamanhoTela(float tamanhoTela) {
        this.tamanhoTela = tamanhoTela;
    }

    public float getTamanhoTela() {
        return tamanhoTela;
    }

    public void setPossuiTecladoNumerico(boolean possuiTecladoNumerico) {
        this.possuiTecladoNumerico = possuiTecladoNumerico;
    }

    public boolean isPossuiTecladoNumerico() {
        return possuiTecladoNumerico;
    }

    public void setPossuiCarregador(boolean possuiCarregador) {
        this.possuiCarregador = possuiCarregador;
    }

    public boolean isPossuiCarregador() {
        return possuiCarregador;
    }

}

