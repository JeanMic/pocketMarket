package com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasNavegacao;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioProdCarro;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioProdMoto;

/**
 * Created by jean_ on 20/11/2017.
 */

public class telaVeiculos extends AppCompatActivity implements View.OnClickListener {

    private ImageView ImgTelaVeiculosCarro;
    private ImageView ImgTelaVeiculosMoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_veiculos);

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
        ImgTelaVeiculosCarro = (ImageView) findViewById(R.id.ImgTelaVeiculosCarro);
        ImgTelaVeiculosMoto = (ImageView) findViewById(R.id.ImgTelaVeiculosMoto);
    }

    private void inicializaEsculta() {
        ImgTelaVeiculosCarro.setOnClickListener(this);
        ImgTelaVeiculosMoto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId ()) {

            case R.id.ImgTelaVeiculosCarro:
                Intent carro = new Intent(getApplicationContext(), formularioProdCarro.class);
                startActivity(carro);
                break;
            case R.id.ImgTelaVeiculosMoto:
                Intent moto = new Intent(getApplicationContext(), formularioProdMoto.class);
                startActivity(moto);
                break;
        }
    }

}
