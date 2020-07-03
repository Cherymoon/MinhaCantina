package com.example.minhacantina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConfirmaActivity extends AppCompatActivity {

    Button btnOk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirma);

        btnOk = findViewById(R.id.btnOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trocaTela(MenuActivity.class);
            }
        });

    }
    public void trocaTela(Class toClass)
    {
        Intent intent = new Intent(getApplicationContext(), toClass);
        startActivity(intent);
    }
}
