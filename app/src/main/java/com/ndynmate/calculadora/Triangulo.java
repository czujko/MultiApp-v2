package com.ndynmate.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Triangulo extends AppCompatActivity implements View.OnClickListener {
    EditText txtBase, txtAltura;
    Button resultado;
    TextView viewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo);

        txtBase = (EditText) findViewById(R.id.txtBase);
        txtAltura = (EditText) findViewById(R.id.txtAltura);

        resultado = findViewById(R.id.btnResultado);
        viewResultado = findViewById(R.id.viewResultado);

        viewResultado.setOnClickListener(this);
    }

    public void onClick(View view) {
        Double base = Double.parseDouble(txtBase.getText().toString());
        Double altura = Double.parseDouble(txtAltura.getText().toString());

        double result = (base * altura) / 2;
        result = Math.round(result*100.0)/100.0;

        viewResultado.setText(String.valueOf(result));
    }
}