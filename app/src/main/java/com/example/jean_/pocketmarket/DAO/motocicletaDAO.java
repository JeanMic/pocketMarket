package com.example.jean_.pocketmarket.DAO;

import com.example.jean_.pocketmarket.modelo.motocicleta;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by jean_ on 17/10/2017.
 */

public class motocicletaDAO extends acesso {

    public motocicletaDAO() throws ClassNotFoundException {
    }

    @Override
    public void insert(Object moto) {

        motocicleta motocicleta = (motocicleta) moto;

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
                "'" + motocicleta.getTituloProduto() + "',\n" +
                "'" + motocicleta.getDescricaoProduto() + "',\n" +
                "'" + motocicleta.getCategoriaProduto() + "',\n" +
                "'" + motocicleta.getFotoProduto() + "',\n" +
                "'" + motocicleta.getPrecoProduto() + "',\n" +
                "NOW(),\n" +
                "'" + motocicleta.getMarca() + "',\n" +
                "'" + motocicleta.getModelo() + "',\n" +
                "'" + motocicleta.getAnoFabricação() + "',\n" +
                "'" + motocicleta.getPlaca() + "',\n" +
                "'" + motocicleta.getQuilometragem() + "',\n" +
                "'" + motocicleta.getCor() + "',\n" +
                "'" + motocicleta.getCombustivel() + "',\n" +
                "'" + motocicleta.getPossuiMultas() + "',\n" +
                "'" + motocicleta.getCilindradas() + "',\n" +
                "'0' , \n" +
                "'0' , \n" +
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
