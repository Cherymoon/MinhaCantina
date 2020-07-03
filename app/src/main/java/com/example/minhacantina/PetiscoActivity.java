package com.example.minhacantina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PetiscoActivity extends AppCompatActivity {



    TextView prato1, prato2, prato3, prato4;
    ImageView menuIcon;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petisco);

        prato1 = findViewById(R.id.prato1);
        prato2 = findViewById(R.id.prato2);
        prato3 = findViewById(R.id.prato3);
        prato4 = findViewById(R.id.prato4);
        menuIcon = findViewById(R.id.menuIcon);

        prato1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String descricao = prato1.getText().toString();
                inserePrato("Mix de Castanhas", R.drawable.ptcastanhas);
                trocaTela(ConfirmaActivity.class);
            }
        });

        prato2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String descricao = prato2.getText().toString();
                inserePrato("Amendoim Torrado", R.drawable.ptamendoim);
                trocaTela(ConfirmaActivity.class);
            }
        });

        prato3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String descricao = prato2.getText().toString();
                inserePrato("Chips de Batata Doce", R.drawable.ptchips);
                trocaTela(ConfirmaActivity.class);
            }
        });

        prato4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String descricao = prato3.getText().toString();
                inserePrato("Chips de Mandioca", R.drawable.ptchipmandioca);
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

    public void inserePrato(String descricao, int idFoto) {
        db = openOrCreateDatabase("Cantina", Context.MODE_PRIVATE, null);

        StringBuilder pedido = new StringBuilder();
        Cursor usuarioLogado = db.rawQuery("SELECT ID_LOGADO FROM USUARIO_LOGADO", null);
        usuarioLogado.moveToFirst();
        String x = usuarioLogado.getString(usuarioLogado.getColumnIndex("ID_LOGADO"));

        pedido.append("INSERT INTO PEDIDO(descricao, foto_url, id_usuario) values(");
        pedido.append("'"+descricao+"',");
        pedido.append("'"+idFoto+"',");
        pedido.append(x);
        pedido.append(");");

        try{
            db.execSQL(pedido.toString());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        db.close();
    }

    public void trocaTela(Class toClass)
    {
        Intent intent = new Intent(getApplicationContext(), toClass);
        startActivity(intent);
    }


}
