package com.example.multiconversor.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;

import com.example.multiconversor.R;

public class ViewResultadoRentabilidade extends AppCompatActivity {

    private TextView tvResultado;
    private Button btnNovaSimulacao;
    private Intent data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_resultado_rentabilidade);

        tvResultado = findViewById(R.id.tvResultado);
        btnNovaSimulacao = findViewById(R.id.btnNovaSimulacao);

        data = getIntent();

        tvResultado.setText(data.getExtras().getString("resultado"));

        btnNovaSimulacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}