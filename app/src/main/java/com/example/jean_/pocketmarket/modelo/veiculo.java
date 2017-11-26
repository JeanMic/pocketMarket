package com.example.jean_.pocketmarket.modelo;

/**
 * Created by jean_ on 11/09/2017.
 */

public abstract class veiculo extends produto {

    private String Marca;

    private String Modelo;

    private int anoFabricação;

    private String placa;

    private int quilometragem;

    private String cor;

    private String combustivel;

    private Boolean possuiMultas;


    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getMarca() {
        return Marca;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setAnoFabricação(int anoFabricação) {
        this.anoFabricação = anoFabricação;
    }

    public int getAnoFabricação() {
        return anoFabricação;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setPossuiMultas(Boolean possuiMultas) {
        this.possuiMultas = possuiMultas;
    }

    public Boolean getPossuiMultas() {
        return possuiMultas;
    }

}
