package com.example.conexionbbddlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;



public class DbHelper extends SQLiteOpenHelper {



    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "ejemplo.db";
    private static final String TABLE_USUARIOS = "usuarios";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private EditText inputUsuario, inputContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputUsuario = findViewById(R.id.input_usuario);
        inputContrasena = findViewById(R.id.input_contrasena);

        Button btn = findViewById(R.id.button4);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Obtener los valores de los campos de texto
                String correo = inputUsuario.getText().toString().trim();
                String contrasena = inputContrasena.getText().toString().trim();

                // Insertar datos en la base de datos
                DbHelper dbhelper = new DbHelper(MainActivity.this);
                long id = dbhelper.insertarUsuario(correo, contrasena);

                if (id != -1) {
                    Toast.makeText(MainActivity.this, "Usuario insertado con ID: " + id, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Error al insertar usuario", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE usuarios");
        onCreate(db);
    }

    public long insertarUsuario(String correo, String psd) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("correo", correo);
        values.put("psd", psd);
        // Insertando fila
        long id = db.insert(TABLE_USUARIOS, null, values);
        // Cerrando la conexión a la base de datos
        db.close();
        return id;
    }
}

