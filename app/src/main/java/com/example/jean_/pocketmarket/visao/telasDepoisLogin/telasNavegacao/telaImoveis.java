package com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasNavegacao;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioProdCarro;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioProdCasa;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioProdMoto;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioProdapartamento;

/**
 * Created by jean_ on 20/11/2017.
 */

public class telaImoveis extends AppCompatActivity implements View.OnClickListener {

    private ImageView ImgTelaImoveisCasa;
    private ImageView ImgTelaImoveisApartamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_imoveis);

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

        ImgTelaImoveisCasa = (ImageView) findViewById(R.id.ImgTelaImoveisCasa);
        ImgTelaImoveisApartamento = (ImageView) findViewById(R.id.ImgTelaImoveisApartamento);
    }

    private void inicializaEsculta() {
        ImgTelaImoveisCasa.setOnClickListener(this);
        ImgTelaImoveisApartamento.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId ()) {

            case R.id.ImgTelaImoveisCasa:
                Intent carro = new Intent(getApplicationContext(), formularioProdCasa.class);
                startActivity(carro);
                break;
            case R.id.ImgTelaImoveisApartamento:
                Intent moto = new Intent(getApplicationContext(), formularioProdapartamento.class);
                startActivity(moto);
                break;
        }
    }

}