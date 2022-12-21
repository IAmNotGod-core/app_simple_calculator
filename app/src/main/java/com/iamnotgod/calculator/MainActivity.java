package com.iamnotgod.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    RadioGroup operator;
    RadioButton operatorButton;
    TextView resultView;
    Button total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.inputN1);
        number2 = findViewById(R.id.inputN2);
        operator = findViewById(R.id.operator);
        resultView = findViewById(R.id.txtResult);
        total = findViewById(R.id.btnTotal);
        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int oprId = operator.getCheckedRadioButtonId();
                operatorButton = findViewById(oprId);

                if (oprId == R.id.oprAdd) {
                    Add();
                }
                else if (oprId == R.id.oprSubtract) {
                    Subtract();
                }
                else if (oprId == R.id.oprMultiply) {
                    Multiply();
                }
                else if (oprId == R.id.oprDivide) {
                    Divide();
                }
            }
        });
    }

    public void Add() {
        float n1 = Float.parseFloat(number1.getText().toString());
        float n2 = Float.parseFloat(number2.getText().toString());

        float result = n1 + n2;
        resultView.setText(""+result);

    }

    public void Subtract() {
        float n1 = Float.parseFloat(number1.getText().toString());
        float n2 = Float.parseFloat(number2.getText().toString());

        float result = n1 - n2;
        resultView.setText(""+result);

    }

    public void Multiply() {
        float n1 = Float.parseFloat(number1.getText().toString());
        float n2 = Float.parseFloat(number2.getText().toString());

        float result = n1 * n2;
        resultView.setText(""+result);

    }

    public void Divide() {
        float n1 = Float.parseFloat(number1.getText().toString());
        float n2 = Float.parseFloat(number2.getText().toString());

        float result = n1 / n2;
        resultView.setText(""+result);

    }
}