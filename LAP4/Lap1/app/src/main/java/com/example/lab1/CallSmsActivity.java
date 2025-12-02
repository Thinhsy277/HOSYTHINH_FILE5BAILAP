package com.example.lab1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CallSmsActivity extends AppCompatActivity {

    EditText txtPhoneNumber;
    Button btnCall, btnSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_sms);

        txtPhoneNumber = findViewById(R.id.txtPhoneNumber);
        btnCall = findViewById(R.id.btnCall);
        btnSms = findViewById(R.id.btnSms);

        // Call button
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = txtPhoneNumber.getText().toString();
                if (!phoneNumber.isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + phoneNumber));
                    startActivity(intent);
                } else {
                    Toast.makeText(CallSmsActivity.this, "Vui lòng nhập số điện thoại", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // SMS button
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = txtPhoneNumber.getText().toString();
                if (!phoneNumber.isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("sms:" + phoneNumber));
                    startActivity(intent);
                } else {
                    Toast.makeText(CallSmsActivity.this, "Vui lòng nhập số điện thoại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
