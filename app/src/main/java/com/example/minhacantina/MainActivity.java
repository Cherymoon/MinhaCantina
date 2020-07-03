package com.example.minhacantina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnEntrar, btnCadastrar;
    EditText login, senha;
    SQLiteDatabase db;
    int usuarioLogado = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEntrar = findViewById(R.id.btnEntrar);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        login = findViewById(R.id.etLogin);
        senha = findViewById(R.id.etSenha);

        criarDB();

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validaLogin(login.getText().toString(), senha.getText().toString()))
                {
                    setUsuarioLogado();
                    trocaTela(CardapioActivity.class);
                }
                else {
                    Toast.makeText(MainActivity.this, "Dados Invalidos.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trocaTela(CadastroActivity.class);
            }
        });

    }

    public void trocaTela(Class toClass)
    {
        Intent intent = new Intent(getApplicationContext(), toClass);
        startActivity(intent);
    }

    public void criarDB() {
        db = openOrCreateDatabase("Cantina", Context.MODE_PRIVATE, null);

        StringBuilder sb = new StringBuilder();

        sb.append("CREATE TABLE IF NOT EXISTS USUARIO(");
        sb.append("_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,");
        sb.append("login INTEGER NOT NULL UNIQUE,");
        sb.append("senha NVARCHAR(60) NOT NULL);");

        sb.append("CREATE TABLE IF NOT EXISTS PEDIDO(");
        sb.append("_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,");
        sb.append("descricao NVARCHAR(255) NOT NULL,");
        sb.append("foto_url NVARCHAR(255),");
        sb.append("id_usuario INTEGER,");
        sb.append("FOREIGN KEY(id_usuario) REFERENCES USUARIO(_id));");

        sb.append("CREATE TABLE IF NOT EXISTS USUARIO_LOGADO(");
        sb.append("ID_LOGADO INTEGER);");

        try {
            String sql = sb.toString();
            String[] queries = sql.split(";");

            for(String query : queries) {
                db.execSQL(query);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        db.close();
    }

    private boolean validaLogin(String login, String senha) {

        if(login.trim().equals("") || senha.trim().equals("")) {
            return false;
        }

        db = openOrCreateDatabase("Cantina", Context.MODE_PRIVATE, null);

        StringBuilder sql = new StringBuilder();
        Cursor valida = db.rawQuery("SELECT _id FROM USUARIO WHERE login='"+login+"'"+"and senha='"+senha+"'", null);
        valida.moveToFirst();

        if(valida.getCount() == 1) {
            usuarioLogado = Integer.parseInt((valida.getString(valida.getColumnIndex("_id"))));
            db.close();
            return true;
        }
        db.close();
        return false;
    }

    private void setUsuarioLogado() {
        db = openOrCreateDatabase("Cantina", Context.MODE_PRIVATE, null);
        String query = "UPDATE usuario_logado SET id_logado="+usuarioLogado;
        try {
            db.execSQL(query);
        } catch(Exception e) {
            e.printStackTrace();
        }
        db.close();
    }

}

