package com.example.multiconversor.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.example.multiconversor.R;
import com.example.multiconversor.Sistema;
import com.example.multiconversor.classes.Rentabilidade;

public class ViewRentabilidade extends AppCompatActivity {

    private EditText txtValorAporte;
    private EditText txtAnos;
    private EditText txtTaxaRentabilidade;
    private EditText txtTaxaCustodia;
    private Button btnSimular;
    private Button btnLimpar;
    private Button btnInicio;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rentabilidade);

        txtValorAporte = findViewById(R.id.txtValorAporte);
        txtAnos = findViewById(R.id.txtAnos);
        txtTaxaRentabilidade = findViewById(R.id.txtTaxaRentabilidade);
        txtTaxaCustodia = findViewById(R.id.txtTaxaCustodia);
        btnSimular = findViewById(R.id.btnSimular);
        btnLimpar = findViewById(R.id.btnLimpar);
        tvResultado = findViewById(R.id.tvResultado);
        btnInicio = findViewById(R.id.btnInicio);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparTela();
            }
        });

        btnSimular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Rentabilidade campos = validaCampos();

                if( campos != null ){
                    tvResultado.setText( campos.getRentabilidade() );
                }else{
                    txtValorAporte.requestFocus();
                    String msgAviso = "Por Favor, certifique-se de que todos os campos foram informados...";
                    Toast.makeText(ViewRentabilidade.this,msgAviso,Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ViewRentabilidade.this, Sistema.class);
                startActivity(i);
            }
        });

    }


    public Rentabilidade validaCampos(){

        String[] campos = new String[4];
        campos[0] = txtValorAporte.getText().toString();
        campos[1] = txtAnos.getText().toString();
        campos[2] = txtTaxaRentabilidade.getText().toString();
        campos[3] = txtTaxaCustodia.getText().toString();

        Boolean vazio = new Boolean(false);

        for(String valor : campos){
            if( valor.isEmpty() ){
                vazio = true;
            }
        }

        if( vazio ){
            return null;
        }

        Rentabilidade camposTela = new Rentabilidade(
                Double.parseDouble(campos[0]),
                Double.parseDouble(campos[1]),
                Double.parseDouble(campos[2]),
                Double.parseDouble(campos[3])
        );

        return camposTela;

    }

    public void limparTela(){

        txtValorAporte.setText("");
        txtAnos.setText("");
        txtTaxaRentabilidade.setText("");
        txtTaxaCustodia.setText("");
        tvResultado.setText("");

        txtValorAporte.requestFocus();

    }


}