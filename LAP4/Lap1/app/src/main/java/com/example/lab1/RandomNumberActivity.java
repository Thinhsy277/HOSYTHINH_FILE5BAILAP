package com.example.lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class RandomNumberActivity extends AppCompatActivity {

    TextView txtRandomNumber;
    Button btnGenerate;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_number);

        txtRandomNumber = findViewById(R.id.txtRandomNumber);
        btnGenerate = findViewById(R.id.btnGenerate);
        random = new Random();

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Generate random number from 0 to 99
                int randomNum = random.nextInt(100);
                txtRandomNumber.setText(String.format("%02d", randomNum));
            }
        });
    }
}
