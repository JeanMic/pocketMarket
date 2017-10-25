package com.example.jean_.pocketmarket.visao.telasPrimarias;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import com.example.jean_.pocketmarket.R;


/**
 * Created by jmtb on 25/10/2017.
 */

public class decisaoFormularioCadastro extends AppCompatActivity implements View.OnClickListener {

    private AppCompatButton btFormPF;
    private AppCompatButton btFormPJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.decisao_formulario);

        //forçar conexao e operção na rede usando a tread da UI
        //StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        //StrictMode.setThreadPolicy(policy);

        //Metodo executado para esconder o actionBar
        getSupportActionBar().hide();

        resgataIDViews();
        inicializaEsculta();
    }

    // Resgata o ID das views
    private void resgataIDViews() {

        btFormPF = (AppCompatButton) findViewById(R.id.botaodecisaoPF);
        btFormPJ = (AppCompatButton) findViewById(R.id.botaodecisaoPJ);
    }

    private void inicializaEsculta() {
        btFormPF.setOnClickListener(this);
        btFormPJ.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.botaodecisaoPF:
                //cria a intent de cadastro de usuário PF
                Intent formCadasPF = new Intent(getApplicationContext(), formularioPF.class);
                startActivity(formCadasPF);
                break;
            case R.id.botaodecisaoPJ:
                //cria a intent de cadastro de usuário PJ
                Intent formCadasPJ = new Intent(getApplicationContext(), formularioPJ.class);
                startActivity(formCadasPJ);
                break;
        }
    }
}
