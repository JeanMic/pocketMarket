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
import com.example.jean_.pocketmarket.modelo.apartamento;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioProdapartamento;

import java.util.ArrayList;

/**
 * Created by jean_ on 27/11/2017.
 */

public class apartamentoUsuarioAdaptador  extends ArrayAdapter<apartamento> {
    private Context context;
    private ArrayList<apartamento> lista;

    public apartamentoUsuarioAdaptador(Context context, ArrayList<?> lista) {
        super(context, 0, (ArrayList<apartamento>) lista);
        this.context = context;
        this.lista = (ArrayList<apartamento>) lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final apartamento itemPosicao = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.tela_exibicao_produto_apartamento_usuario, null);
        final View layout = convertView;

        TextView idvenda = (TextView) convertView.findViewById(R.id.listaidvendaapartamentousuario);
        idvenda.setText("ID Venda: " + itemPosicao.getIdvenda());

        TextView titulo = (TextView) convertView.findViewById(R.id.listatituloapartamentousuario);
        titulo.setText("Titulo Venda: " + itemPosicao.getTituloProduto());

        TextView descricao = (TextView) convertView.findViewById(R.id.listadescricaoapartamentousuario);
        descricao.setText("Descrição Venda: " + itemPosicao.getDescricaoProduto());

        TextView vendedor = (TextView) convertView.findViewById(R.id.listavendedorapartamentousuario);
        vendedor.setText("Documento Vendedor: " + itemPosicao.getCPFCNPJVendedor());

        TextView marca = (TextView) convertView.findViewById(R.id.listavendaoualuguelapartamentousuario);
        marca.setText("Venda Ou Aluguel: " + itemPosicao.getVendaOuAluguel());

        TextView modelo = (TextView) convertView.findViewById(R.id.listacepapartamentousuario);
        modelo.setText("CEP Imovel: " + itemPosicao.getCEPDoImovel());

        TextView preco = (TextView) convertView.findViewById(R.id.listaprecoapartamentousuario);
        preco.setText("Preço Produto: " + Float.toString(itemPosicao.getPrecoProduto()));

        Button button = (Button) convertView.findViewById(R.id.editardadosapartamentousuario);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(context, formularioProdapartamento.class);
            intent.putExtra("qtdquartos", Integer.toString(itemPosicao.getQtdQuartos()));
            intent.putExtra("qtdsuites", Integer.toString(itemPosicao.getQtdDeSuites()));
            intent.putExtra("valoriptu", Float.toString(itemPosicao.getValorIPTU()));
            intent.putExtra("valorcondominio", Float.toString(itemPosicao.getValorCondominio()));
            intent.putExtra("vagasgatagem", Integer.toString(itemPosicao.getVagasNaGaragem()));
            intent.putExtra("cepimovel", Integer.toString(itemPosicao.getCEPDoImovel()));
            intent.putExtra("areautil", Integer.toString(itemPosicao.getAreaUtil()));
            intent.putExtra("tituloProduto", itemPosicao.getTituloProduto());
            intent.putExtra("descricaoProduto", itemPosicao.getDescricaoProduto());
            intent.putExtra("precoProduto", Float.toString(itemPosicao.getPrecoProduto()));
            intent.putExtra("idVenda", itemPosicao.getIdvenda());
            context.startActivity(intent);
        });

        Button buttonDeletar = (Button) convertView.findViewById(R.id.apagarapartamentousuario);
        buttonDeletar.setOnClickListener(v -> {
            if (controle.deletaProdutos(itemPosicao.getCategoriaProduto(), itemPosicao.getCPFCNPJVendedor(), itemPosicao.getIdvenda()))
                layout.setVisibility(View.GONE);
            else
                Toast.makeText(context, "Ocorreu Um Erro no Servidor, Tente Novamente Mais Tarde", Toast.LENGTH_LONG).show();
        });
        return convertView;
    }
}