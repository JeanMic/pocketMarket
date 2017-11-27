package com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasNavegacao;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasExibicaoPesquisas.telasListViews.telaPesquisaProdutodesktopUsuarioListView;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasExibicaoPesquisas.telasListViews.telaPesquisaProdutonotebookUsuarioListView;

/**
 * Created by jean_ on 21/11/2017.
 */

public class telaPesquisaCategoriaComputadoresNotebookAnunciado extends AppCompatActivity implements View.OnClickListener {

    private ImageView ImgComputadoresNotebooksPesquisaDesktopAnunciado;
    private ImageView ImgComputadoresNotebooksPesquisaNotebookAnunciado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_pesquisa_produtos_computadores_notebooks_anunciado);

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
        ImgComputadoresNotebooksPesquisaDesktopAnunciado = (ImageView) findViewById(R.id.ImgComputadoresNotebooksPesquisaDesktopAnunciado);
        ImgComputadoresNotebooksPesquisaNotebookAnunciado = (ImageView) findViewById(R.id.ImgComputadoresNotebooksPesquisaNotebookAnunciado);
    }

    private void inicializaEsculta() {
        ImgComputadoresNotebooksPesquisaDesktopAnunciado.setOnClickListener(this);
        ImgComputadoresNotebooksPesquisaNotebookAnunciado.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.ImgComputadoresNotebooksPesquisaDesktopAnunciado:
                Intent pesquisadesk = new Intent(getApplicationContext(), telaPesquisaProdutodesktopUsuarioListView.class);
                startActivity(pesquisadesk);
                break;
            case R.id.ImgComputadoresNotebooksPesquisaNotebookAnunciado:
                Intent pesquisanote = new Intent(getApplicationContext(), telaPesquisaProdutonotebookUsuarioListView.class);
                startActivity(pesquisanote);
                break;

        }
    }
}
