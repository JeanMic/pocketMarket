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
import com.example.jean_.pocketmarket.modelo.apartamento;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioMensagem;

import java.util.ArrayList;

/**
 * Created by jean_ on 25/11/2017.
 */

public class apartamentoAdaptador extends ArrayAdapter<apartamento> {
    private Context context;
    private ArrayList<apartamento> lista;

    public apartamentoAdaptador(Context context, ArrayList<?> lista) {
        super(context, 0, (ArrayList<apartamento>) lista);
        this.context = context;
        this.lista = (ArrayList<apartamento>) lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final apartamento itemPosicao = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.tela_exibicao_produto_apartamento, null);

        TextView idvenda = (TextView) convertView.findViewById(R.id.listaidvendaapartamento);
        idvenda.setText("ID Venda: " + itemPosicao.getIdvenda());

        TextView titulo = (TextView) convertView.findViewById(R.id.listatituloapartamento);
        titulo.setText("Titulo Venda: " + itemPosicao.getTituloProduto());

        TextView descricao = (TextView) convertView.findViewById(R.id.listadescricaoapartamento);
        descricao.setText("Descrição Venda: " + itemPosicao.getDescricaoProduto());

        TextView vendedor = (TextView) convertView.findViewById(R.id.listavendedorapartamento);
        vendedor.setText("Documento Vendedor: " + itemPosicao.getCPFCNPJVendedor());

        TextView marca = (TextView) convertView.findViewById(R.id.listavendaoualuguelapartamento);
        marca.setText("Venda Ou Aluguel: " + itemPosicao.getVendaOuAluguel());

        TextView modelo = (TextView) convertView.findViewById(R.id.listacepapartamento);
        modelo.setText("CEP Imovel: " + itemPosicao.getCEPDoImovel());

        TextView preco = (TextView) convertView.findViewById(R.id.listaprecoapartamento);
        preco.setText("Preço Produto: " + Float.toString(itemPosicao.getPrecoProduto()));

        Button button = (Button)convertView.findViewById(R.id.mandarmsgvendedorapartamento);
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
