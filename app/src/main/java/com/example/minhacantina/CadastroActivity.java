package com.example.minhacantina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    SQLiteDatabase db;
    EditText login, senha;
    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        login = findViewById(R.id.etLogin);
        senha = findViewById(R.id.etSenha);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userLogin = login.getText().toString();
                String userSenha = senha.getText().toString();
                insereUsuario(userLogin, userSenha);
                trocaTela(MainActivity.class);
            }
        });
    }
    public void insereUsuario(String login, String senha) {
        db = openOrCreateDatabase("Cantina", Context.MODE_PRIVATE, null);

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO USUARIO(login, senha) VALUES(");
        sql.append("'"+login+"', ");
        sql.append("'"+senha+"');");

        try{
            db.execSQL(sql.toString());
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
