package com.example.calculosueldo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class CalcularSueldo extends AppCompatActivity {

    private TextView tvResponse;
    private String response = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_sueldo);
        tvResponse = (TextView)findViewById(R.id.tvResponse);
        Bundle bundle = getIntent().getExtras();
        String nombre1 = bundle.getString("etNombre1");
        Double horas1 = Double.parseDouble(bundle.getString("etHoras1"));
        String cargo1 = bundle.getString("spCargo1");
        String nombre2 = bundle.getString("etNombre2");
        Double horas2 = Double.parseDouble(bundle.getString("etHoras2"));
        String cargo2 = bundle.getString("spCargo2");
        String nombre3 = bundle.getString("etNombre3");
        Double horas3 = Double.parseDouble(bundle.getString("etHoras3"));
        String cargo3 = bundle.getString("spCargo3");
        double sueldo1 = getSueldoBase(horas1);
        double sueldo2 = getSueldoBase(horas2);
        double sueldo3 = getSueldoBase(horas3);
        int status = verifyCargo(cargo1, cargo2, cargo3);
        double sl = getSueldoLiquido(sueldo1);
        double bn = getBono(sueldo1, cargo1, status);
        response += "\n El sueldo de " + nombre1 + " con cargo " + cargo1 + " es:";
        response += "\n Sueldo Base: $" + sueldo1 + "\n\t ISSS: $" + Math.round(sueldo1*0.0525) + "\n\t AFP: $" + Math.round(sueldo1*0.0688) + "\n\t Renta: $" + Math.round(sueldo1*0.1);
        response += "\n Sueldo Liquido: $" + sl + "\n Bono: $" + bn;
        response += "\n Teniendo un Sueldo Liquido Total De: $" +  (sl + bn);
        if ((sl+bn) > 300) response += " y es mayor a $300";
        if (verifyMasSueldo(sueldo1, sueldo2, sueldo3) == 1) response += "\n Este salario es el mayor \n";
        else if (verifyMenosSueldo(sueldo1, sueldo2, sueldo3) == 1) response += "\n Este salario es el menor \n";
        sl = getSueldoLiquido(sueldo2);
        bn = getBono(sueldo2, cargo2, status);
        response += "\n El sueldo de " + nombre2 + " con cargo " + cargo2 + " es:";
        response += "\n Sueldo Base: $" + sueldo2 + "\n\t ISSS: $" + Math.round(sueldo2*0.0525) + "\n\t AFP: $" + Math.round(sueldo2*0.0688) + "\n\t Renta: $" + Math.round(sueldo2*0.1);
        response += "\n Sueldo Liquido: $" + sl + "\n Bono: $" + bn;
        response += "\n Teniendo un Sueldo Liquido Total De: $" +  (sl + bn);
        if ((sl+bn) > 300) response += " y es mayor a $300";
        if (verifyMasSueldo(sueldo1, sueldo2, sueldo3) == 2) response += "\n Este salario es el mayor ";
        else if (verifyMenosSueldo(sueldo1, sueldo2, sueldo3) == 2) response += "\n Este salario es el menor";
        sl = getSueldoLiquido(sueldo3);
        bn = getBono(sueldo3, cargo3, status);
        response += "\n El sueldo de " + nombre3 + " con cargo " + cargo3 + " es:";
        response += "\n Sueldo Base: $" + sueldo3 + "\n\t ISSS: $" + Math.round(sueldo3*0.0525) + "\n\t AFP: $" + Math.round(sueldo3*0.0688) + "\n\t Renta: $" + Math.round(sueldo3*0.1);
        response += "\n Sueldo Liquido: $" + sl + "\n Bono: $" + bn;
        response += "\n Teniendo un Sueldo Liquido Total De: $" +  (sl + bn);
        if ((sl+bn) > 300) response += " y es mayor a $300";
        if (verifyMasSueldo(sueldo1, sueldo2, sueldo3) == 3) response += "\n Este salario es el mayor \n";
        else if (verifyMenosSueldo(sueldo1, sueldo2, sueldo3) == 3) response += "\n Este salario es el menor \n";
        tvResponse.setText(response);
    }

    public double getSueldoBase(double horas){
        double sueldoBase;
        if(horas <= 160)
            sueldoBase = horas * 9.75;
        else
            sueldoBase = ((horas - 160) * 11.50) + 1560;
        return sueldoBase;
    }

    public double getSueldoLiquido(double sueldo){
        double sueldoLiquido = Math.round(sueldo * 0.7787);
        return Math.round(sueldoLiquido);
    }

    public double getBono(double sueldo, String cargo, int state){
        double bono;
        if(state == 0) {
            bono = 0;
            Toast.makeText(this, "Horas Trabajadas Deben Ser Mayores Que Cero", Toast.LENGTH_SHORT).show();
        }
        else {
            if(cargo.equals("Gerente"))
                bono = sueldo * 0.1;
            else if(cargo.equals("Asistente"))
                bono = sueldo * 0.05;
            else if (cargo.equals("Secretaria"))
                bono = sueldo * 0.03;
            else
                bono = sueldo * 0.02;
        }
        return Math.round(bono);
    }

    public int verifyCargo(String c1, String c2, String c3){
        if (c1.equals("Gerente") && c2.equals("Asistente") && c3.equals("Secretaria"))
            return 0;
        else
            return 1;
    }

    public int verifyMasSueldo(double s1, double s2, double s3){
        if (s1 > s2 && s1 > s3)
            return 1;
        else if(s2 > s1 && s2 > s3)
            return 2;
        else
            return 3;
    }

    public int verifyMenosSueldo(double s1, double s2, double s3){
        if (s1 < s2 && s1 < s3)
            return 1;
        else if(s2 < s1 && s2 < s3)
            return 2;
        else
            return 3;
    }

    public void regresar(){
        finish();
    }


}