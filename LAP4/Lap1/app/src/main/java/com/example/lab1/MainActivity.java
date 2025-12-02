package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnCalculator, btnCamera, btnRandomNumber, btnDiceRoller, btnCallSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo các button
        btnCalculator = findViewById(R.id.btnCalculator);
        btnCamera = findViewById(R.id.btnCamera);
        btnRandomNumber = findViewById(R.id.btnRandomNumber);
        btnDiceRoller = findViewById(R.id.btnDiceRoller);
        btnCallSms = findViewById(R.id.btnCallSms);

        // Set onClick listeners
        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
                startActivity(intent);
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CameraActivity.class);
                startActivity(intent);
            }
        });

        btnRandomNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RandomNumberActivity.class);
                startActivity(intent);
            }
        });

        btnDiceRoller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DiceRollerActivity.class);
                startActivity(intent);
            }
        });

        btnCallSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CallSmsActivity.class);
                startActivity(intent);
            }
        });
    }
}
