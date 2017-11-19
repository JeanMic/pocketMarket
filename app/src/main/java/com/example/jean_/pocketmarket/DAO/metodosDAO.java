package com.example.jean_.pocketmarket.DAO;

/**
 * Created by jean_ on 17/10/2017.
 */
import java.sql.SQLException;
import java.util.ArrayList;

public interface metodosDAO {

     void insert(Object obj) throws SQLException;

     ArrayList<Object> select();

     void update() throws SQLException;

     void delete();
}
