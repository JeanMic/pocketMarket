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
import com.example.jean_.pocketmarket.modelo.desktop;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioProdDesktop;

import java.util.ArrayList;

/**
 * Created by jean_ on 27/11/2017.
 */

public class desktopUsuarioAdaptador  extends ArrayAdapter<desktop> {
    private Context context;
    private ArrayList<desktop> lista;

    public desktopUsuarioAdaptador(Context context, ArrayList<?> lista) {
        super(context, 0, (ArrayList<desktop>) lista);
        this.context = context;
        this.lista = (ArrayList<desktop>) lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final desktop itemPosicao = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.tela_exibicao_produto_desktop_usuario, null);
        final View layout = convertView;

        TextView idvenda = (TextView) convertView.findViewById(R.id.listaidvendadesktopusuario);
        idvenda.setText("ID Venda: " + itemPosicao.getIdvenda());

        TextView titulo = (TextView) convertView.findViewById(R.id.listatitulodesktopusuario);
        titulo.setText("Titulo Venda: " + itemPosicao.getTituloProduto());

        TextView descricao = (TextView) convertView.findViewById(R.id.listadescricaodesktopusuario);
        descricao.setText("Descrição Venda: " + itemPosicao.getDescricaoProduto());

        TextView vendedor = (TextView) convertView.findViewById(R.id.listavendedordesktopusuario);
        vendedor.setText("Documento Vendedor: " + itemPosicao.getCPFCNPJVendedor());

        TextView marca = (TextView) convertView.findViewById(R.id.listamarcadesktopusuario);
        marca.setText("Marca: " + itemPosicao.getMarca());

        TextView modelo = (TextView) convertView.findViewById(R.id.listamodelodesktopusuario);
        modelo.setText("Modelo: " + itemPosicao.getModelo());

        TextView preco = (TextView) convertView.findViewById(R.id.listaprecodesktopusuario);
        preco.setText("Preço Produto: " + Float.toString(itemPosicao.getPrecoProduto()));

        Button button = (Button) convertView.findViewById(R.id.editardadosdesktopusuario);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(context, formularioProdDesktop.class);
            intent.putExtra("marca", itemPosicao.getMarca());
            intent.putExtra("modelo", itemPosicao.getModelo());
            intent.putExtra("ram", Integer.toString(itemPosicao.getRAM()));
            intent.putExtra("marcaprocessador", itemPosicao.getMarcaProcessador());
            intent.putExtra("modeloprocessador", itemPosicao.getModeloProcessador());
            intent.putExtra("armazenamento", Integer.toString(itemPosicao.getArmazenamento()));
            intent.putExtra("sistema", itemPosicao.getSistema());
            intent.putExtra("sistemaversao", itemPosicao.getVersaoSistema());
            intent.putExtra("tituloProduto", itemPosicao.getTituloProduto());
            intent.putExtra("descricaoProduto", itemPosicao.getDescricaoProduto());
            intent.putExtra("precoProduto", Float.toString(itemPosicao.getPrecoProduto()));
            intent.putExtra("idVenda", itemPosicao.getIdvenda());
            context.startActivity(intent);
        });

        Button buttonDeletar = (Button) convertView.findViewById(R.id.apagardesktopusuario);
        buttonDeletar.setOnClickListener(v -> {
            if (controle.deletaProdutos(itemPosicao.getCategoriaProduto(), itemPosicao.getCPFCNPJVendedor(), itemPosicao.getIdvenda()))
                layout.setVisibility(View.GONE);
            else
                Toast.makeText(context, "Ocorreu Um Erro no Servidor, Tente Novamente Mais Tarde", Toast.LENGTH_LONG).show();
        });
        return convertView;
    }
}
