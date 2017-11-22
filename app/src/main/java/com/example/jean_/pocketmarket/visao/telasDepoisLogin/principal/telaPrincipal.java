package com.example.jean_.pocketmarket.visao.telasDepoisLogin.principal;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasNavegacao.telaCategoriasProdutos;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasNavegacao.telaPesquisaCategoriasProduto;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasNavegacao.telaProdutoServico;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasNavegacao.telaUsuarioPrincipal;

/**
 * Created by jmtb on 31/10/2017.
 */

public class telaPrincipal extends AppCompatActivity implements View.OnClickListener {

    private ImageView ImgPrincipalAnuncioProdutoServico;
    private ImageView ImgPrincipalPesquisaProduto;
    private ImageView ImgPesquisaServico;
    private ImageView ImgMinhaConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

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

        ImgPrincipalAnuncioProdutoServico = (ImageView) findViewById(R.id.ImgPrincipalAnuncioProdutoServico);
        ImgPrincipalPesquisaProduto = (ImageView) findViewById(R.id.ImgPrincipalPesquisaProduto);
        ImgPesquisaServico = (ImageView) findViewById(R.id.ImgPesquisaServico);
        ImgMinhaConta = (ImageView) findViewById(R.id.ImgMinhaConta);
    }

    private void inicializaEsculta() {
        ImgPrincipalAnuncioProdutoServico.setOnClickListener(this);
        ImgPrincipalPesquisaProduto.setOnClickListener(this);
        ImgPesquisaServico.setOnClickListener(this);
        ImgMinhaConta.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.ImgPrincipalAnuncioProdutoServico:
                Intent CategoriasProdutos = new Intent(getApplicationContext(), telaProdutoServico.class);
                startActivity(CategoriasProdutos);
                break;
            case R.id.ImgPrincipalPesquisaProduto:
                Intent CategoriasPesquisaProdutos = new Intent(getApplicationContext(), telaPesquisaCategoriasProduto.class);
                startActivity(CategoriasPesquisaProdutos);
                break;
            case R.id.ImgPesquisaServico:
//                Intent CategoriasPesquisaProdutos = new Intent(getApplicationContext(), telaPesquisaCategoriasProduto.class);
//                startActivity(CategoriasPesquisaProdutos);
                break;
            case R.id.ImgMinhaConta:
                Intent TelaPrincipalUsuarios = new Intent(getApplicationContext(), telaUsuarioPrincipal.class);
                startActivity(TelaPrincipalUsuarios);
                break;
        }
    }
}
