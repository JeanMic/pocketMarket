package com.example.jean_.pocketmarket.DAO;

import com.example.jean_.pocketmarket.controle.controle;
import com.example.jean_.pocketmarket.modelo.usuarioPF;
import com.example.jean_.pocketmarket.modelo.usuarioPJ;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by jmtb on 24/10/2017.
 */

public class autenticacao extends acesso {

    public autenticacao() throws ClassNotFoundException {
    }

    public boolean select(String login, String senha) {

        boolean resultado = false;

        sql = "SELECT * FROM `market`.`usuario` WHERE CPFCNPJ = '" + login + "' AND senha = '" + senha + "'";


        try {
            rs = stm.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (rs != null) {
            try {
                if (rs.next()) {
                    resultado = true;


                    if (rs.getString("CPFCNPJ").length() == 11) {
                        controle.usuarioLogadoPJ = null;
                        controle.usuarioLogado = "PF";
                        controle.usuarioLogadoPF = new usuarioPF();

                        controle.usuarioLogadoPF.setCPFCNPJ(rs.getString("CPFCNPJ"));
                        controle.usuarioLogadoPF.setTipoUsuario(rs.getString("tipoUsuario"));
                        controle.usuarioLogadoPF.setDDDTelefoneOuCelular(Integer.parseInt(rs.getString("DDDTelefoneOuCelular")));
                        controle.usuarioLogadoPF.setTelefoneOuCelular(Integer.parseInt(rs.getString("telefoneOuCelular")));
                        controle.usuarioLogadoPF.setEmail(rs.getString("email"));
                        controle.usuarioLogadoPF.setEnderecoComResi(rs.getString("enderecoComResi"));
                        controle.usuarioLogadoPF.setCEPComResi(Integer.parseInt(rs.getString("cepComResi")));
                        controle.usuarioLogadoPF.setComplementoComResi(rs.getString("complementoComResi"));
                        controle.usuarioLogadoPF.setNumeroComResi(rs.getString("numeroComResi"));
                        controle.usuarioLogadoPF.setBairroComResi(rs.getString("bairroComResi"));
                        controle.usuarioLogadoPF.setCidadeComResi(rs.getString("cidadeComResi"));
                        controle.usuarioLogadoPF.setUFComResi(rs.getString("UFComResi"));
                        //controle.usuarioLogadoPF.setSenha(rs.getString("senha"));
                        controle.usuarioLogadoPF.setNome(rs.getString("nome"));
                        controle.usuarioLogadoPF.setSexo(rs.getString("sexo"));
                        controle.usuarioLogadoPF.setDataNascimento(rs.getString("dataNascimento"));
                        controle.usuarioLogadoPF.setIdade(Integer.parseInt(rs.getString("idade")));

                    } else {

                        controle.usuarioLogadoPJ = new usuarioPJ();
                        controle.usuarioLogadoPF = null;
                        controle.usuarioLogado = "PJ";

                        controle.usuarioLogadoPJ.setCPFCNPJ(rs.getString("CPFCNPJ"));
                        controle.usuarioLogadoPJ.setTipoUsuario(rs.getString("tipoUsuario"));
                        controle.usuarioLogadoPJ.setDDDTelefoneOuCelular(Integer.parseInt(rs.getString("DDDTelefoneOuCelular")));
                        controle.usuarioLogadoPJ.setTelefoneOuCelular(Integer.parseInt(rs.getString("telefoneOuCelular")));
                        controle.usuarioLogadoPJ.setEmail(rs.getString("email"));
                        controle.usuarioLogadoPJ.setEnderecoComResi(rs.getString("enderecoComResi"));
                        controle.usuarioLogadoPJ.setCEPComResi(Integer.parseInt(rs.getString("cepComResi")));
                        controle.usuarioLogadoPJ.setComplementoComResi(rs.getString("complementoComResi"));
                        controle.usuarioLogadoPJ.setNumeroComResi(rs.getString("numeroComResi"));
                        controle.usuarioLogadoPJ.setBairroComResi(rs.getString("bairroComResi"));
                        controle.usuarioLogadoPJ.setCidadeComResi(rs.getString("cidadeComResi"));
                        controle.usuarioLogadoPJ.setUFComResi(rs.getString("UFComResi"));
                        //controle.usuarioLogadoPJ.setSenha(rs.getString("senha"));
                        controle.usuarioLogadoPJ.setRazaoSocial(rs.getString("razaoSocial"));
                        controle.usuarioLogadoPJ.setDataFundacao(rs.getString("dataFundacao"));
                        controle.usuarioLogadoPJ.setIdadeFundacao(Integer.parseInt(rs.getString("idadeFundacao")));
                    }
                    return resultado;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    desconecta();
                } catch (SQLException f) {
                    e.printStackTrace();
                }
            }
        }
        return resultado;
    }
}
