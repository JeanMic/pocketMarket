package com.example.jean_.pocketmarket.DAO;

import com.example.jean_.pocketmarket.modelo.apartamento;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by jean_ on 17/10/2017.
 */

public class apartamentoDAO extends acesso {

    public apartamentoDAO() throws ClassNotFoundException {
    }

    @Override
    public void insert(Object apartaObj) {

        apartamento apartamento = (apartamento) apartaObj;

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
                "'" + apartamento.getQtdQuartos() +"', \n" +
                "'" + apartamento.getQtdDeSuites() +"', \n" +
                "'" + apartamento.getValorIPTU() +"', \n" +
                "'" + apartamento.getValorCondominio() +"', \n" +
                "'" + apartamento.getVagasNaGaragem() +"', \n" +
                "'" + apartamento.getVendaOuAluguel() +"', \n" +
                "'" + apartamento.getCEPDoImovel() +"', \n" +
                "'" + apartamento.isPossuiPiscina() +"', \n" +
                "'" + apartamento.isPossuiAreaDeServico() +"', \n" +
                "'" + apartamento.isPossuiArCondicionado() +"', \n" +
                "'" + apartamento.isPossuiQuardoEmpregada() +"', \n" +
                "'" + apartamento.isCondominioFechado() +"', \n" +
                "0.0, \n" +
                "FALSE, \n" +
                "'" + apartamento.getAreaUtil() +"', \n" +
                "'" + apartamento.isPossuiAcademia() +"', \n" +
                "'" + apartamento.isPossuiVaranda() +"', \n" +
                "'" + apartamento.isPossuiElevadorPredio() +"', \n" +
                "'" + apartamento.getTituloProduto() +"', \n" +
                "'" + apartamento.getDescricaoProduto() +"', \n" +
                "'" + apartamento.getCategoriaProduto() +"', \n" +
                "'" + apartamento.getFotoProduto() +"', \n" +
                "'" + apartamento.getPrecoProduto() +"', \n" +
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
