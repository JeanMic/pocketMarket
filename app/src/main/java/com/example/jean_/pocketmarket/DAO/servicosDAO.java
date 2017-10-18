package com.example.jean_.pocketmarket.DAO;

import com.example.jean_.pocketmarket.modelo.servico;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by jean_ on 17/10/2017.
 */

public class servicosDAO extends acesso {

    public servicosDAO() throws ClassNotFoundException {
    }

    @Override
    public void insert(Object servico) {

        servico serv = (servico) servico;
        sql = "INSERT INTO market.servico (\n" +
                "tituloServico,\n" +
                "descricaoServico,\n" +
                "categoriaServico,\n" +
                "precoServico,\n" +
                "usuario_CPFCNPJ\n" +
                ")\n" +
                "VALUES\n" +
                "(\n" +
                "'" + serv.getTituloServico() + "', \n" +
                "'" + serv.getDescricaoServico() + "',\n" +
                "'" + serv.getCategoriaServico() + "', \n" +
                "'" + serv.getPrecoServico() + "',\n" +
                "'" + DEFINIR ONDE VOU PEGAR O CPF DO USUARIO LOGADO +")'";
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
    public void update() throws SQLException {

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
