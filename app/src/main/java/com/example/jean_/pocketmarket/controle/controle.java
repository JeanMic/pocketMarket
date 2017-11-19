package com.example.jean_.pocketmarket.controle;

import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.jean_.pocketmarket.DAO.apartamentoDAO;
import com.example.jean_.pocketmarket.DAO.autenticacao;
import com.example.jean_.pocketmarket.DAO.carroDAO;
import com.example.jean_.pocketmarket.DAO.casaDAO;
import com.example.jean_.pocketmarket.DAO.motocicletaDAO;
import com.example.jean_.pocketmarket.DAO.usuarioPFDAO;
import com.example.jean_.pocketmarket.DAO.usuarioPJDAO;
import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.modelo.apartamento;
import com.example.jean_.pocketmarket.modelo.carro;
import com.example.jean_.pocketmarket.modelo.casa;
import com.example.jean_.pocketmarket.modelo.motocicleta;
import com.example.jean_.pocketmarket.modelo.usuarioPF;
import com.example.jean_.pocketmarket.modelo.usuarioPJ;
import com.example.jean_.pocketmarket.visao.telasNavegacao.formularioProdCarro;
import com.example.jean_.pocketmarket.visao.telasNavegacao.formularioProdCasa;
import com.example.jean_.pocketmarket.visao.telasNavegacao.formularioProdMoto;
import com.example.jean_.pocketmarket.visao.telasNavegacao.formularioProdapartamento;
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

    public static boolean validaEntradasProdutoMoto(formularioProdMoto formMoto) {

        //validações comuns para todos os produtos
        if (validaVazio(formMoto.getViewtituloProduto().getText().toString().trim(), "O Titulo Deve ser Informado") &&
                validaVazio(formMoto.getViewdescricaoProduto().getText().toString().trim(), "A Descrição Deve ser Informado") &&
                validaNumeroInteiro(formMoto.getViewprecoProduto().getText().toString().trim(), "O Preço Deve Ser Informado", "Informe Somente Números no Campo Preco Produto") &&

                //validações do produto veiculo
                validaVazio(formMoto.getViewMarca().getText().toString().trim(), "A Marca Deve Ser Informada") &&
                validaVazio(formMoto.getViewModelo().getText().toString().trim(), "O Modelo Deve Ser Informado") &&
                validaNumeroInteiro(formMoto.getViewanoFabricacao().getText().toString().trim(), "O Campo Ano Fabricação Deve ser Informado", "Informe Somente Números no Campo Ano Fabricaçao") &&
                validaPlaca(formMoto.getViewPlaca().getText().toString().trim()) &&
                validaNumeroInteiro(formMoto.getViewQuilometragem().getText().toString().trim(), "O Campo Quilometragem Deve ser Informado", "Informe Somente Números no Campo Quilometragem") &&
                validaVazio(formMoto.getViewCor().getText().toString().trim(), "A Cor Deve Ser Informado") &&

                //validação do produto moto
                validaNumeroInteiro(formMoto.getViewCilindradas().getText().toString().trim(), "As Cilindradas Devem ser Informadas", "Informe Somente Números no Campo Cilindradas")) {

            motocicleta moto = new motocicleta();

            //sets comuns a todos os produtos
            moto.setTituloProduto(formMoto.getViewtituloProduto().getText().toString().trim());
            moto.setDescricaoProduto(formMoto.getViewdescricaoProduto().getText().toString().trim());
            moto.setPrecoProduto(Float.parseFloat(formMoto.getViewprecoProduto().getText().toString().trim()));
            moto.setCategoriaProduto("Moto");
            moto.setDataDeCadastro(new Date());
            moto.setDatacadastroFormatada(new SimpleDateFormat("yyyy-MM-dd"));

            //sets comuns para todos os produtos veículos
            moto.setMarca(formMoto.getViewMarca().getText().toString().trim());
            moto.setModelo(formMoto.getViewModelo().getText().toString().trim());
            moto.setAnoFabricação(Integer.parseInt(formMoto.getViewanoFabricacao().getText().toString().trim()));
            moto.setPlaca(formMoto.getViewPlaca().getText().toString().trim());
            moto.setQuilometragem(Integer.parseInt(formMoto.getViewQuilometragem().getText().toString().trim()));
            moto.setCor(formMoto.getViewCor().getText().toString().trim());
            moto.setCombustivel((formMoto.getViewCombustivel().getCheckedRadioButtonId() == R.id.combustivelalcoolmoto) ? "ALCOOL" : "GASOLINA");
            moto.setPossuiMultas((formMoto.getViewRadiopossuiMultas().getCheckedRadioButtonId() == R.id.possuimultassim) ? true : false);

            //set comun para o produto moto
            moto.setCilindradas(Integer.parseInt(formMoto.getViewCilindradas().getText().toString().trim()));

            try {
                new motocicletaDAO().insert(moto);
                return true;
            } catch (ClassNotFoundException e) {
                formMoto.setMsgCtrl("Ocorreu um Erro no Servidor, Tente Novamente Mais Tarde");
                return false;
            }
//            catch (SQLException e) {
//                formMoto.setMsgCtrl("Usuário já Cadastrado");
//                return false;
//            }

        } else {
            formMoto.setMsgCtrl(msgErroAtual);
            return false;
        }
    }

    public static boolean validaEntradasProdutoCarro(formularioProdCarro formCarro) {

        //validações comuns para todos os produtos
        if (validaVazio(formCarro.getViewtituloProduto().getText().toString().trim(), "O Titulo Deve ser Informado") &&
                validaVazio(formCarro.getViewdescricaoProduto().getText().toString().trim(), "A Descrição Deve ser Informado") &&
                validaNumeroInteiro(formCarro.getViewprecoProduto().getText().toString().trim(), "O Preço Deve Ser Informado", "Informe Somente Números no Campo Preco Produto") &&

                //validações do produto veiculo
                validaVazio(formCarro.getViewMarca().getText().toString().trim(), "A Marca Deve Ser Informada") &&
                validaVazio(formCarro.getViewModelo().getText().toString().trim(), "O Modelo Deve Ser Informado") &&
                validaNumeroInteiro(formCarro.getViewanoFabricacao().getText().toString().trim(), "O Campo Ano Fabricação Deve ser Informado", "Informe Somente Números no Campo Ano Fabricaçao") &&
                validaPlaca(formCarro.getViewPlaca().getText().toString().trim()) &&
                validaNumeroInteiro(formCarro.getViewQuilometragem().getText().toString().trim(), "O Campo Quilometragem Deve ser Informado", "Informe Somente Números no Campo Quilometragem") &&
                validaVazio(formCarro.getViewCor().getText().toString().trim(), "A Cor Deve Ser Informado") &&

                //validação do produto moto
                validaNumeroInteiro(formCarro.getViewQtsPortas().getText().toString().trim(), "As Cilindradas Devem ser Informadas", "Informe Somente Números no Campo Cilindradas") &&
                validaVazio(formCarro.getViewCambio().getText().toString().trim(), "O Cambio Deve ser Informado")) {

            carro carro = new carro();

            //sets comuns a todos os produtos
            carro.setTituloProduto(formCarro.getViewtituloProduto().getText().toString().trim());
            carro.setDescricaoProduto(formCarro.getViewdescricaoProduto().getText().toString().trim());
            carro.setPrecoProduto(Float.parseFloat(formCarro.getViewprecoProduto().getText().toString().trim()));
            carro.setCategoriaProduto("Carro");
            carro.setDataDeCadastro(new Date());
            carro.setDatacadastroFormatada(new SimpleDateFormat("yyyy-MM-dd"));

            //sets comuns para todos os produtos veículos
            carro.setMarca(formCarro.getViewMarca().getText().toString().trim());
            carro.setModelo(formCarro.getViewModelo().getText().toString().trim());
            carro.setAnoFabricação(Integer.parseInt(formCarro.getViewanoFabricacao().getText().toString().trim()));
            carro.setPlaca(formCarro.getViewPlaca().getText().toString().trim());
            carro.setQuilometragem(Integer.parseInt(formCarro.getViewQuilometragem().getText().toString().trim()));
            carro.setCor(formCarro.getViewCor().getText().toString().trim());
            carro.setCombustivel((formCarro.getViewCombustivel().getCheckedRadioButtonId() == R.id.combustivelalcoolcarro) ? "ALCOOL" : (formCarro.getViewCombustivel().getCheckedRadioButtonId() == R.id.combustivelgasolinacarro) ? "GASOLINA" : "FLEX");
            carro.setPossuiMultas((formCarro.getViewRadiopossuiMultas().getCheckedRadioButtonId() == R.id.possuimultassimcarro) ? true : false);

            //set comun para o produto carro
            carro.setQtdPortas(Integer.parseInt(formCarro.getViewQtsPortas().getText().toString().trim()));
            carro.setCambio(formCarro.getViewCambio().getText().toString().trim());

            try {
                new carroDAO().insert(carro);
                return true;
            } catch (ClassNotFoundException e) {
                formCarro.setMsgCtrl("Ocorreu um Erro no Servidor, Tente Novamente Mais Tarde");
                return false;
            }
//            catch (SQLException e) {
//                formMoto.setMsgCtrl("Usuário já Cadastrado");
//                return false;
//            }

        } else {
            formCarro.setMsgCtrl(msgErroAtual);
            return false;
        }
    }

    public static boolean validaEntradasProdutoCasa(formularioProdCasa formCasa) {

        //validações comuns para todos os produtos
        if (validaVazio(formCasa.getViewtituloProduto().getText().toString().trim(), "O Titulo Deve ser Informado") &&
                validaVazio(formCasa.getViewdescricaoProduto().getText().toString().trim(), "A Descrição Deve ser Informado") &&
                validaNumeroInteiro(formCasa.getViewprecoProduto().getText().toString().trim(), "O Preço Deve Ser Informado", "Informe Somente Números no Campo Preco Produto") &&

                //validações do produto imoveis
                validaNumeroInteiro(formCasa.getViewQtdquartos().getText().toString().trim(), "O Campo Qtd de Quartos Deve ser Informado", "Informe Somente Números no Campo Qtd de Quartos") &&
                validaNumeroInteiro(formCasa.getViewQtdsuites().getText().toString().trim(), "O Campo Qtd de Suítes Deve ser Informado", "Informe Somente Números no Campo Qtd de Suítes") &&
                validaNumeroInteiro(formCasa.getViewanoValorIPTU().getText().toString().trim(), "O Campo Valor IPTU Deve ser Informado", "Informe Somente Números no Campo Valor IPTU") &&
                validaNumeroInteiro(formCasa.getViewValorCondominio().getText().toString().trim(), "O Campo Valor Condominio Deve ser Informado", "Informe Somente Números no Campo Valor Condominio") &&
                validaNumeroInteiro(formCasa.getViewVagsaGaragem().getText().toString().trim(), "O Campo Vagas Garagem Deve ser Informado", "Informe Somente Números no Campo Vagas Garagem") &&
                validaCep(formCasa.getViewCEPImovel().getText().toString().trim()) &&

                //validação do produto casa
                validaNumeroInteiro(formCasa.getViewAreaConstruida().getText().toString().trim(), "A Área Construída Devem ser Informada", "Informe Somente Números no Campo Área Construída")) {

            casa casaObj = new casa();

            //sets comuns a todos os produtos
            casaObj.setTituloProduto(formCasa.getViewtituloProduto().getText().toString().trim());
            casaObj.setDescricaoProduto(formCasa.getViewdescricaoProduto().getText().toString().trim());
            casaObj.setPrecoProduto(Float.parseFloat(formCasa.getViewprecoProduto().getText().toString().trim()));
            casaObj.setCategoriaProduto("Casa");
            casaObj.setDataDeCadastro(new Date());
            casaObj.setDatacadastroFormatada(new SimpleDateFormat("yyyy-MM-dd"));

            //sets comuns para todos os produtos Imovel
            casaObj.setQtdQuartos(Integer.parseInt(formCasa.getViewQtdquartos().getText().toString().trim()));
            casaObj.setQtdDeSuites(Integer.parseInt(formCasa.getViewQtdsuites().getText().toString().trim()));
            casaObj.setValorIPTU(Float.parseFloat(formCasa.getViewanoValorIPTU().getText().toString().trim()));
            casaObj.setValorCondominio(Float.parseFloat(formCasa.getViewValorCondominio().getText().toString().trim()));
            casaObj.setVagasNaGaragem(Integer.parseInt(formCasa.getViewVagsaGaragem().getText().toString().trim()));
            casaObj.setVendaOuAluguel((formCasa.getViewVendaouAluguel().getCheckedRadioButtonId() == R.id.vendacasa) ? "VENDA" : "ALUGUEL");
            casaObj.setCEPDoImovel(Integer.parseInt(formCasa.getViewCEPImovel().getText().toString().replace("-", "").trim()));
            casaObj.setPossuiPiscina((formCasa.getViewPussuiPiscina().getCheckedRadioButtonId() == R.id.possuipiscinacasa) ? true : false);
            casaObj.setPossuiAreaDeServico((formCasa.getViewPussuiAreaServico().getCheckedRadioButtonId() == R.id.possuiareadeservicocasa) ? true : false);
            casaObj.setPossuiArCondicionado((formCasa.getViewPussuiArCondicionado().getCheckedRadioButtonId() == R.id.possuiarcondicionadocasa) ? true : false);
            casaObj.setPossuiQuardoEmpregada((formCasa.getViewPussuiQuartoEmpregada().getCheckedRadioButtonId() == R.id.possuiquartoempregadacasa) ? true : false);
            casaObj.setCondominioFechado((formCasa.getViewPussuiCondominioFechado().getCheckedRadioButtonId() == R.id.possuicondominiofechadocasa) ? true : false);

            //set comun para o produto Casa
            casaObj.setAreaConstruida(Integer.parseInt(formCasa.getViewAreaConstruida().getText().toString().trim()));
            casaObj.setPossuiCameraVigilancia((formCasa.getViewPussuiCameraVigilancia().getCheckedRadioButtonId() == R.id.possuicameravigilanciacasa) ? true : false);

            try {
                new casaDAO().insert(casaObj);
                return true;
            } catch (ClassNotFoundException e) {
                formCasa.setMsgCtrl("Ocorreu um Erro no Servidor, Tente Novamente Mais Tarde");
                return false;
            }
//            catch (SQLException e) {
//                formMoto.setMsgCtrl("Usuário já Cadastrado");
//                return false;
//            }

        } else {
            formCasa.setMsgCtrl(msgErroAtual);
            return false;
        }
    }

    public static boolean validaEntradasProdutoApartamento(formularioProdapartamento formApart) {

        //validações comuns para todos os produtos
        if (validaVazio(formApart.getViewtituloProduto().getText().toString().trim(), "O Titulo Deve ser Informado") &&
                validaVazio(formApart.getViewdescricaoProduto().getText().toString().trim(), "A Descrição Deve ser Informado") &&
                validaNumeroInteiro(formApart.getViewprecoProduto().getText().toString().trim(), "O Preço Deve Ser Informado", "Informe Somente Números no Campo Preco Produto") &&

                //validações do produto imoveis
                validaNumeroInteiro(formApart.getViewQtdquartos().getText().toString().trim(), "O Campo Qtd de Quartos Deve ser Informado", "Informe Somente Números no Campo Qtd de Quartos") &&
                validaNumeroInteiro(formApart.getViewQtdsuites().getText().toString().trim(), "O Campo Qtd de Suítes Deve ser Informado", "Informe Somente Números no Campo Qtd de Suítes") &&
                validaNumeroInteiro(formApart.getViewanoValorIPTU().getText().toString().trim(), "O Campo Valor IPTU Deve ser Informado", "Informe Somente Números no Campo Valor IPTU") &&
                validaNumeroInteiro(formApart.getViewValorCondominio().getText().toString().trim(), "O Campo Valor Condominio Deve ser Informado", "Informe Somente Números no Campo Valor Condominio") &&
                validaNumeroInteiro(formApart.getViewVagsaGaragem().getText().toString().trim(), "O Campo Vagas Garagem Deve ser Informado", "Informe Somente Números no Campo Vagas Garagem") &&
                validaCep(formApart.getViewCEPImovel().getText().toString().trim()) &&

                //validação do produto casa
                validaNumeroInteiro(formApart.getViewAreaUtil().getText().toString().trim(), "A Área Construída Devem ser Informada", "Informe Somente Números no Campo Área Construída")) {

            apartamento apartObj = new apartamento();

            //sets comuns a todos os produtos
            apartObj.setTituloProduto(formApart.getViewtituloProduto().getText().toString().trim());
            apartObj.setDescricaoProduto(formApart.getViewdescricaoProduto().getText().toString().trim());
            apartObj.setPrecoProduto(Float.parseFloat(formApart.getViewprecoProduto().getText().toString().trim()));
            apartObj.setCategoriaProduto("Apartamento");
            apartObj.setDataDeCadastro(new Date());
            apartObj.setDatacadastroFormatada(new SimpleDateFormat("yyyy-MM-dd"));

            //sets comuns para todos os produtos Imovel
            apartObj.setQtdQuartos(Integer.parseInt(formApart.getViewQtdquartos().getText().toString().trim()));
            apartObj.setQtdDeSuites(Integer.parseInt(formApart.getViewQtdsuites().getText().toString().trim()));
            apartObj.setValorIPTU(Float.parseFloat(formApart.getViewanoValorIPTU().getText().toString().trim()));
            apartObj.setValorCondominio(Float.parseFloat(formApart.getViewValorCondominio().getText().toString().trim()));
            apartObj.setVagasNaGaragem(Integer.parseInt(formApart.getViewVagsaGaragem().getText().toString().trim()));
            apartObj.setVendaOuAluguel((formApart.getViewVendaouAluguel().getCheckedRadioButtonId() == R.id.vendacasa) ? "VENDA" : "ALUGUEL");
            apartObj.setCEPDoImovel(Integer.parseInt(formApart.getViewCEPImovel().getText().toString().replace("-", "").trim()));
            apartObj.setPossuiPiscina((formApart.getViewPussuiPiscina().getCheckedRadioButtonId() == R.id.possuipiscinaapartamento) ? true : false);
            apartObj.setPossuiAreaDeServico((formApart.getViewPussuiAreaServico().getCheckedRadioButtonId() == R.id.possuiareadeservicoapartamento) ? true : false);
            apartObj.setPossuiArCondicionado((formApart.getViewPussuiArCondicionado().getCheckedRadioButtonId() == R.id.possuiarcondicionadoapartamento) ? true : false);
            apartObj.setPossuiQuardoEmpregada((formApart.getViewPussuiQuartoEmpregada().getCheckedRadioButtonId() == R.id.possuiquartoempregadaapartamento) ? true : false);
            apartObj.setCondominioFechado((formApart.getViewPussuiCondominioFechado().getCheckedRadioButtonId() == R.id.possuicondominiofechadoapartamento) ? true : false);

            //set comun para o produto apartamento
            apartObj.setAreaUtil(Integer.parseInt(formApart.getViewAreaUtil().getText().toString().trim()));
            apartObj.setPossuiAcademia((formApart.getViewPussuiAcademia().getCheckedRadioButtonId() == R.id.possuiacademiaapartamento) ? true : false);
            apartObj.setPossuiVaranda((formApart.getViewPussuiVaranda().getCheckedRadioButtonId() == R.id.possuivarandaapartamento) ? true : false);
            apartObj.setPossuiElevadorPredio((formApart.getViewPussuiElevadorPredio().getCheckedRadioButtonId() == R.id.possuielevadorapartamento) ? true : false);

            try {
                new apartamentoDAO().insert(apartObj);
                return true;
            } catch (ClassNotFoundException e) {
                formApart.setMsgCtrl("Ocorreu um Erro no Servidor, Tente Novamente Mais Tarde");
                return false;
            }
//            catch (SQLException e) {
//                formMoto.setMsgCtrl("Usuário já Cadastrado");
//                return false;
//            }

        } else {
            formApart.setMsgCtrl(msgErroAtual);
            return false;
        }
    }


    //testado
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

    //testado
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

    //testado
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

    //testado
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

    //testado
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

    //testado
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

    //testado
    public static boolean validaVazio(String estaVazio, String MsgErro) {

        if ((estaVazio != null) && (estaVazio.length() > 0)) {
            return true;
        } else {
            msgErroAtual = MsgErro;
            return false;
        }
    }

    //testado
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

    //testado
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

    //testado
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

    //testado
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

    //testado
    public static boolean validaNumeroInteiro(String numero, String msgVazio, String msgInvalido) {

        if (numero != null && !numero.isEmpty()) {

            if (numero.replaceAll("[0-9]", "").isEmpty()) {
                return true;
            } else {
                msgErroAtual = msgInvalido;
                return false;
            }
        } else {
            msgErroAtual = msgVazio;
            return false;
        }
    }

    public static boolean validaPlaca(String Placa) {

        if (Placa != null && Placa.length() != 0) {

            if (Placa.replaceAll("[0-9A-Z]", "").length() == 0) {
                return true;
            } else {
                msgErroAtual = "Informe Apenas Números e Letras Maiúsculas Sem Acentos No Campo Placa";
                return false;
            }
        } else {
            msgErroAtual = "A Placa deve Ser Informada";
            return false;
        }

    }

}