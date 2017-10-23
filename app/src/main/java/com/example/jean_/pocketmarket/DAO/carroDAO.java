package com.example.jean_.pocketmarket.DAO;

import com.example.jean_.pocketmarket.modelo.carro;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by jean_ on 17/10/2017.
 */

public class carroDAO extends acesso {

    public carroDAO() throws ClassNotFoundException {
    }

    @Override
    public void insert(Object carroObj) {

        carro carro = (carro) carroObj;

        sql = "INSERT INTO market.produtoveiculo (\n" +
                "tituloProduto,\n" +
                "descricaoProduto,\n" +
                "categoriaProduto,\n" +
                "fotoProduto,\n" +
                "precoProduto,\n" +
                "dataDeCadastro,\n" +
                "marca,\n" +
                "modelo,\n" +
                "anoFabricacao,\n" +
                "placa,\n" +
                "quilometragem,\n" +
                "cor,\n" +
                "combustivel,\n" +
                "possuiMultas,\n" +
                "cilindradas,\n" +
                "qtdPortas,\n" +
                "cambio )\n" +
                "\n" +
                "VALUES (\n" +
                "'" + carro.getTituloProduto() + "',\n" +
                "'" + carro.getDescricaoProduto() + "',\n" +
                "'" + carro.getCategoriaProduto() + "',\n" +
                "'" + carro.getFotoProduto() + "',\n" +
                "'" + carro.getPrecoProduto() + "',\n" +
                "NOW(),\n" +
                "'" + carro.getMarca() + "',\n" +
                "'" + carro.getModelo() + "',\n" +
                "'" + carro.getAnoFabricação() + "',\n" +
                "'" + carro.getPlaca() + "',\n" +
                "'" + carro.getQuilometragem() + "',\n" +
                "'" + carro.getCor() + "',\n" +
                "'" + carro.getCombustivel() + "',\n" +
                "'" + carro.getPossuiMultas() + "',\n" +
                "'0' , \n" +
                "'" + carro.getQtdPortas() + "',\n" +
                "'" + carro.getCambio() + "',\n" +
                "\n" +
                "INSERT INTO market.usuario_has_produtoveiculo ( produtoVeiculo_idVenda,\n" +
                "usuario_CPFCNPJ )\n" +
                "SELECT LAST_INSERT_ID(), '" + CPF_usuario_logado + "';";

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
