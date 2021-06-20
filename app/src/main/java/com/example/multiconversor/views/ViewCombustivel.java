package com.example.multiconversor.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.multiconversor.R;

public class ViewCombustivel extends AppCompatActivity {

    private  RadioGroup rdGroup;
    private RadioButton rdLitroReal, rdLitroKm, rdRealLitro, rdRealKm, rdKmLitro, rdKmReal;
    private Button btnVoltar;
    private Button btnConverter;
    private String opcao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_combustivel);

        rdGroup = findViewById(R.id.rdGroup);

        rdLitroReal = findViewById(R.id.rdLitroReal);
        rdLitroKm = findViewById(R.id.rdLitroKm);
        rdRealLitro = findViewById(R.id.rdRealLitro);
        rdRealKm = findViewById(R.id.rdRealKm);
        rdKmLitro = findViewById(R.id.rdKmLitro);
        rdKmReal = findViewById(R.id.rdKmReal);

        btnVoltar = findViewById(R.id.btnVoltar);
        btnConverter = findViewById(R.id.btnConverter);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( opcao != null && !opcao.isEmpty() ){

                    Intent janela = new Intent(ViewCombustivel.this,ViewResultadoCombustivel.class);
                    janela.putExtra("escolha",opcao);
                    startActivity(janela);

                }else{
                    Toast.makeText(ViewCombustivel.this,"Escolha uma opção...",Toast.LENGTH_SHORT).show();
                    rdLitroReal.requestFocus();
                }
            }
        });

    }

    public void checarButtons(View v) {
        int radioId = rdGroup.getCheckedRadioButtonId();
        RadioButton rdButton = findViewById(radioId);
        rdButton.setSelected(true);
        opcao = rdButton.getText().toString().toLowerCase().replace(" em ","_");
    }

}