package com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasExibicaoPesquisas.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.modelo.carro;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioMensagem;

import java.util.ArrayList;

/**
 * Created by jean_ on 25/11/2017.
 */

public class carroAdaptador extends ArrayAdapter<carro> {
    private Context context;
    private ArrayList<carro> lista;

    public carroAdaptador(Context context, ArrayList<?> lista) {
        super(context, 0, (ArrayList<carro>) lista);
        this.context = context;
        this.lista = (ArrayList<carro>) lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final carro itemPosicao = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.tela_exibicao_produto_carro, null);

        TextView idvenda = (TextView) convertView.findViewById(R.id.listaidvendacarro);
        idvenda.setText("ID Venda: " + itemPosicao.getIdvenda());

        TextView titulo = (TextView) convertView.findViewById(R.id.listatitulocarro);
        titulo.setText("Titulo Venda: " + itemPosicao.getTituloProduto());

        TextView descricao = (TextView) convertView.findViewById(R.id.listadescricaocarro);
        descricao.setText("Descrição Venda: " + itemPosicao.getDescricaoProduto());

        TextView vendedor = (TextView) convertView.findViewById(R.id.listavendedorcarro);
        vendedor.setText("Documento Vendedor: " + itemPosicao.getCPFCNPJVendedor());

        TextView marca = (TextView) convertView.findViewById(R.id.listamarcacarro);
        marca.setText("Marca Carro: " + itemPosicao.getMarca());

        TextView modelo = (TextView) convertView.findViewById(R.id.listamodelocarro);
        modelo.setText("Modelo Carro: " + itemPosicao.getModelo());

        TextView preco = (TextView) convertView.findViewById(R.id.listaprecocarro);
        preco.setText("Preço Produto: " + Float.toString(itemPosicao.getPrecoProduto()));

        Button button = (Button)convertView.findViewById(R.id.mandarmsgvendedorcarro);
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
