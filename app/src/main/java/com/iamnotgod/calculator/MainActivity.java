package com.iamnotgod.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    RadioGroup operator;
    RadioButton operatorButton;
    TextView resultView;
    Button total;
    RecyclerView recList;
    ArrayList<Record> listRecord;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Gson gson;

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
        buildRecylerView();

        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calculate();
            }
        });
    }

    private void saveData() {
        sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        gson = new Gson();
        String json = gson.toJson(listRecord);
        editor.putString("record list", json).apply();
    }

    private void initData() {
        sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        gson = new Gson();
        String json = sharedPreferences.getString("record list", null);
        Type type = new TypeToken<ArrayList<Record>>() {}.getType();
        listRecord = gson.fromJson(json, type);

        if (listRecord == null) {
            listRecord = new ArrayList<>();
        }
    }

    private void buildRecylerView() {
        recList.setHasFixedSize(true);
        recList.setLayoutManager(new LinearLayoutManager(this));
        recList.setAdapter(new RecordAdapter(listRecord));
    }

    private void Calculate() {
        float n1 = Float.parseFloat(number1.getText().toString());
        float n2 = Float.parseFloat(number2.getText().toString());
        float result = 0;
        String opr = "";

        int oprId = operator.getCheckedRadioButtonId();
        operatorButton = findViewById(oprId);

        if (oprId == R.id.oprAdd) {
            result = n1 + n2;
            opr = "+";
            saveData();
        }
        else if (oprId == R.id.oprSubtract) {
            result = n1 - n2;
            opr = "-";
            saveData();
        }
        else if (oprId == R.id.oprMultiply) {
            result = n1 * n2;
            opr = "×";
            saveData();
        }
        else if (oprId == R.id.oprDivide) {
            result = n1 / n2;
            opr = "÷";
            saveData();
        }
        resultView.setText(""+result);
        listRecord.add(new Record(String.valueOf(n1), opr, String.valueOf(n2), String.valueOf(result)));
    }
}