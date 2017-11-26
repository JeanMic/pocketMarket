package com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasNavegacao;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasExibicaoPesquisas.telasListViews.telaPesquisaProdutodesktopListView;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasExibicaoPesquisas.telasListViews.telaPesquisaProdutonotebookListView;

/**
 * Created by jean_ on 21/11/2017.
 */

public class telaPesquisaCategoriaComputadoresNotebook extends AppCompatActivity implements View.OnClickListener {

    private ImageView ImgComputadoresNotebooksPesquisaDesktop;
    private ImageView ImgComputadoresNotebooksPesquisaNotebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_pesquisa_produtos_computadores_notebooks);

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
        ImgComputadoresNotebooksPesquisaDesktop = (ImageView) findViewById(R.id.ImgComputadoresNotebooksPesquisaDesktop);
        ImgComputadoresNotebooksPesquisaNotebook = (ImageView) findViewById(R.id.ImgComputadoresNotebooksPesquisaNotebook);
    }

    private void inicializaEsculta() {
        ImgComputadoresNotebooksPesquisaDesktop.setOnClickListener(this);
        ImgComputadoresNotebooksPesquisaNotebook.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.ImgComputadoresNotebooksPesquisaDesktop:
                Intent CategoriasProdutos = new Intent(getApplicationContext(), telaPesquisaProdutodesktopListView.class);
                startActivity(CategoriasProdutos);
                break;
            case R.id.ImgComputadoresNotebooksPesquisaNotebook:
                Intent notebook = new Intent(getApplicationContext(), telaPesquisaProdutonotebookListView.class);
                startActivity(notebook);
                break;

        }
    }
}
