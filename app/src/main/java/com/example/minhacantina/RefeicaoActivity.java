package com.example.minhacantina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class RefeicaoActivity extends AppCompatActivity {

    Button btnBebidas, btnLanches, btnRefeicoes, btnSobremesas, btnSaladas;
    ImageView menuIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refeicao);

        btnBebidas = findViewById(R.id.btnBebidas);
        btnLanches = findViewById(R.id.btnLanches);
        btnRefeicoes = findViewById(R.id.btnRefeicoes);
        btnSobremesas = findViewById(R.id.btnSobremesas);
        btnSaladas = findViewById(R.id.btnSaladas);

        menuIcon = findViewById(R.id.menuIcon);

        btnBebidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trocaTela(PratoActivity.class);
            }
        });

        btnLanches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trocaTela(PanquecaActivity.class);
            }
        });

        btnRefeicoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trocaTela(TapiocaActivity.class);
            }
        });

        btnSobremesas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trocaTela(SopaActivity.class);
            }
        });


        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trocaTela(RefeicaoActivity.class);
            }
        });


    }

    public void trocaTela(Class toClass)
    {
        Intent intent = new Intent(getApplicationContext(), toClass);
        startActivity(intent);
    }

}
