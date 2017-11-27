package com.example.jean_.pocketmarket.visao.telasDepoisLogin.formularios_cadastro;

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

public class formularioProdDesktop extends AppCompatActivity implements View.OnClickListener {

    //a variável abaixo é populada no controle caso aconteça de um dado ser inválido
    private String msgCtrl;

    //variáveis de Ids e outras finalidades
    private AppCompatButton viewBtConfirm;

    private String idAtualizacao;

    //views comuns para todos os produtos
    private EditText viewtituloProduto;
    private EditText viewdescricaoProduto;
    private EditText viewprecoProduto;

    //views comuns para todos os produtos computadoresdesktops
    private EditText viewMarca;
    private EditText viewModelo;
    private EditText viewRAM;
    private EditText viewMarcaProcessador;
    private EditText viewModeloProcessador;
    private EditText viewArmazenamento;
    private EditText viewSistema;
    private EditText viewVersaoSistema;
    private RadioGroup viewUsado;

    //atributos de produtos desktops
    private RadioGroup viewPossuimonitor;
    private RadioGroup viewpossuiTeclado;
    private RadioGroup viewpossuiEstabilizador;
    private RadioGroup viewpossuiMouse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_prod_desktop);

        //forçar conexao e operção na rede usando a tread da UI
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Metodo executado para esconder o actionBar
        getSupportActionBar().hide();

        //metodos dos items do formulário
        resgataIDViews();

        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                this.idAtualizacao = bundle.getString("idVenda");

                this.viewtituloProduto.setText(bundle.getString("tituloProduto"));
                this.viewdescricaoProduto.setText(bundle.getString("descricaoProduto"));
                this.viewprecoProduto.setText(bundle.getString("precoProduto"));

                // views comuns para todos os produtos computadores notebooks
                this.viewMarca.setText(bundle.getString("marca"));
                this.viewModelo.setText(bundle.getString("modelo"));
                this.viewRAM.setText(bundle.getString("ram"));
                this.viewMarcaProcessador.setText(bundle.getString("marcaprocessador"));
                this.viewModeloProcessador.setText(bundle.getString("modeloprocessador"));
                this.viewArmazenamento.setText(bundle.getString("armazenamento"));
                this.viewSistema.setText(bundle.getString("sistema"));
                this.viewVersaoSistema.setText(bundle.getString("sistemaversao"));
            }
        }

        viewBtConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (controle.validaEntradasProdutoDesktop(this, idAtualizacao)) {
            Toast.makeText(this, "cadastrou porra!!!!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, this.msgCtrl, Toast.LENGTH_LONG).show();
        }
    }

    private void resgataIDViews() {

        //IDs de views comuns para todos os produtos
        viewBtConfirm = (AppCompatButton) findViewById(R.id.confirmcadasdesktop);
        viewtituloProduto = (EditText) findViewById(R.id.titulovendadesktop);
        viewdescricaoProduto = (EditText) findViewById(R.id.descricaovendadesktop);
        viewprecoProduto = (EditText) findViewById(R.id.precodesktop);

        //IDs de views comuns para todos os computadoresdesktops
        viewMarca = (EditText) findViewById(R.id.marcadesktop);
        viewModelo = (EditText) findViewById(R.id.modelodesktop);
        viewRAM = (EditText) findViewById(R.id.qtdramdesktop);
        viewMarcaProcessador = (EditText) findViewById(R.id.marcaprocessadordesktop);
        viewModeloProcessador = (EditText) findViewById(R.id.modeloprocessadordesktop);
        viewArmazenamento = (EditText) findViewById(R.id.qtdgbshddesktop);
        viewSistema = (EditText) findViewById(R.id.sistemadesktop);
        viewVersaoSistema = (EditText) findViewById(R.id.versaodesktop);
        viewUsado = (RadioGroup) findViewById(R.id.produtousadodesktop);

        //IDs de views comuns para todos os desktops
        viewPossuimonitor = (RadioGroup) findViewById(R.id.possuiounaomonitordesktop);
        viewpossuiTeclado = (RadioGroup) findViewById(R.id.possuiounaotecladodesktop);
        viewpossuiEstabilizador = (RadioGroup) findViewById(R.id.possuiounaoestabilizadordesktop);
        viewpossuiMouse = (RadioGroup) findViewById(R.id.possuiounaomousedesktop);

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

    public RadioGroup getViewPossuimonitor() {
        return viewPossuimonitor;
    }

    public RadioGroup getViewpossuiTeclado() {
        return viewpossuiTeclado;
    }

    public RadioGroup getViewpossuiEstabilizador() {
        return viewpossuiEstabilizador;
    }

    public RadioGroup getViewpossuiMouse() {
        return viewpossuiMouse;
    }

    public void setMsgCtrl(String msgCtrl) {
        this.msgCtrl = msgCtrl;
    }

    public String getIdAtualizacao() {
        return idAtualizacao;
    }

    public void setIdAtualizacao(String idAtualizacao) {
        this.idAtualizacao = idAtualizacao;
    }
}
