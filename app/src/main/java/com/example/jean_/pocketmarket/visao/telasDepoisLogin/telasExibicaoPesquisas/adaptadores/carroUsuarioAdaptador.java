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
import com.example.jean_.pocketmarket.modelo.carro;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioProdCarro;
import java.util.ArrayList;

/**
 * Created by jean_ on 26/11/2017.
 */

public class carroUsuarioAdaptador extends ArrayAdapter<carro> {
    private Context context;
    private ArrayList<carro> lista;

    public carroUsuarioAdaptador(Context context, ArrayList<?> lista) {
        super(context, 0, (ArrayList<carro>) lista);
        this.context = context;
        this.lista = (ArrayList<carro>) lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final carro itemPosicao = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.tela_exibicao_produto_carro_usuario, null);
        final View layout = convertView;

        TextView idvenda = (TextView) convertView.findViewById(R.id.listaidvendacarrousuario);
        idvenda.setText("ID Venda: " + itemPosicao.getIdvenda());

        TextView titulo = (TextView) convertView.findViewById(R.id.listatitulocarrousuario);
        titulo.setText("Titulo Venda: " + itemPosicao.getTituloProduto());

        TextView descricao = (TextView) convertView.findViewById(R.id.listadescricaocarrousuario);
        descricao.setText("Descrição Venda: " + itemPosicao.getDescricaoProduto());

        TextView vendedor = (TextView) convertView.findViewById(R.id.listavendedorcarrousuario);
        vendedor.setText("Documento Vendedor: " + itemPosicao.getCPFCNPJVendedor());

        TextView marca = (TextView) convertView.findViewById(R.id.listamarcacarrousuario);
        marca.setText("Marca Carro: " + itemPosicao.getMarca());

        TextView modelo = (TextView) convertView.findViewById(R.id.listamodelocarrousuario);
        modelo.setText("Modelo Carro: " + itemPosicao.getModelo());

        TextView preco = (TextView) convertView.findViewById(R.id.listaprecocarrousuario);
        preco.setText("Preço Produto: " + Float.toString(itemPosicao.getPrecoProduto()));

        Button button = (Button)convertView.findViewById(R.id.editardadoscarrousuario);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(context,formularioProdCarro.class);
            intent.putExtra("qtdPortas",Integer.toString(itemPosicao.getQtdPortas()));
            intent.putExtra("cambio",itemPosicao.getCambio());
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

        Button buttonDeletar = (Button)convertView.findViewById(R.id.apagarcarrousuario);
        buttonDeletar.setOnClickListener(v -> {
            if (controle.deletaProdutos(itemPosicao.getCategoriaProduto(), itemPosicao.getCPFCNPJVendedor(), itemPosicao.getIdvenda()))
                layout.setVisibility(View.GONE);
            else
                Toast.makeText(context,"Ocorreu Um Erro no Servidor, Tente Novamente Mais Tarde",Toast.LENGTH_LONG).show();
        });
        return convertView;
    }
}
