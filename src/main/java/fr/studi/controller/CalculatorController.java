package fr.studi.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class CalculatorController {

    public String input = "";
    public String operator = "";
    public String number1 = "";
    public String number2 = "";
    public String memory = "";

    @FXML
    private Label screen;
    @FXML
    private Label screenMemory;


    //Input chiffres
    public void input1() {
        inputNumber("1");
    }
    public void input2() {
        inputNumber("2");
    }
    public void input3() {
        inputNumber("3");
    }
    public void input4() {
        inputNumber("4");
    }
    public void input5() {
        inputNumber("5");
    }
    public void input6() {
        inputNumber("6");
    }
    public void input7() {
        inputNumber("7");
    }
    public void input8() {
        inputNumber("8");
    }
    public void input9() {
        inputNumber("9");
    }
    public void input0() {
        inputNumber("0");
    }

    //Input operators
    public void setAddition() {
        inputOperator("+");
    }
    public void setSubstract() {
        inputOperator("-");
    }
    public void setMultiply() {
        inputOperator("x");
    }
    public void setDivide() {
        inputOperator("/");
    }

    //Input special buttons
    //Clears screen, input & operator
    public void clear() {
        input = "";
        operator = "";
        screen.setText("");
        screenMemory.setText("");
    }
    // allows negative numbers
    public void negativeNum() {
        String negativeNum = "-";
        int index = 0;
        StringBuffer negativeInput = new StringBuffer(input);
        negativeInput.insert(index, negativeNum);
        input = String.valueOf(negativeInput);
        screen.setText(input);
    }
    //allows decimals
    public void inputComa() {
        inputNumber(".");
    }

    //Input equals : do the math!
    public void doMaths() {
        if ((input.isEmpty())) {
            screen.setText("You must input a number");
        } else if (operator.isEmpty()) {
            screen.setText("You must select an operation");
        }else {
            number2 = input;
            input = "";
            memory += number2;
            double number1Double = Double.parseDouble(number1);
            double number2Double = Double.parseDouble(number2);
            double result;

            switch (operator) {
                //addition
                case "+":
                    result = number1Double + number2Double;
                    screen.setText(String.valueOf(result));
                    memory += " = " + result;
                    break;
                case "-":
                    result = number1Double - number2Double;
                    screen.setText(String.valueOf(result));
                    memory += " = " + result;
                    break;
                case "x":
                    result = number1Double * number2Double;
                    screen.setText(String.valueOf(result));
                    memory += " = " + result;
                    break;
                case "/":
                    if (number2Double == 0) {
                        screen.setText("Division by zero not possible");
                        break;
                    } else {
                        result = number1Double / number2Double;
                        screen.setText(String.valueOf(result));
                        memory += " = " + result;
                        break;
                    }
            }
            screenMemory.setText(memory);
        }
    }

    //Take the current input and fills the string number in
    private void inputNumber(String number) {
        input += number;
        screen.setText(input);
    }

    //Saves the input for future use, clears it and save the operator for future use + prepares input for number2
    private void inputOperator(String s) {
        if (input.isEmpty()) {
            screen.setText("You must first enter a number");
        } else {
            operator = "";
            operator += s;
            number1 = input;
            memory = number1 + operator;
            input = "";
            screen.setText(operator);
            screenMemory.setText(memory);
        }
    }



}


