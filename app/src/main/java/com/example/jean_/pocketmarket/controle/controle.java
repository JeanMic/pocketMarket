package com.example.jean_.pocketmarket.controle;

import com.example.jean_.pocketmarket.DAO.autenticacao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

/**
 * Created by jmtb on 23/10/2017.
 */

public class controle {

    public static boolean autenticacao(String login, String Senha) throws NoSuchAlgorithmException, UnsupportedEncodingException, ClassNotFoundException, SQLException {

        MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
        byte bytesSenha[] = algoritmo.digest(Senha.getBytes("UTF-8"));

        StringBuilder hexSenhaEncripitada = new StringBuilder();
        for (byte b : bytesSenha) {
            hexSenhaEncripitada.append(String.format("%02X", 0xFF & b));
        }

        autenticacao obj = new autenticacao();
        //se trouxe resultado é pq foi encontrado
        if (obj.select(login, hexSenhaEncripitada.toString())){
            obj.desconecta();
            return true;
        } else {
            obj.desconecta();
            return false;
        }
           }
}
