package com.example.formulageneral;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Math.sqrt;

public class MainActivity extends AppCompatActivity {

    private EditText edtValueA;
    private EditText edtValueB;
    private EditText edtValueC;
    private TextView txvResult;
    private Button btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtValueA = (EditText)findViewById(R.id.edtValora);
        edtValueB = (EditText)findViewById(R.id.edtValorb);
        edtValueC = (EditText)findViewById(R.id.edtValorc);
        txvResult = (TextView)findViewById(R.id.txvResult);
        btnResult = (Button)findViewById(R.id.btnResult);
        btnResult.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                txvResult.setText("");
                double a = Double.parseDouble(edtValueA.getText().toString());
                double b = Double.parseDouble(edtValueB.getText().toString());
                double c = Double.parseDouble(edtValueC.getText().toString());
                double x1 = ((-1) * b + sqrt((b * b) - 4 * a * c)) / 2 * a;
                double x2 = ((-1) * b - sqrt((b * b) - 4 * a * c)) / 2 * a;
                txvResult.setText("X1 es igual a  " + x1 + "\nX2 es igual a " + x2);
            }
        });

    }

}