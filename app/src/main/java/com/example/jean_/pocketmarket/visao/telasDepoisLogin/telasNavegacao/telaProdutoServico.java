package com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasNavegacao;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioProdServico;

/**
 * Created by jean_ on 20/11/2017.
 */

public class telaProdutoServico extends AppCompatActivity implements View.OnClickListener {

    private ImageView ImgProdutosOuServicosProduto;
    private ImageView ImgProdutosOuServicosServicos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_produto_servico);

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
        ImgProdutosOuServicosProduto = (ImageView) findViewById(R.id.ImgProdutosOuServicosProduto);
        ImgProdutosOuServicosServicos = (ImageView) findViewById(R.id.ImgProdutosOuServicosServicos);
    }

    private void inicializaEsculta() {
        ImgProdutosOuServicosProduto.setOnClickListener(this);
        ImgProdutosOuServicosServicos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId ()) {

            case R.id.ImgProdutosOuServicosProduto:
                Intent CategoriasProdutos = new Intent(getApplicationContext(), telaCategoriasProdutos.class);
                startActivity(CategoriasProdutos);
                break;
            case R.id.ImgProdutosOuServicosServicos:
                Intent CategoriasPesquisaProdutos = new Intent(getApplicationContext(), formularioProdServico.class);
                startActivity(CategoriasPesquisaProdutos);
                break;
        }
    }
}