package com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasNavegacao;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioProdDesktop;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioProdNotebook;

/**
 * Created by jean_ on 20/11/2017.
 */

public class telaComputadoresNotebooks extends AppCompatActivity implements View.OnClickListener {

    private ImageView ImgComputadoresNotebooksDesktop;
    private ImageView ImgComputadoresNotebooksNotebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_computadores_notebooks);

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

        ImgComputadoresNotebooksDesktop = (ImageView) findViewById(R.id.ImgComputadoresNotebooksDesktop);
        ImgComputadoresNotebooksNotebook = (ImageView) findViewById(R.id.ImgComputadoresNotebooksNotebook);
    }

    private void inicializaEsculta() {
        ImgComputadoresNotebooksDesktop.setOnClickListener(this);
        ImgComputadoresNotebooksNotebook.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.ImgComputadoresNotebooksDesktop:
                Intent carro = new Intent(getApplicationContext(), formularioProdDesktop.class);
                startActivity(carro);
                break;
            case R.id.ImgComputadoresNotebooksNotebook:
                Intent moto = new Intent(getApplicationContext(), formularioProdNotebook.class);
                startActivity(moto);
                break;
        }
    }
}