package com.example.jean_.pocketmarket.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.jean_.pocketmarket.modelo.usuarioPF;

/**
 * Created by jean_ on 17/10/2017.
 */

public class usuarioPFDAO extends acesso {

    public usuarioPFDAO() throws ClassNotFoundException {
    }

    @Override
    public void insert(Object usua) {

        usuarioPF usuario = (usuarioPF) usua;

        try {


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
