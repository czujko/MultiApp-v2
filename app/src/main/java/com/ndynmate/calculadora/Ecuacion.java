package com.ndynmate.calculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class Ecuacion extends AppCompatActivity implements View.OnClickListener {
    EditText txtA, txtB, txtC;
    Button btnResultadoEcuacion;
    TextView viewResultadoEcuacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecuacion);

        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
        txtC = findViewById(R.id.txtC);

        btnResultadoEcuacion = findViewById(R.id.btnResultadoEcuacion);
        viewResultadoEcuacion = findViewById(R.id.viewResultadoEcuacion);

        Button volver = findViewById(R.id.btnVolverDeEcuacion);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(String.valueOf(MainActivity.class));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        double a = Double.parseDouble(txtA.getText().toString());
        double b = Double.parseDouble(txtB.getText().toString());
        double c = Double.parseDouble(txtC.getText().toString());

        double discriminante = Math.pow(b, 2) - (4 * a * c);

        if (discriminante >= 0) {
            double[] resultado;
            if (discriminante == 0) {
                resultado = new double[1];
                resultado[0] = ((-b) - (4 * a * c)) / (2 * a);
            } else {
                resultado = new double[2];
                resultado[0] = ((-b) + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
                resultado[1] = ((-b) - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
            }
            String resultadoTxt = Arrays.toString(resultado);

            viewResultadoEcuacion.setText(resultadoTxt);
        } else {
            viewResultadoEcuacion.setText("Operación no válida");
        }
    }
}