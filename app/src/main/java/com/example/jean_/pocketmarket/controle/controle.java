package com.example.jean_.pocketmarket.controle;

import com.example.jean_.pocketmarket.DAO.autenticacao;
import com.example.jean_.pocketmarket.DAO.usuarioPFDAO;
import com.example.jean_.pocketmarket.DAO.usuarioPJDAO;
import com.example.jean_.pocketmarket.modelo.usuarioPF;
import com.example.jean_.pocketmarket.modelo.usuarioPJ;
import com.example.jean_.pocketmarket.visao.telasPrimarias.formularioPF;
import com.example.jean_.pocketmarket.visao.telasPrimarias.formularioPJ;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

            usupf.setCPFCNPJ(formPF.getTxtCPF().replaceAll("[^0-9]", ""));
            //usupf.setFoto("123".getBytes());
            usupf.setTipoUsuario("PF");
            usupf.setDDDTelefoneOuCelular(Integer.parseInt(formPF.getTxtDDDNumCel().substring(1, 3)));
            usupf.setTelefoneOuCelular(Integer.parseInt(formPF.getTxtDDDNumCel().substring(4, 14).replace("-", "")));
            usupf.setEmail(formPF.getTxtEmail());
            usupf.setEnderecoComResi(formPF.getTxtEndereco());
            usupf.setCEPComResi(Integer.parseInt(formPF.getTxtCep().replace("-", "")));
            usupf.setComplementoComResi(formPF.getTxtComplResid());
            usupf.setNumeroComResi(formPF.getTxtNumResidencia());
            usupf.setBairroComResi(formPF.getTxtBairro());
            usupf.setCidadeComResi(formPF.getTxtCidade());
            usupf.setUFComResi(formPF.getTxtUF());
            usupf.setSenha(gerarSenha(formPF.getTxtSenha()));
            usupf.setNome(formPF.getTxtNome());
            usupf.setSexo(formPF.getTxtSexo());
            usupf.setDataNascimento(dataFormatoMySQL(formPF.getTxtDtNasc()));
            usupf.setIdade(calculaIdade(formPF.getTxtDtNasc(), "dd/MM/yyyy"));

            try {
                new usuarioPFDAO().insert(usupf);
                return true;
            } catch (ClassNotFoundException e) {
                formPF.setMsgCtrl("Ocorreu um Erro no Servidor, Tente Novamente Mais Tarde");
                return false;
            }

        } else {
            formPF.setMsgCtrl(msgErroAtual);
            return false;
        }
    }

    public static boolean validaEntradasUsuarioPJ(formularioPJ formPJ) {

        if (validaVazio(formPJ.getTxtRazaosocial(), "O Nome Deve ser Informado") && validaCNPJ(formPJ.getTxtCNPJ()) &&
                validaVazio(formPJ.getTxtSenhapj(), "A Senha Deve ser Informada") && validadataFundacao(formPJ.getTxtDtfundacao()) &&
                validaEmail(formPJ.getTxtEmailcontato()) && validaVazio(formPJ.getTxtEnderecocomercial(), "O Endereço Deve Ser Informado") &&
                validaCep(formPJ.getTxtCepcomercial()) && validaVazio(formPJ.getTxtNumcomercial(), "O Número Comercial Deve Ser Informado") &&
                validaVazio(formPJ.getTxtComplcomercial(), "O Complemento do Endereço Deve Ser Informado") &&
                validaVazio(formPJ.getTxtBairrocomercial(), "O Bairro Deve Ser Informado") &&
                validaVazio(formPJ.getTxtCidadecomercial(), "A Cidade Deve Ser Informada") &&
                getTxtDDDNumCel(formPJ.getTxtDDDNumCel())) {

            usuarioPJ usupj = new usuarioPJ();

            usupj.setCPFCNPJ(formPJ.getTxtCNPJ().replaceAll("[^0-9]", ""));
            //usupf.setFoto("123".getBytes());
            usupj.setTipoUsuario("PJ");
            usupj.setDDDTelefoneOuCelular(Integer.parseInt(formPJ.getTxtDDDNumCel().substring(1, 3)));
            usupj.setTelefoneOuCelular(Integer.parseInt(formPJ.getTxtDDDNumCel().substring(4, 14).replace("-", "")));
            usupj.setEmail(formPJ.getTxtEmailcontato());
            usupj.setEnderecoComResi(formPJ.getTxtEnderecocomercial());
            usupj.setCEPComResi(Integer.parseInt(formPJ.getTxtCepcomercial().replace("-", "")));
            usupj.setComplementoComResi(formPJ.getTxtComplcomercial());
            usupj.setNumeroComResi(formPJ.getTxtNumcomercial());
            usupj.setBairroComResi(formPJ.getTxtBairrocomercial());
            usupj.setCidadeComResi(formPJ.getTxtCidadecomercial());
            usupj.setUFComResi(formPJ.getTxtUFcomercial());
            usupj.setSenha(gerarSenha(formPJ.getTxtSenhapj()));
            usupj.setRazaoSocial(formPJ.getTxtRazaosocial());
            usupj.setDataFundacao(dataFormatoMySQL(formPJ.getTxtDtfundacao()));
            usupj.setIdadeFundacao(calculaIdade(formPJ.getTxtDtfundacao(), "dd/MM/yyyy"));

            try {
                new usuarioPJDAO().insert(usupj);
                return true;
            } catch (ClassNotFoundException e) {
                formPJ.setMsgCtrl("Ocorreu um Erro no Servidor, Tente Novamente Mais Tarde");
                return false;
            } catch (SQLException e) {
                formPJ.setMsgCtrl("Usuário já Cadastrado");
                return false;
            }

        } else {
            formPJ.setMsgCtrl(msgErroAtual);
            return false;
        }
    }

    public static boolean validaCPF(String CPF) {

        int Soma;
        int Resto;
        Soma = 0;

        if (CPF != null) {

            CPF = CPF.replaceAll("[^0-9]", "");

            if (CPF.length() == 0) {
                msgErroAtual = "Informe o CPF";
                return false;
            }

            if (CPF.length() < 11) {
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

    public static Boolean validaCNPJ(String CNPJ) {

        int vSoma = 0;
        int vDigito = 0;

        //melhorar esse código depois, deixar igual ao do CPF
        if (CNPJ != null && CNPJ.replaceAll("[^0-9]", "").length() != 14) {
            msgErroAtual = "O CNPJ Informado Está Imcompleto";
            return false;
        }

        CNPJ = CNPJ.replaceAll("[^0-9]", "");

        String vCalculoCNPJ = CNPJ.substring(0, 12);

        char[] vCharCNPJ = CNPJ.toCharArray();

		/* Primeira parte */
        for (int i = 0; i < 4; i++) {
            if (((vCharCNPJ[i] - 48) >= 0) && ((vCharCNPJ[i] - 48) <= 9)) {
                vSoma += (vCharCNPJ[i] - 48) * (6 - (i + 1));
            }
        }
        for (int i = 0; i < 8; i++) {
            if (((vCharCNPJ[i + 4] - 48) >= 0) && ((vCharCNPJ[i + 4] - 48) <= 9)) {
                vSoma += (vCharCNPJ[i + 4] - 48) * (10 - (i + 1));
            }
        }
        vDigito = 11 - (vSoma % 11);

        vCalculoCNPJ += ((vDigito == 10) || (vDigito == 11)) ? "0" : Integer.toString(vDigito);

		/* Segunda parte */
        vSoma = 0;
        for (int i = 0; i < 5; i++) {
            if (((vCharCNPJ[i] - 48) >= 0) && ((vCharCNPJ[i] - 48) <= 9)) {
                vSoma += (vCharCNPJ[i] - 48) * (7 - (i + 1));
            }
        }
        for (int i = 0; i < 8; i++) {
            if (((vCharCNPJ[i + 5] - 48) >= 0) && ((vCharCNPJ[i + 5] - 48) <= 9)) {
                vSoma += (vCharCNPJ[i + 5] - 48) * (10 - (i + 1));
            }
        }
        vDigito = 11 - (vSoma % 11);
        vCalculoCNPJ += ((vDigito == 10) || (vDigito == 11)) ? "0" : Integer.toString(vDigito);

        if (CNPJ.equals(vCalculoCNPJ)) {
            return true;
        } else {
            msgErroAtual = "O CNPJ Informado é Inválido";
            return false;
        }
    }

    public static boolean validadataNasc(String dtNasc) {

        if (dtNasc != null && dtNasc.replaceAll("[^0-9]", "").length() > 0) {
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

    public static boolean validadataFundacao(String dtNasc) {

        if (dtNasc != null && dtNasc.replaceAll("[^0-9]", "").length() > 0) {
            if (dtNasc.replaceAll("[^0-9]", "").length() == 8) {
                DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
                formatoData.setLenient(false);
                try {
                    formatoData.parse(dtNasc);
                    return true;
                } catch (ParseException ex) {
                    msgErroAtual = "A data de Fundação Informada é Inválida";
                    return false;
                }
            } else {
                msgErroAtual = "A data de Fundação Está Incompleta";
                return false;
            }

        } else {
            msgErroAtual = "A data de Fundação deve ser informada";
            return false;
        }

    }

    public static boolean validaEmail(String email) {

        String regexEmail = "^[a-zA-Z0-9][a-zA-Z0-9._-]+@([a-zA-Z0-9._-]+\\.)[a-zA-Z-0-9]{2,3}$";

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
            if (numtel.matches(regexCep)) {
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

    public static int calculaIdade(String dataNasc, String padrao) {

        DateFormat formato = new SimpleDateFormat(padrao);

        Date dataNascInput = null;

        try {
            dataNascInput = formato.parse(dataNasc);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Calendar dataAniversario = new GregorianCalendar();

        dataAniversario.setTime(dataNascInput);

        // Cria um objeto calendar com a data atual

        Calendar hoje = Calendar.getInstance();

        // Obtém a idade baseado no ano

        int idade = hoje.get(Calendar.YEAR) - dataAniversario.get(Calendar.YEAR);

        dataAniversario.add(Calendar.YEAR, idade);

        if (hoje.before(dataAniversario)) {
            idade--;
        }
        return idade;
    }

    public static String dataFormatoMySQL(String dataNasc) {

        SimpleDateFormat formatoOrigem = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoDestino = new SimpleDateFormat("yyyy-MM-dd");
        formatoOrigem.setLenient(false);
        Date dataNascObj = null;
        try {
            dataNascObj = formatoOrigem.parse(dataNasc);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return formatoDestino.format(dataNascObj);
    }

    public static String gerarSenha(String senhaAntiga) {

        MessageDigest algoritmo = null;
        try {
            algoritmo = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        byte bytesSenha[] = new byte[0];
        try {
            bytesSenha = algoritmo.digest(senhaAntiga.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        StringBuilder hexSenhaEncripitada = new StringBuilder();
        for (byte byteAtual : bytesSenha) {
            hexSenhaEncripitada.append(String.format("%02X", 0xFF & byteAtual));
        }
        return hexSenhaEncripitada.toString();

    }
}