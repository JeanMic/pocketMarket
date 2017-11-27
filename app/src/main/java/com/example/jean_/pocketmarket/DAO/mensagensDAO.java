package com.example.jean_.pocketmarket.DAO;

import com.example.jean_.pocketmarket.controle.controle;
import com.example.jean_.pocketmarket.modelo.carro;
import com.example.jean_.pocketmarket.modelo.mensagem;
import com.example.jean_.pocketmarket.modelo.notebook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jean_ on 17/10/2017.
 */

public class mensagensDAO extends acesso implements metodosDAO {

    public mensagensDAO() throws ClassNotFoundException {
    }

    @Override
    public void insert(Object objMen) {

        mensagem msg = (mensagem) objMen;
        sql = "INSERT INTO market.mensagem (\n" +
                "CPFCNPJDestinatario,\n" +
                "tituloMsg,\n" +
                "nomeRazaoSocialRemetente,\n" +
                "dataHoraEnvio,\n" +
                "mensagem,\n" +
                "CPFCNPJ_Remetente\n" +
                ")\n" +
                "VALUES\n" +
                "(\n" +
                "'" + msg.getCPFCNPJdestinatario() + "',\n" +
                "'" + msg.getTituloMensagem() + "',\n" +
                "'" + msg.getNomeRazaoSocialRemetente() + "',\n" +
                "'" + msg.getDatacadastroFormatada().format(msg.getDataEnvio()) + "', \n" +
                "'" + msg.getMensagem() + "', \n" +
                "'" + msg.getCPFCNPJRemetente() + "')";
        try {
            stm.executeUpdate(sql);
            this.desconecta();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<?> select(String qualSelect) {

        ArrayList<mensagem> lista = new ArrayList<>();
        String docPesquisa = controle.usuarioLogado.equals("PF") ? controle.usuarioLogadoPF.getCPFCNPJ() : controle.usuarioLogadoPJ.getCPFCNPJ();
        String condicao = qualSelect.equals("MsgRecebida") ? "CPFCNPJDestinatario = '" + docPesquisa + "'" : "CPFCNPJ_Remetente = '" + docPesquisa + "'";

        sql = "SELECT\n" +
                "  idmensagem,\n" +
                "  tituloMsg,\n" +
                "  CPFCNPJDestinatario,\n" +
                "  nomeRazaoSocialRemetente,\n" +
                "  dataHoraEnvio,\n" +
                "  mensagem,\n" +
                "  CPFCNPJ_Remetente\n" +
                "FROM market.mensagem WHERE " + condicao;
        try {
            ResultSet resultado = stm.executeQuery(sql);
            if (resultado != null) {
                while (resultado.next()) {

                    mensagem obj = new mensagem();

                    obj.setIdmensagem(resultado.getString("idmensagem"));
                    obj.setTituloMensagem(resultado.getString("tituloMsg"));
                    obj.setCPFCNPJdestinatario(resultado.getString("CPFCNPJDestinatario"));
                    obj.setNomeRazaoSocialRemetente(resultado.getString("nomeRazaoSocialRemetente"));
                    obj.setDatacadastroFormatada(new SimpleDateFormat("yyyy-MM-dd"));
                    obj.setDataEnvio(new Date(obj.getDatacadastroFormatada().parse(resultado.getString("dataHoraEnvio")).getTime()));
                    obj.setMensagem(resultado.getString("mensagem"));
                    obj.setCPFCNPJRemetente(resultado.getString("CPFCNPJ_Remetente"));

                    lista.add(obj);
                    obj = null;
                }
            }
            this.desconecta();
            return lista;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Object obj, String idproduto) {

        try {


            this.desconecta();
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
