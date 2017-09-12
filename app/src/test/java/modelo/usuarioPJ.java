package modelo;

/**
 * Created by jean_ on 11/09/2017.
 */

import java.util.Date;

public class usuarioPJ extends usuario {

    private String razaoSocial;

    private Date dataFundacao;

    private int idadeFundacao;


    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setIdadeFundacao(int idadeFundacao) {
        this.idadeFundacao = idadeFundacao;
    }

    public int getIdadeFundacao() {
        return idadeFundacao;
    }

}

