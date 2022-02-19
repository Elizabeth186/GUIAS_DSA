package com.example.salario;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class ResultadoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle Instancia){
        super.onCreate(Instancia);
        setContentView(R.layout.activity_resultado);


        TextView DAFP =  findViewById(R.id.AFP);
        TextView DISS = findViewById(R.id.ISSS);
        TextView DRenta = findViewById(R.id.RENTA);
        TextView TOTALSA = findViewById(R.id.repuesta);

        Intent intent = getIntent();

        double descuentot = intent.getDoubleExtra("totalsalario", 0);
        double AFP = intent.getDoubleExtra("descuentoAFP", 0);
        double ISS = intent.getDoubleExtra("descuentoISS", 0);
        double RENTA = intent.getDoubleExtra("descuentoRenta",0);


        String mensajetotal = "Salario Final: "+(descuentot);
        String mensajeAFP =   "Descuento por AFP: "+(AFP);
        String mensajeISS =   "Descuento por ISSS: "+(ISS);
        String mensajeRENTA = "Descuento por Renta: "+(RENTA);


        DAFP.setText(mensajeAFP);
        DISS.setText(mensajeISS);
        DRenta.setText(mensajeRENTA);
        TOTALSA.setText(mensajetotal);


    }
}
