package com.example.jean_.pocketmarket.visao.telasDepoisLogin.telasExibicaoPesquisas.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.modelo.mensagem;

import java.util.ArrayList;

/**
 * Created by jean_ on 26/11/2017.
 */

public class msg_recebida_usuarioAdaptador  extends ArrayAdapter<mensagem> {
    private Context context;
    private ArrayList<mensagem> lista;

    public msg_recebida_usuarioAdaptador(Context context, ArrayList<?> lista) {
        super(context, 0, (ArrayList<mensagem>) lista);
        this.context = context;
        this.lista = (ArrayList<mensagem>) lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final mensagem itemPosicao = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.tela_exibicao_mensagenrecebida, null);

        TextView idvenda = (TextView) convertView.findViewById(R.id.listaidmensagen);
        idvenda.setText("ID MSG: " + itemPosicao.getIdmensagem());

        TextView titulo = (TextView) convertView.findViewById(R.id.listatitulomensagen);
        titulo.setText("Titulo Mensagem: " + itemPosicao.getTituloMensagem());

        TextView descricao = (TextView) convertView.findViewById(R.id.listadescricaomensagen);
        descricao.setText("Mensagem: " + itemPosicao.getMensagem());

        TextView dataenvio = (TextView) convertView.findViewById(R.id.listadataenvio);
        dataenvio.setText("Data de Envio: " + itemPosicao.getDatacadastroFormatada().format(itemPosicao.getDataEnvio()));

        TextView nomeremetente = (TextView) convertView.findViewById(R.id.listanomeremetente);
        nomeremetente.setText("Nome Remetente: " + itemPosicao.getNomeRazaoSocialRemetente());

        TextView docremetente = (TextView) convertView.findViewById(R.id.listadocumentoremetente);
        docremetente.setText("Documento Remetente: " + itemPosicao.getCPFCNPJRemetente());

//        Button button = (Button)convertView.findViewById(R.id.mandarmsgvendedormensagenrecebida);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context,formularioMensagem.class);
//                intent.putExtra("destinatario",itemPosicao.getCPFCNPJVendedor());
//                context.startActivity(intent);
//            }
//        });

        return convertView;
    }
}