package com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasNavegacao;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.jean_.pocketmarket.R;

/**
 * Created by jean_ on 21/11/2017.
 */

public class telaPesquisaCategoriaImoveisAnunciados extends AppCompatActivity implements View.OnClickListener {

    private ImageView ImgTelaImoveisPesquisaCasaAnunciada;
    private ImageView ImgTelaImoveisPesquisaApartamentoAnunciada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_pesquisa_produtos_imoveis_anunciados);

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
        ImgTelaImoveisPesquisaCasaAnunciada = (ImageView) findViewById(R.id.ImgTelaImoveisPesquisaCasaAnunciada);
        ImgTelaImoveisPesquisaApartamentoAnunciada = (ImageView) findViewById(R.id.ImgTelaImoveisPesquisaApartamentoAnunciada);
    }

    private void inicializaEsculta() {
        ImgTelaImoveisPesquisaCasaAnunciada.setOnClickListener(this);
        ImgTelaImoveisPesquisaApartamentoAnunciada.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.ImgTelaImoveisPesquisaCasaAnunciada:
                //fazer
//                Intent CategoriasProdutos = new Intent(getApplicationContext(), telaCategoriasProdutos.class);
//                startActivity(CategoriasProdutos);
                break;
            case R.id.ImgTelaImoveisPesquisaApartamentoAnunciada:
                //fazer
//                Intent CategoriasPesquisaProdutos = new Intent(getApplicationContext(), telaPesquisaCategoriasProduto.class);
//                startActivity(CategoriasPesquisaProdutos);
                break;
        }
    }
}
