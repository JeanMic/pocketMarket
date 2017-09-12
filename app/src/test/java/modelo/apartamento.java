package modelo;

/**
 * Created by jean_ on 11/09/2017.
 */

public class apartamento extends imovel {

    private int areaUtil;

    private boolean possuiAcademia;

    private boolean possuiVaranda;

    private boolean possuiElevadorPredio;


    public void setAreaUtil(int areaUtil) {
        this.areaUtil = areaUtil;
    }

    public int getAreaUtil() {
        return areaUtil;
    }

    public void setPossuiAcademia(boolean possuiAcademia) {
        this.possuiAcademia = possuiAcademia;
    }

    public boolean isPossuiAcademia() {
        return possuiAcademia;
    }

    public void setPossuiVaranda(boolean possuiVaranda) {
        this.possuiVaranda = possuiVaranda;
    }

    public boolean isPossuiVaranda() {
        return possuiVaranda;
    }

    public void setPossuiElevadorPredio(boolean possuiElevadorPredio) {
        this.possuiElevadorPredio = possuiElevadorPredio;
    }

    public boolean isPossuiElevadorPredio() {
        return possuiElevadorPredio;
    }

}
