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

public class telaPesquisaCategoriaImoveis extends AppCompatActivity implements View.OnClickListener {

    private ImageView ImgTelaImoveisPesquisaCasa;
    private ImageView ImgTelaImoveisPesquisaApartamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_pesquisa_produtos_imoveis);

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
        ImgTelaImoveisPesquisaCasa = (ImageView) findViewById(R.id.ImgTelaImoveisPesquisaCasa);
        ImgTelaImoveisPesquisaApartamento = (ImageView) findViewById(R.id.ImgTelaImoveisPesquisaApartamento);
    }

    private void inicializaEsculta() {
        ImgTelaImoveisPesquisaCasa.setOnClickListener(this);
        ImgTelaImoveisPesquisaApartamento.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.ImgTelaImoveisPesquisaCasa:
                //fazer
//                Intent CategoriasProdutos = new Intent(getApplicationContext(), telaCategoriasProdutos.class);
//                startActivity(CategoriasProdutos);
                break;
            case R.id.ImgTelaImoveisPesquisaApartamento:
                //fazer
//                Intent CategoriasPesquisaProdutos = new Intent(getApplicationContext(), telaPesquisaCategoriasProduto.class);
//                startActivity(CategoriasPesquisaProdutos);
                break;

        }
    }
}
