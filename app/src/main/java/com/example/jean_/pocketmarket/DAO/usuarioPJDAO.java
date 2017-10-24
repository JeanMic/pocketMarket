package com.example.jean_.pocketmarket.DAO;

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
    public void insert(Object usua) {

        usuarioPJ usuario = (usuarioPJ) usua;
        sql = "INSERT INTO `market`.`usuario`\n" +
                "            (`CPFCNPJ`,\n" +
                "             `foto`,\n" +
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
                "             `login`,\n" +
                "             `senha`,\n" +
                "             `nome`,\n" +
                "             `sexo`,\n" +
                "             `dataNascimento`,\n" +
                "             `idade`,\n" +
                "             `razaoSocial`,\n" +
                "             `dataFundacao`,\n" +
                "             `idadeFundacao`)\n" +
                "VALUES\n" +
                "(\n" +
                "'" + usuario.getCPFCNPJ() + "', \n" +
                "'" + usuario.getFoto() + "', \n" +
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
                "'" + usuario.getLogin() + "', \n" +
                "'" + usuario.getSenha() + "', \n" +
                "        '',\n" +
                "        '',\n" +
                "        '',\n" +
                "        '',\n" +
                "'" + usuario.getRazaoSocial() + "', \n" +
                "'" + usuario.getDataFundacao() + "', \n" +
                "        '');"; //COLOCAR A IDADE DE FUNDAÇAO
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
