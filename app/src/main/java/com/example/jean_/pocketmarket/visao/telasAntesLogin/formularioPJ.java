package com.example.jean_.pocketmarket.visao.telasAntesLogin;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.controle.controle;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.principal.telaPrincipal;
import com.example.jean_.pocketmarket.visao.util.Mask;

/**
 * Created by jmtb on 25/10/2017.
 */

public class formularioPJ extends AppCompatActivity implements View.OnClickListener {

    //a variável abaixo é populada no controle caso aconteça de um dado ser inválido
    private String msgCtrl;

    //variáveis de Ids e outras finalidades
    private Spinner viewSpinnercomercial;
    private AppCompatButton viewBtConfirmpj;

    private boolean atualizarcadastro = false;

    private EditText viewRazaosocial;
    private EditText viewCNPJ;
    private EditText viewSenhapj;
    private EditText viewDtfundacao;
    private EditText viewEmailcontato;
    private EditText viewEnderecocomercial;
    private EditText viewCEPcomercial;
    private EditText viewNumcomercial;
    private EditText viewComplcomercial;
    private EditText viewBairrocomercial;
    private EditText viewCidadecomercial;
    private EditText viewDDDNumcomercial;

    //variáveis dos imputs
    private String txtRazaosocial;
    private String txtCNPJ;
    private String txtSenhapj;
    private String txtDtfundacao;
    private String txtEmailcontato;
    private String txtEnderecocomercial;
    private String txtCepcomercial;
    private String txtNumcomercial;
    private String txtComplcomercial;
    private String txtBairrocomercial;
    private String txtCidadecomercial;
    private String txtUFcomercial;
    private String txtDDDNumcomercial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_cadastro_pj);

        //forçar conexao e operção na rede usando a tread da UI
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Metodo executado para esconder o actionBar
        getSupportActionBar().hide();

        //metodos dos items do formulário
        resgataIDViews();
        spinner();

        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                atualizarcadastro = true;
                this.viewRazaosocial.setText(bundle.getString("razaosocial"));
                this.viewDtfundacao.setText(bundle.getString("datafundacao"));
                this.viewEmailcontato.setText(bundle.getString("email"));
                this.viewEnderecocomercial.setText(bundle.getString("endereco"));
                this.viewCEPcomercial.setText(bundle.getString("cep"));
                this.viewNumcomercial.setText(bundle.getString("numcomer"));
                this.viewComplcomercial.setText(bundle.getString("complementocomer"));
                this.viewBairrocomercial.setText(bundle.getString("bairro"));
                this.viewCidadecomercial.setText(bundle.getString("cidade"));
                this.viewDDDNumcomercial.setText(bundle.getString("dddnumcel"));
            }
        }

        viewBtConfirmpj.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        txtRazaosocial = viewRazaosocial.getText().toString().trim();
        txtCNPJ = viewCNPJ.getText().toString().trim();
        txtSenhapj = viewSenhapj.getText().toString().trim();
        txtDtfundacao = viewDtfundacao.getText().toString().trim();
        txtEmailcontato = viewEmailcontato.getText().toString().trim();
        txtEnderecocomercial = viewEnderecocomercial.getText().toString().trim();
        txtCepcomercial = viewCEPcomercial.getText().toString().trim();
        txtNumcomercial = viewNumcomercial.getText().toString().trim();
        txtComplcomercial = viewComplcomercial.getText().toString().trim();
        txtBairrocomercial = viewBairrocomercial.getText().toString().trim();
        txtCidadecomercial = viewCidadecomercial.getText().toString().trim();
        txtUFcomercial = (String) viewSpinnercomercial.getSelectedItem();
        txtDDDNumcomercial = viewDDDNumcomercial.getText().toString().trim();

        if (controle.validaEntradasUsuarioPJ(this)) {
            if (atualizarcadastro) {
                Toast.makeText(this, "Cadastro Atualizado", Toast.LENGTH_LONG).show();
            } else {
                Intent telaPrincipal = new Intent(getApplicationContext(), telaPrincipal.class);
                startActivity(telaPrincipal);
            }
        } else {
            Toast.makeText(this, this.msgCtrl, Toast.LENGTH_LONG).show();
        }
    }

    private void resgataIDViews() {

        viewBtConfirmpj = (AppCompatButton) findViewById(R.id.confirmregistropj);

        viewRazaosocial = (EditText) findViewById(R.id.razaosocial);

        viewCNPJ = (EditText) findViewById(R.id.cnpj);
        viewCNPJ.addTextChangedListener(Mask.insert("##.###.###/####-##", viewCNPJ));

        viewSenhapj = (EditText) findViewById(R.id.senhausupj);

        viewDtfundacao = (EditText) findViewById(R.id.datafundacao);
        viewDtfundacao.addTextChangedListener(Mask.insert("##/##/####", viewDtfundacao));

        viewEmailcontato = (EditText) findViewById(R.id.emailpj);
        viewEnderecocomercial = (EditText) findViewById(R.id.enderecomercial);

        viewCEPcomercial = (EditText) findViewById(R.id.cepcomercial);
        viewCEPcomercial.addTextChangedListener(Mask.insert("#####-###", viewCEPcomercial));

        viewNumcomercial = (EditText) findViewById(R.id.numerorcomercial);

        viewComplcomercial = (EditText) findViewById(R.id.complementoendpj);
        viewBairrocomercial = (EditText) findViewById(R.id.bairrocomercial);
        viewCidadecomercial = (EditText) findViewById(R.id.cidadecomercial);
        viewSpinnercomercial = (Spinner) findViewById(R.id.spinnerufscomercial);

        viewDDDNumcomercial = (EditText) findViewById(R.id.DDDnumcomercial);
        viewDDDNumcomercial.addTextChangedListener(Mask.insert("(##)#####-####", viewDDDNumcomercial));

    }

    private void spinner() {

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.listaUFs, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        viewSpinnercomercial.setAdapter(adapter);

    }

    public String getTxtRazaosocial() {
        return txtRazaosocial;
    }

    public String getTxtCNPJ() {
        return txtCNPJ;
    }

    public String getTxtSenhapj() {
        return txtSenhapj;
    }

    public String getTxtDtfundacao() {
        return txtDtfundacao;
    }

    public String getTxtEmailcontato() {
        return txtEmailcontato;
    }

    public String getTxtEnderecocomercial() {
        return txtEnderecocomercial;
    }

    public String getTxtCepcomercial() {
        return txtCepcomercial;
    }

    public String getTxtNumcomercial() {
        return txtNumcomercial;
    }

    public String getTxtComplcomercial() {
        return txtComplcomercial;
    }

    public String getTxtBairrocomercial() {
        return txtBairrocomercial;
    }

    public String getTxtCidadecomercial() {
        return txtCidadecomercial;
    }

    public String getTxtUFcomercial() {
        return txtUFcomercial;
    }

    public String getTxtDDDNumCel() {
        return txtDDDNumcomercial;
    }

    public void setMsgCtrl(String msgCtrl) {
        this.msgCtrl = msgCtrl;
    }

    public boolean isAtualizarcadastro() {
        return atualizarcadastro;
    }

    public void setAtualizarcadastro(boolean atualizarcadastro) {
        this.atualizarcadastro = atualizarcadastro;
    }

}
