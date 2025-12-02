package com.example.moneyconvert;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText txtInput;
    Spinner spUnit;
    TextView lblHL, lblDam, lblKm, lblLy, lblMet, lblYard, lblFoot, lblInch;

    String[] units = {"Hải lý", "Dặm", "Km", "Lý", "Met", "Yard", "Foot", "Inch"};

    double[][] ratio = {
            {1.000000, 1.15077945, 1.8520000, 20.2537183, 1852.0000, 2025.37183, 6076.11549, 72913.38583},
            {0.86897624, 1.00000000, 1.6093440, 17.6000000, 1609.3440, 1760.00000, 5280.00000, 63360.00000},
            {0.53995680, 0.62137119, 1.0000000, 10.9361330, 1000.0000, 1093.61330, 3280.83990, 39370.07874},
            {0.04937265, 0.05681818, 0.0914400, 1.00000000, 91.44000, 100.00000, 300.00000, 3600.000000},
            {0.00053960, 0.00062137, 0.0010000, 0.0109361, 1.0000000, 1.0936133, 3.2808399, 39.37007874},
            {0.00049374, 0.00056818, 0.0009144, 0.01000000, 0.9144000, 1.0000000, 3.0000000, 36.00000000},
            {0.00016458, 0.00018939, 0.0003048, 0.00333333, 0.3048000, 0.3333333, 1.0000000, 12.00000000},
            {0.00001371, 0.00001578, 0.0000254, 0.00027778, 0.0254000, 0.0277778, 0.0833333, 1.00000000}
    };

    TextView[] results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInput = findViewById(R.id.txtInput);
        spUnit = findViewById(R.id.spUnit);

        lblHL = findViewById(R.id.lblHL);
        lblDam = findViewById(R.id.lblDam);
        lblKm = findViewById(R.id.lblKm);
        lblLy = findViewById(R.id.lblLy);
        lblMet = findViewById(R.id.lblMet);
        lblYard = findViewById(R.id.lblYard);
        lblFoot = findViewById(R.id.lblFoot);
        lblInch = findViewById(R.id.lblInch);

        results = new TextView[]{lblHL, lblDam, lblKm, lblLy, lblMet, lblYard, lblFoot, lblInch};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, units);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spUnit.setAdapter(adapter);

        spUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, android.view.View view, int position, long id) {
                convert();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        txtInput.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) { convert(); }
            @Override public void afterTextChanged(Editable s) {}
        });

        convert();
    }

    void convert() {
        String val = txtInput.getText().toString().trim();
        if (val.isEmpty()) val = "0";
        double input = Double.parseDouble(val);
        int pos = spUnit.getSelectedItemPosition();

        for (int i = 0; i < 8; i++) {
            double out = input * ratio[pos][i];
            if (out > 1000) {
                results[i].setText(String.format("%,.4f", out));
            } else {
                results[i].setText(String.format("%.4f", out));
            }
        }
    }
}
