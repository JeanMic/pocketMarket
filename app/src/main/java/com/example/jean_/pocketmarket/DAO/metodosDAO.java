package com.example.jean_.pocketmarket.DAO;

/**
 * Created by jean_ on 17/10/2017.
 */
import java.sql.SQLException;
import java.util.ArrayList;

public interface metodosDAO {

    public void insert(Object obj) throws SQLException;

    public ArrayList<Object> select();

    public void update() throws SQLException;

    public void delete();
}
