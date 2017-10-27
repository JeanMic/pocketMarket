package com.example.jean_.pocketmarket.visao.telasPrimarias;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.jean_.pocketmarket.R;

/**
 * Created by jmtb on 25/10/2017.
 */

public class formularioPF extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    String itemSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usuario_PF_formulario);

        //forçar conexao e operção na rede usando a tread da UI
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Metodo executado para esconder o actionBar
        getSupportActionBar().hide();



        Spinner listaUFs = (Spinner) findViewById(R.id.UFresidencial);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.listaUFs, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        listaUFs.setAdapter(adapter);
    }





    @Override
    public void onClick(View v) {


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        itemSelecionado = (String) parent.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
