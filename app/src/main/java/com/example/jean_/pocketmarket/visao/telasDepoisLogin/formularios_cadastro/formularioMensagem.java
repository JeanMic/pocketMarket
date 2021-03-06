package com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.controle.controle;

/**
 * Created by jmtb on 13/11/2017.
 */

public class formularioMensagem extends AppCompatActivity implements View.OnClickListener {

    //a variável abaixo é populada no controle caso aconteça de um dado ser inválido
    private String msgCtrl;

    //variáveis de Ids e outras finalidades
    private AppCompatButton viewBtConfirm;

    private String idmensagem = "";

    //views comuns para todos os servicos
    private EditText viewtitulomsg;
    private EditText viewdescricaomsg;
    private String destinatario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_mensagem);

        //forçar conexao e operção na rede usando a tread da UI
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Metodo executado para esconder o actionBar
        getSupportActionBar().hide();

        //metodos dos items do formulário
        resgataIDViews();

        //pega o cpf repassado na itent anterior
        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                setDestinatario(bundle.getString("destinatario"));
                this.idmensagem = (bundle.getString("idMsg"));
            }
        }

        viewBtConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (controle.validaEntradasMensagem(this, idmensagem)) {
            if (idmensagem == null) {
                Toast.makeText(this, "Mensagem Enviada", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Mensagem Editada", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, this.msgCtrl, Toast.LENGTH_LONG).show();
        }
    }

    private void resgataIDViews() {

        //IDs de views comuns para todos os produtos
        viewBtConfirm = (AppCompatButton) findViewById(R.id.confirmcadasmsg);
        viewtitulomsg = (EditText) findViewById(R.id.titulomsg);
        viewdescricaomsg = (EditText) findViewById(R.id.descricaomsg);
    }

    public EditText getViewtituloProduto() {
        return viewtitulomsg;
    }

    public EditText getViewdescricaoProduto() {
        return viewdescricaomsg;
    }

    public void setMsgCtrl(String msgCtrl) {
        this.msgCtrl = msgCtrl;
    }

    public String getViewdestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getDestinatario() {
        return destinatario;
    }


    public String getIdmensagem() {
        return idmensagem;
    }

    public void setIdmensagem(String idmensagem) {
        this.idmensagem = idmensagem;
    }

}
