package com.example.jean_.pocketmarket.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by jmtb on 24/10/2017.
 */

public class autenticacao extends acesso {

    public autenticacao() throws ClassNotFoundException {
    }

    public boolean select(String login, String senha) {

        sql = "SELECT * FROM `market`.`usuario` WHERE CPFCNPJ = '" + login +"' AND senha = '" + senha + "'";

        try {
            rs = stm.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
