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
import com.example.jean_.pocketmarket.modelo.mensagem;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioMensagem;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro.formularioProdServico;

import java.util.ArrayList;

/**
 * Created by jean_ on 26/11/2017.
 */

public class msg_enviada_usuarioAdaptador extends ArrayAdapter<mensagem> {
    private Context context;
    private ArrayList<mensagem> lista;

    public msg_enviada_usuarioAdaptador(Context context, ArrayList<?> lista) {
        super(context, 0, (ArrayList<mensagem>) lista);
        this.context = context;
        this.lista = (ArrayList<mensagem>) lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final mensagem itemPosicao = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.tela_exibicao_mensagenenviada, null);
        final View layout = convertView;

        TextView idvenda = (TextView) convertView.findViewById(R.id.listaidmensagenenviada);
        idvenda.setText("ID MSG: " + itemPosicao.getIdmensagem());

        TextView titulo = (TextView) convertView.findViewById(R.id.listatitulomensagenenviada);
        titulo.setText("Titulo Mensagem: " + itemPosicao.getTituloMensagem());

        TextView descricao = (TextView) convertView.findViewById(R.id.listadescricaomensagenenviada);
        descricao.setText("Mensagem: " + itemPosicao.getMensagem());

        TextView dataenvio = (TextView) convertView.findViewById(R.id.listadataenviomsgenviada);
        dataenvio.setText("Data de Envio: " + itemPosicao.getDatacadastroFormatada().format(itemPosicao.getDataEnvio()));

        TextView docremetente = (TextView) convertView.findViewById(R.id.listadocumentodestinatario);
        docremetente.setText("Remetente: " + itemPosicao.getCPFCNPJRemetente());

        Button button = (Button) convertView.findViewById(R.id.editardadosmsgenviadausuario);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(context, formularioMensagem.class);
            intent.putExtra("tituloProduto", itemPosicao.getTituloMensagem());
            intent.putExtra("descricaoProduto", itemPosicao.getMensagem());
            intent.putExtra("destinatario", itemPosicao.getCPFCNPJdestinatario());
            intent.putExtra("idMsg", itemPosicao.getIdmensagem());
            context.startActivity(intent);
        });

        Button buttonDeletar = (Button) convertView.findViewById(R.id.apagarmsgenviadausuario);
        buttonDeletar.setOnClickListener(v -> {
            if (controle.deletaProdutos("Msg", itemPosicao.getCPFCNPJRemetente(), itemPosicao.getIdmensagem()))
                layout.setVisibility(View.GONE);
            else
                Toast.makeText(context, "Ocorreu Um Erro no Servidor, Tente Novamente Mais Tarde", Toast.LENGTH_LONG).show();
        });
        return convertView;
    }
}