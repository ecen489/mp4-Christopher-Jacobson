package com.hfad.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button add;
    private Button sub;
    private Button mul;
    private Button dec;
    private Button clear;
    private Button equal;
    private TextView userInput;
    private TextView result;
    private final char ADD = '+';
    private final char SUB = '-';
    private final char MUL = 'x';
    private final char DIV = '/';
    private final char EQU = 0;
    private double val1 = Double.NaN;
    private double val2;
    private char OPERATION;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText().toString() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText().toString() + "9");
            }
        });

        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(userInput.getText().toString() + ".");
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                OPERATION = SUB;
                result.setText(String.valueOf(val1) + "-");
                userInput.setText(null);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                OPERATION = ADD;
                result.setText(String.valueOf(val1) + "+");
                userInput.setText(null);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                OPERATION = MUL;
                result.setText(String.valueOf(val1) + "x");
                userInput.setText(null);
            }
        });

        /*div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                OPERATION = DIV;
                result.setText(String.valueOf(val1) + "/");
                userInput.setText(null);
            }
        });
        */
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                OPERATION = EQU;
                result.setText(result.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                // 5 + 4 = 9
                userInput.setText(null);
            }
        });


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userInput.getText().length() > 0) {
                    CharSequence name = userInput.getText().toString();
                    userInput.setText(name.subSequence(0, name.length() - 1));
                } else {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    userInput.setText(null);
                    result.setText(null);
                }
            }
        });

    }
    private void setupUI(){
        zero = (Button)findViewById(R.id.btn0);
        one = (Button)findViewById(R.id.btn1);
        two = (Button)findViewById(R.id.btn2);
        three = (Button)findViewById(R.id.btn3);
        four = (Button)findViewById(R.id.btn4);
        five = (Button)findViewById(R.id.btn5);
        six = (Button)findViewById(R.id.btn6);
        seven = (Button)findViewById(R.id.btn7);
        eight = (Button)findViewById(R.id.btn8);
        nine = (Button)findViewById(R.id.btn9);
        add = (Button)findViewById(R.id.btnadd);
        sub = (Button)findViewById(R.id.btnsub);
        mul = (Button)findViewById(R.id.btnmul);
        dec = (Button)findViewById(R.id.btndec);
        equal = (Button)findViewById(R.id.btnequ);
        clear = (Button)findViewById(R.id.btnclear);
        userInput = (TextView)findViewById(R.id.tvinfo);
        result = (TextView)findViewById(R.id.tvres);
    }

    private void compute(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(userInput.getText().toString());

            switch(OPERATION){
                case ADD:
                    val1 = val1 + val2;
                    break;
                case SUB:
                    val1 = val1 - val2;
                    break;
                case MUL:
                    val1 = val1 * val2;
                    break;
                //case DIV:
                    //val1 = val1 / val2;
                    //break;
                case EQU:
                    break;
            }
        }
        else{
            val1 = Double.parseDouble(userInput.getText().toString());
        }

    }
}
