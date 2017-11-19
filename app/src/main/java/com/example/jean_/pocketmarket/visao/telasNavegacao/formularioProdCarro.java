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

/**
 * Created by jmtb on 13/11/2017.
 */

public class formularioProdCarro extends AppCompatActivity implements View.OnClickListener {

    //a variável abaixo é populada no controle caso aconteça de um dado ser inválido
    private String msgCtrl;

    //variáveis de Ids e outras finalidades
    private AppCompatButton viewBtConfirm;

    //views comuns para todos os produtos
    private EditText viewtituloProduto;
    private EditText viewdescricaoProduto;
    private EditText viewprecoProduto;

    //views comuns para todos os produtos veiculos
    private EditText viewMarca;
    private EditText viewModelo;
    private EditText viewanoFabricacao;
    private EditText viewPlaca;
    private EditText viewQuilometragem;
    private EditText viewCor;
    private RadioGroup viewCombustivel;
    private RadioGroup viewRadiopossuiMultas;

    //views view do produto moto
    private EditText viewQtsPortas;
    private EditText viewCambio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_prod_carro);

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

        if (controle.validaEntradasProdutoCarro(this)) {
            //Intent telaPrincipal = new Intent(getApplicationContext(), telaPrincipal.class);
            //startActivity(telaPrincipal);
            Toast.makeText(this, "cadastrou porra!!!!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, this.msgCtrl, Toast.LENGTH_LONG).show();
        }
    }

    private void resgataIDViews() {

        //IDs de views comuns para todos os produtos
        viewBtConfirm = (AppCompatButton) findViewById(R.id.confirmcadascarro);
        viewtituloProduto = (EditText) findViewById(R.id.titulovendacarro);
        viewdescricaoProduto = (EditText) findViewById(R.id.descricaovendacarro);
        viewprecoProduto = (EditText) findViewById(R.id.precocarro);

        //IDs de views comuns para todos os veiculos
        viewMarca = (EditText) findViewById(R.id.marcacarro);
        viewModelo = (EditText) findViewById(R.id.modelocarro);
        viewanoFabricacao = (EditText) findViewById(R.id.anofabricacaocarro);
        viewPlaca = (EditText) findViewById(R.id.placacarro);
        viewQuilometragem = (EditText) findViewById(R.id.quilometragemcarro);
        viewCor = (EditText) findViewById(R.id.corcarro);
        viewCombustivel = (RadioGroup) findViewById(R.id.combustivelcarro);
        viewRadiopossuiMultas = (RadioGroup) findViewById(R.id.possuimultascarro);

        //IDs views produto Carro
        viewQtsPortas = (EditText) findViewById(R.id.qtdportascarro);
        viewCambio = (EditText) findViewById(R.id.cambiocarro);

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

    public EditText getViewanoFabricacao() {
        return viewanoFabricacao;
    }

    public EditText getViewPlaca() {
        return viewPlaca;
    }

    public EditText getViewQuilometragem() {
        return viewQuilometragem;
    }

    public EditText getViewCor() {
        return viewCor;
    }

    public RadioGroup getViewCombustivel() {
        return viewCombustivel;
    }

    public RadioGroup getViewRadiopossuiMultas() {
        return viewRadiopossuiMultas;
    }

    public EditText getViewQtsPortas() {
        return viewQtsPortas;
    }

    public EditText getViewCambio() {
        return viewCambio;
    }

    public void setMsgCtrl(String msgCtrl) {
        this.msgCtrl = msgCtrl;
    }
}
