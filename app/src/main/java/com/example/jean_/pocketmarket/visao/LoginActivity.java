package com.example.jean_.pocketmarket.visao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jean_.pocketmarket.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Metodo executado para esconder o actionBar
        getSupportActionBar().hide();

       // String teste = "testando importação";
     }
}
