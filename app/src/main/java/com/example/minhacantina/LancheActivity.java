package com.example.minhacantina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LancheActivity extends AppCompatActivity {

    Button btnBebidas, btnLanches, btnRefeicoes, btnSobremesas, btnSaladas;
    ImageView menuIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanche);

        btnBebidas = findViewById(R.id.btnBebidas);
        btnLanches = findViewById(R.id.btnLanches);
        btnRefeicoes = findViewById(R.id.btnRefeicoes);
        btnSobremesas = findViewById(R.id.btnSobremesas);
        btnSaladas = findViewById(R.id.btnSaladas);

        menuIcon = findViewById(R.id.menuIcon);

        btnBebidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trocaTela(AssadoActivity.class);
            }
        });

        btnLanches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trocaTela(SanduicheActivity.class);
            }
        });

        btnRefeicoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trocaTela(EmpanadoActivity.class);
            }
        });

        btnSobremesas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trocaTela(PetiscoActivity.class);
            }
        });


        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trocaTela(LancheActivity.class);
            }
        });


    }

    public void trocaTela(Class toClass)
    {
        Intent intent = new Intent(getApplicationContext(), toClass);
        startActivity(intent);
    }

}
