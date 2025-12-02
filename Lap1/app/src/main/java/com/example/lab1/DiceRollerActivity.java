package com.example.lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class DiceRollerActivity extends AppCompatActivity {

    ImageView imgDice;
    Random random;
    int[] diceImages = {
        R.drawable.dice_1,
        R.drawable.dice_2,
        R.drawable.dice_3,
        R.drawable.dice_4,
        R.drawable.dice_5,
        R.drawable.dice_6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roller);

        imgDice = findViewById(R.id.imgDice);
        random = new Random();

        // Tap to roll the dice
        imgDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });
    }

    private void rollDice() {
        int randomIndex = random.nextInt(6);
        imgDice.setImageResource(diceImages[randomIndex]);
    }
}
