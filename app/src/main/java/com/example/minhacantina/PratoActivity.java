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
import android.widget.Toast;

public class PratoActivity extends AppCompatActivity {

    SQLiteDatabase db;
    ImageView menuIcon;
    Button comprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prato);

        menuIcon = findViewById(R.id.menuIcon);
        comprar = findViewById(R.id.btnBebidas);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trocaTela(MenuActivity.class);
            }
        });

        comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inserePrato("Prato do Dia", R.drawable.pratodia);
                trocaTela(ConfirmaActivity.class);
            }
        });

    }

    public void trocaTela(Class toClass)
    {
        Intent intent = new Intent(getApplicationContext(), toClass);
        startActivity(intent);
    }

    public void inserePrato(String descricao, int idFoto) {
        db = openOrCreateDatabase("Cantina", Context.MODE_PRIVATE, null);

        StringBuilder pedido = new StringBuilder();
        Cursor usuarioLogado = db.rawQuery("SELECT ID_LOGADO FROM USUARIO_LOGADO", null);
        usuarioLogado.moveToFirst();
        String x = usuarioLogado.getString(usuarioLogado.getColumnIndex("ID_LOGADO"));

        Toast.makeText(this, x, Toast.LENGTH_SHORT).show();

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

}
