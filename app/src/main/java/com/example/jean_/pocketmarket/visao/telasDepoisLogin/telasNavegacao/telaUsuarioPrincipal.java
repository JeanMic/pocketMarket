package com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasNavegacao;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.controle.controle;
import com.example.jean_.pocketmarket.visao.telasAntesLogin.formularioPF;
import com.example.jean_.pocketmarket.visao.telasAntesLogin.formularioPJ;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioProdCasa;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasExibicaoPesquisas.telasListViews.telaPesquisaMsgRecebidaListView;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasExibicaoPesquisas.telasListViews.telaPesquisaProdutoservicoUsuarioListView;

/**
 * Created by jean_ on 21/11/2017.
 */

public class telaUsuarioPrincipal extends AppCompatActivity implements View.OnClickListener {

    private ImageView ImgCoontaUsuarioMensagens;
    private ImageView ImgCoontaUsuarioServicosProdutos;
    private ImageView ImgCoontaUsuarioDadosCadastrais;
    private ImageView ImgCoontaUsuarioServicosAnunciados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal_conta_usuario);

        //forçar conexao e operção na rede usando a tread da UI
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Metodo executado para esconder o actionBar
        //getSupportActionBar().hide();

        //resgato o ID das views
        resgataIDViews();

        //inicializa a escuta das imagens
        inicializaEsculta();
    }

    private void resgataIDViews() {
        ImgCoontaUsuarioMensagens = (ImageView) findViewById(R.id.ImgCoontaUsuarioMensagens);
        ImgCoontaUsuarioServicosProdutos = (ImageView) findViewById(R.id.ImgCoontaUsuarioServicosProdutos);
        ImgCoontaUsuarioDadosCadastrais = (ImageView) findViewById(R.id.ImgCoontaUsuarioDadosCadastrais);
        ImgCoontaUsuarioServicosAnunciados = (ImageView) findViewById(R.id.ImgCoontaUsuarioServicosAnunciados);
    }

    private void inicializaEsculta() {
        ImgCoontaUsuarioMensagens.setOnClickListener(this);
        ImgCoontaUsuarioServicosProdutos.setOnClickListener(this);
        ImgCoontaUsuarioDadosCadastrais.setOnClickListener(this);
        ImgCoontaUsuarioServicosAnunciados.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.ImgCoontaUsuarioMensagens:
                Intent mensagens = new Intent(getApplicationContext(), telaUsuarioCategoriasMensagens.class);
                startActivity(mensagens);
                break;
            case R.id.ImgCoontaUsuarioServicosProdutos:
                Intent pesquisaprodutosanunciados = new Intent(getApplicationContext(), telaCategoriasProdutosAnunciados.class);
                startActivity(pesquisaprodutosanunciados);
                break;
            case R.id.ImgCoontaUsuarioServicosAnunciados:
                Intent pesquisaservicosanunciados = new Intent(getApplicationContext(), telaPesquisaProdutoservicoUsuarioListView.class);
                startActivity(pesquisaservicosanunciados);
                break;
            case R.id.ImgCoontaUsuarioDadosCadastrais:

                Intent edicaoCadastroUsuario = null;

                if (controle.usuarioLogado.equals("PF")) {
                    edicaoCadastroUsuario = new Intent(getApplicationContext(), formularioPF.class);
                    edicaoCadastroUsuario.putExtra("nome", (controle.usuarioLogadoPF.getNome()));
                    edicaoCadastroUsuario.putExtra("datanascimento", (controle.usuarioLogadoPF.getDataNascimento()));
                    edicaoCadastroUsuario.putExtra("email", (controle.usuarioLogadoPF.getEmail()));
                    edicaoCadastroUsuario.putExtra("endereco", (controle.usuarioLogadoPF.getEnderecoComResi()));
                    edicaoCadastroUsuario.putExtra("cep", (controle.usuarioLogadoPF.getCEPComResi()));
                    edicaoCadastroUsuario.putExtra("numresid", (controle.usuarioLogadoPF.getNumeroComResi()));
                    edicaoCadastroUsuario.putExtra("complementoresid", (controle.usuarioLogadoPF.getComplementoComResi()));
                    edicaoCadastroUsuario.putExtra("bairro", (controle.usuarioLogadoPF.getBairroComResi()));
                    edicaoCadastroUsuario.putExtra("cidade", (controle.usuarioLogadoPF.getCidadeComResi()));
                    edicaoCadastroUsuario.putExtra("dddnumcel", (controle.usuarioLogadoPF.getDDDTelefoneOuCelular()));
                } else {
                    edicaoCadastroUsuario = new Intent(getApplicationContext(), formularioPJ.class);
                    edicaoCadastroUsuario.putExtra("razaosocial", (controle.usuarioLogadoPJ.getRazaoSocial()));
                    edicaoCadastroUsuario.putExtra("datafundacao", (controle.usuarioLogadoPJ.getDataFundacao()));
                    edicaoCadastroUsuario.putExtra("email", (controle.usuarioLogadoPJ.getEmail()));
                    edicaoCadastroUsuario.putExtra("endereco", (controle.usuarioLogadoPJ.getEnderecoComResi()));
                    edicaoCadastroUsuario.putExtra("cep", (controle.usuarioLogadoPJ.getCEPComResi()));
                    edicaoCadastroUsuario.putExtra("numcomer", (controle.usuarioLogadoPJ.getNumeroComResi()));
                    edicaoCadastroUsuario.putExtra("complementocomer", (controle.usuarioLogadoPJ.getComplementoComResi()));
                    edicaoCadastroUsuario.putExtra("bairro", (controle.usuarioLogadoPJ.getBairroComResi()));
                    edicaoCadastroUsuario.putExtra("cidade", (controle.usuarioLogadoPJ.getCidadeComResi()));
                    edicaoCadastroUsuario.putExtra("dddnumcel", (controle.usuarioLogadoPJ.getDDDTelefoneOuCelular()));
                }
                startActivity(edicaoCadastroUsuario);
                break;
        }
    }
}

