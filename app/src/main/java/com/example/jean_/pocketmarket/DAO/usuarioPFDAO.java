package com.example.jean_.pocketmarket.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.jean_.pocketmarket.modelo.usuarioPF;

/**
 * Created by jean_ on 17/10/2017.
 */

public class usuarioPFDAO extends acesso implements metodosDAO {

    public usuarioPFDAO() throws ClassNotFoundException {
    }

    @Override
    public void insert(Object usua) {

        usuarioPF usuario = (usuarioPF) usua;
        sql = "INSERT INTO `market`.`usuario`" +
                "            (`CPFCNPJ`," +
               // "             `foto`," +
                "             `tipoUsuario`," +
                "             `DDDTelefoneOuCelular`," +
                "             `telefoneOuCelular`," +
                "             `email`," +
                "             `enderecoComResi`," +
                "             `cepComResi`," +
                "             `complementoComResi`," +
                "             `numeroComResi`," +
                "             `bairroComResi`," +
                "             `cidadeComResi`," +
                "             `UFComResi`," +
                "             `login`," +
                "             `senha`," +
                "             `nome`," +
                "             `sexo`," +
                "             `dataNascimento`," +
                "             `idade`," +
                "             `razaoSocial`," +
                "             `dataFundacao`," +
                "             `idadeFundacao`)" +
                "VALUES" +
                "(" +
                "'" + usuario.getCPFCNPJ() + "', " +
                //"'" + usuario.getFoto() + "', " +
                "'" + usuario.getTipoUsuario() + "', " +
                "'" + usuario.getDDDTelefoneOuCelular() + "', " +
                "'" + usuario.getTelefoneOuCelular() + "', " +
                "'" + usuario.getEmail() + "', " +
                "'" + usuario.getEnderecoComResi() + "', " +
                "'" + usuario.getCEPComResi() + "', " +
                "'" + usuario.getComplementoComResi() + "', " +
                "'" + usuario.getNumeroComResi() + "', " +
                "'" + usuario.getBairroComResi() + "', " +
                "'" + usuario.getCidadeComResi() + "', " +
                "'" + usuario.getUFComResi() + "', " +
                "'" + usuario.getSenha() + "', " +
                "'" + usuario.getNome() + "', " +
                "'" + usuario.getSexo() + "', " +
                "'" + usuario.getDataNascimento() + "', " +
                "'" + usuario.getIdade() + "', " +
                "        '0'," +
                "        ''," +
                "        '');";//
        //java.sql.SQLException: Column count doesn't match value count at row 1
        try {
            int test = stm.executeUpdate(sql);
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
