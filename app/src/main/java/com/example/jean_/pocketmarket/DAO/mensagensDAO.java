package com.example.jean_.pocketmarket.DAO;

import com.example.jean_.pocketmarket.modelo.mensagem;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by jean_ on 17/10/2017.
 */

public class mensagensDAO extends acesso implements metodosDAO {

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
                "CPFCNPJ_Remetente\n" +
                ")\n" +
                "VALUES\n" +
                "(\n" +
                "'" + msg.getCPFCNPJdestinatario() + "',\n" +
                "'" + msg.getNomeRazaoSocialRemetente() + "',\n" +
                "'" + msg.getDatacadastroFormatada().format(msg.getDataEnvio()) + "', \n" +
                "'" + msg.getMensagem() + "', \n" +
                "'" + msg.getCPFCNPJRemetente() + "')";
        try {
            stm.executeUpdate(sql);
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
