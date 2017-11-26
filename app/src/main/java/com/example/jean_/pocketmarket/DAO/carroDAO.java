package com.example.jean_.pocketmarket.DAO;

import com.example.jean_.pocketmarket.modelo.carro;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by jean_ on 17/10/2017.
 */

public class carroDAO extends acesso implements metodosDAO {

    public carroDAO() throws ClassNotFoundException {
    }

    @Override
    public void insert(Object carroObj) {

        carro carro = (carro) carroObj;

        sql = "INSERT INTO market.produtoveiculo (\n" +
                "tituloProduto,\n" +
                "descricaoProduto,\n" +
                "categoriaProduto,\n" +
                // "fotoProduto,\n" +
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
                //"'" + carro.getFotoProduto() + "',\n" +
                "'" + carro.getPrecoProduto() + "',\n" +
                "'" + carro.getDatacadastroFormatada().format(carro.getDataDeCadastro()) + "',\n" +
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
                "'" + carro.getCambio() + "')\n";

        sqlRelacionamento = "INSERT INTO market.usuario_has_produtoveiculo (\n" +
                "produtoVeiculo_idVenda,\n" +
                "usuario_CPFCNPJ)\n" +
                "\n" +
                "SELECT LAST_INSERT_ID(),\n" +
                "'" + carro.getCPFCNPJVendedor() +"';";

        try {
            stm.executeUpdate(sql);
            stm.executeUpdate(sqlRelacionamento);
            this.desconecta();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

//    @Override
    public ArrayList<?> select(String qualSelect) {

        ArrayList<carro> lista = new ArrayList<>();

        sql = "SELECT\n" +
                " produtoveiculo.idVenda,\n" +
                " produtoveiculo.tituloProduto,\n" +
                " produtoveiculo.descricaoProduto,\n" +
                " produtoveiculo.categoriaProduto,\n" +
                " produtoveiculo.fotoProduto,\n" +
                " produtoveiculo.precoProduto,\n" +
                " produtoveiculo.dataDeCadastro,\n" +
                " produtoveiculo.marca,\n" +
                " produtoveiculo.modelo,\n" +
                " produtoveiculo.anoFabricacao,\n" +
                " produtoveiculo.placa,\n" +
                " produtoveiculo.quilometragem,\n" +
                " produtoveiculo.cor,\n" +
                " produtoveiculo.combustivel,\n" +
                " produtoveiculo.possuiMultas,\n" +
                " produtoveiculo.cilindradas,\n" +
                " produtoveiculo.qtdPortas,\n" +
                " produtoveiculo.cambio, \n" +
                " usuario_has_produtoveiculo.usuario_CPFCNPJ\n" +
                "  FROM produtoveiculo INNER JOIN usuario_has_produtoveiculo ON produtoveiculo.idVenda = usuario_has_produtoveiculo.produtoVeiculo_idVenda WHERE categoriaProduto = 'Carro';";

        try {
            ResultSet resultado = stm.executeQuery(sql);
            Date data = null;
            if (resultado != null){
                while (resultado.next()){

                    carro obj = new carro();

                    obj.setQtdPortas(resultado.getInt("qtdPortas"));
                    obj.setCambio(resultado.getString("cambio"));
                    obj.setMarca(resultado.getString("marca"));
                    obj.setModelo(resultado.getString("modelo"));
                    obj.setAnoFabricação(Integer.parseInt(resultado.getString("anoFabricacao")));
                    obj.setPlaca(resultado.getString("placa"));
                    obj.setQuilometragem(Integer.parseInt(resultado.getString("quilometragem")));
                    obj.setCor(resultado.getString("cor"));
                    obj.setCombustivel(resultado.getString("combustivel"));
                    obj.setPossuiMultas(Boolean.parseBoolean(resultado.getString("possuiMultas")));
                    obj.setTituloProduto(resultado.getString("tituloProduto"));
                    obj.setDescricaoProduto(resultado.getString("descricaoProduto"));
                    obj.setCategoriaProduto(resultado.getString("categoriaProduto"));
                    obj.setPrecoProduto(Float.parseFloat(resultado.getString("precoProduto")));
                    obj.setDatacadastroFormatada(new SimpleDateFormat("yyyy-MM-dd"));
                    obj.setDataDeCadastro(new Date(obj.getDatacadastroFormatada().parse(resultado.getString("dataDeCadastro")).getTime()));
                    obj.setIdvenda(resultado.getString("idVenda"));
                    obj.setCPFCNPJVendedor(resultado.getString("usuario_CPFCNPJ"));

                    lista.add(obj);
                    obj = null;
                }
            }
            this.desconecta();
            return lista;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
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
