package com.example.calculator_walling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView display;
    String currEntry, op, s1, s2;
    boolean decimalCheck;
    double num1, num2;
    Button clear, clearEntry, changeSign, divide, plus, minus, multiply, equals, decimal,
            zero, one, two, three, four, five, six, seven, eight, nine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currEntry = " ";
        decimalCheck = true;
        display = findViewById(R.id.display);

        clear = findViewById(R.id.clear);
        clearEntry = findViewById(R.id.clearEntry);
        changeSign = findViewById(R.id.changeSign);
        divide = findViewById(R.id.divide);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        equals = findViewById(R.id.equals);
        decimal = findViewById(R.id.decimal);
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);

        //On click listeners
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearTotal();
            }
        });
        clearEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearEntry();
            }
        });
        changeSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeSign();
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTotal();
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChar("/");
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChar("+");
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChar("-");
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChar("*");
            }
        });
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChar(".");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChar("0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChar("1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChar("2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChar("3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChar("4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChar("5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChar("6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChar("7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChar("8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChar("9");
            }
        });
    }

    public void calculate(String op) {
        try {
            num1 = Double.parseDouble(s1);
            num2 = Double.parseDouble(s2);

            switch (op) {
                case "+":
                    num1 = num1 + num2;
                    break;
                case "-":
                    num1 = num1 - num2;
                    break;
                case "*":
                    num1 = num1 * num2;
                    break;
                case "/":
                    num1 = num1 / num2;
                    break;
            }
        }
        catch (Exception e){
            showError();
        }
    }

    public void showError() { display.setText("Error"); }
    public void updateTotal() { display.setText(currEntry); }

    public void clearTotal() {
        currEntry = "";
        s1 = ""; s2 = "";
        decimalCheck = true;
        updateTotal();
    }

    public void getTotal() {
        s2 = currEntry;
        calculate(op);

        currEntry = Double.toString(num1);
        updateTotal();

        decimalCheck = true;

    }

    public void clearEntry() {
        currEntry = "";
        decimalCheck = true;
        updateTotal();
    }

    public void changeSign() {
        if (currEntry.charAt(0) == '-') {
            currEntry = currEntry.substring(1);
        }
        else {
            currEntry = "-"+currEntry;
            currEntry = currEntry.replaceAll("\\s+","");
        }
        updateTotal();
    }

    public void addChar(String c) { //adds char to end of currEntry
        switch (c) {
            case "/":
                s1 = currEntry;
                currEntry = "";
                op = "/";
                decimalCheck = true;
                break;

            case "*":
                s1 = currEntry;
                currEntry = "";
                op = "*";
                decimalCheck = true;
                break;

            case "+":
                s1 = currEntry;
                currEntry = "";
                op = "+";
                decimalCheck = true;
                break;

            case "-":
                s1 = currEntry;
                currEntry = "";
                op = "-";
                decimalCheck = true;
                break;

            case ".":
                if (decimalCheck) {
                    currEntry += c;
                    decimalCheck = false;
                }
                break;
            case "0":
                currEntry += c;
                break;
            case "1":
                currEntry += c;
                break;
            case "2":
                currEntry += c;
                break;
            case "3":
                currEntry += c;
                break;
            case "4":
                currEntry += c;
                break;
            case "5":
                currEntry += c;
                break;
            case "6":
                currEntry += c;
                break;
            case "7":
                currEntry += c;
                break;
            case "8":
                currEntry += c;
                break;
            case "9":
                currEntry += c;
                break;
        }
        updateTotal();
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("s1", s1);
        bundle.putString("s2", s2);
        bundle.putString("op", op);
        bundle.putString("currEntry", display.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        s1 = savedInstanceState.getString("s1");
        s2 = savedInstanceState.getString("s2");
        op = savedInstanceState.getString("op");
        display.setText(savedInstanceState.getString("currEntry"));
    }


}
