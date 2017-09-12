package modelo;

/**
 * Created by jean_ on 11/09/2017.
 */

public class casa extends imovel {

    private int areaConstruida;

    private boolean possuiCameraVigilancia;


    public void setAreaConstruida(int areaConstruida) {
        this.areaConstruida =  areaConstruida;
    }

    public int getAreaConstruida() {
        return areaConstruida;
    }

    public void setPossuiCameraVigilancia(boolean possuiCameraVigilancia) {
        this.possuiCameraVigilancia = possuiCameraVigilancia;
    }

    public boolean isPossuiCameraVigilancia() {
        return possuiCameraVigilancia;
    }

}

