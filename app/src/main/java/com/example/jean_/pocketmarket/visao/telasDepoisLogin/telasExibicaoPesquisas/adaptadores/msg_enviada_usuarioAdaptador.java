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

public class msg_enviada_usuarioAdaptador  extends ArrayAdapter<mensagem> {
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

//        Button button = (Button)convertView.findViewById(R.id.mandarmsgvendedormensagenenviada);
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