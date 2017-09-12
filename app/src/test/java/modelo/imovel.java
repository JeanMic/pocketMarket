package modelo;

/**
 * Created by jean_ on 11/09/2017.
 */

public abstract class imovel extends produto {

    private int QtdQuartos;

    private int QtdDeSuites;

    private float valorIPTU;

    private float valorCondominio;

    private int vagasNaGaragem;

    private String vendaOuAluguel;

    private int CEPDoImovel;

    private boolean possuiPiscina;

    private boolean possuiAreaDeServico;

    private boolean possuiArCondicionado;

    private boolean possuiQuardoEmpregada;

    private boolean condominioFechado;


    public void setQtdQuartos(int QtdQuartos) {
        this.QtdQuartos = QtdQuartos;
    }

    public int getQtdQuartos() {
        return QtdQuartos;
    }

    public void setQtdDeSuites(int QtdDeSuites) {
        this.QtdDeSuites = QtdDeSuites;
    }

    public int getQtdDeSuites() {
        return QtdDeSuites;
    }

    public void setValorIPTU(float valorIPTU) {
        this.valorIPTU = valorIPTU;
    }

    public float getValorIPTU() {
        return valorIPTU;
    }

    public void setValorCondominio(float valorCondominio) {
        this.valorCondominio = valorCondominio;
    }

    public float getValorCondominio() {
        return valorCondominio;
    }

    public void setVagasNaGaragem(int vagasNaGaragem) {
        this.vagasNaGaragem = vagasNaGaragem;
    }

    public int getVagasNaGaragem() {
        return vagasNaGaragem;
    }

    public void setVendaOuAluguel(String vendaOuAluguel) {
        this.vendaOuAluguel = vendaOuAluguel;
    }

    public String getVendaOuAluguel() {
        return vendaOuAluguel;
    }

    public void setCEPDoImovel(int CEPDoImovel) {
        this.CEPDoImovel = CEPDoImovel;
    }

    public int getCEPDoImovel() {
        return CEPDoImovel;
    }

    public void setPossuiPiscina(boolean possuiPiscina) {
        this.possuiPiscina = possuiPiscina;
    }

    public boolean isPossuiPiscina() {
        return possuiPiscina;
    }

    public void setPossuiAreaDeServico(boolean possuiAreaDeServico) {
        this.possuiAreaDeServico = possuiAreaDeServico;
    }

    public boolean isPossuiAreaDeServico() {
        return possuiAreaDeServico;
    }

    public void setPossuiArCondicionado(boolean possuiArCondicionado) {
        this.possuiArCondicionado = possuiArCondicionado;
    }

    public boolean isPossuiArCondicionado() {
        return possuiArCondicionado;
    }

    public void setPossuiQuardoEmpregada(boolean possuiQuardoEmpregada) {
        this.possuiQuardoEmpregada = possuiQuardoEmpregada;
    }

    public boolean isPossuiQuardoEmpregada() {
        return possuiQuardoEmpregada;
    }

    public void setCondominioFechado(boolean condominioFechado) {
        this.condominioFechado = condominioFechado;
    }

    public boolean isCondominioFechado() {
        return condominioFechado;
    }

}

