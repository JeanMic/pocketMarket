package com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasNavegacao;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasExibicaoPesquisas.telasListViews.telaPesquisaProdutocarroListView;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasExibicaoPesquisas.telasListViews.telaPesquisaProdutomotoListView;

/**
 * Created by jean_ on 21/11/2017.
 */

public class telaPesquisaCategoriaVeiculo extends AppCompatActivity implements View.OnClickListener {

    private ImageView ImgTelaVeiculosPesquisaCarro;
    private ImageView ImgTelaVeiculosPesquisaMoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_pesquisa_produtos_veiculos);

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
        ImgTelaVeiculosPesquisaCarro = (ImageView) findViewById(R.id.ImgTelaVeiculosPesquisaCarro);
        ImgTelaVeiculosPesquisaMoto = (ImageView) findViewById(R.id.ImgTelaVeiculosPesquisaMoto);
    }

    private void inicializaEsculta() {
        ImgTelaVeiculosPesquisaCarro.setOnClickListener(this);
        ImgTelaVeiculosPesquisaMoto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.ImgTelaVeiculosPesquisaCarro:
                Intent carro = new Intent(getApplicationContext(), telaPesquisaProdutocarroListView.class);
                startActivity(carro);
                break;
            case R.id.ImgTelaVeiculosPesquisaMoto:
                Intent moto = new Intent(getApplicationContext(), telaPesquisaProdutomotoListView.class);
                startActivity(moto);
                break;

        }
    }
}
