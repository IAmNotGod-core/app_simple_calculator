package com.iamnotgod.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    RadioGroup operator;
    RadioButton operatorButton;
    TextView resultView;
    Button total;
    RecyclerView recList;
    ArrayList<Record> listRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.inputN1);
        number2 = findViewById(R.id.inputN2);
        operator = findViewById(R.id.operator);
        resultView = findViewById(R.id.txtResult);
        total = findViewById(R.id.btnTotal);
        recList = findViewById(R.id.recList);
        initData();

        recList.setAdapter(new RecordAdapter(listRecord));
        recList.setLayoutManager(new LinearLayoutManager(this));

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

    private void initData() {
        this.listRecord = new ArrayList<>();
        listRecord.add(new Record("10", "+", "5", "15"));
        listRecord.add(new Record("20", "÷", "2", "10"));
        listRecord.add(new Record("15", "-", "5", "10"));
        listRecord.add(new Record("5", "×", "5", "25"));
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