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

public class formularioProdapartamento extends AppCompatActivity implements View.OnClickListener {

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

    //views view do produto apartamento
    private EditText viewAreaUtil;
    private RadioGroup viewPussuiAcademia;
    private RadioGroup viewPussuiVaranda;
    private RadioGroup viewPussuiElevadorPredio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_prod_apartamento);

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

        if (controle.validaEntradasProdutoApartamento(this)) {
            //Intent telaPrincipal = new Intent(getApplicationContext(), telaPrincipal.class);
            //startActivity(telaPrincipal);
            Toast.makeText(this, "cadastrou porra!!!!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, this.msgCtrl, Toast.LENGTH_LONG).show();
        }
    }

    private void resgataIDViews() {

        //IDs de views comuns para todos os produtos
        viewBtConfirm = (AppCompatButton) findViewById(R.id.confirmcadasapartamento);
        viewtituloProduto = (EditText) findViewById(R.id.titulovendaapartamento);
        viewdescricaoProduto = (EditText) findViewById(R.id.descricaovendaapartamento);
        viewprecoProduto = (EditText) findViewById(R.id.precoapartamento);

        //IDs de views comuns para todos os imoveis
        viewQtsquartos = (EditText) findViewById(R.id.qtdquartosapartamento);
        viewQtdsuites = (EditText) findViewById(R.id.qtdsuitesapartamento);
        viewValorIPTU = (EditText) findViewById(R.id.valiptuapartamento);
        viewValorCondominio = (EditText) findViewById(R.id.valcondominioapartamento);
        viewVagsaGaragem = (EditText) findViewById(R.id.qtdvagasgaragemapartamento);
        viewVendaouAluguel = (RadioGroup) findViewById(R.id.vendaoualuguelapartamento);

        //Mascara CEP
        viewCEPImovel = (EditText) findViewById(R.id.cepapartamento);
        viewCEPImovel.addTextChangedListener(Mask.insert("#####-###", viewCEPImovel));

        viewPussuiPiscina = (RadioGroup) findViewById(R.id.possuiounaopiscinaapartamento);
        viewPussuiAreaServico = (RadioGroup) findViewById(R.id.possuiounaoareadeservicoapartamento);
        viewPussuiArCondicionado = (RadioGroup) findViewById(R.id.possuiounaoarcondicionadoapartamento);
        viewPussuiQuartoEmpregada = (RadioGroup) findViewById(R.id.possuiounaoquartoempregadaapartamento);
        viewPussuiCondominioFechado = (RadioGroup) findViewById(R.id.possuiounaocondominiofechadoapartamento);

        //IDs views produto apartamento
        viewAreaUtil = (EditText) findViewById(R.id.areautilapartamento);
        viewPussuiAcademia = (RadioGroup) findViewById(R.id.possuiounaoacademiaapartamento);
        viewPussuiVaranda = (RadioGroup) findViewById(R.id.possuiounaovarandaapartamento);
        viewPussuiElevadorPredio = (RadioGroup) findViewById(R.id.possuiounaoelevadorapartamento);

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

    public EditText getViewAreaUtil() {
        return viewAreaUtil;
    }

    public RadioGroup getViewPussuiAcademia() {
        return viewPussuiAcademia;
    }

    public RadioGroup getViewPussuiVaranda() {
        return viewPussuiVaranda;
    }

    public RadioGroup getViewPussuiElevadorPredio() {
        return viewPussuiElevadorPredio;
    }


    public void setMsgCtrl(String msgCtrl) {
        this.msgCtrl = msgCtrl;
    }
}
