package com.example.salario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final EditText Editextnombre = findViewById(R.id.nombre);
        EditText Editexthoras = findViewById(R.id.horas);
        Button btnClacular = findViewById(R.id.btn_calculo);

        btnClacular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = Editextnombre.toString(),
                        horas = Editexthoras.getText().toString();
                if (nombre.isEmpty()||horas.isEmpty()) return;

                int horaTrabajo = Integer.parseInt(horas);

                final double ValorHoras = 8.50;

                double horatotal = horaTrabajo * ValorHoras;
                double descuentoAFP = horatotal * 0.03;
                double descuentoISS =  horatotal * 0.02;
                double descuentoRenta = horatotal * 0.04;
                double totalsalario = horatotal - descuentoAFP - descuentoISS - descuentoRenta;

                Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
                intent.putExtra("horatotal", horatotal);
                intent.putExtra("descuentoAFP", descuentoAFP);
                intent.putExtra("descuentoISS", descuentoISS);
                intent.putExtra("descuentoRenta", descuentoRenta);
                intent.putExtra("totalsalario", totalsalario);

                startActivity(intent);



            }
        });
    }



}