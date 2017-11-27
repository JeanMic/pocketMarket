package com.example.jean_.pocketmarket.controle;

import com.example.jean_.pocketmarket.DAO.apartamentoDAO;
import com.example.jean_.pocketmarket.DAO.autenticacao;
import com.example.jean_.pocketmarket.DAO.carroDAO;
import com.example.jean_.pocketmarket.DAO.casaDAO;
import com.example.jean_.pocketmarket.DAO.celularesTelefoniaDAO;
import com.example.jean_.pocketmarket.DAO.desktopDAO;
import com.example.jean_.pocketmarket.DAO.mensagensDAO;
import com.example.jean_.pocketmarket.DAO.motocicletaDAO;
import com.example.jean_.pocketmarket.DAO.notebookDAO;
import com.example.jean_.pocketmarket.DAO.servicosDAO;
import com.example.jean_.pocketmarket.DAO.usuarioPFDAO;
import com.example.jean_.pocketmarket.DAO.usuarioPJDAO;
import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.modelo.apartamento;
import com.example.jean_.pocketmarket.modelo.carro;
import com.example.jean_.pocketmarket.modelo.casa;
import com.example.jean_.pocketmarket.modelo.celularesTelefonia;
import com.example.jean_.pocketmarket.modelo.desktop;
import com.example.jean_.pocketmarket.modelo.mensagem;
import com.example.jean_.pocketmarket.modelo.motocicleta;
import com.example.jean_.pocketmarket.modelo.notebook;
import com.example.jean_.pocketmarket.modelo.servico;
import com.example.jean_.pocketmarket.modelo.usuario;
import com.example.jean_.pocketmarket.modelo.usuarioPF;
import com.example.jean_.pocketmarket.modelo.usuarioPJ;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioMensagem;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioProdCarro;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioProdCasa;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioProdCelulares;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioProdDesktop;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioProdMoto;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioProdNotebook;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioProdServico;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioProdapartamento;
import com.example.jean_.pocketmarket.visao.telasAntesLogin.formularioPF;
import com.example.jean_.pocketmarket.visao.telasAntesLogin.formularioPJ;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by jmtb on 23/10/2017.
 */

public class controle {

