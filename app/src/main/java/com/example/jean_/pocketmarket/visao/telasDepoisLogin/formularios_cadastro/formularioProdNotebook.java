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

public class formularioProdNotebook extends AppCompatActivity implements View.OnClickListener {

    //a variável abaixo é populada no controle caso aconteça de um dado ser inválido
    private String msgCtrl;

    //variáveis de Ids e outras finalidades
    private AppCompatButton viewBtConfirm;

    //views comuns para todos os produtos
    private EditText viewtituloProduto;
    private EditText viewdescricaoProduto;
    private EditText viewprecoProduto;

    //views comuns para todos os produtos computadoresnotebooks
    private EditText viewMarca;
    private EditText viewModelo;
    private EditText viewRAM;
    private EditText viewMarcaProcessador;
    private EditText viewModeloProcessador;
    private EditText viewArmazenamento;
    private EditText viewSistema;
    private EditText viewVersaoSistema;
    private RadioGroup viewUsado;

    //atributos de produtos notebooks
    private EditText viewTamanhoTela;
    private RadioGroup viewpossuitecladonumerico;
    private RadioGroup viewpossuicarregador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_prod_notebook);

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

        if (controle.validaEntradasProdutoNotebook(this)) {
            //Intent telaPrincipal = new Intent(getApplicationContext(), telaPrincipal.class);
            //startActivity(telaPrincipal);
            Toast.makeText(this, "cadastrou porra!!!!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, this.msgCtrl, Toast.LENGTH_LONG).show();
        }
    }

    private void resgataIDViews() {

        //IDs de views comuns para todos os produtos
        viewBtConfirm = (AppCompatButton) findViewById(R.id.confirmcadasnotebook);
        viewtituloProduto = (EditText) findViewById(R.id.titulovendanotebook);
        viewdescricaoProduto = (EditText) findViewById(R.id.descricaovendanotebook);
        viewprecoProduto = (EditText) findViewById(R.id.preconotebook);

        //IDs de views comuns para todos os computadoresnotebooks
        viewMarca = (EditText) findViewById(R.id.marcanotebook);
        viewModelo = (EditText) findViewById(R.id.modelonotebook);
        viewRAM = (EditText) findViewById(R.id.qtdramnotebook);
        viewMarcaProcessador = (EditText) findViewById(R.id.marcaprocessadornotebook);
        viewModeloProcessador = (EditText) findViewById(R.id.modeloprocessadornotebook);
        viewArmazenamento = (EditText) findViewById(R.id.qtdgbshdnotebook);
        viewSistema = (EditText) findViewById(R.id.sistemanotebook);
        viewVersaoSistema = (EditText) findViewById(R.id.versaonotebook);
        viewUsado = (RadioGroup) findViewById(R.id.produtousadonotebook);

        //IDs de views comuns para todos os notebooks
        viewTamanhoTela = (EditText) findViewById(R.id.tamanhotelanotebook);
        viewpossuitecladonumerico = (RadioGroup) findViewById(R.id.possuiounaotecladonumericonotebook);
        viewpossuicarregador = (RadioGroup) findViewById(R.id.possuiounaocarregadortebook);

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

    public EditText getViewRAM() {
        return viewRAM;
    }

    public EditText getViewMarcaProcessador() {
        return viewMarcaProcessador;
    }

    public EditText getViewModeloProcessador() {
        return viewModeloProcessador;
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

    public EditText getViewTamanhoTela() {
        return viewTamanhoTela;
    }

    public RadioGroup getViewpossuitecladonumerico() {
        return viewpossuitecladonumerico;
    }

    public RadioGroup getViewpossuicarregador() {
        return viewpossuicarregador;
    }

    public void setMsgCtrl(String msgCtrl) {
        this.msgCtrl = msgCtrl;
    }
}
