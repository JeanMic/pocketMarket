package com.example.jean_.pocketmarket.visao.telasNavegacao;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.controle.controle;
import com.example.jean_.pocketmarket.visao.util.Mask;

/**
 * Created by jmtb on 13/11/2017.
 */

public class formularioProdCelulares extends AppCompatActivity implements View.OnClickListener {

    //a variável abaixo é populada no controle caso aconteça de um dado ser inválido
    private String msgCtrl;

    //variáveis de Ids e outras finalidades
    private AppCompatButton viewBtConfirm;

    //views comuns para todos os produtos
    private EditText viewtituloProduto;
    private EditText viewdescricaoProduto;
    private EditText viewprecoProduto;

    //views comuns para todos os produtos computadorescelularess
    private EditText viewSistema;
    private EditText viewVersaoSistema;
    private EditText viewtamanhoTela;
    private EditText viewMarca;
    private EditText viewModelo;
    private EditText viewArmazenamento;
    private RadioGroup viewUsado;
    private RadioGroup viewPussuiCarregador;
    private RadioGroup viewPussuiFoneOuvido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_prod_celular);

        //forçar conexao e operção na rede usando a tread da UI
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Metodo executado para esconder o actionBar
        getSupportActionBar().hide();

        //metodos dos items do formulário
        resgataIDViews();

        viewBtConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (controle.validaEntradasProdutoCelular(this)) {
            //Intent telaPrincipal = new Intent(getApplicationContext(), telaPrincipal.class);
            //startActivity(telaPrincipal);
            Toast.makeText(this, "cadastrou porra!!!!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, this.msgCtrl, Toast.LENGTH_LONG).show();
        }
    }

    private void resgataIDViews() {

        //IDs de views comuns para todos os produtos
        viewBtConfirm = (AppCompatButton) findViewById(R.id.confirmcadascelulares);
        viewtituloProduto = (EditText) findViewById(R.id.titulovendacelulares);
        viewdescricaoProduto = (EditText) findViewById(R.id.descricaovendacelulares);
        viewprecoProduto = (EditText) findViewById(R.id.precocelulares);

        //IDs de views comuns para todos os celulares
        viewMarca = (EditText) findViewById(R.id.marcacelulares);
        viewModelo = (EditText) findViewById(R.id.modelocelulares);
        viewArmazenamento = (EditText) findViewById(R.id.qtdgbshdcelulares);
        viewSistema = (EditText) findViewById(R.id.sistemacelulares);
        viewVersaoSistema = (EditText) findViewById(R.id.versaocelulares);
        viewtamanhoTela = (EditText) findViewById(R.id.tamanhotelacelular);
        viewUsado = (RadioGroup) findViewById(R.id.produtousadocelulares);
        viewPussuiCarregador = (RadioGroup) findViewById(R.id.possuiounaocarregadorcelulares);
        viewPussuiFoneOuvido = (RadioGroup) findViewById(R.id.possuiounaofoneouvidocelulares);

    }

    public EditText getViewtituloProduto() {
        return viewtituloProduto;
    }

    public EditText getViewdescricaoProduto() {
        return viewdescricaoProduto;
    }

    public EditText getViewprecoProduto() {
        return viewprecoProduto;
    }

    public EditText getViewMarca() {
        return viewMarca;
    }

    public EditText getViewModelo() {
        return viewModelo;
    }

    public EditText getViewArmazenamento() {
        return viewArmazenamento;
    }

    public EditText getViewSistema() {
        return viewSistema;
    }

    public EditText getViewVersaoSistema() {
        return viewVersaoSistema;
    }

    public RadioGroup getViewUsado() {
        return viewUsado;
    }

    public EditText getViewtamanhoTela() {
        return viewtamanhoTela;
    }

    public RadioGroup getViewPussuiCarregador() {
        return viewPussuiCarregador;
    }

    public RadioGroup getViewPussuiFoneOuvido() {
        return viewPussuiFoneOuvido;
    }

    public void setMsgCtrl(String msgCtrl) {
        this.msgCtrl = msgCtrl;
    }
}
