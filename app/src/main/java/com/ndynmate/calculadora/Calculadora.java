package com.ndynmate.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

import org.mariuszgromada.math.mxparser.Expression;

public class Calculadora extends AppCompatActivity {

    private static EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.display).equals(display.getText().toString())) {
                    display.setText("");
                }
            }
        });
    }

    private void actualizaDisplay(String nuevoString) {
        String viejoString = display.getText().toString();
        int posicionCursor = display.getSelectionStart();
        String izquierda = viejoString.substring(0, posicionCursor);
        String derecha = viejoString.substring(posicionCursor);

        if (getString(R.string.display).equals(display.getText().toString())) {
            display.setText(nuevoString);
            display.setSelection(posicionCursor + 1);
        } else {
            display.setText(String.format("%s%s%s", izquierda, nuevoString, derecha));
            display.setSelection(posicionCursor + 1);
        }
    }

    public void onClickBtnSiete(View view) {
        actualizaDisplay("7");
    }

    public void onClickBtnOcho(View view) {
        actualizaDisplay("8");
    }

    public void onClickBtnNueve(View view) {
        actualizaDisplay("9");
    }

    public void onClickBtnCuatro(View view) {
        actualizaDisplay("4");
    }

    public void onClickBtnCinco(View view) {
        actualizaDisplay("5");
    }

    public void onClickBtnSeis(View view) {
        actualizaDisplay("6");
    }

    public void onClickBtnUno(View view) {
        actualizaDisplay("1");
    }

    public void onClickBtnDos(View view) {
        actualizaDisplay("2");
    }

    public void onClickBtnTres(View view) {
        actualizaDisplay("3");
    }

    public void onClickBtnCero(View view) {
        actualizaDisplay("0");
    }

    public void onClickClear(View view) {
        display.setText("0");
    }

    public void onClickBackspace(View view) {
        int posicionCursor = display.getSelectionStart();
        int textoLength = display.getText().length();
        if (posicionCursor != 0 && textoLength != 0) {
            SpannableStringBuilder select = (SpannableStringBuilder) display.getText();
            select.replace(posicionCursor - 1, posicionCursor, "");
            display.setText(select);
            display.setSelection(posicionCursor - 1);
        }
    }

    public void onClickPorcentaje(View view) {
        actualizaDisplay("%");
    }

    public void onClickParentesis(View view) {
        int cursorPosicion = display.getSelectionStart();
        int abreParent = 0;
        int cierraParent = 0;
        int textoLength = display.getText().length();

        for (int i = 0; i < cursorPosicion; i++) {
            if (display.getText().toString().substring(i, i + 1).equals("(")) {
                abreParent += 1;
            }
            if (display.getText().toString().substring(i, i + 1).equals(")")) {
                cierraParent += 1;
            }
        }

        if (abreParent == cierraParent || display.getText().toString().substring(textoLength - 1, textoLength).equals("(")) {
            actualizaDisplay("(");
        } else if (cierraParent < abreParent && !display.getText().toString().substring(textoLength - 1, textoLength).equals("(")) {
            actualizaDisplay(")");
        }

        display.setSelection(cursorPosicion + 1);

    }

    public void onClickBtnPunto(View view) {
        actualizaDisplay(".");
    }

    public void onClickBtnIgual(View view) {
        String operacion = display.getText().toString();
        Expression math = new Expression(operacion);
        String resultado = String.valueOf(math.calculate());
        display.setText(resultado);
        display.setSelection(resultado.length());
    }

    public void onClickBtnSuma(View view) {
        actualizaDisplay("+");
    }

    public void onClickMultiplica(View view) {
        actualizaDisplay("*");
    }

    public void onClickResta(View view) {
        actualizaDisplay("-");
    }

    public void onClickBtnDivide(View view) {
        actualizaDisplay("/");
    }

    public void onClickBtnExponente(View view) {
        actualizaDisplay("^");
    }

    public void onClickBtnRaiz(View view) {
        String operacion = display.getText().toString();
        double resultado = Math.sqrt(Double.parseDouble(operacion));
        resultado = Math.round(resultado * 100.0) / 100.0;
        display.setText(String.valueOf(resultado));
        display.setSelection(String.valueOf(resultado).length());
    }

    public void onClickBtnArea(View view) {
        Double radio = Double.parseDouble(display.getText().toString());
        double area = Math.PI * Math.pow(radio, 2);
        area = Math.round(area * 100.0) / 100.0;
        display.setText(String.valueOf(area));
        display.setSelection(String.valueOf(area).length());
    }

    public void onClickBtnLongitud(View view) {
        Double radio = Double.parseDouble(display.getText().toString());
        double diametro = 2 * Math.PI * radio;
        diametro = Math.round(diametro * 100.0) / 100.0;
        display.setText(String.valueOf(diametro));
        display.setSelection(String.valueOf(diametro).length());
    }
}