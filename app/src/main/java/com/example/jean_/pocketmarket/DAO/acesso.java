package com.example.jean_.pocketmarket.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by jean_ on 15/10/2017.
 */

public abstract class acesso {

    Connection connection = null;
    ResultSet rs = null;
    Statement stm = null;

     public Statement createStatement() throws ClassNotFoundException {

     try {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/market", "root", "123");
        stm = connection.createStatement();
        return stm;

    }catch(SQLException e){
            e.getErrorCode();
            return null;
        }
    }
}
