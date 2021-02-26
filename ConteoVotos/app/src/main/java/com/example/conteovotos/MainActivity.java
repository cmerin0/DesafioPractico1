package com.example.conteovotos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.sqrt;

public class MainActivity extends AppCompatActivity {

    private EditText etVotos;
    private Button btnContar;
    private TextView tvResultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etVotos = (EditText)findViewById(R.id.etVotos);
        btnContar = (Button)findViewById(R.id.btnContar);
        tvResultados = (TextView)findViewById(R.id.tvResultados);

        btnContar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getVotes();
            }
        });

    }

    public void getVotes(){
        tvResultados.setText("HOLA MUNDO DESDE JAVA");
        String totalVotos = etVotos.getText().toString().replace(" ", "");
        String votos [] = totalVotos.split(",");
        int n = votos.length;
        int a = 0, b = 0, c = 0, d = 0, x = 0;
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(votos[i]);
            switch (v) {
                case 1: a++; break;
                case 2: b++; break;
                case 3: c++; break;
                case 4: d++; break;
                default: x++; break;
            }
        }
        String res = "Resultado de los votos de un total de " + n + " es: ";
        res += "\n 1. Messi: " + a + " votos (" + Math.round((a*1.0 / n) * 100) + "%)";
        res += "\n 2. Cristiano: " + b + " votos (" + Math.round((b*1.0 / n) * 100) + "%)";
        res += "\n 3. Neymar: " + c + " votos (" + Math.round((c*1.0 / n) * 100) + "%)";
        res += "\n 4. Chicharito: " + d + " votos (" + Math.round((d*1.0 / n) * 100) + "%)";
        res += "\n Con un total de " + x + " votos nulos (" + Math.round((x*1.0 / n) * 100) + "%)";
        tvResultados.setText(res);
    }

}