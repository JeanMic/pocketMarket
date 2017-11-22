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

public class telaPesquisaCategoriaVeiculoAnunciados extends AppCompatActivity implements View.OnClickListener {

    private ImageView ImgTelaVeiculosPesquisaCarroAnunciado;
    private ImageView ImgTelaVeiculosPesquisaMotoAnunciado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_pesquisa_produtos_veiculos_anunciados);

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
        ImgTelaVeiculosPesquisaCarroAnunciado = (ImageView) findViewById(R.id.ImgTelaVeiculosPesquisaCarroAnunciado);
        ImgTelaVeiculosPesquisaMotoAnunciado = (ImageView) findViewById(R.id.ImgTelaVeiculosPesquisaMotoAnunciado);
    }

    private void inicializaEsculta() {
        ImgTelaVeiculosPesquisaCarroAnunciado.setOnClickListener(this);
        ImgTelaVeiculosPesquisaMotoAnunciado.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.ImgTelaVeiculosPesquisaCarroAnunciado:
                //fazer
//                Intent CategoriasProdutos = new Intent(getApplicationContext(), telaCategoriasProdutos.class);
//                startActivity(CategoriasProdutos);
                break;
            case R.id.ImgTelaVeiculosPesquisaMotoAnunciado:
                //fazer
//                Intent CategoriasPesquisaProdutos = new Intent(getApplicationContext(), telaPesquisaCategoriasProduto.class);
//                startActivity(CategoriasPesquisaProdutos);
                break;

        }
    }
}
