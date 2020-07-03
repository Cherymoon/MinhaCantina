package com.example.minhacantina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MenuActivity extends AppCompatActivity {

    LinearLayout lyHome, lyPedidos, lySair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        lyHome = findViewById(R.id.lyHome);
        lyPedidos = findViewById(R.id.lyPedidos);
        lySair = findViewById(R.id.lySair);

        lyHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trocaTela(CardapioActivity.class);
            }
        });
        lyPedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trocaTela(PedidosActivity.class);
            }
        });

        lySair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

    }

    public void trocaTela(Class toClass)
    {
        Intent intent = new Intent(getApplicationContext(), toClass);
        startActivity(intent);
    }

}
