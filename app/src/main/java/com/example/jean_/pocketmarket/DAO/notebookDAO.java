package com.example.jean_.pocketmarket.DAO;

import com.example.jean_.pocketmarket.modelo.computadoresNotebooks;
import com.example.jean_.pocketmarket.modelo.notebook;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by jean_ on 17/10/2017.
 */

public class notebookDAO extends acesso {

    public notebookDAO() throws ClassNotFoundException {
    }

    @Override
    public void insert(Object note) {

        notebook compnote = (notebook) note;

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
                "'" + compnote.getMarca() + "',\n" +
                "'" + compnote.getModelo() + "',\n" +
                "'" + compnote.getRAM() + "',\n" +
                "'" + compnote.getMarcaProcessador() + "',\n" +
                "'" + compnote.getModeloProcessador() + "',\n" +
                "'" + compnote.getArmazenamento() + "',\n" +
                "'" + compnote.getSistema() + "',\n" +
                "'" + compnote.getVersaoSistema() + "',\n" +
                "'" + compnote.isUsado() + "',\n" +
                "'" + compnote.getTamanhoTela() + "',\n" +
                "'" + compnote.isPossuiTecladoNumerico() + "',\n" +
                "'" + compnote.isPossuiCarregador() + "',\n" +
                "FALSE, \n" +
                "FALSE, \n" +
                "FALSE, \n" +
                "FALSE, \n" +
                "'" + compnote.getTituloProduto() + "',\n" +
                "'" + compnote.getDescricaoProduto() + "',\n" +
                "'" + compnote.getCategoriaProduto() + "',\n" +
                "'" + compnote.getFotoProduto() + "',\n" +
                "'" + compnote.getPrecoProduto() + "',\n" +
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
