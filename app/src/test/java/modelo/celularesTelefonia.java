package modelo;

/**
 * Created by jean_ on 11/09/2017.
 */

public class celularesTelefonia extends produto {

    private String Sistema;

    private String versaoSistema;

    private String tamanhoTela;

    private String marca;

    private String modelo;

    private String armazenamento;

    private boolean usado;

    private boolean possuiCarregador;

    private boolean possuiFonedeOuvido;


    public void setSistema(String Sistema) {
        this.Sistema = Sistema;
    }

    public String getSistema() {
        return Sistema;
    }

    public void setVersaoSistema(String versaoSistema) {
        this.versaoSistema = versaoSistema;
    }

    public String getVersaoSistema() {
        return versaoSistema;
    }

    public void setTamanhoTela(String tamanhoTela) {
        this.tamanhoTela = tamanhoTela;
    }

    public String getTamanhoTela() {
        return tamanhoTela;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setArmazenamento(String armazenamento) {
        this.armazenamento = armazenamento;
    }

    public String getArmazenamento() {
        return armazenamento;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setPossuiCarregador(boolean possuiCarregador) {
        this.possuiCarregador = possuiCarregador;
    }

    public boolean isPossuiCarregador() {
        return possuiCarregador;
    }

    public void setPossuiFonedeOuvido(boolean possuiFonedeOuvido) {
        this.possuiFonedeOuvido = possuiFonedeOuvido;
    }

    public boolean isPossuiFonedeOuvido() {
        return possuiFonedeOuvido;
    }

}

