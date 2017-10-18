package com.example.jean_.pocketmarket.DAO;

import com.example.jean_.pocketmarket.DAO.acesso;
import com.example.jean_.pocketmarket.modelo.mensagem;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by jean_ on 17/10/2017.
 */

public class mensagensDAO extends acesso {

    public mensagensDAO() throws ClassNotFoundException {
    }

    @Override
    public void insert(Object objMen) {

        mensagem msg = (mensagem) objMen;
        sql = "INSERT INTO market.mensagem (\n" +
                "CPFCNPJDestinatario,\n" +
                "nomeRazaoSocialRemetente,\n" +
                "dataHoraEnvio,\n" +
                "mensagem,\n" +
                "usuario_CPFCNPJ\n" +
                ")\n" +
                "VALUES\n" +
                "(\n" +
                "'" + msg.getCPFCNPJdestinatario() + "',\n" +
                "'" + msg.getNomeRazaoSocialRemetente() + "',\n" +
                "'" + msg.getDataHoraEnvio() + "',\n" +
                "'" + msg.getMensagem() + "', \n" +
                "'" + msg.getCPFCNPJremetente() + "')";
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
