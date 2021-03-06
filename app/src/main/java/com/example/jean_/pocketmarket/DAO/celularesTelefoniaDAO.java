package com.example.jean_.pocketmarket.DAO;

import com.example.jean_.pocketmarket.controle.controle;
import com.example.jean_.pocketmarket.modelo.carro;
import com.example.jean_.pocketmarket.modelo.celularesTelefonia;
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

public class celularesTelefoniaDAO extends acesso implements metodosDAO {


    public celularesTelefoniaDAO() throws ClassNotFoundException {
    }

    @Override
    public void insert(Object cel) {

        celularesTelefonia celtel = (celularesTelefonia) cel;

        sql = "INSERT INTO market.produtocelularestelefonia (\n" +
                "sistema,\n" +
                "versaoSistema,\n" +
                "tamanhoTela,\n" +
                "marca,\n" +
                "modelo,\n" +
                "armazenamento,\n" +
                "usado,\n" +
                "possuiCarregador,\n" +
                "possuiFoneDeOuvido,\n" +
                "tituloProduto,\n" +
                "descricaoProduto,\n" +
                "categoriaProduto,\n" +
                // "fotoProduto,\n" +
                "precoProduto,\n" +
                "dataDeCadastro\n" +
                ")\n" +
                "VALUES\n" +
                "(\n" +
                "'" + celtel.getSistema() + "', \n" +
                "'" + celtel.getVersaoSistema() + "', \n" +
                "'" + celtel.getTamanhoTela() + "', \n" +
                "'" + celtel.getMarca() + "', \n" +
                "'" + celtel.getModelo() + "', \n" +
                "'" + celtel.getArmazenamento() + "', \n" +
                "'" + celtel.isUsado() + "', \n" +
                "'" + celtel.isPossuiCarregador() + "', \n" +
                "'" + celtel.isPossuiFonedeOuvido() + "', \n" +
                "'" + celtel.getTituloProduto() + "', \n" +
                "'" + celtel.getDescricaoProduto() + "', \n" +
                "'" + celtel.getCategoriaProduto() + "', \n" +
                // "'" + celtel.getFotoProduto() + "', \n" +
                "'" + celtel.getPrecoProduto() + "', \n" +
                "'" + celtel.getDatacadastroFormatada().format(celtel.getDataDeCadastro()) + "'\n" +
                ");\n";

        sqlRelacionamento = "INSERT INTO market.produtocelularestelefonia_has_usuario (\n" +
                "produtoCelularestelefonia_idprodutoCelularestelefonia,\n" +
                "usuario_CPFCNPJ)\n" +
                "SELECT LAST_INSERT_ID(),\n" +
                "'" + celtel.getCPFCNPJVendedor() + "';";

        try {
            stm.executeUpdate(sql);
            stm.executeUpdate(sqlRelacionamento);
            this.desconecta();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<?> select(String qualSelect) {

        ArrayList<celularesTelefonia> lista = new ArrayList<>();
        String docusuariologado = controle.usuarioLogado.equals("PF") ? controle.usuarioLogadoPF.getCPFCNPJ() : controle.usuarioLogadoPJ.getCPFCNPJ();
        String condicao = qualSelect.equals("Usuario") ? " AND usuario_CPFCNPJ = '" + docusuariologado + "';" : ";";

        sql = "SELECT\n" +
                "  idprodutoCelularestelefonia,\n" +
                "  sistema,\n" +
                "  versaoSistema,\n" +
                "  tamanhoTela,\n" +
                "  marca,\n" +
                "  modelo,\n" +
                "  armazenamento,\n" +
                "  usado,\n" +
                "  possuiCarregador,\n" +
                "  possuiFoneDeOuvido,\n" +
                "  tituloProduto,\n" +
                "  descricaoProduto,\n" +
                "  categoriaProduto,\n" +
                "  precoProduto,\n" +
                "  dataDeCadastro,\n" +
                "  fotoProduto, \n" +
                "  produtocelularestelefonia_has_usuario.usuario_CPFCNPJ\n" +
                "FROM market.produtocelularestelefonia INNER JOIN produtocelularestelefonia_has_usuario ON " +
                "produtocelularestelefonia.idprodutoCelularestelefonia = produtocelularestelefonia_has_usuario.produtoCelularestelefonia_idprodutoCelularestelefonia " +
                "WHERE categoriaProduto = 'Celular'" + condicao;

        try {
            ResultSet resultado = stm.executeQuery(sql);
            Date data = null;
            if (resultado != null) {
                while (resultado.next()) {

                    celularesTelefonia obj = new celularesTelefonia();

                    obj.setTamanhoTela(resultado.getString("tamanhoTela"));
                    obj.setPossuiFonedeOuvido(Boolean.parseBoolean(resultado.getString("possuiFoneDeOuvido")));
                    obj.setPossuiCarregador(Boolean.parseBoolean(resultado.getString("possuiCarregador")));
                    obj.setMarca(resultado.getString("marca"));
                    obj.setModelo(resultado.getString("modelo"));
                    obj.setArmazenamento(resultado.getString("armazenamento"));
                    obj.setSistema(resultado.getString("sistema"));
                    obj.setVersaoSistema(resultado.getString("versaoSistema"));
                    obj.setUsado(Boolean.parseBoolean(resultado.getString("usado")));
                    obj.setTituloProduto(resultado.getString("tituloProduto"));
                    obj.setDescricaoProduto(resultado.getString("descricaoProduto"));
                    obj.setCategoriaProduto(resultado.getString("categoriaProduto"));
                    obj.setPrecoProduto(Float.parseFloat(resultado.getString("precoProduto")));
                    obj.setDatacadastroFormatada(new SimpleDateFormat("yyyy-MM-dd"));
                    obj.setDataDeCadastro(new Date(obj.getDatacadastroFormatada().parse(resultado.getString("dataDeCadastro")).getTime()));
                    obj.setIdvenda(resultado.getString("idprodutoCelularestelefonia"));
                    obj.setCPFCNPJVendedor(resultado.getString("usuario_CPFCNPJ"));

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

        celularesTelefonia celtel = (celularesTelefonia) obj;

        sql = "UPDATE `market`.`produtocelularestelefonia`\n" +
                "SET\n" +
                "  `sistema` = '" + celtel.getSistema() + "',\n" +
                "  `versaoSistema` = '" + celtel.getVersaoSistema() + "',\n" +
                "  `tamanhoTela` = '" + celtel.getTamanhoTela() + "',\n" +
                "  `marca` = '" + celtel.getMarca() + "',\n" +
                "  `modelo` = '" + celtel.getModelo() + "',\n" +
                "  `armazenamento` = '" + celtel.getArmazenamento() + "',\n" +
                "  `usado` = '" + celtel.isUsado() + "',\n" +
                "  `possuiCarregador` = '" + celtel.isPossuiCarregador() + "',\n" +
                "  `possuiFoneDeOuvido` = '" + celtel.isPossuiFonedeOuvido() + "',\n" +
                "  `tituloProduto` = '" + celtel.getTituloProduto() + "',\n" +
                "  `descricaoProduto` = '" + celtel.getDescricaoProduto() + "',\n" +
                "  `precoProduto` = '" + celtel.getPrecoProduto() + "'\n" +
                "WHERE `idprodutoCelularestelefonia` = '" + idproduto + "';";
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
    public boolean delete(String cpfcnpfvendedor, String idproduto) {

        sql = "        DELETE\n" +
                "        FROM `market`.`produtocelularestelefonia_has_usuario`\n" +
                "        WHERE `produtoCelularestelefonia_idprodutoCelularestelefonia` = '" + idproduto + "'\n" +
                "        AND `usuario_CPFCNPJ` = '" + cpfcnpfvendedor + "';";

        String sql2 = "        DELETE\n" +
                "        FROM `market`.`produtocelularestelefonia`\n" +
                "        WHERE `idprodutoCelularestelefonia` ='" + idproduto + "';";
        try {
            stm.executeUpdate(sql);
            stm.executeUpdate(sql2);
            this.desconecta();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
