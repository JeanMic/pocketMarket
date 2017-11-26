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
import com.example.jean_.pocketmarket.modelo.casa;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioMensagem;

import java.util.ArrayList;

/**
 * Created by jean_ on 25/11/2017.
 */

public class casaAdaptador extends ArrayAdapter<casa> {
    private Context context;
    private ArrayList<casa> lista;

    public casaAdaptador(Context context, ArrayList<?> lista) {
        super(context, 0, (ArrayList<casa>) lista);
        this.context = context;
        this.lista = (ArrayList<casa>) lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final casa itemPosicao = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.tela_exibicao_produto_casa, null);

        TextView idvenda = (TextView) convertView.findViewById(R.id.listaidvendacasa);
        idvenda.setText("ID Venda: " + itemPosicao.getIdvenda());

        TextView titulo = (TextView) convertView.findViewById(R.id.listatitulocasa);
        titulo.setText("Titulo Venda: " + itemPosicao.getTituloProduto());

        TextView descricao = (TextView) convertView.findViewById(R.id.listadescricaocasa);
        descricao.setText("Descrição Venda: " + itemPosicao.getDescricaoProduto());

        TextView vendedor = (TextView) convertView.findViewById(R.id.listavendedorcasa);
        vendedor.setText("Documento Vendedor: " + itemPosicao.getCPFCNPJVendedor());

        TextView marca = (TextView) convertView.findViewById(R.id.listavendaoualuguelcasa);
        marca.setText("Venda Ou Aluguel: " + itemPosicao.getVendaOuAluguel());

        TextView modelo = (TextView) convertView.findViewById(R.id.listacepcasa);
        modelo.setText("CEP Imovel: " + itemPosicao.getCEPDoImovel());

        TextView preco = (TextView) convertView.findViewById(R.id.listaprecocasa);
        preco.setText("Preço Produto: " + Float.toString(itemPosicao.getPrecoProduto()));

        Button button = (Button)convertView.findViewById(R.id.mandarmsgvendedorcasa);
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

