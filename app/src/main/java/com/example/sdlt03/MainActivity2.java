package com.example.sdlt03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Button buttonNumber01, buttonNumber02;
    TextView scoresText, gameWelcomeText;
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String playerName = getIntent().getStringExtra("playerName");
        TextView tvWelcome = findViewById(R.id.gameWelcomeText);

        tvWelcome.setText("Welcome to Number Game,"+ playerName+"!");
        buttonNumber01 = findViewById(R.id.buttonNumber01);
        buttonNumber02 = findViewById(R.id.buttonNumber02);
        scoresText = findViewById(R.id.scoresText);
        gameWelcomeText = findViewById(R.id.gameWelcomeText);

        generateNumbers();

        buttonNumber01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(buttonNumber01.getText().toString()) > Integer.parseInt(buttonNumber02.getText().toString())) {
                    score += 5;
                } else {
                    score -= 5;
                }
                scoresText.setText(String.valueOf(score));
                generateNumbers();
            }
        });

        buttonNumber02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(buttonNumber02.getText().toString()) > Integer.parseInt(buttonNumber01.getText().toString())) {
                    score += 5;
                } else {
                    score -= 5;
                }
                scoresText.setText(String.valueOf(score));
                generateNumbers();
            }
        });
    }

    private void generateNumbers() {
        int num1 = (int) (Math.random() * 999 + 1);
        int num2 = (int) (Math.random() * 999 + 1);

        while (num1 == num2) {  // ensure numbers are not equal
            num2 = (int) (Math.random() * 999 + 1);
        }

        buttonNumber01.setText(String.valueOf(num1));
        buttonNumber02.setText(String.valueOf(num2));
    }
}