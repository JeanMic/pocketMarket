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
import com.example.jean_.pocketmarket.visao.util.Mask;

/**
 * Created by jmtb on 13/11/2017.
 */

public class formularioProdCasa extends AppCompatActivity implements View.OnClickListener {

    //a variável abaixo é populada no controle caso aconteça de um dado ser inválido
    private String msgCtrl;

    //variáveis de Ids e outras finalidades
    private AppCompatButton viewBtConfirm;

    //views comuns para todos os produtos
    private EditText viewtituloProduto;
    private EditText viewdescricaoProduto;
    private EditText viewprecoProduto;

    //views comuns para todos os produtos imoveis
    private EditText viewQtsquartos;
    private EditText viewQtdsuites;
    private EditText viewValorIPTU;
    private EditText viewValorCondominio;
    private EditText viewVagsaGaragem;
    private RadioGroup viewVendaouAluguel;
    private EditText viewCEPImovel;
    private RadioGroup viewPussuiPiscina;
    private RadioGroup viewPussuiAreaServico;
    private RadioGroup viewPussuiArCondicionado;
    private RadioGroup viewPussuiQuartoEmpregada;
    private RadioGroup viewPussuiCondominioFechado;

    //views view do produto Casa
    private EditText viewAreaConstruida;
    private RadioGroup viewPussuiCameraVigilancia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_prod_casa);

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

        if (controle.validaEntradasProdutoCasa(this)) {
            //Intent telaPrincipal = new Intent(getApplicationContext(), telaPrincipal.class);
            //startActivity(telaPrincipal);
            Toast.makeText(this, "cadastrou porra!!!!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, this.msgCtrl, Toast.LENGTH_LONG).show();
        }
    }

    private void resgataIDViews() {

        //IDs de views comuns para todos os produtos
        viewBtConfirm = (AppCompatButton) findViewById(R.id.confirmcadascasa);
        viewtituloProduto = (EditText) findViewById(R.id.titulovendacasa);
        viewdescricaoProduto = (EditText) findViewById(R.id.descricaovendacasa);
        viewprecoProduto = (EditText) findViewById(R.id.precocasa);

        //IDs de views comuns para todos os imoveis
        viewQtsquartos = (EditText) findViewById(R.id.qtdquartoscasa);
        viewQtdsuites = (EditText) findViewById(R.id.qtdsuitescasa);
        viewValorIPTU = (EditText) findViewById(R.id.valiptucasa);
        viewValorCondominio = (EditText) findViewById(R.id.valcondominiocasa);
        viewVagsaGaragem = (EditText) findViewById(R.id.qtdvagasgaragemcasa);
        viewVendaouAluguel = (RadioGroup) findViewById(R.id.vendaoualuguelcasa);

        //Mascara CEP
        viewCEPImovel = (EditText) findViewById(R.id.cepcasa);
        viewCEPImovel.addTextChangedListener(Mask.insert("#####-###", viewCEPImovel));

        viewPussuiPiscina = (RadioGroup) findViewById(R.id.possuiounaopiscinacasa);
        viewPussuiAreaServico = (RadioGroup) findViewById(R.id.possuiounaoareadeservicocasa);
        viewPussuiArCondicionado = (RadioGroup) findViewById(R.id.possuiounaoarcondicionadocasa);
        viewPussuiQuartoEmpregada = (RadioGroup) findViewById(R.id.possuiounaoquartoempregadacasa);
        viewPussuiCondominioFechado = (RadioGroup) findViewById(R.id.possuiounaocondominiofechadocasa);

        //IDs views produto casa
        viewAreaConstruida = (EditText) findViewById(R.id.areaconstruidacasa);
        viewPussuiCameraVigilancia = (RadioGroup) findViewById(R.id.possuiounaocameravigilanciacasa);

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

    public EditText getViewQtdquartos() {
        return viewQtsquartos;
    }

    public EditText getViewQtdsuites() {
        return viewQtdsuites;
    }

    public EditText getViewanoValorIPTU() {
        return viewValorIPTU;
    }

    public EditText getViewValorCondominio() {
        return viewValorCondominio;
    }

    public EditText getViewVagsaGaragem() {
        return viewVagsaGaragem;
    }

    public RadioGroup getViewVendaouAluguel() {
        return viewVendaouAluguel;
    }

    public EditText getViewCEPImovel() {
        return viewCEPImovel;
    }

    public RadioGroup getViewPussuiPiscina() {
        return viewPussuiPiscina;
    }

    public RadioGroup getViewPussuiAreaServico() {
        return viewPussuiAreaServico;
    }

    public RadioGroup getViewPussuiArCondicionado() {
        return viewPussuiArCondicionado;
    }

    public RadioGroup getViewPussuiQuartoEmpregada() {
        return viewPussuiQuartoEmpregada;
    }

    public RadioGroup getViewPussuiCondominioFechado() {
        return viewPussuiCondominioFechado;
    }

    public EditText getViewAreaConstruida() {
        return viewAreaConstruida;
    }

    public RadioGroup getViewPussuiCameraVigilancia() {
        return viewPussuiCameraVigilancia;
    }


    public void setMsgCtrl(String msgCtrl) {
        this.msgCtrl = msgCtrl;
    }
}
