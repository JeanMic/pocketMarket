package com.example.jean_.pocketmarket.DAO;

import com.example.jean_.pocketmarket.modelo.carro;
import com.example.jean_.pocketmarket.modelo.usuarioPF;
import com.example.jean_.pocketmarket.modelo.usuarioPJ;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by jean_ on 17/10/2017.
 */

public class usuarioPJDAO extends acesso implements metodosDAO {

    public usuarioPJDAO() throws ClassNotFoundException {
    }

    @Override
    public void insert(Object usua) throws SQLException {

        usuarioPJ usuario = (usuarioPJ) usua;
        sql = "INSERT INTO `market`.`usuario`\n" +
                "            (`CPFCNPJ`,\n" +
                // "             `foto`,\n" +
                "             `tipoUsuario`,\n" +
                "             `DDDTelefoneOuCelular`,\n" +
                "             `telefoneOuCelular`,\n" +
                "             `email`,\n" +
                "             `enderecoComResi`,\n" +
                "             `cepComResi`,\n" +
                "             `complementoComResi`,\n" +
                "             `numeroComResi`,\n" +
                "             `bairroComResi`,\n" +
                "             `cidadeComResi`,\n" +
                "             `UFComResi`,\n" +
                "             `senha`,\n" +
                // "             `nome`,\n" +
                // "             `sexo`,\n" +
                //  "             `dataNascimento`,\n" +
                //  "             `idade`,\n" +
                "             `razaoSocial`,\n" +
                "             `dataFundacao`,\n" +
                "             `idadeFundacao`)\n" +
                "VALUES\n" +
                "(\n" +
                "'" + usuario.getCPFCNPJ() + "', \n" +
                // "'" + usuario.getFoto() + "', \n" +
                "'" + usuario.getTipoUsuario() + "', \n" +
                "'" + usuario.getDDDTelefoneOuCelular() + "', \n" +
                "'" + usuario.getTelefoneOuCelular() + "', \n" +
                "'" + usuario.getEmail() + "', \n" +
                "'" + usuario.getEnderecoComResi() + "', \n" +
                "'" + usuario.getCEPComResi() + "', \n" +
                "'" + usuario.getComplementoComResi() + "', \n" +
                "'" + usuario.getNumeroComResi() + "', \n" +
                "'" + usuario.getBairroComResi() + "', \n" +
                "'" + usuario.getCidadeComResi() + "', \n" +
                "'" + usuario.getUFComResi() + "', \n" +
                "'" + usuario.getSenha() + "', \n" +
                //   "        '',\n" +
                // "        '',\n" +
                //  "        '',\n" +
                //   "        '',\n" +
                "'" + usuario.getRazaoSocial() + "', \n" +
                "'" + usuario.getDataFundacao() + "', \n" +
                "'" + usuario.getIdadeFundacao() + "');";
        try {
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.desconecta();
        }
    }

    @Override
    public ArrayList<?> select(String qualSelect) {

        try {


            this.desconecta();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Object obj, String idproduto) {

        usuarioPJ usuario = (usuarioPJ) obj;

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
                "  `razaoSocial` = '" + usuario.getRazaoSocial() + "',\n" +
                "  `dataFundacao` = '" + usuario.getDataFundacao() + "',\n" +
                "  `idadeFundacao` = '" + usuario.getIdadeFundacao() + "'\n" +
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

        try {

            this.desconecta();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
