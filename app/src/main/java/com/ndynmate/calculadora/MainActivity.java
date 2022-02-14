package com.ndynmate.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCalculadora:
                setContentView(R.layout.activity_calculadora);
                break;
            case R.id.btnTriangulo:
                setContentView(R.layout.activity_triangulo);
                break;
            case R.id.btnEcuacion:
                setContentView(R.layout.activity_ecuacion);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCalculadora = findViewById(R.id.btnCalculadora);
        btnCalculadora.setOnClickListener(this);

    }
}