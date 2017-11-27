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
import com.example.jean_.pocketmarket.controle.controle;
import com.example.jean_.pocketmarket.modelo.servico;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioProdServico;

import java.util.ArrayList;

/**
 * Created by jean_ on 27/11/2017.
 */

public class servicoUsuarioAdaptador  extends ArrayAdapter<servico> {
    private Context context;
    private ArrayList<servico> lista;

    public servicoUsuarioAdaptador(Context context, ArrayList<?> lista) {
        super(context, 0, (ArrayList<servico>) lista);
        this.context = context;
        this.lista = (ArrayList<servico>) lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final servico itemPosicao = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.tela_exibicao_produto_servico_usuario, null);
        final View layout = convertView;

        TextView idvenda = (TextView) convertView.findViewById(R.id.listaidvendaservicousuario);
        idvenda.setText("ID Venda: " + itemPosicao.getIdservico());

        TextView titulo = (TextView) convertView.findViewById(R.id.listatituloservicousuario);
        titulo.setText("Titulo Serviço: " + itemPosicao.getTituloServico());

        TextView descricao = (TextView) convertView.findViewById(R.id.listadescricaoservicousuario);
        descricao.setText("Descrição Serviço: " + itemPosicao.getDescricaoServico());

        TextView vendedor = (TextView) convertView.findViewById(R.id.listavendedorservicousuario);
        vendedor.setText("Documento Vendedor: " + itemPosicao.getCPFCNPJVendedor());

        TextView preco = (TextView) convertView.findViewById(R.id.listaprecoservicousuario);
        preco.setText("Preço Serviço: " + Float.toString(itemPosicao.getPrecoServico()));

        Button button = (Button) convertView.findViewById(R.id.editardadosservicousuario);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(context, formularioProdServico.class);
            intent.putExtra("tituloProduto", itemPosicao.getTituloServico());
            intent.putExtra("descricaoProduto", itemPosicao.getDescricaoServico());
            intent.putExtra("precoProduto", Float.toString(itemPosicao.getPrecoServico()));
            intent.putExtra("idVenda", itemPosicao.getIdservico());
            context.startActivity(intent);
        });

        Button buttonDeletar = (Button) convertView.findViewById(R.id.apagarservicousuario);
        buttonDeletar.setOnClickListener(v -> {
            if (controle.deletaProdutos("Servico", itemPosicao.getCPFCNPJVendedor(), itemPosicao.getIdservico()))
                layout.setVisibility(View.GONE);
            else
                Toast.makeText(context, "Ocorreu Um Erro no Servidor, Tente Novamente Mais Tarde", Toast.LENGTH_LONG).show();
        });
        return convertView;
    }
}