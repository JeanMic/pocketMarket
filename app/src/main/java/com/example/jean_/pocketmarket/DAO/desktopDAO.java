package com.example.jean_.pocketmarket.DAO;

import com.example.jean_.pocketmarket.modelo.carro;
import com.example.jean_.pocketmarket.modelo.desktop;
import com.example.jean_.pocketmarket.modelo.notebook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jean_ on 17/10/2017.
 */

public class desktopDAO extends acesso implements metodosDAO {


    public desktopDAO() throws ClassNotFoundException {
    }

    @Override
    public void insert(Object desk) {

        desktop compdesk = (desktop) desk;

        sql = "INSERT INTO market.produtocomputadoresnotebooks (\n" +
                "marca,\n" +
                "modelo,\n" +
                "RAM,\n" +
                "marcaProcessador,\n" +
                "modeloProcessador,\n" +
                "armazenamento,\n" +
                "sistema,\n" +
                "versaoSistema,\n" +
                "usado,\n" +
                "tamanhoTela,\n" +
                "possuiTecladoNumerico,\n" +
                "possuiCarregador,\n" +
                "possuiMonitor,\n" +
                "possuiTeclado,\n" +
                "possuiEstabilizador,\n" +
                "possuiMouse,\n" +
                "tituloProduto,\n" +
                "descricaoProduto,\n" +
                "categoriaProduto,\n" +
                "fotoProduto,\n" +
                "precoProduto,\n" +
                "dataDeCadastro\n" +
                ")\n" +
                "VALUES\n" +
                "(\n" +
                "'" + compdesk.getMarca() + "',\n" +
                "'" + compdesk.getModelo() + "',\n" +
                "'" + compdesk.getRAM() + "',\n" +
                "'" + compdesk.getMarcaProcessador() + "',\n" +
                "'" + compdesk.getModeloProcessador() + "',\n" +
                "'" + compdesk.getArmazenamento() + "',\n" +
                "'" + compdesk.getSistema() + "',\n" +
                "'" + compdesk.getVersaoSistema() + "',\n" +
                "'" + compdesk.isUsado() + "',\n" +
                "0.0, \n" +
                "'false', \n" +
                "'false', \n" +
                "'" + compdesk.isPossuiMonitor() + "',\n" +
                "'" + compdesk.isPossuiTeclado() + "',\n" +
                "'" + compdesk.isPossuiEstabilizador() + "',\n" +
                "'" + compdesk.ispossuiMouse() + "',\n" +
                "'" + compdesk.getTituloProduto() + "',\n" +
                "'" + compdesk.getDescricaoProduto() + "',\n" +
                "'" + compdesk.getCategoriaProduto() + "',\n" +
                "'" + compdesk.getFotoProduto() + "',\n" +
                "'" + compdesk.getPrecoProduto() + "',\n" +
                "'" + compdesk.getDatacadastroFormatada().format(compdesk.getDataDeCadastro()) + "'\n" +
                ");\n";

        sqlRelacionamento = "INSERT INTO market.produtocomputadoresnotebooks_has_usuario (\n" +
                "produtoComputadoresNotebooks_idprodutoComputadoresNotebooks,\n" +
                "usuario_CPFCNPJ)\n" +
                "SELECT LAST_INSERT_ID(),\n" +
                "'"+ compdesk.getCPFCNPJVendedor() +"';";
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

        ArrayList<desktop> lista = new ArrayList<>();

        sql = "SELECT\n" +
                "  produtocomputadoresnotebooks.idprodutoComputadoresNotebooks,\n" +
                "  produtocomputadoresnotebooks.marca,\n" +
                "  produtocomputadoresnotebooks.modelo,\n" +
                "  produtocomputadoresnotebooks.RAM,\n" +
                "  produtocomputadoresnotebooks.marcaProcessador,\n" +
                "  produtocomputadoresnotebooks.modeloProcessador,\n" +
                "  produtocomputadoresnotebooks.armazenamento,\n" +
                "  produtocomputadoresnotebooks.sistema,\n" +
                "  produtocomputadoresnotebooks.versaoSistema,\n" +
                "  produtocomputadoresnotebooks.usado,\n" +
                "  produtocomputadoresnotebooks.tamanhoTela,\n" +
                "  produtocomputadoresnotebooks.possuiTecladoNumerico,\n" +
                "  produtocomputadoresnotebooks.possuiCarregador,\n" +
                "  produtocomputadoresnotebooks.possuiMonitor,\n" +
                "  produtocomputadoresnotebooks.possuiTeclado,\n" +
                "  produtocomputadoresnotebooks.possuiEstabilizador,\n" +
                "  produtocomputadoresnotebooks.possuiMouse,\n" +
                "  produtocomputadoresnotebooks.tituloProduto,\n" +
                "  produtocomputadoresnotebooks.descricaoProduto,\n" +
                "  produtocomputadoresnotebooks.categoriaProduto,\n" +
                "  produtocomputadoresnotebooks.precoProduto,\n" +
                "  produtocomputadoresnotebooks.dataDeCadastro,\n" +
                "  produtocomputadoresnotebooks.fotoProduto, \n" +
                "  produtocomputadoresnotebooks_has_usuario.usuario_CPFCNPJ\n" +
                "  FROM market.produtocomputadoresnotebooks INNER JOIN produtocomputadoresnotebooks_has_usuario " +
                "ON produtocomputadoresnotebooks.idprodutoComputadoresNotebooks = produtocomputadoresnotebooks_has_usuario.produtoComputadoresNotebooks_idprodutoComputadoresNotebooks " +
                "WHERE categoriaProduto = 'Desktop';";

        try {
            ResultSet resultado = stm.executeQuery(sql);
            Date data = null;
            if (resultado != null) {
                while (resultado.next()) {

                    desktop obj = new desktop();

                    obj.setPossuiMonitor(Boolean.parseBoolean(resultado.getString("possuiMonitor")));
                    obj.setPossuiTeclado(Boolean.parseBoolean(resultado.getString("possuiTeclado")));
                    obj.setPossuiEstabilizador(Boolean.parseBoolean(resultado.getString("possuiEstabilizador")));
                    obj.setpossuiMouse(Boolean.parseBoolean(resultado.getString("possuiMouse")));
                    obj.setMarca(resultado.getString("marca"));
                    obj.setModelo(resultado.getString("modelo"));
                    obj.setRAM(resultado.getInt("RAM"));
                    obj.setMarcaProcessador(resultado.getString("marcaProcessador"));
                    obj.setModeloProcessador(resultado.getString("modeloProcessador"));
                    obj.setArmazenamento(resultado.getInt("armazenamento"));
                    obj.setSistema(resultado.getString("sistema"));
                    obj.setVersaoSistema(resultado.getString("versaoSistema"));
                    obj.setUsado(Boolean.parseBoolean(resultado.getString("usado")));
                    obj.setTituloProduto(resultado.getString("tituloProduto"));
                    obj.setDescricaoProduto(resultado.getString("descricaoProduto"));
                    obj.setCategoriaProduto(resultado.getString("categoriaProduto"));
                    obj.setPrecoProduto(Float.parseFloat(resultado.getString("precoProduto")));
                    obj.setDatacadastroFormatada(new SimpleDateFormat("yyyy-MM-dd"));
                    obj.setDataDeCadastro(new Date(obj.getDatacadastroFormatada().parse(resultado.getString("dataDeCadastro")).getTime()));
                    obj.setIdvenda(resultado.getString("idprodutoComputadoresNotebooks"));
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
