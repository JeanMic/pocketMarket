package com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasExibicaoPesquisas.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.controle.controle;
import com.example.jean_.pocketmarket.modelo.casa;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioProdCasa;

import java.util.ArrayList;

/**
 * Created by jean_ on 27/11/2017.
 */

public class casaUsuarioAdaptador extends ArrayAdapter<casa> {
    private Context context;
    private ArrayList<casa> lista;

    public casaUsuarioAdaptador(Context context, ArrayList<?> lista) {
        super(context, 0, (ArrayList<casa>) lista);
        this.context = context;
        this.lista = (ArrayList<casa>) lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final casa itemPosicao = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.tela_exibicao_produto_casa_usuario, null);
        final View layout = convertView;

        TextView idvenda = (TextView) convertView.findViewById(R.id.listaidvendacasausuario);
        idvenda.setText("ID Venda: " + itemPosicao.getIdvenda());

        TextView titulo = (TextView) convertView.findViewById(R.id.listatitulocasausuario);
        titulo.setText("Titulo Venda: " + itemPosicao.getTituloProduto());

        TextView descricao = (TextView) convertView.findViewById(R.id.listadescricaocasausuario);
        descricao.setText("Descrição Venda: " + itemPosicao.getDescricaoProduto());

        TextView vendedor = (TextView) convertView.findViewById(R.id.listavendedorcasausuario);
        vendedor.setText("Documento Vendedor: " + itemPosicao.getCPFCNPJVendedor());

        TextView marca = (TextView) convertView.findViewById(R.id.listavendaoualuguelcasausuario);
        marca.setText("Venda Ou Aluguel: " + itemPosicao.getVendaOuAluguel());

        TextView modelo = (TextView) convertView.findViewById(R.id.listacepcasausuario);
        modelo.setText("CEP Imovel: " + itemPosicao.getCEPDoImovel());

        TextView preco = (TextView) convertView.findViewById(R.id.listaprecocasausuario);
        preco.setText("Preço Produto: " + Float.toString(itemPosicao.getPrecoProduto()));

        Button button = (Button) convertView.findViewById(R.id.editardadoscasausuario);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(context, formularioProdCasa.class);
            intent.putExtra("qtdquartos", Integer.toString(itemPosicao.getQtdQuartos()));
            intent.putExtra("qtdsuites", Integer.toString(itemPosicao.getQtdDeSuites()));
            intent.putExtra("valoriptu", Float.toString(itemPosicao.getValorIPTU()));
            intent.putExtra("valorcondominio", Float.toString(itemPosicao.getValorCondominio()));
            intent.putExtra("vagasgatagem", Integer.toString(itemPosicao.getVagasNaGaragem()));
            intent.putExtra("cepimovel", Integer.toString(itemPosicao.getCEPDoImovel()));
            intent.putExtra("areaconstruida", Integer.toString(itemPosicao.getAreaConstruida()));
            intent.putExtra("tituloProduto", itemPosicao.getTituloProduto());
            intent.putExtra("descricaoProduto", itemPosicao.getDescricaoProduto());
            intent.putExtra("precoProduto", Float.toString(itemPosicao.getPrecoProduto()));
            intent.putExtra("idVenda", itemPosicao.getIdvenda());
            context.startActivity(intent);
        });

        Button buttonDeletar = (Button) convertView.findViewById(R.id.apagarcasausuario);
        buttonDeletar.setOnClickListener(v -> {
            if (controle.deletaProdutos(itemPosicao.getCategoriaProduto(), itemPosicao.getCPFCNPJVendedor(), itemPosicao.getIdvenda()))
                layout.setVisibility(View.GONE);
            else
                Toast.makeText(context, "Ocorreu Um Erro no Servidor, Tente Novamente Mais Tarde", Toast.LENGTH_LONG).show();
        });
        return convertView;
    }
}