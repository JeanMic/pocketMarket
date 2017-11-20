package com.example.jean_.pocketmarket.DAO;

import com.example.jean_.pocketmarket.modelo.celularesTelefonia;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by jean_ on 17/10/2017.
 */

public class celularesTelefoniaDAO extends acesso implements metodosDAO {


    public celularesTelefoniaDAO() throws ClassNotFoundException {
    }

    @Override
    public void insert(Object cel) {

        celularesTelefonia celtel = (celularesTelefonia) cel;

        sql = "INSERT INTO market.produtocelularestelefonia (\n" +
                "sistema,\n" +
                "versaoSistema,\n" +
                "tamanhoTela,\n" +
                "marca,\n" +
                "modelo,\n" +
                "armazenamento,\n" +
                "usado,\n" +
                "possuiCarregador,\n" +
                "possuiFoneDeOuvido,\n" +
                "tituloProduto,\n" +
                "descricaoProduto,\n" +
                "categoriaProduto,\n" +
               // "fotoProduto,\n" +
                "precoProduto,\n" +
                "dataDeCadastro\n" +
                ")\n" +
                "VALUES\n" +
                "(\n" +
                "'" + celtel.getSistema() + "', \n" +
                "'" + celtel.getVersaoSistema() + "', \n" +
                "'" + celtel.getTamanhoTela() + "', \n" +
                "'" + celtel.getMarca() + "', \n" +
                "'" + celtel.getModelo() + "', \n" +
                "'" + celtel.getArmazenamento() + "', \n" +
                "'" + celtel.isUsado() + "', \n" +
                "'" + celtel.isPossuiCarregador() + "', \n" +
                "'" + celtel.isPossuiFonedeOuvido() + "', \n" +
                "'" + celtel.getTituloProduto() + "', \n" +
                "'" + celtel.getDescricaoProduto() + "', \n" +
                "'" + celtel.getCategoriaProduto() + "', \n" +
               // "'" + celtel.getFotoProduto() + "', \n" +
                "'" + celtel.getPrecoProduto() + "', \n" +
                "'" + celtel.getDatacadastroFormatada().format(celtel.getDataDeCadastro()) + "'\n" +
                ");\n";

        sqlRelacionamento = "INSERT INTO market.produtocelularestelefonia_has_usuario (\n" +
                "produtoCelularestelefonia_idprodutoCelularestelefonia,\n" +
                "usuario_CPFCNPJ)\n" +
                "SELECT LAST_INSERT_ID(),\n" +
                "'01234567890';";

        try {
            stm.executeUpdate(sql);
            stm.executeUpdate(sqlRelacionamento);
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
