package modelo;

/**
 * Created by jean_ on 11/09/2017.
 */

public abstract class computadoresNotebooks extends produto {

    private String marca;

    private String modelo;

    private int RAM;

    private String marcaProcessador;

    private String modeloProcessador;

    private int armazenamento;

    private String sistema;

    private String versaoSistema;

    private boolean usado;



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

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getRAM() {
        return RAM;
    }

    public void setMarcaProcessador(String marcaProcessador) {
        this.marcaProcessador = marcaProcessador;
    }

    public String getMarcaProcessador() {
        return marcaProcessador;
    }

    public void setModeloProcessador(String modeloProcessador) {
        this.modeloProcessador = modeloProcessador;
    }

    public String getModeloProcessador() {
        return modeloProcessador;
    }

    public void setArmazenamento(int armazenamento) {
        this.armazenamento = armazenamento;
    }

    public int getArmazenamento() {
        return armazenamento;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getSistema() {
        return sistema;
    }

    public void setVersaoSistema(String versaoSistema) {
        this.versaoSistema = versaoSistema;
    }

    public String getVersaoSistema() {
        return versaoSistema;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }

    public boolean isUsado() {
        return usado;
    }

}

