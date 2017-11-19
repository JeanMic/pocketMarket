package com.example.jean_.pocketmarket.visao.telasPrimarias;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.controle.controle;
import com.example.jean_.pocketmarket.visao.telasNavegacao.telaPrincipal;
import com.example.jean_.pocketmarket.visao.util.Mask;

/**
 * Created by jmtb on 25/10/2017.
 */

//public class formularioPF extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

public class formularioPF extends AppCompatActivity implements View.OnClickListener {

    //a variável abaixo é populada no controle caso aconteça de um dado ser inválido
    private String msgCtrl;

    //variáveis de Ids e outras finalidades
    private Spinner viewSpinner;
    private AppCompatButton viewBtConfirm;

    private RadioGroup viewRadioSexo;
    private EditText viewNome;
    private EditText viewCPF;
    private EditText viewSenha;
    private EditText viewDtnasc;
    private EditText viewEmail;
    private EditText viewEndereco;
    private EditText viewCEP;
    private EditText viewNumResid;
    private EditText viewComplResi;
    private EditText viewBairro;
    private EditText viewCidade;
    private EditText viewDDDNumCel;

    //variáveis dos imputs
    private String txtNome;
    private String txtCPF;
    private String txtSexo;
    private String txtSenha;
    private String txtDtNasc;
    private String txtEmail;
    private String txtEndereco;
    private String txtCep;
    private String txtNumResidencia;
    private String txtComplResid;
    private String txtBairro;
    private String txtCidade;
    private String txtUF;
    private String txtDDDNumCel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_cadastro_pf);

        //forçar conexao e operção na rede usando a tread da UI
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Metodo executado para esconder o actionBar
        getSupportActionBar().hide();

        //metodos dos items do formulário
        resgataIDViews();
        spinner();
        viewBtConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        txtNome = viewNome.getText().toString().trim();
        txtCPF = viewCPF.getText().toString().trim();
        txtSexo = (viewRadioSexo.getCheckedRadioButtonId() == R.id.radiomasc) ? "M" : "F";
        txtSenha = viewSenha.getText().toString().trim();
        txtDtNasc = viewDtnasc.getText().toString().trim();
        txtEmail = viewEmail.getText().toString().trim();
        txtEndereco = viewEndereco.getText().toString().trim();
        txtCep = viewCEP.getText().toString().trim();
        txtNumResidencia = viewNumResid.getText().toString().trim();
        txtComplResid = viewComplResi.getText().toString().trim();
        txtBairro = viewBairro.getText().toString().trim();
        txtCidade = viewCidade.getText().toString().trim();
        txtUF = (String) viewSpinner.getSelectedItem();
        txtDDDNumCel = viewDDDNumCel.getText().toString().trim();

        if (controle.validaEntradasUsuarioPF(this)) {
            Intent telaPrincipal = new Intent(getApplicationContext(), telaPrincipal.class);
            startActivity(telaPrincipal);
        } else {
            Toast.makeText(this, this.msgCtrl, Toast.LENGTH_LONG).show();
        }
    }


    private void resgataIDViews() {

        viewBtConfirm = (AppCompatButton) findViewById(R.id.confirmregistro);

        viewNome = (EditText) findViewById(R.id.nome);

        viewCPF = (EditText) findViewById(R.id.cpf);
        viewCPF.addTextChangedListener(Mask.insert("###.###.###-##", viewCPF));

        viewRadioSexo = (RadioGroup) findViewById(R.id.rdmascfem);
        viewSenha = (EditText) findViewById(R.id.senhausupf);

        viewDtnasc = (EditText) findViewById(R.id.datanasc);
        viewDtnasc.addTextChangedListener(Mask.insert("##/##/####", viewDtnasc));

        viewEmail = (EditText) findViewById(R.id.email);
        viewEndereco = (EditText) findViewById(R.id.endereco);

        viewCEP = (EditText) findViewById(R.id.cep);
        viewCEP.addTextChangedListener(Mask.insert("#####-###", viewCEP));

        viewNumResid = (EditText) findViewById(R.id.numeroresidencia);
        viewComplResi = (EditText) findViewById(R.id.complementoresidencia);
        viewBairro = (EditText) findViewById(R.id.bairroresidencial);
        viewCidade = (EditText) findViewById(R.id.cidaderesidencial);
        viewSpinner = (Spinner) findViewById(R.id.spinnerufs);

        viewDDDNumCel = (EditText) findViewById(R.id.DDDnumcel);
        viewDDDNumCel.addTextChangedListener(Mask.insert("(##)#####-####", viewDDDNumCel));

    }

    private void spinner() {

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.listaUFs, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        viewSpinner.setAdapter(adapter);

    }

    public String getTxtDDDNumCel() {
        return txtDDDNumCel;
    }

    public String getTxtNome() {
        return txtNome;
    }

    public String getTxtCPF() {
        return txtCPF;
    }

    public String getTxtSexo() {
        return txtSexo;
    }

    public String getTxtSenha() {
        return txtSenha;
    }

    public String getTxtDtNasc() {
        return txtDtNasc;
    }

    public String getTxtEmail() {
        return txtEmail;
    }

    public String getTxtEndereco() {
        return txtEndereco;
    }

    public String getTxtCep() {
        return txtCep;
    }

    public String getTxtNumResidencia() {
        return txtNumResidencia;
    }

    public String getTxtComplResid() {
        return txtComplResid;
    }

    public String getTxtBairro() {
        return txtBairro;
    }

    public String getTxtCidade() {
        return txtCidade;
    }

    public String getTxtUF() {
        return txtUF;
    }

    public void setMsgCtrl(String msgCtrl) {
        this.msgCtrl = msgCtrl;
    }
}
