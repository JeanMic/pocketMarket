package com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasNavegacao;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioProdCelulares;

/**
 * Created by jean_ on 20/11/2017.
 */

public class telaCategoriasProdutos extends AppCompatActivity implements View.OnClickListener {

    private ImageView ImgTelaCategoriasVeiculos;
    private ImageView ImgTelaCategoriasImoveis;
    private ImageView ImgTelaCategoriasComputadoresNotebooks;
    private ImageView ImgTelaCategoriasSmartphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_categorias_produtos);

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

        ImgTelaCategoriasVeiculos = (ImageView) findViewById(R.id.ImgTelaCategoriasVeiculos);
        ImgTelaCategoriasImoveis = (ImageView) findViewById(R.id.ImgTelaCategoriasImoveis);
        ImgTelaCategoriasComputadoresNotebooks = (ImageView) findViewById(R.id.ImgTelaCategoriasComputadoresNotebooks);
        ImgTelaCategoriasSmartphone = (ImageView) findViewById(R.id.ImgTelaCategoriasSmartphone);
    }

    private void inicializaEsculta() {
        ImgTelaCategoriasVeiculos.setOnClickListener(this);
        ImgTelaCategoriasImoveis.setOnClickListener(this);
        ImgTelaCategoriasComputadoresNotebooks.setOnClickListener(this);
        ImgTelaCategoriasSmartphone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId ()) {

            case R.id.ImgTelaCategoriasVeiculos:
                Intent veiculos = new Intent(getApplicationContext(), telaVeiculos.class);
                startActivity(veiculos);
                break;
            case R.id.ImgTelaCategoriasImoveis:
                Intent imoveis = new Intent(getApplicationContext(), telaImoveis.class);
                startActivity(imoveis);
                break;
            case R.id.ImgTelaCategoriasComputadoresNotebooks:
                Intent computadoresnotebooks = new Intent(getApplicationContext(), telaComputadoresNotebooks.class);
                startActivity(computadoresnotebooks);
                break;
            case R.id.ImgTelaCategoriasSmartphone:
                Intent celulares = new Intent(getApplicationContext(), formularioProdCelulares.class);
                startActivity(celulares);
                break;
        }
    }

}
