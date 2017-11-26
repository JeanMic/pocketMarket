package com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasNavegacao;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasExibicaoPesquisas.telasListViews.telaPesquisaProdutosmartphoneListView;

/**
 * Created by jean_ on 21/11/2017.
 */

public class telaPesquisaCategoriasProduto extends AppCompatActivity implements View.OnClickListener {

    private ImageView ImgTelaPesquisaVeiculos;
    private ImageView ImgTelaPesquisaImoveis;
    private ImageView ImgTelaPesquisaComputadoresNotebooks;
    private ImageView ImgTelaPesquisaSmartphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_pesquisa_categorias_produtos);

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
        ImgTelaPesquisaVeiculos = (ImageView) findViewById(R.id.ImgTelaPesquisaVeiculos);
        ImgTelaPesquisaImoveis = (ImageView) findViewById(R.id.ImgTelaPesquisaImoveis);
        ImgTelaPesquisaComputadoresNotebooks = (ImageView) findViewById(R.id.ImgTelaPesquisaComputadoresNotebooks);
        ImgTelaPesquisaSmartphone = (ImageView) findViewById(R.id.ImgTelaPesquisaSmartphone);
    }

    private void inicializaEsculta() {
        ImgTelaPesquisaVeiculos.setOnClickListener(this);
        ImgTelaPesquisaImoveis.setOnClickListener(this);
        ImgTelaPesquisaComputadoresNotebooks.setOnClickListener(this);
        ImgTelaPesquisaSmartphone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.ImgTelaPesquisaVeiculos:
                Intent pesquisaveiculo = new Intent(getApplicationContext(), telaPesquisaCategoriaVeiculo.class);
                startActivity(pesquisaveiculo);
                break;
            case R.id.ImgTelaPesquisaImoveis:
                Intent pesquisaimoveis = new Intent(getApplicationContext(), telaPesquisaCategoriaImoveis.class);
                startActivity(pesquisaimoveis);
                break;
            case R.id.ImgTelaPesquisaComputadoresNotebooks:
                Intent pesquisacomputadores = new Intent(getApplicationContext(), telaPesquisaCategoriaComputadoresNotebook.class);
                startActivity(pesquisacomputadores);
                break;
            case R.id.ImgTelaPesquisaSmartphone:
                Intent pesquisacelular = new Intent(getApplicationContext(), telaPesquisaProdutosmartphoneListView.class);
                startActivity(pesquisacelular);
                break;
        }
    }
}
