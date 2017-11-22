package com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasNavegacao;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.jean_.pocketmarket.R;

/**
 * Created by jean_ on 21/11/2017.
 */

public class telaUsuarioPrincipal extends AppCompatActivity implements View.OnClickListener {

    private ImageView ImgCoontaUsuarioMensagens;
    private ImageView ImgCoontaUsuarioServicosProdutos;
    private ImageView ImgCoontaUsuarioDadosCadastrais;

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
    }

    private void inicializaEsculta() {
        ImgCoontaUsuarioMensagens.setOnClickListener(this);
        ImgCoontaUsuarioServicosProdutos.setOnClickListener(this);
        ImgCoontaUsuarioDadosCadastrais.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.ImgCoontaUsuarioMensagens:
                Intent pesquisaveiculo = new Intent(getApplicationContext(), telaUsuarioCategoriasMensagens.class);
                startActivity(pesquisaveiculo);
                break;
            case R.id.ImgCoontaUsuarioServicosProdutos:
                Intent pesquisaimoveis = new Intent(getApplicationContext(), telaCategoriasProdutosAnunciados.class);
                startActivity(pesquisaimoveis);
                break;
            case R.id.ImgCoontaUsuarioDadosCadastrais:
                //fazer
//                Intent pesquisacomputadores = new Intent(getApplicationContext(), telaPesquisaCategoriaComputadoresNotebook.class);
//                startActivity(pesquisacomputadores);
                break;
        }
    }
}

