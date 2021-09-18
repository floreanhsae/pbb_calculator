package com.example.new_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ast.Scope;

public class MainActivity extends AppCompatActivity {

    Button btnZero,btnOne,btnTwo,btnThree,btnFour,btnFive,btnSix,btnSeven,btnEight,btnNine,
            btnTitik,btnKurung,btnKurang,btnClear,btnPersen,btnPlus,btnBagi,btnKali,btnEqual;
    TextView tvInput, tvOutput;
    String process;
    boolean checkBracket = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnZero = findViewById(R.id.btnZero);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);

        btnPlus = findViewById(R.id.btnPlus);
        btnKurang = findViewById(R.id.btnKurang);
        btnKali = findViewById(R.id.btnKali);
        btnBagi = findViewById(R.id.btnBagi);

        btnClear = findViewById(R.id.btnClear);
        btnKurung = findViewById(R.id.btnKurung);
        btnPersen = findViewById(R.id.btnPersen);
        btnTitik = findViewById(R.id.btnTitik);
        btnEqual = findViewById(R.id.btnEqual);

        tvInput = findViewById(R.id.tvInput);
        tvOutput = findViewById(R.id.tvOutput);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvInput.setText("");
                tvOutput.setText("");
            }
        });

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "0");
            }
        });

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "1");
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "2");
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "3");
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "4");
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "5");
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "6");
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "7");
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "8");
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "9");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "+");
            }
        });

        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "-");
            }
        });

        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "/");
            }
        });

        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "x");
            }
        });

        btnTitik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + ".");
            }
        });

        btnPersen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();
                tvInput.setText(process + "%");
            }
        });

        btnKurung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBracket) {
                    process = tvInput.getText().toString();
                    tvInput.setText(process + ")");
                    checkBracket = false;
                } else {
                    process = tvInput.getText().toString();
                    tvInput.setText(process + "(");
                    checkBracket = true;
                }
            }
        });

         btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process = tvInput.getText().toString();

                process = process.replaceAll("x","*");
                process = process.replaceAll("%", "/100");

                Context rhino = Context.enter();

                rhino.setOptimizationLevel(-1);

                String finalResult = "";

                try {
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalResult = rhino.evaluateString(scriptable,process, "javascript", 1, null).toString();
                } catch (Exception e) {
                    finalResult = "0";
                }

                tvOutput.setText(finalResult);
            }
        });
    }
}