    public static usuarioPF usuarioLogadoPF;
    public static usuarioPJ usuarioLogadoPJ;
    public static String usuarioLogado;
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
            return true;
        } else {
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

    public static boolean validaEntradasProdutoMoto(formularioProdMoto formMoto, String idatualizacao) {

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
            moto.setCPFCNPJVendedor(usuarioLogadoPF == null ? usuarioLogadoPJ.getCPFCNPJ() : usuarioLogadoPF.getCPFCNPJ());

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
                if (idatualizacao == null) {
                    new motocicletaDAO().insert(moto);
                } else {
                    new motocicletaDAO().update(moto, formMoto.getIdAtualizacao());
                }
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

    public static boolean validaEntradasProdutoCarro(formularioProdCarro formCarro, String idatualizacao) {

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
            carro.setCPFCNPJVendedor(usuarioLogadoPF == null ? usuarioLogadoPJ.getCPFCNPJ() : usuarioLogadoPF.getCPFCNPJ());

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
                if (idatualizacao == null) {
                    new carroDAO().insert(carro);
                } else {
                    new carroDAO().update(carro, formCarro.getIdAtualizacao());
                }
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
            casaObj.setCPFCNPJVendedor(usuarioLogadoPF == null ? usuarioLogadoPJ.getCPFCNPJ() : usuarioLogadoPF.getCPFCNPJ());

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
            apartObj.setCPFCNPJVendedor(usuarioLogadoPF == null ? usuarioLogadoPJ.getCPFCNPJ() : usuarioLogadoPF.getCPFCNPJ());

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

    public static boolean validaEntradasProdutoNotebook(formularioProdNotebook formNote) {

        //validações comuns para todos os produtos
        if (validaVazio(formNote.getViewtituloProduto().getText().toString().trim(), "O Titulo Deve ser Informado") &&
                validaVazio(formNote.getViewdescricaoProduto().getText().toString().trim(), "A Descrição Deve ser Informado") &&
                validaNumeroInteiro(formNote.getViewprecoProduto().getText().toString().trim(), "O Preço Deve Ser Informado", "Informe Somente Números no Campo Preco Produto") &&

                //validações do produto computadornotebook
                validaVazio(formNote.getViewMarca().getText().toString().trim(), "O Campo Marca Deve ser Informado") &&
                validaVazio(formNote.getViewModelo().getText().toString().trim(), "O Campo Modelo Deve ser Informado") &&
                validaNumeroInteiro(formNote.getViewRAM().getText().toString().trim(), "O Campo RAM Deve ser Informado", "Informe Somente Números no Campo RAM") &&
                validaVazio(formNote.getViewMarcaProcessador().getText().toString().trim(), "O Campo Marca Processador Deve ser Informado") &&
                validaVazio(formNote.getViewModeloProcessador().getText().toString().trim(), "O Campo Modelo Processador Deve ser Informado") &&
                validaNumeroInteiro(formNote.getViewArmazenamento().getText().toString().trim(), "O Campo Armazenamento Deve ser Informado", "Informe Somente Números no Armazenamento") &&
                validaVazio(formNote.getViewSistema().getText().toString().trim(), "O Campo Sistema Deve ser Informado") &&
                validaVazio(formNote.getViewVersaoSistema().getText().toString().trim(), "O Campo Versão Sistema Deve ser Informado") &&

                //validação do produto notebook
                validaNumeroInteiro(formNote.getViewTamanhoTela().getText().toString().trim(), "O Tamanho da Tela Deve ser Informado", "Informe Somente Números no Campo Tamanho Tela")) {

            notebook noteObj = new notebook();

            //sets comuns a todos os produtos
            noteObj.setTituloProduto(formNote.getViewtituloProduto().getText().toString().trim());
            noteObj.setDescricaoProduto(formNote.getViewdescricaoProduto().getText().toString().trim());
            noteObj.setPrecoProduto(Float.parseFloat(formNote.getViewprecoProduto().getText().toString().trim()));
            noteObj.setCategoriaProduto("Notebook");
            noteObj.setDataDeCadastro(new Date());
            noteObj.setDatacadastroFormatada(new SimpleDateFormat("yyyy-MM-dd"));
            noteObj.setCPFCNPJVendedor(usuarioLogadoPF == null ? usuarioLogadoPJ.getCPFCNPJ() : usuarioLogadoPF.getCPFCNPJ());

            //sets comuns para todos os produtos computadoresnotebooks
            noteObj.setMarca(formNote.getViewMarca().getText().toString().trim());
            noteObj.setModelo(formNote.getViewModelo().getText().toString().trim());
            noteObj.setRAM(Integer.parseInt(formNote.getViewRAM().getText().toString().trim()));
            noteObj.setMarcaProcessador(formNote.getViewMarcaProcessador().getText().toString().trim());
            noteObj.setModeloProcessador(formNote.getViewModeloProcessador().getText().toString().trim());
            noteObj.setArmazenamento(Integer.parseInt(formNote.getViewArmazenamento().getText().toString().trim()));
            noteObj.setSistema(formNote.getViewSistema().getText().toString().trim());
            noteObj.setVersaoSistema(formNote.getViewVersaoSistema().getText().toString().trim());
            noteObj.setUsado((formNote.getViewUsado().getCheckedRadioButtonId() == R.id.usadonotebook) ? true : false);

            //set comun para o produto notebooks
            noteObj.setTamanhoTela(Integer.parseInt(formNote.getViewTamanhoTela().getText().toString().trim()));
            noteObj.setPossuiTecladoNumerico((formNote.getViewpossuitecladonumerico().getCheckedRadioButtonId() == R.id.tecladonumericonotebook) ? true : false);
            noteObj.setPossuiCarregador((formNote.getViewpossuicarregador().getCheckedRadioButtonId() == R.id.possuicarregadordanotebook) ? true : false);

            try {
                new notebookDAO().insert(noteObj);
                return true;
            } catch (ClassNotFoundException e) {
                formNote.setMsgCtrl("Ocorreu um Erro no Servidor, Tente Novamente Mais Tarde");
                return false;
            }
//            catch (SQLException e) {
//                formMoto.setMsgCtrl("Usuário já Cadastrado");
//                return false;
//            }

        } else {
            formNote.setMsgCtrl(msgErroAtual);
            return false;
        }
    }

    public static boolean validaEntradasProdutoDesktop(formularioProdDesktop formdesk) {

        //validações comuns para todos os produtos
        if (validaVazio(formdesk.getViewtituloProduto().getText().toString().trim(), "O Titulo Deve ser Informado") &&
                validaVazio(formdesk.getViewdescricaoProduto().getText().toString().trim(), "A Descrição Deve ser Informado") &&
                validaNumeroInteiro(formdesk.getViewprecoProduto().getText().toString().trim(), "O Preço Deve Ser Informado", "Informe Somente Números no Campo Preco Produto") &&

                //validações do produto computadornotebook
                validaVazio(formdesk.getViewMarca().getText().toString().trim(), "O Campo Marca Deve ser Informado") &&
                validaVazio(formdesk.getViewModelo().getText().toString().trim(), "O Campo Modelo Deve ser Informado") &&
                validaNumeroInteiro(formdesk.getViewRAM().getText().toString().trim(), "O Campo RAM Deve ser Informado", "Informe Somente Números no Campo RAM") &&
                validaVazio(formdesk.getViewMarcaProcessador().getText().toString().trim(), "O Campo Marca Processador Deve ser Informado") &&
                validaVazio(formdesk.getViewModeloProcessador().getText().toString().trim(), "O Campo Modelo Processador Deve ser Informado") &&
                validaNumeroInteiro(formdesk.getViewArmazenamento().getText().toString().trim(), "O Campo Armazenamento Deve ser Informado", "Informe Somente Números no Armazenamento") &&
                validaVazio(formdesk.getViewSistema().getText().toString().trim(), "O Campo Sistema Deve ser Informado") &&
                validaVazio(formdesk.getViewVersaoSistema().getText().toString().trim(), "O Campo Versão Sistema Deve ser Informado")) {

            desktop deskObj = new desktop();

            //sets comuns a todos os produtos
            deskObj.setTituloProduto(formdesk.getViewtituloProduto().getText().toString().trim());
            deskObj.setDescricaoProduto(formdesk.getViewdescricaoProduto().getText().toString().trim());
            deskObj.setPrecoProduto(Float.parseFloat(formdesk.getViewprecoProduto().getText().toString().trim()));
            deskObj.setCategoriaProduto("Desktop");
            deskObj.setDataDeCadastro(new Date());
            deskObj.setDatacadastroFormatada(new SimpleDateFormat("yyyy-MM-dd"));
            deskObj.setCPFCNPJVendedor(usuarioLogadoPF == null ? usuarioLogadoPJ.getCPFCNPJ() : usuarioLogadoPF.getCPFCNPJ());

            //sets comuns para todos os produtos computadoresnotebooks
            deskObj.setMarca(formdesk.getViewMarca().getText().toString().trim());
            deskObj.setModelo(formdesk.getViewModelo().getText().toString().trim());
            deskObj.setRAM(Integer.parseInt(formdesk.getViewRAM().getText().toString().trim()));
            deskObj.setMarcaProcessador(formdesk.getViewMarcaProcessador().getText().toString().trim());
            deskObj.setModeloProcessador(formdesk.getViewModeloProcessador().getText().toString().trim());
            deskObj.setArmazenamento(Integer.parseInt(formdesk.getViewArmazenamento().getText().toString().trim()));
            deskObj.setSistema(formdesk.getViewSistema().getText().toString().trim());
            deskObj.setVersaoSistema(formdesk.getViewVersaoSistema().getText().toString().trim());
            deskObj.setUsado((formdesk.getViewUsado().getCheckedRadioButtonId() == R.id.usadodesktop) ? true : false);

            //set comun para o produto Desktop
            deskObj.setPossuiMonitor((formdesk.getViewPossuimonitor().getCheckedRadioButtonId() == R.id.possuimonitordesktop) ? true : false);
            deskObj.setPossuiTeclado((formdesk.getViewpossuiTeclado().getCheckedRadioButtonId() == R.id.possuitecladodadesktop) ? true : false);
            deskObj.setPossuiEstabilizador((formdesk.getViewpossuiEstabilizador().getCheckedRadioButtonId() == R.id.possuiestabilizadordesktop) ? true : false);
            deskObj.setpossuiMouse((formdesk.getViewpossuiMouse().getCheckedRadioButtonId() == R.id.possuimousedesktop) ? true : false);

            try {
                new desktopDAO().insert(deskObj);
                return true;
            } catch (ClassNotFoundException e) {
                formdesk.setMsgCtrl("Ocorreu um Erro no Servidor, Tente Novamente Mais Tarde");
                return false;
            }
//            catch (SQLException e) {
//                formMoto.setMsgCtrl("Usuário já Cadastrado");
//                return false;
//            }

        } else {
            formdesk.setMsgCtrl(msgErroAtual);
            return false;
        }
    }

    public static boolean validaEntradasProdutoCelular(formularioProdCelulares formCel) {

        //validações comuns para todos os produtos
        if (validaVazio(formCel.getViewtituloProduto().getText().toString().trim(), "O Titulo Deve ser Informado") &&
                validaVazio(formCel.getViewdescricaoProduto().getText().toString().trim(), "A Descrição Deve ser Informado") &&
                validaNumeroInteiro(formCel.getViewprecoProduto().getText().toString().trim(), "O Preço Deve Ser Informado", "Informe Somente Números no Campo Preco Produto") &&

                //validações do produto celulares
                validaVazio(formCel.getViewMarca().getText().toString().trim(), "O Campo Marca Deve ser Informado") &&
                validaVazio(formCel.getViewModelo().getText().toString().trim(), "O Campo Modelo Deve ser Informado") &&
                validaNumeroInteiro(formCel.getViewArmazenamento().getText().toString().trim(), "O Campo Armazenamento Deve ser Informado", "Informe Somente Números no Armazenamento") &&
                validaVazio(formCel.getViewSistema().getText().toString().trim(), "O Campo Sistema Deve ser Informado") &&
                validaVazio(formCel.getViewVersaoSistema().getText().toString().trim(), "O Campo Versão Sistema Deve ser Informado") &&
                validaNumeroInteiro(formCel.getViewtamanhoTela().getText().toString().trim(), "O Campo Tamanho Tela Deve ser Informado", "Informe Somente Números no Tamanho Tela")) {

            celularesTelefonia celObj = new celularesTelefonia();

            //sets comuns a todos os produtos
            celObj.setTituloProduto(formCel.getViewtituloProduto().getText().toString().trim());
            celObj.setDescricaoProduto(formCel.getViewdescricaoProduto().getText().toString().trim());
            celObj.setPrecoProduto(Float.parseFloat(formCel.getViewprecoProduto().getText().toString().trim()));
            celObj.setCategoriaProduto("Celular");
            celObj.setDataDeCadastro(new Date());
            celObj.setDatacadastroFormatada(new SimpleDateFormat("yyyy-MM-dd"));
            celObj.setCPFCNPJVendedor(usuarioLogadoPF == null ? usuarioLogadoPJ.getCPFCNPJ() : usuarioLogadoPF.getCPFCNPJ());

            //sets comuns para todos os produtos celulares
            celObj.setMarca(formCel.getViewMarca().getText().toString().trim());
            celObj.setModelo(formCel.getViewModelo().getText().toString().trim());
            celObj.setSistema(formCel.getViewSistema().getText().toString().trim());
            celObj.setVersaoSistema(formCel.getViewVersaoSistema().getText().toString().trim());
            celObj.setTamanhoTela(formCel.getViewtamanhoTela().getText().toString().trim());
            celObj.setArmazenamento(formCel.getViewArmazenamento().getText().toString().trim());
            celObj.setUsado((formCel.getViewUsado().getCheckedRadioButtonId() == R.id.usadocelulares) ? true : false);
            celObj.setPossuiCarregador((formCel.getViewPussuiCarregador().getCheckedRadioButtonId() == R.id.possuicarregadorcelulares) ? true : false);
            celObj.setPossuiFonedeOuvido((formCel.getViewPussuiFoneOuvido().getCheckedRadioButtonId() == R.id.possuicfoneouvidocelulares) ? true : false);

            try {
                new celularesTelefoniaDAO().insert(celObj);
                return true;
            } catch (ClassNotFoundException e) {
                formCel.setMsgCtrl("Ocorreu um Erro no Servidor, Tente Novamente Mais Tarde");
                return false;
            }
//            catch (SQLException e) {
//                formMoto.setMsgCtrl("Usuário já Cadastrado");
//                return false;
//            }

        } else {
            formCel.setMsgCtrl(msgErroAtual);
            return false;
        }
    }

    public static boolean validaEntradasProdutoServico(formularioProdServico formServico) {

        //validações comuns para todos os produtos
        if (validaVazio(formServico.getViewtituloProduto().getText().toString().trim(), "O Titulo Deve ser Informado") &&
                validaVazio(formServico.getViewdescricaoProduto().getText().toString().trim(), "A Descrição Deve ser Informado") &&
                validaNumeroInteiro(formServico.getViewprecoProduto().getText().toString().trim(), "O Preço Deve Ser Informado", "Informe Somente Números no Campo Preco Produto")) {

            servico servicoObj = new servico();

            //sets comuns a todos os Servicos
            servicoObj.setTituloServico(formServico.getViewtituloProduto().getText().toString().trim());
            servicoObj.setDescricaoServico(formServico.getViewdescricaoProduto().getText().toString().trim());
            servicoObj.setPrecoServico(Float.parseFloat(formServico.getViewprecoProduto().getText().toString().trim()));
            servicoObj.setCategoriaServico("Servico");
            servicoObj.setDataDeCadastro(new Date());
            servicoObj.setDatacadastroFormatada(new SimpleDateFormat("yyyy-MM-dd"));
            servicoObj.setCPFCNPJVendedor(usuarioLogadoPF == null ? usuarioLogadoPJ.getCPFCNPJ() : usuarioLogadoPF.getCPFCNPJ());

            try {
                new servicosDAO().insert(servicoObj);
                return true;
            } catch (ClassNotFoundException e) {
                formServico.setMsgCtrl("Ocorreu um Erro no Servidor, Tente Novamente Mais Tarde");
                return false;
            }
//            catch (SQLException e) {
//                formMoto.setMsgCtrl("Usuário já Cadastrado");
//                return false;
//            }

        } else {
            formServico.setMsgCtrl(msgErroAtual);
            return false;
        }
    }

    public static boolean validaEntradasMensagem(formularioMensagem formMsg) {

        //validações comuns para todos os produtos
        if (validaVazio(formMsg.getViewtituloProduto().getText().toString().trim(), "O Titulo Deve ser Informado") &&
                validaVazio(formMsg.getViewdescricaoProduto().getText().toString().trim(), "A Descrição Deve ser Informado")) {

            mensagem mensagemObj = new mensagem();

            //sets comuns a todos os Servicos
            mensagemObj.setTituloMensagem(formMsg.getViewtituloProduto().getText().toString().trim());
            mensagemObj.setMensagem(formMsg.getViewdescricaoProduto().getText().toString().trim());
            mensagemObj.setDataEnvio(new Date());
            mensagemObj.setDatacadastroFormatada(new SimpleDateFormat("yyyy-MM-dd"));
            mensagemObj.setNomeRazaoSocialRemetente(usuarioLogadoPF == null ? usuarioLogadoPJ.getRazaoSocial() : usuarioLogadoPF.getNome());
            mensagemObj.setCPFCNPJRemetente(usuarioLogadoPF == null ? usuarioLogadoPJ.getCPFCNPJ() : usuarioLogadoPF.getCPFCNPJ());
            mensagemObj.setCPFCNPJdestinatario(formMsg.getViewdestinatario().getText().toString().trim());

            try {
                new mensagensDAO().insert(mensagemObj);
                return true;
            } catch (ClassNotFoundException e) {
                formMsg.setMsgCtrl("Ocorreu um Erro no Servidor, Tente Novamente Mais Tarde");
                return false;
            }
//            catch (SQLException e) {
//                formMoto.setMsgCtrl("Usuário já Cadastrado");
//                return false;
//            }

        } else {
            formMsg.setMsgCtrl(msgErroAtual);
            return false;
        }
    }

    public static ArrayList<?> getProdutos(String pesquisa, String qualSelect) throws ClassNotFoundException {

        switch (pesquisa) {
            case "Celular":
                return new celularesTelefoniaDAO().select(qualSelect);
            case "Desktop":
                return new desktopDAO().select(qualSelect);
            case "Notebook":
                return new notebookDAO().select(qualSelect);
            case "Apartamento":
                return new apartamentoDAO().select(qualSelect);
            case "Casa":
                return new casaDAO().select(qualSelect);
            case "Carro":
                return new carroDAO().select(qualSelect);
            case "Moto":
                return new motocicletaDAO().select(qualSelect);
            case "Servico":
                return new servicosDAO().select(qualSelect);
            case "Msg":
                return new mensagensDAO().select(qualSelect);
        }
        return null;
    }

    public static boolean deletaProdutos(String produto, String cpfcnpjvendedor, String idproduto) {
        try {
            switch (produto) {
                case "Celular":
                    return new celularesTelefoniaDAO().delete(cpfcnpjvendedor, idproduto);
                case "Desktop":
                    return new desktopDAO().delete(cpfcnpjvendedor, idproduto);
                case "Notebook":
                    return new notebookDAO().delete(cpfcnpjvendedor, idproduto);
                case "Apartamento":
                    return new apartamentoDAO().delete(cpfcnpjvendedor, idproduto);
                case "Casa":
                    return new casaDAO().delete(cpfcnpjvendedor, idproduto);
                case "Carro":
                    return new carroDAO().delete(cpfcnpjvendedor, idproduto);
                case "Moto":
                    return new motocicletaDAO().delete(cpfcnpjvendedor, idproduto);
                case "Servico":
                    return new servicosDAO().delete(cpfcnpjvendedor, idproduto);
                case "Msg":
                    return new mensagensDAO().delete(cpfcnpjvendedor, idproduto);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

//    public static boolean updateProdutos(String produto, String idproduto) {
//        try {
//            switch (produto) {
//                case "Celular":
//                    return new celularesTelefoniaDAO().update(idproduto);
//                case "Desktop":
//                    return new desktopDAO().update(idproduto);
//                case "Notebook":
//                    return new notebookDAO().update(idproduto);
//                case "Apartamento":
//                    return new apartamentoDAO().update(idproduto);
//                case "Casa":
//                    return new casaDAO().update(idproduto);
//                case "Carro":
//                    return new carroDAO().update(idproduto);
//                case "Moto":
//                    return new motocicletaDAO().update(idproduto);
//                case "Servico":
//                    return new servicosDAO().update(idproduto);
//                case "Msg":
//                    return new mensagensDAO().update(idproduto);
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            return false;
//        }
//        return false;
//    }

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