package com.example.jean_.pocketmarket.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.jean_.pocketmarket.modelo.carro;
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
                "        NULL," +
                "        '0');";//

        try {
            int test = stm.executeUpdate(sql);
            this.desconecta();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<carro> select(String qualSelect) {
        return null;
    }

    @Override
    public boolean update(Object obj, String idproduto) {

        usuarioPF usuario = (usuarioPF) obj;

        sql = "UPDATE `market`.`usuario`\n" +
                "SET \n" +
                "  `DDDTelefoneOuCelular` = '" + usuario.getDDDTelefoneOuCelular() + "',\n" +
                "  `telefoneOuCelular` = '" + usuario.getTelefoneOuCelular() + "',\n" +
                "  `email` = '" + usuario.getEmail() + "',\n" +
                "  `enderecoComResi` = '" + usuario.getEnderecoComResi() + "',\n" +
                "  `cepComResi` = '" + usuario.getCEPComResi() + "',\n" +
                "  `complementoComResi` = '" + usuario.getComplementoComResi() + "',\n" +
                "  `numeroComResi` = '" + usuario.getNumeroComResi() + "',\n" +
                "  `bairroComResi` = '" + usuario.getBairroComResi() + "',\n" +
                "  `cidadeComResi` = '" + usuario.getCidadeComResi() + "',\n" +
                "  `UFComResi` = '" + usuario.getUFComResi() + "',\n" +
                "  `senha` = '" + usuario.getSenha() + "',\n" +
                "  `nome` = '" + usuario.getNome() + "',\n" +
                "  `sexo` = '" + usuario.getSexo() + "',\n" +
                "  `dataNascimento` = '" + usuario.getDataNascimento() + "',\n" +
                "  `idade` = '" + usuario.getIdade() + "'\n" +
                "WHERE `CPFCNPJ` = '" + usuario.getCPFCNPJ() + "';";
        try {
            stm.executeUpdate(sql);
            this.desconecta();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String cpfcnpjvendedor, String idproduto) {
        return false;
    }
}
