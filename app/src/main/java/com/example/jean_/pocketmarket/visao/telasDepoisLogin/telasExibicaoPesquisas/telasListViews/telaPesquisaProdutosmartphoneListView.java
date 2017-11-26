package com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasExibicaoPesquisas.telasListViews;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.controle.controle;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasExibicaoPesquisas.adaptadores.smatphoneAdaptador;

/**
 * Created by jean_ on 25/11/2017.
 */

public class telaPesquisaProdutosmartphoneListView  extends ActionBarActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_pesquisa_smatphone_list_view);

        this.listView = (ListView) findViewById(R.id.listViewsmartphone);
        try {
            this.listView.setAdapter(new smatphoneAdaptador(this, controle.getProdutos("Celular", "")));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}