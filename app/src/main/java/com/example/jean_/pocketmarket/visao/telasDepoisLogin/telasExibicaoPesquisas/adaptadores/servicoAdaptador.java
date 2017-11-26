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
import com.example.jean_.pocketmarket.modelo.servico;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioMensagem;

import java.util.ArrayList;

/**
 * Created by jean_ on 26/11/2017.
 */

public class servicoAdaptador extends ArrayAdapter<servico> {
    private Context context;
    private ArrayList<servico> lista;

    public servicoAdaptador(Context context, ArrayList<?> lista) {
        super(context, 0, (ArrayList<servico>) lista);
        this.context = context;
        this.lista = (ArrayList<servico>) lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final servico itemPosicao = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.tela_exibicao_produto_servico, null);

        TextView idvenda = (TextView) convertView.findViewById(R.id.listaidvendaservico);
        idvenda.setText("ID Venda: " + itemPosicao.getIdservico());

        TextView titulo = (TextView) convertView.findViewById(R.id.listatituloservico);
        titulo.setText("Titulo Serviço: " + itemPosicao.getTituloServico());

        TextView descricao = (TextView) convertView.findViewById(R.id.listadescricaoservico);
        descricao.setText("Descrição Serviço: " + itemPosicao.getDescricaoServico());

        TextView vendedor = (TextView) convertView.findViewById(R.id.listavendedorservico);
        vendedor.setText("Documento Vendedor: " + itemPosicao.getCPFCNPJVendedor());

        TextView preco = (TextView) convertView.findViewById(R.id.listaprecoservico);
        preco.setText("Preço Produto: " + Float.toString(itemPosicao.getPrecoServico()));

        Button button = (Button)convertView.findViewById(R.id.mandarmsgvendedorservico);
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