package com.example.jean_.pocketmarket.visao.telasNavegacao;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.controle.controle;
import com.example.jean_.pocketmarket.visao.telasPrimarias.decisaoFormularioCadastro;

/**
 * Created by jmtb on 31/10/2017.
 */

public class telaPrincipal extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //forçar conexao e operção na rede usando a tread da UI
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Metodo executado para esconder o actionBar
        getSupportActionBar().hide();

        //resgataIDViews();
       // inicializaEsculta();
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.botaoLogin: //modificar o Id do botão clicado

                break;
            case R.id.textolink: //modificar o Id do botão clicado

                break;
        }
    }

}
