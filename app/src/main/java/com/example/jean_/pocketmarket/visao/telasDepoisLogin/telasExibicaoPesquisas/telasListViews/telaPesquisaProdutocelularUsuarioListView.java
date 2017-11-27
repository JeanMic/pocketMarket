package com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasExibicaoPesquisas.telasListViews;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.controle.controle;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasExibicaoPesquisas.adaptadores.celularUsuarioAdaptador;

/**
 * Created by jean_ on 27/11/2017.
 */

public class telaPesquisaProdutocelularUsuarioListView  extends ActionBarActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_pesquisa_celular_usuario_list_view);

        this.listView = (ListView) findViewById(R.id.listViewcelularusuario);
        try {
            this.listView.setAdapter(new celularUsuarioAdaptador(this, controle.getProdutos("Celular", "Usuario")));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}