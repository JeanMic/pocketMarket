package com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro;

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

public class formularioProdMoto extends AppCompatActivity implements View.OnClickListener {

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
    private EditText viewCilindradas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_prod_moto);

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

        if (controle.validaEntradasProdutoMoto(this)) {
            //Intent telaPrincipal = new Intent(getApplicationContext(), telaPrincipal.class);
            //startActivity(telaPrincipal);
            Toast.makeText(this, "cadastrou porra!!!!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, this.msgCtrl, Toast.LENGTH_LONG).show();
        }
    }

    private void resgataIDViews() {

        //IDs de views comuns para todos os produtos
        viewBtConfirm = (AppCompatButton) findViewById(R.id.confirmcadasmoto);
        viewtituloProduto = (EditText) findViewById(R.id.titulovendamoto);
        viewdescricaoProduto = (EditText) findViewById(R.id.descricaovendamoto);
        viewprecoProduto = (EditText) findViewById(R.id.precomoto);

        //IDs de views comuns para todos os veiculos
        viewMarca = (EditText) findViewById(R.id.marcamoto);
        viewModelo = (EditText) findViewById(R.id.modelomoto);
        viewanoFabricacao = (EditText) findViewById(R.id.anofabricacaomoto);
        viewPlaca = (EditText) findViewById(R.id.placamoto);
        viewQuilometragem = (EditText) findViewById(R.id.quilometragemmoto);
        viewCor = (EditText) findViewById(R.id.cormoto);
        viewCombustivel = (RadioGroup) findViewById(R.id.combustivelmoto);
        viewRadiopossuiMultas = (RadioGroup) findViewById(R.id.possuimultasmoto);

        //IDs views produto moto
        viewCilindradas = (EditText) findViewById(R.id.cilindradasmoto);

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

    public EditText getViewCilindradas() {
        return viewCilindradas;
    }

    public void setMsgCtrl(String msgCtrl) {
        this.msgCtrl = msgCtrl;
    }
}
