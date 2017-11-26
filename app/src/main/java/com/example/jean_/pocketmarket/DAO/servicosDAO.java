package com.example.jean_.pocketmarket.DAO;

import com.example.jean_.pocketmarket.modelo.carro;
import com.example.jean_.pocketmarket.modelo.motocicleta;
import com.example.jean_.pocketmarket.modelo.servico;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jean_ on 17/10/2017.
 */

public class servicosDAO extends acesso implements metodosDAO {

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
                "'"+ serv.getCPFCNPJVendedor() +"')";
        try {
            stm.executeUpdate(sql);
            this.desconecta();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<?> select(String qualSelect) {

        ArrayList<servico> lista = new ArrayList<>();

        sql = "SELECT\n" +
                "  `tituloServico`,\n" +
                "  `descricaoServico`,\n" +
                "  `categoriaServico`,\n" +
                "  `precoServico`,\n" +
                "  `usuario_CPFCNPJ`,\n" +
                "  `idServico`\n" +
                "FROM `market`.`servico`;";
        try {
            ResultSet resultado = stm.executeQuery(sql);
            if (resultado != null) {
                while (resultado.next()) {

                    servico obj = new servico();

                    obj.setTituloServico(resultado.getString("tituloServico"));
                    obj.setDescricaoServico(resultado.getString("descricaoServico"));
                    obj.setCategoriaServico(resultado.getString("categoriaServico"));
                    obj.setPrecoServico(Float.parseFloat(resultado.getString("precoServico")));
                    obj.setCPFCNPJVendedor(resultado.getString("usuario_CPFCNPJ"));
                    obj.setIdservico(resultado.getString("idServico"));

                    lista.add(obj);
                    obj = null;
                }
            }
            this.desconecta();
            return lista;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update() throws SQLException {

    }

    @Override
    public void delete() {

    }

}
