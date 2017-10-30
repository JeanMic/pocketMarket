package com.example.jean_.pocketmarket.controle;

import com.example.jean_.pocketmarket.DAO.autenticacao;
import com.example.jean_.pocketmarket.modelo.usuarioPF;
import com.example.jean_.pocketmarket.visao.telasPrimarias.formularioPF;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by jmtb on 23/10/2017.
 */

public class controle {

    private static String msgErroAtual;

    public static boolean autenticacao(String login, String Senha) throws NoSuchAlgorithmException, UnsupportedEncodingException, ClassNotFoundException, SQLException {

        MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
        byte bytesSenha[] = algoritmo.digest(Senha.getBytes("UTF-8"));

        StringBuilder hexSenhaEncripitada = new StringBuilder();
        for (byte byteAtual : bytesSenha) {
            hexSenhaEncripitada.append(String.format("%02X", 0xFF & byteAtual));
        }

        autenticacao obj = new autenticacao();
        //se trouxe resultado é pq foi encontrado
        if (obj.select(login, hexSenhaEncripitada.toString())) {
            obj.desconecta();
            return true;
        } else {
            obj.desconecta();
            return false;
        }

    }

    public static boolean validaEntradasUsuarioPF(formularioPF formPF) {

        if (validaVazio(formPF.getTxtNome(), "O Nome Deve ser Informado") && validaCPF(formPF.getTxtCPF()) &&
                validaVazio(formPF.getTxtSenha(), "A Senha Deve ser Informada") && validadataNasc(formPF.getTxtDtNasc()) &&
                validaEmail(formPF.getTxtEmail()) && validaVazio(formPF.getTxtEndereco(), "O Endereço Deve Ser Informado") &&
                validaCep(formPF.getTxtCep()) && validaVazio(formPF.getTxtNumResidencia(), "O Número da Residencia Deve Ser Informado") &&
                validaVazio(formPF.getTxtComplResid(), "O Complemento da Residencia Deve Ser Informado") &&
                validaVazio(formPF.getTxtBairro(), "O Bairro Deve Ser Informado") &&
                validaVazio(formPF.getTxtCidade(), "A Cidade Deve Ser Informada") &&
                getTxtDDDNumCel(formPF.getTxtDDDNumCel())) {

            usuarioPF usupf = new usuarioPF();

            usupf.setNome(formPF.getTxtNome());

            //situação positiva aqui
            return true;
        } else {
            formPF.setMsgCtrl(msgErroAtual);
            return false;
        }
    }

    public static boolean validaCPF(String CPF) {

        int Soma;
        int Resto;
        Soma = 0;

        if (CPF != null) {

            CPF = CPF.replaceAll("[^0-9]", "");

            if (CPF.length() != 11) {
                msgErroAtual = "O CPF Deve possuir onze digitos";
                return false;
            }

            for (int i = 1; i <= 9; i++)
                Soma = Soma + Integer.parseInt(CPF.substring(i - 1, i)) * (11 - i);
            Resto = (Soma * 10) % 11;
            if ((Resto == 10) || (Resto == 11))
                Resto = 0;
            if (Resto != Integer.parseInt(CPF.substring(9, 10))) {
                msgErroAtual = "O CPF Informado é Inválido";
                return false;
            }
            Soma = 0;
            for (int i = 1; i <= 10; i++)
                Soma = Soma + Integer.parseInt(CPF.substring(i - 1, i)) * (12 - i);
            Resto = (Soma * 10) % 11;
            if ((Resto == 10) || (Resto == 11))
                Resto = 0;
            if (Resto != Integer.parseInt(CPF.substring(10, 11))) {
                msgErroAtual = "O CPF Informado é Inválido";
                return false;
            }
            return true;

        } else {
            msgErroAtual = "O CPF Deve ser Informado";
            return false;
        }
    }

//    public static boolean validaNome(String nome) {
//
//        if ((nome != null) && (nome.length() > 0)) {
//            return true;
//        } else {
//            msgErroAtual = "O Nome Deve ser Informado";
//            return false;
//        }
//
//    }

//    public static boolean validaSenha(String senha) {
//
//        if ((senha != null) && (senha.length() > 0)) {
//            return true;
//        } else {
//            msgErroAtual = "A Senha Deve ser Informada";
//            return false;
//        }
//    }

    public static boolean validadataNasc(String dtNasc) {

        if (dtNasc != null) {
            if (dtNasc.replaceAll("[^0-9]", "").length() == 8) {
                DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
                formatoData.setLenient(false);
                try {
                    formatoData.parse(dtNasc);
                    return true;
                } catch (ParseException ex) {
                    msgErroAtual = "A data de Nascimento Informada é Inválida";
                    return false;
                }
            } else {
                msgErroAtual = "A data de Nascimento Está Incompleta";
                return false;
            }

        } else {
            msgErroAtual = "A data de Nascimento deve ser informada";
            return false;
        }

    }

    public static boolean validaEmail(String email) {

        String regexEmail = "^[a-zA-Z0-9][a-zA-Z0-9\\._-]+@([a-zA-Z0-9\\._-]+\\.)[a-zA-Z-0-9]{2,3}$";

        if ((email != null) && (email.length() > 0)) {
            if (email.matches(regexEmail)) {
                return true;
            } else {
                msgErroAtual = "O E-mail Informado é Inválido";
                return false;
            }
        } else {
            msgErroAtual = "O E-mail Deve Ser Informado";
            return false;
        }
    }

//    public static boolean validaEndereco(String endereco) {
//
//        if ((endereco != null) && (endereco.length() > 0)) {
//            return true;
//        } else {
//            msgErroAtual = "O Endereço Deve Ser Informado";
//            return false;
//        }
//    }

    public static boolean validaCep(String cep) {

        String regexCep = "^[0-9]{5}-[0-9]{3}$";

        if ((cep != null) && (cep.length() > 0)) {
            if (cep.matches(regexCep)) {
                return true;
            } else {
                msgErroAtual = "O CEP Informado é Inválido";
                return false;
            }
        } else {
            msgErroAtual = "O CEP Deve Ser Informado";
            return false;
        }
    }

    public static boolean validaVazio(String estaVazio, String MsgErro) {

        if ((estaVazio != null) && (estaVazio.length() > 0)) {
            return true;
        } else {
            msgErroAtual = MsgErro;
            return false;
        }
    }

    public static boolean getTxtDDDNumCel(String numtel) {

        String regexCep = "^\\([0-9]{2}\\)[0-9]{5}-[0-9]{4}$";

        if ((numtel != null) && (numtel.length() > 0)) {
            if (numtel.matches(numtel)) {
                return true;
            } else {
                msgErroAtual = "O Númedo de DDD e Celular Informado é Inválido";
                return false;
            }
        } else {
            msgErroAtual = "O Númedo de DDD e Celular Deve Ser Informado";
            return false;
        }
    }

}