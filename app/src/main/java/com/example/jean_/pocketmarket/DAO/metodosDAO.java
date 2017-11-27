package com.example.jean_.pocketmarket.DAO;

/**
 * Created by jean_ on 17/10/2017.
 */

import com.example.jean_.pocketmarket.modelo.carro;

import java.sql.SQLException;
import java.util.ArrayList;

public interface metodosDAO {

    void insert(Object obj) throws SQLException;

    ArrayList<?> select(String qualSelect);

    boolean update(Object obj, String idproduto) throws SQLException;

    boolean delete(String cpfcnpjvendedor, String idproduto);
}
