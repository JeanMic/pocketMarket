package com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasNavegacao;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasExibicaoPesquisas.telasListViews.telaPesquisaMsgEnviadaListView;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasExibicaoPesquisas.telasListViews.telaPesquisaMsgRecebidaListView;

/**
 * Created by jean_ on 21/11/2017.
 */

public class telaUsuarioCategoriasMensagens extends AppCompatActivity implements View.OnClickListener {

    private ImageView ImgCoontaUsuarioMensagensRecebidas;
    private ImageView ImgCoontaUsuarioMensagensEnviadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_categorias_mensagens_usuarios);

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
        ImgCoontaUsuarioMensagensRecebidas = (ImageView) findViewById(R.id.ImgCoontaUsuarioMensagensRecebidas);
        ImgCoontaUsuarioMensagensEnviadas = (ImageView) findViewById(R.id.ImgCoontaUsuarioMensagensEnviadas);
    }

    private void inicializaEsculta() {
        ImgCoontaUsuarioMensagensRecebidas.setOnClickListener(this);
        ImgCoontaUsuarioMensagensEnviadas.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.ImgCoontaUsuarioMensagensRecebidas:
                //fazer
                Intent msgrecebida = new Intent(getApplicationContext(), telaPesquisaMsgRecebidaListView.class);
                startActivity(msgrecebida);
                break;
            case R.id.ImgCoontaUsuarioMensagensEnviadas:
                //fazer
                Intent msgenviada = new Intent(getApplicationContext(), telaPesquisaMsgEnviadaListView.class);
                startActivity(msgenviada);
                break;

        }
    }
}
