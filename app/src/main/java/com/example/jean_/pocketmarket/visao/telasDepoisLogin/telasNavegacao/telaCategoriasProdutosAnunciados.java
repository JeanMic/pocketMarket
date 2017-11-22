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

public class telaCategoriasProdutosAnunciados extends AppCompatActivity implements View.OnClickListener {

    private ImageView ImgTelaCategoriasVeiculosAnunciados;
    private ImageView ImgTelaCategoriasImoveisAnunciados;
    private ImageView ImgTelaCategoriasComputadoresNotebooksAnunciados;
    private ImageView ImgTelaCategoriasSmartphoneAnunciados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_categorias_produtos_anunciados);

        //forçar conexao e operção na rede usando a tread da UI
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Metodo executado para esconder o actionBar
        getSupportActionBar().hide();

        //resgato o ID das views
        resgataIDViews();

        //inicializa a escuta das imagens
        inicializaEsculta();
    }

    private void resgataIDViews() {

        ImgTelaCategoriasVeiculosAnunciados = (ImageView) findViewById(R.id.ImgTelaCategoriasVeiculosAnunciados);
        ImgTelaCategoriasImoveisAnunciados = (ImageView) findViewById(R.id.ImgTelaCategoriasImoveisAnunciados);
        ImgTelaCategoriasComputadoresNotebooksAnunciados = (ImageView) findViewById(R.id.ImgTelaCategoriasComputadoresNotebooksAnunciados);
        ImgTelaCategoriasSmartphoneAnunciados = (ImageView) findViewById(R.id.ImgTelaCategoriasSmartphoneAnunciados);
    }

    private void inicializaEsculta() {
        ImgTelaCategoriasVeiculosAnunciados.setOnClickListener(this);
        ImgTelaCategoriasImoveisAnunciados.setOnClickListener(this);
        ImgTelaCategoriasComputadoresNotebooksAnunciados.setOnClickListener(this);
        ImgTelaCategoriasSmartphoneAnunciados.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.ImgTelaCategoriasVeiculosAnunciados:
                Intent pesquisaveiculo = new Intent(getApplicationContext(), telaPesquisaCategoriaVeiculoAnunciados.class);
                startActivity(pesquisaveiculo);
                break;
            case R.id.ImgTelaCategoriasImoveisAnunciados:
                Intent pesquisaimoveis = new Intent(getApplicationContext(), telaPesquisaCategoriaImoveisAnunciados.class);
                startActivity(pesquisaimoveis);
                break;
            case R.id.ImgTelaCategoriasComputadoresNotebooksAnunciados:
                Intent pesquisacomputadores = new Intent(getApplicationContext(), telaPesquisaCategoriaComputadoresNotebookAnunciado.class);
                startActivity(pesquisacomputadores);
                break;
            case R.id.ImgTelaCategoriasSmartphoneAnunciados:
                //esse produto nao tem sub-categoria categoria, a itent é iniciada aqui mesmo
//                Intent pesquisacelular = new Intent(getApplicationContext(), telaUsuarioPrincipal.class);
//                startActivity(pesquisacelular);
                break;
        }
    }
}
