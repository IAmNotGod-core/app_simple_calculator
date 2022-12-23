package com.iamnotgod.calculator;

public class Record {

    private String number1, number2, result;
    private String operator;

    public Record(String number1, String operator, String number2, String result) {
        this.number1 = number1;
        this.operator = operator;
        this.number2 = number2;
        this.result = result;
    }

    public String getNumber1() {
        return number1;
    }

    public String getNumber2() {
        return number2;
    }

    public String getResult() {
        return result;
    }

    public String getOperator() {
        return operator;
    }
}
