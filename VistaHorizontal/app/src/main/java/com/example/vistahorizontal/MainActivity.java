package com.example.vistahorizontal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String PULSADO = "pulsado";
    private static final String TEXTO_INTRODUCIDO = "texto";
    private EditText etTexto;
    private Button btnBoton;
    private TextView tvTexto;
    private boolean pulsado;
    private String textoIntroducido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTexto = (EditText) findViewById(R.id.et_texto);
        btnBoton = (Button) findViewById(R.id.btn_boton);
        tvTexto = (TextView) findViewById(R.id.tv_texto);

        restaurarCampos(savedInstanceState);

        btnBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = etTexto.getText().toString();
                if (!texto.isEmpty()) {
                    textoIntroducido = etTexto.getText().toString();
                    pulsado = true;
                    mostrarTextView();
                }
            }
        });


        if (pulsado) {
            mostrarTextView();
        }
    }

    public void mostrarTextView() {
        tvTexto.setText(textoIntroducido);
        tvTexto.setVisibility(View.VISIBLE);
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (pulsado) {
            outState.putBoolean(PULSADO, pulsado);
            outState.putString(TEXTO_INTRODUCIDO, textoIntroducido);
        }
    }

    private void restaurarCampos(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean(PULSADO, false)) {
                this.pulsado = savedInstanceState.getBoolean(PULSADO);
                this.textoIntroducido = savedInstanceState.getString(TEXTO_INTRODUCIDO, "");
            }
        }
    }


}
