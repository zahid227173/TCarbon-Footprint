package com.example.carbonfootprint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class FlightActivity extends AppCompatActivity {

    TextInputEditText editTextMiles;
    TextView click, result1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight);

        editTextMiles = findViewById(R.id.miles);
        click = findViewById(R.id.click4);
        result1 = findViewById(R.id.result4);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResult();
            }
        });
    }

    private void calculateResult() {
        double miles, result;
        String miles1;

        miles1 = editTextMiles.getText().toString();

        if (miles1.isEmpty()) {
            // Handle the case where the user hasn't entered values in both fields
            // For example, show an error message or set a default value for the result.
            return;
        }

        try {
            miles = Double.parseDouble(miles1);

            result = (miles * 0.304) / 1000;

            result1.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            // Handle the case where the user has entered invalid values
            // For example, show an error message or set a default value for the result.
            e.printStackTrace();
        }
    }
}