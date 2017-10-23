package com.example.jean_.pocketmarket.DAO;

import com.example.jean_.pocketmarket.modelo.desktop;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by jean_ on 17/10/2017.
 */

public class desktopDAO extends acesso {


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
                "FALSE, \n" +
                "FALSE, \n" +
                "'" + compdesk.isPossuiMonitor() + "',\n" +
                "'" + compdesk.isPossuiTeclado() + "',\n" +
                "'" + compdesk.isPossuiEstabilizador() + "',\n" +
                "'" + compdesk.ispossuiMouse() + "',\n" +
                "'" + compdesk.getTituloProduto() + "',\n" +
                "'" + compdesk.getDescricaoProduto() + "',\n" +
                "'" + compdesk.getCategoriaProduto() + "',\n" +
                "'" + compdesk.getFotoProduto() + "',\n" +
                "'" + compdesk.getPrecoProduto() + "',\n" +
                "NOW() \n" +
                ");\n" +
                "\n" +
                "INSERT INTO market.produtocomputadoresnotebooks_has_usuario (\n" +
                "produtoComputadoresNotebooks_idprodutoComputadoresNotebooks,\n" +
                "usuario_CPFCNPJ\n" +
                ")\n" +
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
