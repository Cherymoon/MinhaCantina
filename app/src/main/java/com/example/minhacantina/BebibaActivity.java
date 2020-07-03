package com.example.minhacantina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class BebibaActivity extends AppCompatActivity {

    Button btnBebidas, btnLanches, btnRefeicoes, btnSobremesas, btnSaladas;
    ImageView menuIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebiba);

        btnBebidas = findViewById(R.id.btnBebidas);
        btnLanches = findViewById(R.id.btnLanches);
        btnRefeicoes = findViewById(R.id.btnRefeicoes);
        btnSobremesas = findViewById(R.id.btnSobremesas);
        btnSaladas = findViewById(R.id.btnSaladas);

        menuIcon = findViewById(R.id.menuIcon);

        btnBebidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trocaTela(SucoActivity.class);
            }
        });

        btnLanches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trocaTela(CafeActivity.class);
            }
        });

        btnRefeicoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trocaTela(ChaActivity.class);
            }
        });

        btnSobremesas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trocaTela(RefrisActivity.class);
            }
        });

        btnSaladas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trocaTela(SmoothieActivity.class);
            }
        });




        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trocaTela(BebibaActivity.class);
            }
        });


    }

    public void trocaTela(Class toClass)
    {
        Intent intent = new Intent(getApplicationContext(), toClass);
        startActivity(intent);
    }

}
