package com.example.multiconversor.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import com.example.multiconversor.utils.StringUtils;

import com.example.multiconversor.R;

public class ViewInfoCombustivel extends AppCompatActivity {

    private EditText txtValorLitroGasolina, txtKmLitroGasolina, txtValorLitroAlcool, txtKmLitroAlcool;
    private EditText txtValorLitroDisel, txtKmLitroDisel, txtDistancia, txtValorAbastecer;
    private Button btnInicio, btnAvancar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_info_combustivel);

        txtValorLitroGasolina = findViewById(R.id.txtValorLitroGasolina);
        txtKmLitroGasolina = findViewById(R.id.txtKmLitroGasolina);
        txtValorLitroAlcool = findViewById(R.id.txtValorLitroAlcool);
        txtKmLitroAlcool = findViewById(R.id.txtKmLitroAlcool);
        txtValorLitroDisel = findViewById(R.id.txtValorLitroDisel);
        txtKmLitroDisel = findViewById(R.id.txtKmLitroDisel);
        txtDistancia = findViewById(R.id.txtDistancia);
        txtValorAbastecer = findViewById(R.id.txtValorAbastecer);

        btnInicio = findViewById(R.id.btnInicio);
        btnAvancar = findViewById(R.id.btnAvancar);


        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent janela = new Intent(ViewInfoCombustivel.this, ViewCombustivel.class);
                startActivity(janela);
            }
        });


    }

























    /*public void setEscolha(){

        data = getIntent();
        opcao = data.getExtras().getString("escolha");

        StringUtils str = new StringUtils( opcao.replace("_"," ") );
        str.Capitalize();
        tvTipoConversao.setText("Conversão Escolhida: " + str.getParam().replace(" ", " em "));

    }*/

    /*public void direcionarEscolha(){

        switch (opcao){

            case "litros_reais":
                break;
            case "litros_kilometros":
                break;
            case "reais_litros":
                break;
            case "reais_kilometros":
                break;
            case "kilometros_litros":
                break;
            case "kilometros_reais":
                break;
            default:
                Toast.makeText(ViewInfoCombustivel.this, "Opção invalida, ou algum erro ocorreu durante a escolha da opção...",Toast.LENGTH_LONG).show();
                break;
        }

    }*/

}