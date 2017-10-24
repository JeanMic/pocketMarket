package com.example.jean_.pocketmarket.DAO;

import com.example.jean_.pocketmarket.modelo.casa;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by jean_ on 17/10/2017.
 */

public class casaDAO extends acesso implements metodosDAO {

    public casaDAO() throws ClassNotFoundException {
    }

    @Override
    public void insert(Object casaObj) {

        casa casa = (casa) casaObj;

        sql = "INSERT INTO market.produtoimovel (\n" +
                "qtdQuartos,\n" +
                "qtdDeSuites,\n" +
                "valorIPTU,\n" +
                "valorCondominio,\n" +
                "qtdVagasGaragem,\n" +
                "vendaOuAluguel,\n" +
                "CEPDoImovel,\n" +
                "possuiPiscina,\n" +
                "possuiAreadeServico,\n" +
                "possuiArCondicionado,\n" +
                "possuiQuartoEmpregada,\n" +
                "condominioFechado,\n" +
                "areaconstruida,\n" +
                "possuiCameraVigilancia,\n" +
                "areaUtil,\n" +
                "possuiAcademia,\n" +
                "possuiVaranda,\n" +
                "possuiElevadorPredio,\n" +
                "tituloProduto,\n" +
                "descricaoProduto,\n" +
                "categoriaProduto,\n" +
                "fotoProduto,\n" +
                "precoProduto,\n" +
                "dataDeCadastro\n" +
                ")\n" +
                "VALUES\n" +
                "(\n" +
                "'" + casa.getQtdQuartos() +"', \n" +
                "'" + casa.getQtdDeSuites() +"', \n" +
                "'" + casa.getValorIPTU() +"', \n" +
                "'" + casa.getValorCondominio() +"', \n" +
                "'" + casa.getVagasNaGaragem() +"', \n" +
                "'" + casa.getVendaOuAluguel() +"', \n" +
                "'" + casa.getCEPDoImovel() +"', \n" +
                "'" + casa.isPossuiPiscina() +"', \n" +
                "'" + casa.isPossuiAreaDeServico() +"', \n" +
                "'" + casa.isPossuiArCondicionado() +"', \n" +
                "'" + casa.isPossuiQuardoEmpregada() +"', \n" +
                "'" + casa.isCondominioFechado() +"', \n" +
                "'" + casa.getAreaConstruida() +"', \n" +
                "'" + casa.isPossuiCameraVigilancia() +"', \n" +
                "0.0, \n" +
                "FALSE, \n" +
                "FALSE, \n" +
                "FALSE, \n" +
                "'" + casa.getTituloProduto() +"', \n" +
                "'" + casa.getDescricaoProduto() +"', \n" +
                "'" + casa.getCategoriaProduto() +"', \n" +
                "'" + casa.getFotoProduto() +"', \n" +
                "'" + casa.getPrecoProduto() +"', \n" +
                "NOW()\n" +
                ");\n" +
                "\n" +
                "INSERT INTO market.produtoimovel_has_usuario (\n" +
                "produtoImovel_idprodutoImovel,\n" +
                "usuario_CPFCNPJ\n" +
                ")\n"; //+
               // "SELECT LAST_INSERT_ID(), '" + CPF_usuario_logado + "';";

        try {
            rs = stm.executeQuery(sql);
            this.desconecta();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Object> select() {

        try {


            this.desconecta();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void update() {

        try {


            this.desconecta();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {

        try {


            this.desconecta();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
