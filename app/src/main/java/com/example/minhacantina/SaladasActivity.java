package com.example.minhacantina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SaladasActivity extends AppCompatActivity {

    Button btnBebidas, btnLanches, btnRefeicoes, btnSobremesas, btnSaladas;
    ImageView menuIcon;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saladas);

        btnBebidas = findViewById(R.id.btnBebidas);
        btnLanches = findViewById(R.id.btnLanches);
        btnRefeicoes = findViewById(R.id.btnRefeicoes);
        btnSobremesas = findViewById(R.id.btnSobremesas);
        btnSaladas = findViewById(R.id.btnSaladas);

        menuIcon = findViewById(R.id.menuIcon);

        btnBebidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inserePrato("Salada - Ceaser");
                trocaTela(ConfirmaActivity.class);
            }
        });

        btnLanches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inserePrato("Salada - Grega");
                trocaTela(ConfirmaActivity.class);
            }
        });

        btnRefeicoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inserePrato("Salada - Vegan");
                trocaTela(ConfirmaActivity.class);
            }
        });

        btnSobremesas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inserePrato("Salada - Veggie");
                trocaTela(ConfirmaActivity.class);
            }
        });

        menuIcon.setOnClickListener(new View.OnClickListener() {
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

    public void inserePrato(String descricao) {
        db = openOrCreateDatabase("Cantina", Context.MODE_PRIVATE, null);

        StringBuilder pedido = new StringBuilder();
        Cursor usuarioLogado = db.rawQuery("SELECT ID_LOGADO FROM USUARIO_LOGADO", null);
        usuarioLogado.moveToFirst();
        String logado = usuarioLogado.getString(usuarioLogado.getColumnIndex("ID_LOGADO"));

        pedido.append("INSERT INTO PEDIDO(descricao, foto_url, id_usuario) values(");
        pedido.append("'"+descricao+"',");
        pedido.append("NULL,");
        pedido.append(logado);
        pedido.append(");");

        try{
            db.execSQL(pedido.toString());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        db.close();
    }

}
