package com.example.jean_.pocketmarket.visao.telasAntesLogin;

import android.content.Intent;
import android.os.StrictMode;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Toast;

import com.example.jean_.pocketmarket.R;
import com.example.jean_.pocketmarket.controle.controle;
import com.example.jean_.pocketmarket.visao.telasDepoisLogin.principal.telaPrincipal;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText txtdoc;
    private TextInputEditText txtsenha;

    private AppCompatButton btlogin;
    private AppCompatTextView txtlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //forçar conexao e operção na rede usando a tread da UI
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Metodo executado para esconder o actionBar
        getSupportActionBar().hide();

        resgataIDViews();
        inicializaEsculta();
    }

    // Resgata o ID das views
    private void resgataIDViews() {
        txtdoc = (TextInputEditText) findViewById(R.id.txtdoc);
        txtsenha = (TextInputEditText) findViewById(R.id.txtsenha);

        btlogin = (AppCompatButton) findViewById(R.id.botaoLogin);
        txtlink = (AppCompatTextView) findViewById(R.id.textolink);
    }

    private void inicializaEsculta() {
        btlogin.setOnClickListener(this);
        txtlink.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //se pressionou o botao de login, mandar pro controle o login e senha e testar autenticalção
            case R.id.botaoLogin:
                try {
                    if (controle.autenticacao(txtdoc.getText().toString().trim(), txtsenha.getText().toString().trim())){
                        Intent TelaPrincipal = new Intent(getApplicationContext(), telaPrincipal.class);
                        startActivity(TelaPrincipal);
                    } else {
                        Toast.makeText(this, "ta errado fera, concerta isso ai", Toast.LENGTH_LONG).show();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.textolink:
                // cria a intent da tela do formulario de cadastro de Usuarios PF e PJ
                Intent decisaoCadastro = new Intent(getApplicationContext(), decisaoFormularioCadastro.class);
                startActivity(decisaoCadastro);
                break;
        }
    }
}
