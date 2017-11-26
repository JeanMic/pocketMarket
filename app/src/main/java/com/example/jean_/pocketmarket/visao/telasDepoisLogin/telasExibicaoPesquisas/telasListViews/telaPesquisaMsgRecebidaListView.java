package com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasExibicaoPesquisas.telasListViews;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.controle.controle;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasExibicaoPesquisas.adaptadores.msg_recebida_usuarioAdaptador;

/**
 * Created by jean_ on 26/11/2017.
 */

public class telaPesquisaMsgRecebidaListView  extends ActionBarActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_pesquisa_msg_recebida_usuario_list_view);

        this.listView = (ListView) findViewById(R.id.listViewmsgrecebida);
        try {
            this.listView.setAdapter(new msg_recebida_usuarioAdaptador(this, controle.getProdutos("Msg", "MsgRecebida")));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}