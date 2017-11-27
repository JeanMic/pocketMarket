package com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasExibicaoPesquisas.telasListViews;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.controle.controle;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasExibicaoPesquisas.adaptadores.apartamentoUsuarioAdaptador;

/**
 * Created by jean_ on 27/11/2017.
 */

public class telaPesquisaProdutoapartamentoUsuarioListView extends ActionBarActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_pesquisa_apartamento_usuario_list_view);

        this.listView = (ListView) findViewById(R.id.listViewapartamentousuario);
        try {
            this.listView.setAdapter(new apartamentoUsuarioAdaptador(this, controle.getProdutos("Apartamento", "Usuario")));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}