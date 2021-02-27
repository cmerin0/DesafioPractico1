package com.example.calculosueldo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static java.lang.Math.sqrt;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre1, etNombre2, etNombre3;
    private EditText etHoras1, etHoras2, etHoras3;
    private Spinner spCargo1, spCargo2, spCargo3;
    private Button btnCalcularSueldo;
    private int r = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombre1 = (EditText)findViewById(R.id.etNombre1);
        etNombre2 = (EditText)findViewById(R.id.etNombre2);
        etNombre3 = (EditText)findViewById(R.id.etNombre3);
        etHoras1 = (EditText)findViewById(R.id.etHoras1);
        etHoras2 = (EditText)findViewById(R.id.etHoras2);
        etHoras3 = (EditText)findViewById(R.id.etHoras3);
        spCargo1 = (Spinner)findViewById(R.id.spCargo1);
        spCargo2 = (Spinner)findViewById(R.id.spCargo2);
        spCargo3 = (Spinner)findViewById(R.id.spCargo3);
        btnCalcularSueldo = (Button)findViewById(R.id.btnCalcular);
        String [] op = {"Gerente", "Asistente", "Secretaria"};
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, op);
        spCargo1.setAdapter(adapter);
        spCargo2.setAdapter(adapter);
        spCargo3.setAdapter(adapter);
        btnCalcularSueldo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                validar();
            }
        });
    }

    public void validar(){
        r = 0;
        String nombre1 = etNombre1.getText().toString();
        String nombre2 = etNombre2.getText().toString();
        String nombre3 = etNombre3.getText().toString();
        String horas1 = etHoras1.getText().toString();
        String horas2 = etHoras2.getText().toString();
        String horas3 = etHoras3.getText().toString();
        if (nombre1.equals("") || nombre2.equals("") || nombre3.equals(""))
            Toast.makeText(this, "Por Favor, Ingrese todos los campos de Nombre", Toast.LENGTH_SHORT).show();
        else r++;
        if(horas1.equals("") || horas2.equals("") || horas3.equals(""))
            Toast.makeText(this, "Por Favor, Ingrese todos los campos de Horas Trabajadas", Toast.LENGTH_SHORT).show();
        else {
            double h1 = Double.parseDouble(horas1);
            double h2 = Double.parseDouble(horas2);
            double h3 = Double.parseDouble(horas3);
            if(h1 <= 0 || h2 <= 0 || h3 <= 0)
                Toast.makeText(this, "Horas Trabajadas Deben Ser Mayores Que Cero", Toast.LENGTH_SHORT).show();
            else r++;
        }
        if(r == 2){
            Intent i = new Intent(getApplicationContext(), CalcularSueldo.class);
            i.putExtra("etNombre1", nombre1);
            i.putExtra("etHoras1", horas1);
            i.putExtra("spCargo1", spCargo1.getSelectedItem().toString());
            i.putExtra("etNombre2", nombre2);
            i.putExtra("etHoras2", horas2);
            i.putExtra("spCargo2", spCargo2.getSelectedItem().toString());
            i.putExtra("etNombre3", nombre3);
            i.putExtra("etHoras3", horas3);
            i.putExtra("spCargo3", spCargo3.getSelectedItem().toString());
            startActivity(i);
        }
    }

}