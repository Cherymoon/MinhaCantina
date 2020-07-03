package com.example.minhacantina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class PedidosActivity extends AppCompatActivity {

    SQLiteDatabase db;
    ListView listaPedidos;
    TextView txtTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);

        listaPedidos = findViewById(R.id.listaPedidos);
        txtTop = findViewById(R.id.txtTop);

        listarPedidos();
    }

    public void listarPedidos() {
        db = openOrCreateDatabase("Cantina", Context.MODE_PRIVATE, null);

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pedido p LEFT JOIN USUARIO_LOGADO log on log.id_logado = p.id_usuario where p.id_usuario = log.id_logado");

        Cursor c = db.rawQuery("SELECT login FROM USUARIO u where u._id = (SELECT * FROM USUARIO_LOGADO)", null);
        c.moveToFirst();
        String usuario = c.getString(c.getColumnIndex("login"));
        char aux = usuario.toUpperCase().charAt(0);
        txtTop.setText("Pedidos de "+aux+usuario.substring(1));

        Cursor dados = db.rawQuery(sql.toString(), null);
        String[] from = new String[] {"_id","descricao","foto_url","id_usuario"};
        int[] to = new int[] {R.id.idPedido, R.id.dsPedido, R.id.idFoto, R.id.idUsuario};

        SimpleCursorAdapter scAdapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.item_pedido, dados, from, to, 0);
        listaPedidos.setAdapter(scAdapter);

        db.close();
    }
}
