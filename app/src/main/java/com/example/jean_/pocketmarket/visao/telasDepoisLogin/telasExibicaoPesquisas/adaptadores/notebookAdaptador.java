package com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasExibicaoPesquisas.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.modelo.notebook;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioMensagem;

import java.util.ArrayList;

/**
 * Created by jean_ on 25/11/2017.
 */

public class notebookAdaptador  extends ArrayAdapter<notebook> {
    private Context context;
    private ArrayList<notebook> lista;

    public notebookAdaptador(Context context, ArrayList<?> lista) {
        super(context, 0, (ArrayList<notebook>) lista);
        this.context = context;
        this.lista = (ArrayList<notebook>) lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final notebook itemPosicao = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.tela_exibicao_produto_notebook, null);

        TextView idvenda = (TextView) convertView.findViewById(R.id.listaidvendanotebook);
        idvenda.setText("ID Venda: " + itemPosicao.getIdvenda());

        TextView titulo = (TextView) convertView.findViewById(R.id.listatitulonotebook);
        titulo.setText("Titulo Venda: " + itemPosicao.getTituloProduto());

        TextView descricao = (TextView) convertView.findViewById(R.id.listadescricaonotebook);
        descricao.setText("Descrição Venda: " + itemPosicao.getDescricaoProduto());

        TextView vendedor = (TextView) convertView.findViewById(R.id.listavendedornotebook);
        vendedor.setText("Documento Vendedor: " + itemPosicao.getCPFCNPJVendedor());

        TextView marca = (TextView) convertView.findViewById(R.id.listamarcanotebook);
        marca.setText("Marca Notebook: " + itemPosicao.getMarca());

        TextView modelo = (TextView) convertView.findViewById(R.id.listamodelonotebook);
        modelo.setText("Modelo Notebook: " + itemPosicao.getModelo());

        TextView preco = (TextView) convertView.findViewById(R.id.listapreconotebook);
        preco.setText("Preço Produto: " + Float.toString(itemPosicao.getPrecoProduto()));

        Button button = (Button)convertView.findViewById(R.id.mandarmsgvendedornotebook);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,formularioMensagem.class);
                intent.putExtra("destinatario",itemPosicao.getCPFCNPJVendedor());
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
