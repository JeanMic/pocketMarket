package com.example.jean_.pocketmarket.DAO;

import com.example.jean_.pocketmarket.modelo.apartamento;
import com.example.jean_.pocketmarket.modelo.carro;
import com.example.jean_.pocketmarket.modelo.casa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jean_ on 17/10/2017.
 */

public class apartamentoDAO extends acesso implements metodosDAO {

    public apartamentoDAO() throws ClassNotFoundException {
    }

    @Override
    public void insert(Object apartaObj) {

        apartamento apartamento = (apartamento) apartaObj;

        sql = "INSERT INTO market.produtoimovel (\n" +
                "qtdQuartos,\n" +
                "qtdDeSuites,\n" +
                "valorIPTU,\n" +
                "valorCondominio,\n" +
                "qtdVagasGaragem,\n" +
                "vendaOuAluguel,\n" +
                "CEPDoImovel,\n" +
                "possuiPiscina,\n" +
                "possuiAreadeServico,\n" +
                "possuiArCondicionado,\n" +
                "possuiQuartoEmpregada,\n" +
                "condominioFechado,\n" +
                "areaconstruida,\n" +
                "possuiCameraVigilancia,\n" +
                "areaUtil,\n" +
                "possuiAcademia,\n" +
                "possuiVaranda,\n" +
                "possuiElevadorPredio,\n" +
                "tituloProduto,\n" +
                "descricaoProduto,\n" +
                "categoriaProduto,\n" +
                //"fotoProduto,\n" +
                "precoProduto,\n" +
                "dataDeCadastro\n" +
                ")\n" +
                "VALUES\n" +
                "(\n" +
                "'" + apartamento.getQtdQuartos() + "', \n" +
                "'" + apartamento.getQtdDeSuites() + "', \n" +
                "'" + apartamento.getValorIPTU() + "', \n" +
                "'" + apartamento.getValorCondominio() + "', \n" +
                "'" + apartamento.getVagasNaGaragem() + "', \n" +
                "'" + apartamento.getVendaOuAluguel() + "', \n" +
                "'" + apartamento.getCEPDoImovel() + "', \n" +
                "'" + apartamento.isPossuiPiscina() + "', \n" +
                "'" + apartamento.isPossuiAreaDeServico() + "', \n" +
                "'" + apartamento.isPossuiArCondicionado() + "', \n" +
                "'" + apartamento.isPossuiQuardoEmpregada() + "', \n" +
                "'" + apartamento.isCondominioFechado() + "', \n" +
                "0.0, \n" +
                "'false', \n" +
                "'" + apartamento.getAreaUtil() + "', \n" +
                "'" + apartamento.isPossuiAcademia() + "', \n" +
                "'" + apartamento.isPossuiVaranda() + "', \n" +
                "'" + apartamento.isPossuiElevadorPredio() + "', \n" +
                "'" + apartamento.getTituloProduto() + "', \n" +
                "'" + apartamento.getDescricaoProduto() + "', \n" +
                "'" + apartamento.getCategoriaProduto() + "', \n" +
                //  "'" + apartamento.getFotoProduto() + "', \n" +
                "'" + apartamento.getPrecoProduto() + "', \n" +
                "'" + apartamento.getDatacadastroFormatada().format(apartamento.getDataDeCadastro()) + "'\n" +
                ");\n";

        sqlRelacionamento = "INSERT INTO market.produtoimovel_has_usuario (\n" +
                "produtoImovel_idprodutoImovel,\n" +
                "usuario_CPFCNPJ)\n" +
                "SELECT LAST_INSERT_ID(),\n" +
                "'"+ apartamento.getCPFCNPJVendedor() +"';";

        try {
            stm.executeUpdate(sql);
            stm.executeUpdate(sqlRelacionamento);
            this.desconecta();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<?> select(String qualSelect) {

        ArrayList<apartamento> lista = new ArrayList<>();

        sql = "SELECT\n" +
                "  produtoimovel.idprodutoImovel,\n" +
                "  produtoimovel.qtdQuartos,\n" +
                "  produtoimovel.qtdDeSuites,\n" +
                "  produtoimovel.valorIPTU,\n" +
                "  produtoimovel.valorCondominio,\n" +
                "  produtoimovel.qtdVagasGaragem,\n" +
                "  produtoimovel.vendaOuAluguel,\n" +
                "  produtoimovel.CEPDoImovel,\n" +
                "  produtoimovel.possuiPiscina,\n" +
                "  produtoimovel.possuiAreadeServico,\n" +
                "  produtoimovel.possuiArCondicionado,\n" +
                "  produtoimovel.possuiQuartoEmpregada,\n" +
                "  produtoimovel.condominioFechado,\n" +
                "  produtoimovel.areaconstruida,\n" +
                "  produtoimovel.possuiCameraVigilancia,\n" +
                "  produtoimovel.areaUtil,\n" +
                "  produtoimovel.possuiAcademia,\n" +
                "  produtoimovel.possuiVaranda,\n" +
                "  produtoimovel.possuiElevadorPredio,\n" +
                "  produtoimovel.tituloProduto,\n" +
                "  produtoimovel.descricaoProduto,\n" +
                "  produtoimovel.categoriaProduto,\n" +
                "  produtoimovel.precoProduto,\n" +
                "  produtoimovel.dataDeCadastro,\n" +
                "  produtoimovel.fotoProduto,\n" +
                "  produtoimovel_has_usuario.usuario_CPFCNPJ\n" +
                "  FROM market.produtoimovel INNER JOIN produtoimovel_has_usuario ON produtoimovel.idprodutoImovel = produtoimovel_has_usuario.produtoImovel_idprodutoImovel WHERE categoriaProduto = 'Apartamento';";

        try {
            ResultSet resultado = stm.executeQuery(sql);
            Date data = null;
            if (resultado != null){
                while (resultado.next()){

                    apartamento obj = new apartamento();

                    obj.setAreaUtil(resultado.getInt("areaUtil"));
                    obj.setPossuiAcademia(Boolean.parseBoolean(resultado.getString("possuiAcademia")));
                    obj.setPossuiVaranda(Boolean.parseBoolean(resultado.getString("possuiVaranda")));
                    obj.setPossuiElevadorPredio(Boolean.parseBoolean(resultado.getString("possuiElevadorPredio")));
                    obj.setQtdQuartos(resultado.getInt("qtdQuartos"));
                    obj.setQtdDeSuites(resultado.getInt("qtdDeSuites"));
                    obj.setValorIPTU(Float.parseFloat(resultado.getString("valorIPTU")));
                    obj.setValorCondominio(Float.parseFloat(resultado.getString("valorCondominio")));
                    obj.setVagasNaGaragem(resultado.getInt("qtdVagasGaragem"));
                    obj.setVendaOuAluguel(resultado.getString("vendaOuAluguel"));
                    obj.setCEPDoImovel(resultado.getInt("CEPDoImovel"));
                    obj.setPossuiPiscina(Boolean.parseBoolean(resultado.getString("possuiPiscina")));
                    obj.setPossuiAreaDeServico(Boolean.parseBoolean(resultado.getString("possuiAreadeServico")));
                    obj.setPossuiArCondicionado(Boolean.parseBoolean(resultado.getString("possuiArCondicionado")));
                    obj.setPossuiQuardoEmpregada(Boolean.parseBoolean(resultado.getString("possuiQuartoEmpregada")));
                    obj.setCondominioFechado(Boolean.parseBoolean(resultado.getString("condominioFechado")));
                    obj.setTituloProduto(resultado.getString("tituloProduto"));
                    obj.setDescricaoProduto(resultado.getString("descricaoProduto"));
                    obj.setCategoriaProduto(resultado.getString("categoriaProduto"));
                    obj.setPrecoProduto(Float.parseFloat(resultado.getString("precoProduto")));
                    obj.setDatacadastroFormatada(new SimpleDateFormat("yyyy-MM-dd"));
                    obj.setDataDeCadastro(new Date(obj.getDatacadastroFormatada().parse(resultado.getString("dataDeCadastro")).getTime()));
                    obj.setIdvenda(resultado.getString("idprodutoImovel"));
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
    public boolean update(Object obj, String idproduto) {

        try {


            this.desconecta();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String cpfcnpjvendedor, String idproduto) {

        try {


            this.desconecta();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
