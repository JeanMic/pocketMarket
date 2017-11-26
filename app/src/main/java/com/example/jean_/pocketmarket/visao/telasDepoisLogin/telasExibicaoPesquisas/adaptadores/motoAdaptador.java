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
import com.example.jean_.pocketmarket.modelo.motocicleta;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioMensagem;

import java.util.ArrayList;

/**
 * Created by jean_ on 25/11/2017.
 */

public class motoAdaptador extends ArrayAdapter<motocicleta> {
    private Context context;
    private ArrayList<motocicleta> lista;

    public motoAdaptador(Context context, ArrayList<?> lista) {
        super(context, 0, (ArrayList<motocicleta>) lista);
        this.context = context;
        this.lista = (ArrayList<motocicleta>) lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final motocicleta itemPosicao = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.tela_exibicao_produto_moto, null);

        TextView idvenda = (TextView) convertView.findViewById(R.id.listaidvendamoto);
        idvenda.setText("ID Venda: " + itemPosicao.getIdvenda());

        TextView titulo = (TextView) convertView.findViewById(R.id.listatitulomoto);
        titulo.setText("Titulo Venda: " + itemPosicao.getTituloProduto());

        TextView descricao = (TextView) convertView.findViewById(R.id.listadescricaomoto);
        descricao.setText("Descrição Venda: " + itemPosicao.getDescricaoProduto());

        TextView vendedor = (TextView) convertView.findViewById(R.id.listavendedormoto);
        vendedor.setText("Documento Vendedor: " + itemPosicao.getCPFCNPJVendedor());

        TextView marca = (TextView) convertView.findViewById(R.id.listamarcamoto);
        marca.setText("Marca moto: " + itemPosicao.getMarca());

        TextView modelo = (TextView) convertView.findViewById(R.id.listamodelomoto);
        modelo.setText("Modelo moto: " + itemPosicao.getModelo());

        TextView preco = (TextView) convertView.findViewById(R.id.listaprecomoto);
        preco.setText("Preço Produto: " + Float.toString(itemPosicao.getPrecoProduto()));

        Button button = (Button)convertView.findViewById(R.id.mandarmsgvendedormoto);
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
