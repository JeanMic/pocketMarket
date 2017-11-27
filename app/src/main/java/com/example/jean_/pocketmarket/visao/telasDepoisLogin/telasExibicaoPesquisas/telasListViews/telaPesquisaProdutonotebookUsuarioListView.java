package com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasExibicaoPesquisas.telasListViews;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.controle.controle;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasExibicaoPesquisas.adaptadores.casaUsuarioAdaptador;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasExibicaoPesquisas.adaptadores.notebookUsuarioAdaptador;

/**
 * Created by jean_ on 27/11/2017.
 */

public class telaPesquisaProdutonotebookUsuarioListView extends ActionBarActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_pesquisa_notebook_usuario_list_view);

        this.listView = (ListView) findViewById(R.id.listViewnotebookusuario);
        try {
            this.listView.setAdapter(new notebookUsuarioAdaptador(this, controle.getProdutos("Notebook", "Usuario")));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}