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
import com.example.jean_.pocketmarket.modelo.motocicleta;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioProdMoto;
import java.util.ArrayList;

/**
 * Created by jean_ on 26/11/2017.
 */

public class motoUsuarioAdaptador extends ArrayAdapter<motocicleta> {
    private Context context;
    private ArrayList<motocicleta> lista;

    public motoUsuarioAdaptador(Context context, ArrayList<?> lista) {
        super(context, 0, (ArrayList<motocicleta>) lista);
        this.context = context;
        this.lista = (ArrayList<motocicleta>) lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final motocicleta itemPosicao = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.tela_exibicao_produto_moto_usuario, null);
        final View layout = convertView;

        TextView idvenda = (TextView) convertView.findViewById(R.id.listaidvendamotousuario);
        idvenda.setText("ID Venda: " + itemPosicao.getIdvenda());

        TextView titulo = (TextView) convertView.findViewById(R.id.listatitulomotousuario);
        titulo.setText("Titulo Venda: " + itemPosicao.getTituloProduto());

        TextView descricao = (TextView) convertView.findViewById(R.id.listadescricaomotousuario);
        descricao.setText("Descrição Venda: " + itemPosicao.getDescricaoProduto());

        TextView vendedor = (TextView) convertView.findViewById(R.id.listavendedormotousuario);
        vendedor.setText("Documento Vendedor: " + itemPosicao.getCPFCNPJVendedor());

        TextView marca = (TextView) convertView.findViewById(R.id.listamarcamotousuario);
        marca.setText("Marca Moto: " + itemPosicao.getMarca());

        TextView modelo = (TextView) convertView.findViewById(R.id.listamodelomotousuario);
        modelo.setText("Modelo Moto: " + itemPosicao.getModelo());

        TextView preco = (TextView) convertView.findViewById(R.id.listaprecomotousuario);
        preco.setText("Preço Produto: " + Float.toString(itemPosicao.getPrecoProduto()));

        Button button = (Button)convertView.findViewById(R.id.editardadosmotousuario);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(context,formularioProdMoto.class);
            intent.putExtra("cilindradas",Integer.toString(itemPosicao.getCilindradas()));
            intent.putExtra("marca",itemPosicao.getMarca());
            intent.putExtra("modelo",itemPosicao.getModelo());
            intent.putExtra("anoFabricacao",Integer.toString(itemPosicao.getAnoFabricação()));
            intent.putExtra("placa",itemPosicao.getPlaca());
            intent.putExtra("quilometragem",Integer.toString(itemPosicao.getQuilometragem()));
            intent.putExtra("cor",itemPosicao.getCor());
            intent.putExtra("tituloProduto",itemPosicao.getTituloProduto());
            intent.putExtra("descricaoProduto",itemPosicao.getDescricaoProduto());
            intent.putExtra("precoProduto", Float.toString(itemPosicao.getPrecoProduto()));
            intent.putExtra("idVenda",itemPosicao.getIdvenda());
            context.startActivity(intent);
        });

        Button buttonDeletar = (Button)convertView.findViewById(R.id.apagarmotousuario);
        buttonDeletar.setOnClickListener(v -> {
            if (controle.deletaProdutos(itemPosicao.getCategoriaProduto(), itemPosicao.getCPFCNPJVendedor(), itemPosicao.getIdvenda()))
                layout.setVisibility(View.GONE);
            else
                Toast.makeText(context,"Ocorreu Um Erro no Servidor, Tente Novamente Mais Tarde",Toast.LENGTH_LONG).show();
        });
        return convertView;
    }
}
