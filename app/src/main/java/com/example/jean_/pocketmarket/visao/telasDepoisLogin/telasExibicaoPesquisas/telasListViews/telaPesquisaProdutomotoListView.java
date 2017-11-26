package com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasExibicaoPesquisas.telasListViews;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.controle.controle;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasExibicaoPesquisas.adaptadores.motoAdaptador;

/**
 * Created by jean_ on 25/11/2017.
 */

public class telaPesquisaProdutomotoListView extends ActionBarActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_pesquisa_moto_list_view);

        this.listView = (ListView) findViewById(R.id.listViewmoto);
        try {
            this.listView.setAdapter(new motoAdaptador(this, controle.getProdutos("Moto")));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}